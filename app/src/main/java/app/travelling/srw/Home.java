package app.travelling.srw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class Home extends Activity {

    private Database dbWisata;
    private ListView lvDestination;
    private ListDestinationAdapter adapter;
    private List<Destination> destinationList;
    //Button  inf, rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_home);
        lvDestination = (ListView) findViewById(R.id.listView2);
        dbWisata = new Database(this);

        //check exists database
        File database = getApplicationContext().getDatabasePath(Database.DB_pariwisata);
        if (false == database.exists()) {
            dbWisata.getReadableDatabase();

            //Get destination list in database when database exists
            //init adapter
            adapter = new ListDestinationAdapter(this, destinationList);
            //set adapter for list view
            lvDestination.setAdapter(adapter);

            //copy database
            if (copyDatabase(this)) {
                Toast.makeText(this, "Copy database success", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_LONG).show();
                return;
            }
        }


    }

    private boolean copyDatabase (Context context) {
        try {

            InputStream inputStream = context.getAssets().open(Database.DB_pariwisata);
            String outFileName = Database.DB_PATH + Database.DB_pariwisata;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int lenght = 0;
            while ((lenght = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, lenght);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("Home", "DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
