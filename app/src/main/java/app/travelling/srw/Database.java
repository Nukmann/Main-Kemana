package app.travelling.srw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.ProcessingInstruction;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Computer on 4/24/2016.
 */
public class Database extends SQLiteOpenHelper {

    public static final String DB_PATH = "data/data/app.travelling.srw";
    public static final String DB_pariwisata = "Pariwisata.db";
    private SQLiteDatabase DBwisata;
    private final Context Cwisata;

    public Database(Context context){
        super(context, DB_pariwisata, null, 1);
        this.Cwisata = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void openDatabase()  {
        String myPath = DB_PATH + DB_pariwisata;
        DBwisata = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (DBwisata!=null) {
            DBwisata.close();
        }
    }


    public List<Destination> getListDestination()  {
        Destination destination = null;
        List<Destination> destinationList = new ArrayList<>();
        openDatabase();
        Cursor cursor = DBwisata.rawQuery("SELECT * FROM DESTINATION", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            destination = new Destination(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getInt(4), cursor.getInt(5), cursor.getInt(6));
            destinationList.add(destination);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return destinationList;
}
}


