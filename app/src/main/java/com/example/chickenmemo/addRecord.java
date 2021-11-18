package com.example.chickenmemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class addRecord extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText et1,et2,et3,et4;
    Button bt1;
    Spinner spl;
    String itemselect,balance;
    String name;
    int total=0,received=0;
    DatabaseReference dreff;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        et1=(EditText) findViewById(R.id.cutomer_name);
        et2=(EditText) findViewById(R.id.total_amt121);
        et3=(EditText) findViewById(R.id.adv_amt);
        et4=(EditText) findViewById(R.id.bal_amt);
        bt1=(Button) findViewById(R.id.btn_add_list);
        spl=findViewById(R.id.spinner123);
        dreff=FirebaseDatabase.getInstance().getReference("database");


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.order_details, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spl.setAdapter(adapter);
        spl.setOnItemSelectedListener(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveTheData();
                Intent it=new Intent(addRecord.this,navigation.class);
                startActivity(it);
            }
        });

        et4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balance_cal();
                et4.setText(balance);
                Toast.makeText(addRecord.this,"balance is:"+balance,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void SaveTheData() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        Date date = new Date();
        String Datee =formatter.format(date);
        SaveData s=new SaveData(name,itemselect,total,Datee,balance,received);
        dreff.push().setValue(s);
        Toast.makeText(addRecord.this,"data saved sucessfully..",Toast.LENGTH_SHORT).show();


    }


    private void balance_cal() {

        name=et1.getText().toString().trim();
        total=(Integer) parseInt(et2.getText().toString());
        received=(Integer) parseInt(et3.getText().toString());
        balance = String.valueOf(total - received);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemselect = parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

