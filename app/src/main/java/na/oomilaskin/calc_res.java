package na.oomilaskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_res extends AppCompatActivity {

    private EditText resEdit;
    private EditText voltEdit;
    private EditText curEdit;
    private TextView resView;
    private TextView voltView;
    private TextView curView;
    private Button laskeResBtn;
    private Button jaaLukuBtn;
    private Button jaaLukuTarkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_res);

        resEdit = (EditText) findViewById(R.id.resEdit);
        resEdit.setText("");
        resEdit.setEnabled(false);
        voltEdit = (EditText) findViewById(R.id.voltEdit);
        voltEdit.setText("");
        curEdit = (EditText) findViewById(R.id.curEdit);
        curEdit.setText("");

        resView = (TextView) findViewById(R.id.resView);
        voltView = (TextView) findViewById(R.id.voltView);
        curView = (TextView) findViewById(R.id.curView);

        laskeResBtn = (Button) findViewById(R.id.laskeResBtn);
        laskeResBtn.setOnClickListener(laskeResistanssi);
    }

    //////////////
    // Funktiot //
    //////////////
    View.OnClickListener laskeResistanssi = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            // laske resistanssi R=U/I
            if ( voltEdit.getText().toString().length() > 0 && curEdit.getText().toString().length() > 0 && Double.parseDouble(curEdit.getText().toString()) != 0) {
                resEdit.setText(Double.toString(Double.parseDouble(voltEdit.getText().toString()) / Double.parseDouble(curEdit.getText().toString())));
                voltEdit.setText("");
                curEdit.setText("");
            } else {
                resEdit.setText("Virheelliset arvot!");
            }
        }
    };
}
