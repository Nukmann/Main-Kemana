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

/**
 * Created by Computer on 4/24/2016.
 */
public class Database extends SQLiteOpenHelper {

    private static String DB_PATH = "data/data/SRW/databases/";
    private static String DB_pariwisata = "Pariwisata";
    private SQLiteDatabase DBwisata;
    private final Context Cwisata;
    public String NamaLokasi = "NamaDestinasi";
    public String Harga = "Harga";

    public Database(Context c){
        super(c, DB_pariwisata, null, 1);
        this.Cwisata = c;
    }

    public void databasewisata() throws IOException{
        boolean dbExist = checkDatabase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e){
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_pariwisata;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e){

        } if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = Cwisata.getAssets().open(DB_pariwisata);
        String outFileName = DB_PATH + DB_pariwisata;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDatabase() throws SQLException {
        String myPath = DB_PATH + DB_pariwisata;
        DBwisata = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if (DBwisata != null)
            DBwisata.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllEvents(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select rowid _id, * from eventlist order by id desc", null);
        if (cursor != null){
            cursor.moveToFirst();
        } return cursor;
    }
}

