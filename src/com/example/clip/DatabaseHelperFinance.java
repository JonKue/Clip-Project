package com.example.clip;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperFinance extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Career-Data";

	// Vital Signs table Name
	private static final String GOAL = "goal";

	// Goal Columns names
	private static final String KEY_GTYPE = "goaltype";
	private static final String KEY_GNAME = "goalname";

	public DatabaseHelperFinance(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// Create a table for Vital Sign
		String CREATE_GOAL_TABLE = "CREATE TABLE " + GOAL + "(" + KEY_GTYPE
				+ " TEXT PRIMARY KEY, " + KEY_GNAME + " TEXT " + ")";

		db.execSQL(CREATE_GOAL_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + GOAL);

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

}
