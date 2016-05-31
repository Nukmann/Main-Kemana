package app.travelling.srw;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Computer on 4/24/2016.
 */
public class Recommendation extends AppCompatActivity {
    public RadioButton jarak1, jarak2, jarak3;
    public RadioButton harga1, harga2, harga3;
    public RadioButton fasilitas1, fasilitas2, fasilitas3;
    public RadioGroup choice1, choice2, choice3;
    public RadioButton parameter1;
    public Button recommend;
    public boolean jarak1ischecked;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        choice1 = (RadioGroup) findViewById(R.id.choice1);
        choice2 = (RadioGroup) findViewById(R.id.choice2);
        choice3 = (RadioGroup) findViewById(R.id.choice3);

        jarak1 = (RadioButton) findViewById(R.id.jarak1);
        jarak2 = (RadioButton) findViewById(R.id.jarak2);
        jarak3 = (RadioButton) findViewById(R.id.jarak3);

        harga1 = (RadioButton) findViewById(R.id.harga1);
        harga2 = (RadioButton) findViewById(R.id.harga2);
        harga3 = (RadioButton) findViewById(R.id.harga3);

        fasilitas1 = (RadioButton) findViewById(R.id.fasilitas1);
        fasilitas2 = (RadioButton) findViewById(R.id.fasilitas2);
        fasilitas3 = (RadioButton) findViewById(R.id.fasilitas3);

        recommend = (Button) findViewById(R.id.button);
        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickrecommend();
            }
        });

        choice1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.jarak1) {
                    harga2.setEnabled(true);
                    harga3.setEnabled(true);
                    jarak2.setEnabled(false);
                    jarak3.setEnabled(false);
                    fasilitas2.setEnabled(true);
                    fasilitas3.setEnabled(true);
                } else if (checkedId == R.id.fasilitas1) {
                    harga2.setEnabled(true);
                    harga3.setEnabled(true);
                    jarak2.setEnabled(true);
                    jarak3.setEnabled(true);
                    fasilitas2.setEnabled(false);
                    fasilitas3.setEnabled(false);
                } else {
                    jarak2.setEnabled(true);
                    jarak3.setEnabled(true);
                    harga2.setEnabled(false);
                    harga3.setEnabled(false);
                    fasilitas2.setEnabled(true);
                    fasilitas3.setEnabled(true);
                }
            }
        });

        choice2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.jarak2) {
                    jarak3.setEnabled(false);
                    if (harga3.isEnabled() == false) {
                        fasilitas3.setChecked(true);
                    } else if (fasilitas3.isEnabled() == false){
                        harga3.setChecked(true);
                    }
                } else if (checkedId == R.id.fasilitas2) {
                    fasilitas3.setEnabled(false);
                    if (harga3.isEnabled() == false) {
                        jarak3.setChecked(true);
                    } else if (jarak3.isEnabled() == false){
                        harga3.setChecked(true);
                    }
                } else {
                    harga3.setEnabled(false);
                    if (jarak3.isEnabled() == false) {
                        fasilitas3.setChecked(true);
                    } else if (fasilitas3.isEnabled() == false){
                        jarak3.setChecked(true);
                    }
                }
            }
        });

    }

    public void clickrecommend() {

    }
}
