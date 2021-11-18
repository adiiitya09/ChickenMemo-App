package com.example.chickenmemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Searchingdata extends AppCompatActivity {
    ListView l1;
    EditText eet11;
    Button b;

    private FirebaseDatabase Database;
    private DatabaseReference reff;
    private SaveData saveData;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    final String Tag="viewList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchingdata);
        eet11=(EditText) findViewById(R.id.editText2);
        b=(Button) findViewById(R.id.btn_121);
        l1=(ListView)findViewById(R.id.ListView1111);

        Database=FirebaseDatabase.getInstance();
        reff=Database.getReference("database");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.cardview,R.id.cust_name121,list);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff.addValueEventListener(new ValueEventListener() {
                                               @Override
                                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                   for(DataSnapshot dta:dataSnapshot.getChildren()){
                                                       saveData=dta.getValue(SaveData.class);
                                                       String s1=saveData.getCustomer_name().toString();
                                                       String s2=eet11.getText().toString();

                                                       if(s1.equals(s2)){
                                                           Toast.makeText(Searchingdata.this,"details found!!",Toast.LENGTH_SHORT).show();
                                                           list.add("customer name--"+saveData.getCustomer_name().toString()+"\n"+
                                                                   "item name--"+saveData.getItems_name().toString()+"\n"+
                                                                   "total_amount--"+saveData.getTotal_amount()+"\n"+
                                                                   "advance_amount--"+saveData.getAdvance_amount()+"\n"+
                                                                   "balance_amount--"+saveData.getBalance_amount()+"\n"+
                                                                   "date--"+saveData.getDate_of_order().toString());
                                                           break;

                                                       }
                                                       else {
                                                           Toast.makeText(Searchingdata.this,"searching for details!!",Toast.LENGTH_SHORT).show();
                                                       }


                                                   }
                                                   l1.setAdapter(adapter);

                                               }



                                               @Override
                                               public void onCancelled(@NonNull DatabaseError databaseError) {

                                                   Intent t=new Intent(Searchingdata.this,viewList.class);
                                                   startActivity(t);


                                               }
                                           }
                );

            }
        });






    }
}
