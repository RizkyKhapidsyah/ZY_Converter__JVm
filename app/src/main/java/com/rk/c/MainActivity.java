package com.rk.c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    TextView dollars;
    TextView rupiah;
    RadioButton dtor;
    RadioButton rtod;
    Button convert;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        dollars = (TextView) this.findViewById(R.id.dollar);
        rupiah = (TextView) this.findViewById(R.id.rupiah);

        dtor = (RadioButton) this.findViewById(R.id.dtor);
        dtor.setChecked(true);
        rtod = (RadioButton) this.findViewById(R.id.rtod);

        convert = (Button) this.findViewById(R.id.convert);
        convert.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (dtor.isChecked()) {
            convertDollarsToRupiah();
        }
        if (rtod.isChecked()) {
            convertRupiahToDollars();
        }
    }

    protected void convertDollarsToRupiah() {
        double val = Double.parseDouble(dollars.getText().toString());
        // in a real app, we'd get this off the 'net
        rupiah.setText(Double.toString(val * 14000));
    }

    protected void convertRupiahToDollars() {
        double val = Double.parseDouble(rupiah.getText().toString());
        // in a real app, we'd get this off the 'net
        dollars.setText(Double.toString(val / 14000));
    }
}
