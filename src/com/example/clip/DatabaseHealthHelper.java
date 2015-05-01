package com.example.clip;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHealthHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "Health-Data";

	// Vital Signs table Name
	private static final String VITAL_SIGN = "vitalSign";

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

	// Medication Columns Names
	private static final String KEY_MPN = "pillname";
	private static final String KEY_MDS = "datestarted";
	private static final String KEY_MDE = "dateended";

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
				 + KEY_BT + " REAL, " + KEY_PULSE + " INTEGER, " + KEY_RR + " INTEGER, "
				+ KEY_SBP + " INTEGER, " + KEY_DBP + " INTEGER " + ")";
		String CREATE_ALLERGY_TABLE = "CREATE TABLE " + ALLERGY + "("
				+ KEY_AGNAME + " TEXT, " + KEY_AGDESCRIPTION + " TEXT " + ")";
		String CREATE_MEDICATION_TABLE = "CREATE TABLE " + MEDICATION + "("
				+ KEY_MPN + " TEXT PRIMARY KEY, " + KEY_MDS + " TEXT, "
				+ KEY_MDE + " TEXT " + ")";

		db.execSQL(CREATE_VITAL_SIGN_TABLE);
		db.execSQL(CREATE_MEDICATION_TABLE);
		db.execSQL(CREATE_ALLERGY_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + VITAL_SIGN);
		db.execSQL("DROP TABLE IF EXISTS " + ALLERGY);
		db.execSQL("DROP TABLE IF EXISTS " + MEDICATION);

		// Create tables again

	}

	@SuppressWarnings("static-access")
	public void openDatabase() {

		SQLiteDatabase db = this.getWritableDatabase();

		onUpgrade(db, 0, 1);

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
		cursor.moveToLast();

		VitalSign vitalSign = new VitalSign();
		vitalSign.setBodyTemperature(cursor.getString(0));
		vitalSign.setPulse(cursor.getString(1));
		vitalSign.setRespirationRate(cursor.getString(2));
		String[] bp = { cursor.getString(2), cursor.getString(4) };
		vitalSign.setBloodPressure(bp);

		return vitalSign;
	}

	// Add Medicaton
	public void addMedication(Medication md) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(KEY_MPN, md.getPillName());
		values.put(KEY_MDS, md.getDateStarted());
		values.put(KEY_MDE, md.getDateEnded());
		db.insert("MEDICATION", null, values);
		db.close(); // Closing database connection
		
	}

	// Get Medication
	public Medication getMedication(String pillName) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM MEDICATOIN WHERE pillName = '"
				+ pillName + "'";

		Cursor cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		Medication md = new Medication(cursor.getString(0));
		md.setDateStarted(cursor.getString(1));
		md.setDateEnded(cursor.getString(2));

		return md;
	}

	// Getting All Medicaton
	public Cursor getAllMedication() {
		SQLiteDatabase db = this.getWritableDatabase();
		String selectQuery = "Select * from MEDICATION";
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;

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

	// Getting All allergy
	public Cursor getAllAllergy() {
		SQLiteDatabase db = this.getWritableDatabase();
		String selectQuery = "Select * from ALLERGY";
		Cursor cursor = db.rawQuery(selectQuery, null);
		return cursor;

	}

	// Get allergy
	public Allergy getAllergy(String name) {
		SQLiteDatabase db = this.getReadableDatabase();

		String selectQuery = "SELECT * FROM ALLERGY WHERE name = " + KEY_AGNAME;

		Cursor cursor = db.rawQuery(selectQuery, null);
		cursor.moveToFirst();
		Allergy ag = new Allergy();
		ag.setAllergyName(cursor.getString(1));
		ag.setAllergyDescription(cursor.getString(2));

		return ag;
	}
}
