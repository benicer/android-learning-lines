package com.example.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

	public static final String CREATE_BOOK = "create table Book ("
			+ "id integer primary key autoincrement, " 
			+ "author text, "
			+ "price real, " 
			+ "pages integer, " 
			+ "name text)";
	
	public static final String CREATE_CATEGORY = "create table Category ("
			+ "id integer primary key autoincrement, "
			+ "category_name text, "
			+ "category_code integer)";

	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BOOK);
		db.execSQL(CREATE_CATEGORY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists Book");
		db.execSQL("drop table if exists Category");
		onCreate(db);
	}

}
