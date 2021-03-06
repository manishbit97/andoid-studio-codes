package com.example.appp48_sqlite_all;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
static final String KEY_ROWID = "_id";
static final String KEY_NAME = "name";
static final String KEY_NUM = "num";

//static final String TAG = "DBAdapter";
static final String DATABASE_NAME = "MyDBT";
static final String DATABASE_TABLE = "contacts";
static final int DATABASE_VERSION = 1;
static final String DATABASE_CREATE =
"create table contacts (_id integer primary key, "
+ "name text not null, num text not null);";
   final Context context;
private DatabaseHelper DBHelper;
private SQLiteDatabase db;
public DBAdapter(Context ctx)      //This is the constructor
{
this.context = ctx;
DBHelper = new DatabaseHelper(context);
}

private static class DatabaseHelper extends SQLiteOpenHelper  //inherits sqliteopenhelper
{
	DatabaseHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

@Override
	public void onCreate(SQLiteDatabase db)
	{
	try {
		db.execSQL(DATABASE_CREATE);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
/*Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
+ newVersion + ", which will destroy all old data");
db.execSQL("DROP TABLE IF EXISTS contacts");
onCreate(db);*/
	}
}
//---opens the database---
public DBAdapter open() throws SQLException
{
db = DBHelper.getWritableDatabase();
return this;
}
//---closes the database---
public void close()
{
DBHelper.close();
}
//---insert a contact into the database---
public long insert(String _id ,String name, String num)
{
ContentValues cv = new ContentValues();
cv.put(KEY_ROWID, _id);
cv.put(KEY_NAME, name);
cv.put(KEY_NUM, num);

return db.insert(DATABASE_TABLE, null, cv);
}
//---deletes a particular contact---
public boolean deleteContact(long rowId)
{
return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
}

//---retrieves all the contacts---
public Cursor retrieveAll()
{
return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_NAME,
KEY_NUM}, null, null, null, null, KEY_NAME);
}
//---retrieves a particular contact---
public Cursor getContact(long rowId) throws SQLException
{
Cursor mCursor =
db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
KEY_NAME, KEY_NUM}, KEY_ROWID + "=" + rowId, null,
null, null, null, null);
if (mCursor != null) {
mCursor.moveToFirst();
}
return mCursor;
}
//---updates a contact---
public boolean updateContact(long rowId, String name, String num)
{
ContentValues args = new ContentValues();
args.put(KEY_NAME, name);
args.put(KEY_NUM, num);
return db.update(
DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
}
   
}