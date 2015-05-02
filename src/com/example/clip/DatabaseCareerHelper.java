package com.example.clip;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseCareerHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Career-Data";

	// goal table Name
	private static final String GOAL = "goal";

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

	public DatabaseCareerHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// Create a table for Vital Sign
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
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + GOAL);
		db.execSQL("DROP TABLE IF EXISTS " + JOB_SEARCH);
		db.execSQL("DROP TABLE IF EXISTS COMPANY");

		// Create tables again
	}

	@SuppressWarnings("static-access")
	public void openDatabase() {

		SQLiteDatabase db = this.getWritableDatabase();

		onUpgrade(db, 0, 1);

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
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;

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

	public void deleteJobSearch(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("JOB_SEARCH", "id" + " = ?",
				new String[]{String.valueOf(id)});
		db.close();
	}

	// Getting All job search
	public Cursor getAllJobSearch() {
		SQLiteDatabase db = this.getWritableDatabase();
		String selectQuery = "Select * from JOB_SEARCH";
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;

	}

	public void addCompanyInfo(CompanyInformation companyInformation) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("companyName", companyInformation.getComName());
		values.put("product", companyInformation.getComProduct());
		values.put("address", companyInformation.getPhoneNum());
		values.put("phone", companyInformation.getLocation());
		values.put("facts", companyInformation.getKeyFacts());
		values.put("reasons", companyInformation.getReasons());
		values.put("subDate", companyInformation.getResumeSubDate());
		values.put("interviewDate", companyInformation.getInterviewDate());
		values.put("outcome", companyInformation.getInterviewResult().toString());
		values.put("notes", companyInformation.getNotes().toString());

		db.insert("COMPANY", null, values);
		db.close();
	}

	public void deleteCompany(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete("COMPANY", "id" + " = ?",
				new String[]{String.valueOf(id)});
		db.close();
	}

	// Getting All job search
	public Cursor getAllCompany() {
		SQLiteDatabase db = this.getWritableDatabase();
		String selectQuery = "Select * from COMPANY";
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;
	}

}
