package na.oomilaskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_volt extends AppCompatActivity {

    private EditText resEdit;
    private EditText voltEdit;
    private EditText curEdit;
    private TextView resView;
    private TextView voltView;
    private TextView curView;
    private Button laskeVoltBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_volt);

        resEdit = (EditText) findViewById(R.id.resEdit);
        resEdit.setText("");
        voltEdit = (EditText) findViewById(R.id.voltEdit);
        voltEdit.setText("");
        voltEdit.setEnabled(false);
        curEdit = (EditText) findViewById(R.id.curEdit);
        curEdit.setText("");

        resView = (TextView) findViewById(R.id.resView);
        voltView = (TextView) findViewById(R.id.voltView);
        curView = (TextView) findViewById(R.id.curView);

        laskeVoltBtn = (Button) findViewById(R.id.laskeVoltBtn);
        laskeVoltBtn.setOnClickListener(laskeJannite);
    }

    //////////////
    // Funktiot //
    //////////////

    View.OnClickListener laskeJannite = new View.OnClickListener()
    {
        // lasketaan jännite U=RI
        public void onClick(View v)
        {
            //laske jännite U=RI
            if ( resEdit.getText().toString().length() > 0 && curEdit.getText().toString().length() > 0) {
                voltEdit.setText( Double.toString(Double.parseDouble(resEdit.getText().toString()) * Double.parseDouble(curEdit.getText().toString())) );
                resEdit.setText("");
                curEdit.setText("");
            } else {
                voltEdit.setText("Virheelliset arvot!");
            }
        }
    };

}
