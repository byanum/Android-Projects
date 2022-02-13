package com.example.externalstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String name = "contactsManager";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String tbl_contacts = "contacts";


//    ---------------------------built iin--------------------------------------
    @RequiresApi(api = Build.VERSION_CODES.P)
    public DatabaseHandler(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE" +tbl_contacts+"("
                +KEY_ID+ "INTEGER PRIMARY KEY," +KEY_NAME+"TEXT,"
                +KEY_PHONE+ "TEXT"+")";

        db.execSQL(createQuery);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " +tbl_contacts);

        onCreate(db);

    }

//    --------------------------------built in----------------------------------


//    developer defined

//    INSERT CONTACTS
    void addContacts(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
//        fetch values
        cv.put(KEY_NAME, contact.getName());
        cv.put(KEY_PHONE,contact.getPhone());

//        insert query
        db.insert(tbl_contacts, null, cv);
        db.close();
    }

//    UPDATE CONTACTS
    int updateContacts(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(KEY_NAME, contact.getName());
        cv.put(KEY_PHONE, contact.getPhone());

        return db.update(tbl_contacts,cv, KEY_ID+ " =?", new String[]{String.valueOf(contact.getId())});


    }

//    DELETE CONTACT
    void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(tbl_contacts,KEY_ID+" =?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

//    COUNTING ALL OF THE CONTACTS
    int Counting(Contact contact) {
        String countQuery = "SELECT * FROM " + tbl_contacts;
        SQLiteDatabase db = this.getReadableDatabase();

//    use cursor
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }


//    to show single contact on the list
//    SINGLE CONTACT
    void getSingle(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tbl_contacts, new String[] { KEY_ID,
                        KEY_NAME, KEY_PHONE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();

            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
            // return contact
            return contact;

        }

    }


//    LIST: CONTACTS
    public List<Contact> getContactList(){
        List<Contact> contactList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM "  +tbl_contacts;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

//        looping through all list and adding to list

        if(cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
    }



}
