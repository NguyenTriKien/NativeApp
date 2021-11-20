package vn.com.greenwich.estateapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.time.LocalDateTime;

public class EstateDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "EstateInformation.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Estate";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Estate_name";
    private static final String COLUMN_STREET = "Street";
    private static final String COLUMN_CITY = "City";
    private static final String COLUMN_DISTRICT = "District";
    private static final String COLUMN_WARD = "Ward";
    private static final String COLUMN_TYPE = "Type";
    private static final String COLUMN_BEDROOM = "Bedroom";
    private static final String COLUMN_PRICE = "Price";
    private static final String COLUMN_FURNITURE = "Furniture";
    private static final String COLUMN_REPORTER = "Reporter";
    private static final String COLUMN_NOTE = "Note";
    private static final String COLUMN_DATE = "Date";

    public EstateDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String query = "CREATE TABLE " + TABLE_NAME +
                       " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                       COLUMN_NAME + " TEXT, " +
                       COLUMN_STREET + " TEXT, " +
                       COLUMN_CITY + " TEXT, " +
                       COLUMN_DISTRICT + " TEXT, " +
                       COLUMN_WARD + " TEXT, " +
                       COLUMN_TYPE + " TEXT, " +
                       COLUMN_BEDROOM + " INTEGER, " +
                       COLUMN_PRICE + " INTEGER, " +
                       COLUMN_FURNITURE + " TEXT, " +
                       COLUMN_REPORTER + " TEXT, " +
                       COLUMN_NOTE + " TEXT, " +
                       COLUMN_DATE + " REAL);";
       db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
       onCreate(db);
    }

    void addEstate(String Name, String Street, String City, String District, String Ward, String Type,
                 int Bedroom, float Price, String Furniture, String Reporter, String Note){

        LocalDateTime Date = LocalDateTime.now();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, Name);
        cv.put(COLUMN_STREET, Street);
        cv.put(COLUMN_CITY, City);
        cv.put(COLUMN_DISTRICT, District);
        cv.put(COLUMN_WARD, Ward);
        cv.put(COLUMN_TYPE, Type);
        cv.put(COLUMN_BEDROOM, Bedroom);
        cv.put(COLUMN_PRICE, Price);
        cv.put(COLUMN_FURNITURE, Furniture);
        cv.put(COLUMN_REPORTER, Reporter);
        cv.put(COLUMN_NOTE, Note);
        cv.put(COLUMN_DATE, String.valueOf(Date));
        
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = " SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
           cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
