package com.example.example;

//-----UPDATE PACKAGE/IMPORTS FOR CLIP-----//

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CLIP-data";


    // goal table Name
    private static final String GOAL = "GOAL";

    // job search Name
    private static final String JOB_SEARCH = "JOB_SEARCH";

    // Goal Columns names
    private static final String KEY_GTYPE = "goaltype";
    private static final String KEY_GNAME = "goalname";

    // Job Search Columns names
    private static final String KEY_JSNAME = "comapplied";
    private static final String KEY_JSDATE = "date";
    private static final String KEY_JSSTATUS = "status";
    private static final String KEY_JSOTHERNOTE = "othernote";

    // Vital Signs table Name
    private static final String VITAL_SIGN = "VITAL_SIGN";

    // Exercise Plan table Name
    private static final String EXERCISE_PLAN = "EXERCISE_PLAN";

    // Diet Plan table Name
    private static final String DIET_PLAN = "DIET_PLAN";

    // Medication table Name
    private static final String MEDICATION = "MEDICATION";

    // Allergy table Name
    private static final String ALLERGY = "ALLERGY";

    // Vital Signs Columns names
    private static final String KEY_BT = "bodyTemp";
    private static final String KEY_PULSE = "pulse";
    private static final String KEY_RR = "resRate";
    private static final String KEY_SBP = "sysBP";
    private static final String KEY_DBP = "diasysBP";

    // Allergy Columns names
    private static final String KEY_AGNAME = "agname";
    private static final String KEY_AGDESCRIPTION = "adescription";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USER ( uid INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, password TEXT, question INTEGER, answer TEXT)");
        
        //tables for education section
        db.execSQL("CREATE TABLE SCHOOLS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "schoolName TEXT, degreeType TEXT, program TEXT, enrollment TEXT," +
                "dateStart TEXT, dateGrad TEXT, tuition TEXT, course TEXT, " +
                "appDate TEXT, appStat TEXT, type TEXT)");
        db.execSQL("CREATE TABLE LOANS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lenderName TEXT, amount TEXT, status TEXT)");
        db.execSQL("CREATE TABLE SCHOLARSHIPS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "scholarshipName TEXT, requirements TEXT, amount TEXT, status TEXT)");
        
        
        //tables for finance section
        db.execSQL("CREATE TABLE STOCKS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "numStock TEXT, name TEXT)");
        db.execSQL("CREATE TABLE STATES ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "date TEXT, cash TEXT, assets TEXT, liabilities TEXT, creditCards TEXT," +
                "other TEXT)");
        db.execSQL("CREATE TABLE FGOALS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, description TEXT, type TEXT, date TEXT)");

        //

        String CREATE_GOAL_TABLE = "CREATE TABLE " + GOAL + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_GTYPE
                + " TEXT, " + KEY_GNAME + " TEXT " + ")";
        String CREATE_JOB_SEARCH_TABLE = "CREATE TABLE " + JOB_SEARCH + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_JSNAME + " TEXT, " + KEY_JSDATE + " TEXT, "
                + KEY_JSSTATUS + " TEXT, " + KEY_JSOTHERNOTE + " TEXT " + ")";

        db.execSQL(CREATE_GOAL_TABLE);
        db.execSQL(CREATE_JOB_SEARCH_TABLE);

        db.execSQL("CREATE TABLE COMPANY ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "companyName TEXT, product TEXT, address TEXT, phone TEXT, " +
                "facts TEXT, reasons TEXT, subDate TEXT, interviewDate TEXT, " +
                "outcome TEXT, notes TEXT)");

        db.execSQL("CREATE TABLE IDENTITY ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, website TEXT, userName TEXT, password TEXT)");
        db.execSQL("CREATE TABLE CONTACTS ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, affiliation TEXT, date TEXT, timesUsed TEXT, comments TEXT)");



        String CREATE_VITAL_SIGN_TABLE = "CREATE TABLE " + VITAL_SIGN + "("
                + KEY_BT + " TEXT, " + KEY_PULSE + " TEXT, " + KEY_RR
                + " TEXT, " + KEY_SBP + " TEXT, " + KEY_DBP + " TEXT " + ")";

        String CREATE_ALLERGY_TABLE = "CREATE TABLE " + ALLERGY
                + "( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_AGNAME + " TEXT, " + KEY_AGDESCRIPTION + " TEXT " + ")";

        db.execSQL(CREATE_VITAL_SIGN_TABLE);

        db.execSQL(CREATE_ALLERGY_TABLE);

        db.execSQL("CREATE TABLE EXERCISE_PLAN ( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "planName TEXT, routine TEXT, starttime TEXT, endtime TEXT, otherinfo TEXT)");

        db.execSQL("CREATE TABLE DIET_PLAN ( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "dietType TEXT, description TEXT, datestart TEXT, dateend TEXT)");

        db.execSQL("CREATE TABLE MEDICATION ( id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "pillName TEXT, numdose TEXT, datestart TEXT, dateend TEXT)");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS USER");
        //education section
        db.execSQL("DROP TABLE IF EXISTS SCHOOLS");
        db.execSQL("DROP TABLE IF EXISTS LOANS");
        db.execSQL("DROP TABLE IF EXISTS SCHOLARSHIPS");
        
        //finance section
        db.execSQL("DROP TABLE IF EXISTS STOCKS");
        db.execSQL("DROP TABLE IF EXISTS STATES");
        db.execSQL("DROP TABLE IF EXISTS FGOALS");


        db.execSQL("DROP TABLE IF EXISTS GOAL");
        db.execSQL("DROP TABLE IF EXISTS JOB_SEARCH");
        db.execSQL("DROP TABLE IF EXISTS COMPANY");
        db.execSQL("DROP TABLE IF EXISTS IDENTITY");
        db.execSQL("DROP TABLE IF EXISTS CONTACTS");


        db.execSQL("DROP TABLE IF EXISTS " + VITAL_SIGN);
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_PLAN);
        db.execSQL("DROP TABLE IF EXISTS " + ALLERGY);
        db.execSQL("DROP TABLE IF EXISTS " + DIET_PLAN);
        db.execSQL("DROP TABLE IF EXISTS " + MEDICATION);

        // Create tables again
        onCreate(db);
    }

    public void onWipe() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS USER");
        //education section
        db.execSQL("DROP TABLE IF EXISTS SCHOOLS");
        db.execSQL("DROP TABLE IF EXISTS LOANS");
        db.execSQL("DROP TABLE IF EXISTS SCHOLARSHIPS");
        //finance section
        db.execSQL("DROP TABLE IF EXISTS STOCKS");
        db.execSQL("DROP TABLE IF EXISTS STATES");
        db.execSQL("DROP TABLE IF EXISTS FGOALS");

        db.execSQL("DROP TABLE IF EXISTS GOAL");
        db.execSQL("DROP TABLE IF EXISTS JOB_SEARCH");
        db.execSQL("DROP TABLE IF EXISTS COMPANY");
        db.execSQL("DROP TABLE IF EXISTS IDENTITY");
        db.execSQL("DROP TABLE IF EXISTS CONTACTS");


        db.execSQL("DROP TABLE IF EXISTS " + VITAL_SIGN);
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_PLAN);
        db.execSQL("DROP TABLE IF EXISTS " + ALLERGY);
        db.execSQL("DROP TABLE IF EXISTS " + DIET_PLAN);
        db.execSQL("DROP TABLE IF EXISTS " + MEDICATION);

        // Create tables again
        onCreate(db);
    }

    /*
     * USER table operations
     *
     */
        // Register new user
    boolean registerUser(String inputName, String inputPass, int inputQuestion, String inputAnswer) {
        SQLiteDatabase db = this.getWritableDatabase();
        String hashedpass = "", hashedansw = "";

        try {
            hashedpass = Encryption.SHA1(inputPass);
            hashedansw = Encryption.SHA1(inputAnswer);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.d("CLIP-DEBUG:: --", ""+hashedpass);
        ContentValues values = new ContentValues();
        values.put("name", inputName);

        values.put("password", hashedpass);
        values.put("question", inputQuestion);
        values.put("answer", hashedansw);

        // Inserting Row
        if(!hashedpass.equals("")) {
            db.insert("USER", null, values);
            db.close();
            return true;
        }
        db.close();
        return false;
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
        String hashedpass = "";

        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();

        try {
            hashedpass = Encryption.SHA1(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Log.d("CLIP-DEBUG:: --", ""+hashedpass);
        if(!hashedpass.equals(""))
            selectQuery = "SELECT * FROM USER WHERE name = '" +name+
                "' AND password = '" + hashedpass +"'";


        cursor = db.rawQuery(selectQuery, null);

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

    /* ------------------------- *
     * SCHOOLS table operations  *
     * ------------------------- */
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
                new String[]{String.valueOf(id)});
        db.close();
    }


    /*
     * LOANS Table
     */

    void addLoan(Loan loan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("lenderName", loan.getCompanyName());
        values.put("amount", loan.getAmount());
        values.put("status", loan.getApplicationStatus().toString());

        // Inserting Row
        db.insert("LOANS", null, values);
        db.close(); // Closing database connection
    }

    Loan selectLoan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM LOANS WHERE id = " +id;


        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        Loan loan = new Loan(Integer.parseInt(cursor.getString(0)));
        loan.setCompanyName(cursor.getString(1));
        loan.setAmount(Integer.parseInt(cursor.getString(2)));
        loan.setApplicationStatus(cursor.getString(3));

        cursor.close();
        return loan;
    }

    // Getting All Current Schools
    public List<Loan> getAllLoans() {
        List<Loan> loanList = new ArrayList<>();
        String selectQuery = "SELECT * FROM LOANS";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Loan loan = new Loan(Integer.parseInt(cursor.getString (0)));
                loan.setCompanyName(cursor.getString(1));
                loan.setAmount(Integer.parseInt(cursor.getString(2)));
                loan.setApplicationStatus(cursor.getString(3));
                loanList.add(loan);
            } while (cursor.moveToNext());
        } cursor.close();

        // return user list
        return loanList;
    }

    public void deleteLoan(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("LOANS", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
    
    
    
    /*
     * SCHOLARSHIPS Table
     */
    void addScholarship(Scholarship scholarship) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("scholarshipName", scholarship.getName());
        values.put("requirements", scholarship.getRequirement());
        values.put("amount", scholarship.getAmount());
        values.put("status", scholarship.getApplicationStatus().toString());

        // Inserting Row
        db.insert("SCHOLARSHIPS", null, values);
        db.close(); // Closing database connection
    }

    Scholarship selectScholarship(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM SCHOLARSHIPS WHERE id = " +id;


        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        Scholarship scholarship = new Scholarship(Integer.parseInt(cursor.getString(0)));
        scholarship.setName(cursor.getString(1));
        scholarship.setRequirement(cursor.getString(2));
        scholarship.setAmount(Integer.parseInt(cursor.getString(3)));
        scholarship.setApplicationStatus(cursor.getString(4));

        cursor.close();
        return scholarship;
    }

    // Getting All Current Schools
    public List<Scholarship> getAllScholarships() {
        List<Scholarship> scholarshipList = new ArrayList<>();
        String selectQuery = "SELECT * FROM SCHOLARSHIPS";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Scholarship scholarship = new Scholarship(Integer.parseInt(cursor.getString(0)));
                scholarship.setName(cursor.getString(1));
                scholarship.setRequirement(cursor.getString(2));
                scholarship.setAmount(Integer.parseInt(cursor.getString(3)));
                scholarship.setApplicationStatus(cursor.getString(4));
                scholarshipList.add(scholarship);
            } while (cursor.moveToNext());
        } cursor.close();

        // return user list
        return scholarshipList;
    }

    public void deleteScholarship(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("SCHOLARSHIPS", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
    

    /*******************************
     * Functions for Finance Section
     * Inserting values into tables
     * ******************************/
    //attempting to work with stocks database implementation
    void addStock(Stocks stock) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("numStock", stock.getNumStock());
        values.put("name", stock.getName());

        // Inserting Row
        db.insert("STOCKS", null, values);
        db.close(); // Closing database connection
    }
    
    
    //attempting to work with stocks database implementation
    void addState(FinancialState state) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("date", state.getDate());
        values.put("cash", state.getCash());
        values.put("assets", state.getAssets());
        values.put("liabilities", state.getLiabilities());
        values.put("creditCards", state.getCreditCards());
        values.put("other", state.getOther());

        // Inserting Row
        db.insert("STATES", null, values);
        db.close(); // Closing database connection
    }
    
    //add finance goals to the database
    void addFGoal(FinanceGoal goal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", goal.getName());
        values.put("description", goal.getDescription());
        values.put("type", goal.getType());
        values.put("date", goal.getDate());


        // Inserting Row
        db.insert("FGOALS", null, values);
        db.close(); // Closing database connection
    }
    
    
    
    
    /*
    * Getting values from tables
    * ******************************/
 // Getting All StocksS
    public List<Stocks> getAllStocks() {
        List<Stocks> stockList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM STOCKS";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Stocks stock = new Stocks(Integer.parseInt(cursor.getString(0)));
                stock.setNumStock(cursor.getString(1));
                stock.setName(cursor.getString(2));
                // Adding contact to list
                stockList.add(stock);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        // return user list
        return stockList;
    }
    
  //Getting All States
   public List<FinancialState> getAllStates() {
       List<FinancialState> stateList = new ArrayList<>();
       // Select All Query
       String selectQuery = "SELECT * FROM STATES";

       SQLiteDatabase db = this.getWritableDatabase();
       Cursor cursor = db.rawQuery(selectQuery, null);

       // looping through all rows and adding to list
       if (cursor.moveToFirst()) {
           do {
               FinancialState state = new FinancialState(Integer.parseInt(cursor.getString(0)));
               state.setDate(cursor.getString(1));
               state.setCash(cursor.getString(2));
               state.setAssets(cursor.getString(3));
               state.setLiabilities(cursor.getString(4));
               state.setCreditCards(cursor.getString(5));
               state.setOther(cursor.getString(6));
               // Adding contact to list
               stateList.add(state);
           } while (cursor.moveToNext());
       }

       cursor.close();
       db.close();
       // return state list
       return stateList;
   }
   
  //Getting All Finance Goals
  public List<FinanceGoal> getAllFGoals() {
      List<FinanceGoal> goalList = new ArrayList<>();
      // Select All Query
      String selectQuery = "SELECT * FROM FGOALS";

      SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery(selectQuery, null);

      // looping through all rows and adding to list
      if (cursor.moveToFirst()) {
          do {
              FinanceGoal goal = new FinanceGoal(Integer.parseInt(cursor.getString(0)));
              goal.setName(cursor.getString(1));
              goal.setDescription(cursor.getString(2));
              goal.setType(cursor.getString(3));
              goal.setDate(cursor.getString(4));
              // Adding contact to list
              goalList.add(goal);
          } while (cursor.moveToNext());
      }

      cursor.close();
      db.close();
      // return state list
      return goalList;
  }
  
  /*
   * Deleting values from database
   * *****************************
   */  
  	
	  
	  public void deleteStock(int id) {
	      SQLiteDatabase db = this.getWritableDatabase();
	      db.delete("STOCKS", "id" + " = ?",
	              new String[] { String.valueOf(id) });
	      db.close();
	  }

	  public void deleteState(int id) {
	      SQLiteDatabase db = this.getWritableDatabase();
	      db.delete("STATES", "id" + " = ?",
	              new String[] { String.valueOf(id) });
	      db.close();
	  }
	  public void deleteFGoal(int id) {
	      SQLiteDatabase db = this.getWritableDatabase();
	      db.delete("FGOALS", "id" + " = ?",
	              new String[] { String.valueOf(id) });
	      db.close();
	  }


    // Add goal
    public void addGoal(Goal goal) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_GTYPE, goal.getType());
        values.put(KEY_GNAME, goal.getName());

        db.insert("GOAL", null, values);
        db.close();
    }

    // Getting All goal
    public Cursor getAllGoal() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "Select * from GOAL";
        return db.rawQuery(selectQuery, null);

    }

    // Add job search
    public void addJobSearch(JobSearch js) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_JSNAME, js.getJobName());
        values.put(KEY_JSDATE, js.getDate());
        values.put(KEY_JSSTATUS, js.getStatus());
        values.put(KEY_JSOTHERNOTE, js.getNote());

        db.insert("JOB_SEARCH", null, values);
        db.close();

    }

    // Getting All job search
    public Cursor getAllJobSearch() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "Select * from JOB_SEARCH";
        return db.rawQuery(selectQuery, null);

    }

    public void deleteJobSearch(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("JOB_SEARCH", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    void addCompany(CompanyInformation companyInformation) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("companyName", companyInformation.getComName());
        values.put("product", companyInformation.getComProduct());
        values.put("address", companyInformation.getLocation());
        values.put("phone", companyInformation.getPhoneNum());
        values.put("facts", companyInformation.getKeyFacts());
        values.put("reasons", companyInformation.getReasons());
        values.put("subDate", companyInformation.getResumeSubDate());
        values.put("interviewDate", companyInformation.getInterviewDate());
        values.put("outcome", companyInformation.getInterviewResult().toString());
        values.put("notes", companyInformation.getNotes());

        // Inserting Row
        db.insert("COMPANY", null, values);
        db.close(); // Closing database connection
    }

    public Cursor getAllCompany() {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "Select * from COMPANY";
        return db.rawQuery(selectQuery, null);

    }

    //delete contacts
    public void deleteCompany(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("COMPANY", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    //Add electronic identity
    void addIdentity(ElectronicIdentity id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", id.getName());
        values.put("website", id.getWebsite());
        values.put("userName", id.getUserName());
        values.put("password", id.getPassWord());

        // Inserting Row
        db.insert("IDENTITY", null, values);
        db.close(); // Closing database connection
    }

    //get All electronic identities
    public List<ElectronicIdentity> getAllIdentities() {
        List<ElectronicIdentity> idList = new ArrayList<>();
        String selectQuery = "SELECT * FROM IDENTITY";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ElectronicIdentity id = new ElectronicIdentity(Integer.parseInt(cursor.getString(0)));
                id.setName(cursor.getString(1));
                id.setWebsite(cursor.getString(2));
                id.setUserName(cursor.getString(3));
                id.setPassWord(cursor.getString(4));
                idList.add(id);
            } while (cursor.moveToNext());
        } cursor.close();

        // return user list
        return idList;
    }

    //delete electronic identities
    public void deleteIdentity(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("IDENTITY", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


    //Add contact
    void addContact(ContactList contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", contact.getName());
        values.put("affiliation", contact.getAffiliation());
        values.put("date", contact.getEstablishedDate());
        values.put("timesUsed", contact.getTimesUsed());
        values.put("comments", contact.getComments());

        // Inserting Row
        db.insert("CONTACTS", null, values);
        db.close(); // Closing database connection
    }

    //get All contacts
    public List<ContactList> getAllContacts() {
        List<ContactList> contactList = new ArrayList<>();
        String selectQuery = "SELECT * FROM CONTACTS";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ContactList contact = new ContactList(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setAffiliation(cursor.getString(2));
                contact.setEstablishedDate(cursor.getString(3));
                contact.setTimesUsed(cursor.getString(4));
                contact.setComments(cursor.getString(5));
                contactList.add(contact);
            } while (cursor.moveToNext());
        } cursor.close();

        // return contact list
        return contactList;
    }

    //delete contacts
    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("CONTACTS", "id" + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


    // Add vital signs
    public void addVitalSign(VitalSign vs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_BT, vs.getBodyTemperature());
        values.put(KEY_PULSE, vs.getPulse());
        values.put(KEY_RR, vs.getRespirationRate());
        values.put(KEY_SBP, vs.getBloodPressure()[0]);
        values.put(KEY_DBP, vs.getBloodPressure()[1]);
        // Inserting Row
        db.insert("VITAL_SIGN", null, values);
        db.close(); // Closing database connection


    }

    // Getting vitals signs
    public VitalSign getVitalSign() {
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM VITAL_SIGN";

        Cursor cursor = db.rawQuery(selectQuery, null);

        VitalSign vitalSign = new VitalSign();
        if (cursor.moveToLast()) {

            vitalSign.setBodyTemperature(cursor.getString(0));
            vitalSign.setPulse(cursor.getString(1));
            vitalSign.setRespirationRate(cursor.getString(2));
            String[] bp = { cursor.getString(3), cursor.getString(4) }; // TODO
            vitalSign.setBloodPressure(bp);
        }
        cursor.close();
        db.close();

        return vitalSign;
    }

    // Add Medication

    /*** ADD data ***/

    // Add Exercise Plan
    public void addExercisePlan(ExercisePlan ep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("planName", ep.getExerciseName());
        values.put("routine", ep.getRoutine());
        values.put("starttime", ep.getStartTime());
        values.put("endtime", ep.getEndTime());
        values.put("otherinfo", ep.getOtherInfo());

        db.insert("EXERCISE_PLAN", null, values);
        db.close(); // Closing database connection

    }

    // Add Diet Plan
    public void addDietPlan(Diet dp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("dietType", dp.getDietType());
        values.put("description", dp.getOtherInfo());
        values.put("datestart", dp.getStartDate());
        values.put("dateend", dp.getEndDate());

        db.insert("DIET_PLAN", null, values);
        db.close(); // Closing database connection

    }

    // Add Medicaton
    public void addMedication(Medication md) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("pillname", md.getPillName());
        values.put("numdose", md.getNoOfDosage());
        values.put("datestart", md.getDateStarted());
        values.put("dateend", md.getDateEnded());

        db.insert("MEDICATION", null, values);
        db.close(); // Closing database connection

    }

    /*** Getting all information ***/

    // Getting All Exercise Plan
    public List<ExercisePlan> getAllExercisePlan() {
        List<ExercisePlan> exercisePlanList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM EXERCISE_PLAN";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ExercisePlan exercisePlan = new ExercisePlan(Integer.parseInt(cursor.getString(0)));
                exercisePlan.setExerciseName(cursor.getString(1));
                exercisePlan.setRoutine(cursor.getString(2));
                exercisePlan.setStartTime(cursor.getString(3));
                exercisePlan.setOtherInfo(cursor.getString(4));
                exercisePlan.setEndTime(cursor.getString(5));
                // Adding contact to list
                exercisePlanList.add(exercisePlan);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        // return user list
        return exercisePlanList;
    }

    // Getting All Diet Plan
    public List<Diet> getAllDietPlan() {
        List<Diet> dietPlanList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM DIET_PLAN";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Diet dietPlan = new Diet(Integer.parseInt(cursor.getString(0)));
                dietPlan.setDietType(cursor.getString(1));
                dietPlan.setOtherInfo(cursor.getString(2));
                dietPlan.setStartDate(cursor.getString(3));
                dietPlan.setEndDate(cursor.getString(3));
                // Adding contact to list
                dietPlanList.add(dietPlan);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        // return user list
        return dietPlanList;
    }

    // Getting All Medication
    public List<Medication> getAllMedication() {
        List<Medication> medicationList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM MEDICATION";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Medication medication = new Medication(Integer.parseInt(cursor
                        .getString(0)));
                medication.setPillName(cursor.getString(1));
                medication.setNoOfDosage(cursor.getString(2));
                medication.setDateStarted(cursor.getString(3));
                medication.setDateEnded(cursor.getString(3));
                // Adding contact to list
                medicationList.add(medication);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        // return user list
        return medicationList;
    }

    // Getting All Allergy
    public List<Allergy> getAllAllergy() {
        List<Allergy> allergyList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM ALLERGY";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Allergy allergy = new Allergy(Integer.parseInt(cursor
                        .getString(0)));

                allergy.setAllergyName(cursor.getString(1));
                allergy.setAllergyDescription(cursor.getString(2));

                allergyList.add(allergy);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        // return user list
        return allergyList;
    }

    /*** Deleting values from Database ***/

    // Delete ExercisePlan
    public void deleteExercisePlan(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("EXERCISE_PLAN", "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Delete dietPlan
    public void deleteDietPlan(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("DIET_PLAN", "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Delete medication
    public void deleteMedication(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("MEDICATION", "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Delete allergy
    // Delete medication
    public void deleteAllergy(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("ALLERGY", "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Add allergy
    public void addAllergy(Allergy ag) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_AGNAME, ag.getAllergyName());
        values.put(KEY_AGDESCRIPTION, ag.getAllergyDescription());

        db.insert("ALLERGY", null, values);
        db.close();
    }

	/*
	// Getting All allergy
	public Cursor getAllAllergy() {
		SQLiteDatabase db = this.getWritableDatabase();
		String selectQuery = "Select * from ALLERGY";
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;

	}
	*/

    // Get allergy
    public Allergy getAllergy(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM ALLERGY WHERE name = " + KEY_AGNAME;

        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        Allergy ag = new Allergy(0);
        ag.setAllergyName(cursor.getString(1));
        ag.setAllergyDescription(cursor.getString(2));


        cursor.close();
        db.close();

        return ag;
    }
}
