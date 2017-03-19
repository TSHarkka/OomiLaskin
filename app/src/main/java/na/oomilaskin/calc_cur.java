package na.oomilaskin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_cur extends AppCompatActivity {

    private EditText resEdit;
    private EditText voltEdit;
    private EditText curEdit;
    private TextView resView;
    private TextView voltView;
    private TextView curView;
    private Button laskeCurBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_cur);

        resEdit = (EditText) findViewById(R.id.resEdit);
        resEdit.setText("");
        voltEdit = (EditText) findViewById(R.id.voltEdit);
        voltEdit.setText("");
        curEdit = (EditText) findViewById(R.id.curEdit);
        curEdit.setText("");

        resView = (TextView) findViewById(R.id.resView);
        voltView = (TextView) findViewById(R.id.voltView);
        curView = (TextView) findViewById(R.id.curView);

        laskeCurBtn = (Button) findViewById(R.id.laskeCurBtn);
        laskeCurBtn.setOnClickListener(laskeVirta);
    }


    //////////////
    // Funktiot //
    //////////////

    View.OnClickListener laskeVirta = new View.OnClickListener()
    {
        // lasketaan virta I=U/R
        public void onClick(View v)
        {
            // lasketaan virta I=U/R
            if ( resEdit.getText().toString().length() > 0 && Double.parseDouble( voltEdit.getText().toString() ) != 0 && voltEdit.getText().toString().length() > 0 ) {
                curEdit.setText( Double.toString(Double.parseDouble( voltEdit.getText().toString() ) / Double.parseDouble( resEdit.getText().toString()) ) );
                voltEdit.setText("");
                resEdit.setText("");
            } else {
                curEdit.setText("Virheelliset arvot!");
            }
        }
    };
}
