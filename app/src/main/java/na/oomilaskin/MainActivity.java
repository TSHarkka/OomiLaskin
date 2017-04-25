package na.oomilaskin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuList = (ListView) findViewById(R.id.menuList);

        String[] val_arvot = new String[] {
                "Resistanssin laskeminen","Jännitteen laskeminen","Virran laskeminen" , "testi", "Lopeta sovellus"
        };

        ArrayAdapter<String> oma_adapteri = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, val_arvot);
        menuList.setAdapter(oma_adapteri);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int paikka, long id) {
                int kom_paikka = paikka;
                String komento = (String)  menuList.getItemAtPosition(paikka);
                Toast.makeText(getApplicationContext(), "Kohta : " + kom_paikka + " komento : " + komento, Toast.LENGTH_LONG).show();

                Intent akt = null;
                if (kom_paikka == 0) {
                    akt = new Intent(MainActivity.this, calc_res.class);
                    startActivity(akt);
                } else if (kom_paikka == 1) {
                    akt = new Intent(MainActivity.this, calc_volt.class);
                    startActivity(akt);
                } else if (kom_paikka == 2) {
                    akt = new Intent(MainActivity.this, calc_cur.class);
                    startActivity(akt);
                } else if (kom_paikka == 3) {
                    akt = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(akt);
                } else {
                    Intent intent = new Intent();
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    //////////////
    // Funktiot //
    //////////////

}
