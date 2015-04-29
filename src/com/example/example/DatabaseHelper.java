package com.example.example;

//-----UPDATE PACKAGE/IMPORTS FOR CLIP-----//

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CLIP-data";

    // TABLES
    private static final String TABLE_USER = "USER";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USER ( uid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, password TEXT, question INTEGER, answer TEXT)");
        db.execSQL("CREATE TABLE SCHOOLS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "schoolName TEXT, degreeType TEXT, program TEXT, enrollment TEXT," +
                "dateStart TEXT, dateGrad TEXT, tuition TEXT, course TEXT, " +
                "appDate TEXT, appStat TEXT, type TEXT)");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS USER");
        db.execSQL("DROP TABLE IF EXISTS SCHOOLS");

        // Create tables again
        onCreate(db);
    }

    /*
     * USER table operations
     *
     */
        // Register new user
    void registerUser(String inputName, String inputPass, int inputQuestion, String inputAnswer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", inputName);
        values.put("password", inputPass);
        values.put("question", inputQuestion);
        values.put("answer", inputAnswer);

        // Inserting Row
        db.insert("USER", null, values);
        db.close(); // Closing database connection
    }

    boolean isEmpty()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM USER";


        Cursor cursor = db.rawQuery(selectQuery, null);

        boolean res = !cursor.moveToFirst(); // True if Empty
        cursor.close();
        return res;
    }
    boolean isValidName(String inputName) {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM USER WHERE name = '" +inputName +"'";


        Cursor cursor = db.rawQuery(selectQuery, null);
        boolean res = !cursor.moveToFirst(); // True if Empty
        cursor.close();
        return res; //If name exists return false
    }

    // Getting single contact
    boolean loginUser(String name, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM USER";

        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();/*
        Log.d("CLIP-DEGUG::", "USER id: " + Integer.parseInt(cursor.getString(0)));
        Log.d("CLIP-DEGUG::", "USER name: " + cursor.getString(1));
        Log.d("CLIP-DEGUG::", "USER pass: " + cursor.getString(2));*/


        selectQuery = "SELECT * FROM USER WHERE name = '" +name+
                "' AND password = '" + password +"'";


        cursor = db.rawQuery(selectQuery, null);

        //Entry Exists
//            User user = new User();
// Username/Password incorrect
        boolean res = cursor.moveToFirst(); // True if Empty
        cursor.close();
        return res;
    }

    // Getting All Users    --Only needed for multiple user system
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM USER";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setID(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                // Adding contact to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return user list
        return userList;
    }

/*
    // Updating single user
    public int updateContact(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }*/

    /*
      * SCHOOLS table operations
      *
      */
    void addSchool_Current(School school) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("schoolname", school.get_schoolName());
        values.put("degreeType", school.get_degreeType());
        values.put("program", school.get_program());
        values.put("enrollment", school.get_enrollment());
        values.put("dateStart", school.get_dateStart());
        values.put("dateGrad", school.get_dateGrad());
        values.put("tuition", school.get_tuition());
        values.put("course", school.get_course());
        values.put("type", "CURRENT");

        // Inserting Row
        db.insert("SCHOOLS", null, values);
        db.close(); // Closing database connection
    }

    void addSchool_Future(School school) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("schoolname", school.get_schoolName());
        values.put("degreeType", school.get_degreeType());
        values.put("program", school.get_program());
        values.put("enrollment", school.get_enrollment());
        values.put("appDate", school.get_dateStart());
        values.put("appStat", school.get_dateGrad());
        values.put("type", "FUTURE");

        // Inserting Row
        db.insert("SCHOOLS", null, values);
        db.close(); // Closing database connection
    }

    // Getting single school
    School selectSchool(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM SCHOOLS WHERE id = " +id;


        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        School school = new School(Integer.parseInt(cursor.getString(0)));
        school.set_schoolName(cursor.getString(1));
        school.set_degreeType(cursor.getString(2));
        school.set_program(cursor.getString(3));
        school.set_enrollment(cursor.getString(4));
        school.set_dateStart(cursor.getString(5));
        school.set_dateGrad(cursor.getString(6));
        school.set_tuition(cursor.getString(7));
        school.set_course(cursor.getString(8));
        school.set_type(cursor.getString(11));

        cursor.close();
        return school;
    }

    // Getting All Current Schools
    public List<School> getAllCurrentSchools() {
        List<School> schoolList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM SCHOOLS WHERE type = 'CURRENT'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                School school = new School(Integer.parseInt(cursor.getString(0)));
                school.set_schoolName(cursor.getString(1));
                school.set_degreeType(cursor.getString(2));
                school.set_program(cursor.getString(3));
                school.set_enrollment(cursor.getString(4));
                school.set_dateStart(cursor.getString(5));
                school.set_dateGrad(cursor.getString(6));
                school.set_tuition(cursor.getString(7));
                school.set_course(cursor.getString(8));
                school.set_type("CURRENT");
                // Adding contact to list
                schoolList.add(school);
            } while (cursor.moveToNext());
        } cursor.close();

        // return user list
        return schoolList;
    }

    // Getting All Current Schools
    public List<School> getAllFutureSchools() {
        List<School> schoolList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM SCHOOLS WHERE type = 'FUTURE'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                School school = new School(Integer.parseInt(cursor.getString(0)));
                school.set_schoolName(cursor.getString(1));
                school.set_degreeType(cursor.getString(2));
                school.set_program(cursor.getString(3));
                school.set_enrollment(cursor.getString(4));
                school.set_appDate(cursor.getString(9));
                school.set_appStat(cursor.getString(10));
                school.set_type("FUTURE");
                // Adding contact to list
                schoolList.add(school);
            } while (cursor.moveToNext());
        } cursor.close();

        // return user list
        return schoolList;
    }


    public void deleteSchool(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SCHOOLS", "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }



}
