package net.androidbootcamp.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

import static net.androidbootcamp.medicalcalculator.R.drawable.ic_launcher_weight;

public class MainActivity extends AppCompatActivity {
    //Variables for calculations
    double dblConversionRate = 2.2;
    double dblWeightEntered;
    double dblConvertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set program and tool parameters
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(ic_launcher_weight);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Map controls
        final EditText weight = findViewById(R.id.txtWeight);
        final RadioButton rdLbToKilo = findViewById(R.id.radLBToKilo);
        final RadioButton rdKiloToLb = findViewById(R.id.radKiloToLB);
        final TextView result = findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                dblWeightEntered=Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat(("#.#"));
                if(rdLbToKilo.isChecked()){
                    if(dblWeightEntered <500){
                        dblConvertedWeight = dblWeightEntered / dblConversionRate;
                        result.setText(tenth.format(dblConvertedWeight) + " Kilograms");
                    } else {
                        Toast.makeText(MainActivity.this, " Pounds must be less than 500", Toast.LENGTH_SHORT).show();
                    }
                }

                if(rdKiloToLb.isChecked()){
                    if(dblWeightEntered <225){
                        dblConvertedWeight = dblWeightEntered * dblConversionRate;
                        result.setText(tenth.format(dblConvertedWeight) + " Pounds");
                    } else {
                        Toast.makeText(MainActivity.this, " Kilos must be less than 225", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }
}
