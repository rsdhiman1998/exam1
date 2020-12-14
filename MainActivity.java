package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String subjects[] = {"Java","Swift","Ios","Android","Database"};
    ArrayList<Course> courseDetails = new ArrayList<>();
    TextView Welcome,fees,hours,total_fees,total_hours;
    Spinner sp;
    RadioButton grad, ungrad;
    Button add;
    boolean firstrb, secondrb;
    CheckBox accomo,medical;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillingdata();
        Welcome=findViewById(R.id.tx1);
        Welcome.setText("Welcome back "+LoginPage.studentName);

        sp=findViewById(R.id.sp1);
        fees=findViewById(R.id.fee1);
        hours=findViewById(R.id.hrs1);
        total_fees=findViewById(R.id.tfees);
        total_hours=findViewById(R.id.thrs);
        grad=findViewById(R.id.rb1);
        ungrad=findViewById(R.id.rd1);
        accomo=findViewById(R.id.ch1);
        medical=findViewById(R.id.ch2);
        add=findViewById(R.id.buttonAdd);


        ArrayAdapter rs = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,subjects);
        sp.setAdapter(rs);
        //fees.setText(Double.toString(courseDetails.get(0).getFess()));

        sp.setOnItemSelectedListener(this);
        grad.setOnClickListener(new RadioButtonActions());
        ungrad.setOnClickListener(new RadioButtonActions());
        accomo.setOnCheckedChangeListener(new CheckBoxActions());
        medical.setOnCheckedChangeListener(new CheckBoxActions());
        add.setOnClickListener(new RadioButtonActions());
    }

    public void fillingdata()
    {
        courseDetails.add(new Course(1300.0,6,subjects[0]));
        courseDetails.add(new Course(1500.0,5,subjects[1]));
        courseDetails.add(new Course(1350.0,5,subjects[2]));
        courseDetails.add(new Course(1400.0,7,subjects[3]));
        courseDetails.add(new Course(1000.0,4,subjects[4]));
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        fees.setText(String.valueOf(courseDetails.get(position).getFess()));
        hours.setText(String.valueOf(courseDetails.get(position).getHrs()));

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class RadioButtonActions implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (v.getId()==R.id.rb1)
            {
                firstrb = true;
                secondrb = false;
            }
            else if(v.getId() == R.id.rd1)
            {
                firstrb = false;
                secondrb = true;
            }else if(v.getId()==R.id.buttonAdd) {
                double currentFees = Double.parseDouble(total_fees.getText().toString());
                double currentHrs = Double.parseDouble(total_hours.getText().toString());
                currentHrs += Double.parseDouble(hours.getText().toString());
           //     currentFees+=Double.parseDouble(fees.getText().toString());

                if (firstrb == true) {
                    if(currentHrs <= 19)
                    {
                        currentFees+=Double.parseDouble(fees.getText().toString());
                        total_hours.setText(String.valueOf(currentHrs));
                        total_fees.setText(String.valueOf(currentFees));
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "You can not add more ", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(secondrb == true)
                {
                    if(currentHrs<= 21)
                    {
                        currentFees+=Double.parseDouble(fees.getText().toString());
                        total_hours.setText(String.valueOf(currentHrs));
                        total_fees.setText(String.valueOf(currentFees));
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "You can not add more ", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        }
    }

    private class CheckBoxActions implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            double currentPrice = Double.parseDouble(fees.getText().toString());
            if (buttonView.getId() == R.id.ch1) {
                if (accomo.isChecked()) {
                    currentPrice += 1000;
                    total_fees.setText(String.valueOf(currentPrice));
                } else {
                    currentPrice -= 1000;
                    total_fees.setText(String.valueOf(currentPrice));
                }
            }
            if (buttonView.getId() == R.id.ch2) {
                if (medical.isChecked()) {
                    currentPrice += 700;
                    total_fees.setText(String.valueOf(currentPrice));
                } else {
                    currentPrice -= 700;
                    total_fees.setText(String.valueOf(currentPrice));
                }
            }

        }
    }
}