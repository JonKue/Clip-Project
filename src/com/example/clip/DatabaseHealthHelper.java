package com.example.clip;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHealthHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Health-Data";

	// Vital Signs table Name
	private static final String VITAL_SIGN = "VITAL_SIGN";
	
	// Exercise Plan table Name
	private static final String EXERCISE_PLAN = "exerciseplan";

	// Diet Plan table Name
	private static final String DIET_PLAN = "dietplan";

	// Medication table Name
	private static final String MEDICATION = "medication";

	// Allergy table Name
	private static final String ALLERGY = "allergy";

	// Vital Signs Columns names
	private static final String KEY_BT = "bodyTemp";
	private static final String KEY_PULSE = "pulse";
	private static final String KEY_RR = "resRate";
	private static final String KEY_SBP = "sysBP";
	private static final String KEY_DBP = "diasysBP";

	// Allergy Columns names
	private static final String KEY_AGNAME = "agname";
	private static final String KEY_AGDESCRIPTION = "adescription";

	public DatabaseHealthHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// Create a table for Vital Sign
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

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + VITAL_SIGN);
		db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_PLAN);
		db.execSQL("DROP TABLE IF EXISTS " + ALLERGY);
		db.execSQL("DROP TABLE IF EXISTS " + DIET_PLAN);
		db.execSQL("DROP TABLE IF EXISTS " + MEDICATION);

		// Create tables again

	}

	// Add vital signs
	public boolean addVitalSign(VitalSign vs) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();

		values.put(KEY_BT, vs.getBodyTemperature());
		values.put(KEY_PULSE, vs.getPulse());
		values.put(KEY_RR, vs.getRespirationRate());
		values.put(KEY_SBP, vs.getBloodPressure()[0]);
		values.put(KEY_DBP, vs.getBloodPressure()[1]);
		// Inserting Row
		long flag = db.insert("VITAL_SIGN", null, values);
		db.close(); // Closing database connection
		//Log.d("CLIP: ", flag + "");

		if (flag == -1)
			return false;
		else
			return true;

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
			values.put("routine", ep.getRoutine().toString());
			values.put("starttime", ep.getStartTime().toString());
			values.put("endtime", ep.getEndTime().toString());
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
		List<ExercisePlan> exercisePlanList = new ArrayList<ExercisePlan>();
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

		// return user list
		return exercisePlanList;
	}

	// Getting All Diet Plan
	public List<Diet> getAllDietPlan() {
		List<Diet> dietPlanList = new ArrayList<Diet>();
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

		// return user list
		return dietPlanList;
	}

	// Getting All Medication
	public List<Medication> getAllMedication() {
		List<Medication> medicationList = new ArrayList<Medication>();
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

		// return user list
		return medicationList;
	}
	
	// Getting All Allergy
	public List<Allergy> getAllAllergy() {
		List<Allergy> allergyList = new ArrayList<Allergy>();
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

		return ag;
	}
}
