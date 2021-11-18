package com.example.chickenmemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewList extends AppCompatActivity {

    private ListView listView1;
    private FirebaseDatabase Database1;
    private DatabaseReference reff1;
    private SaveData saveData1;
    private ArrayList<String> list1;
    private ArrayAdapter<String> adapter1;
    int amt=0;
    TextView t11;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        t11=(TextView) findViewById(R.id.text_view_1);
        b=(Button)findViewById(R.id.button3);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(viewList.this,Searchingdata.class);

                startActivity(it);
            }
        });

        saveData1=new SaveData();
        listView1=(ListView)findViewById(R.id.id_list_view1);
        Database1=FirebaseDatabase.getInstance();
        reff1=Database1.getReference("database");
        list1=new ArrayList<>();
        adapter1=new ArrayAdapter<String>(this,R.layout.cardview,R.id.cust_name121,list1);
        reff1.addValueEventListener(new ValueEventListener() {
                                       @Override
                                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                           for(DataSnapshot dta:dataSnapshot.getChildren()){

                                               saveData1=dta.getValue(SaveData.class);
                                               list1.add("customer name--"+saveData1.getCustomer_name().toString()+"\n"+
                                                       "item name--"+saveData1.getItems_name().toString()+"\n"+
                                                       "total_amount--"+saveData1.getTotal_amount()+"\n"+
                                                       "advance_amount--"+saveData1.getAdvance_amount()+"\n"+
                                                       "balance_amount--"+saveData1.getBalance_amount()+"\n"+
                                                       "date--"+saveData1.getDate_of_order().toString());

                                               amt=amt+Integer.parseInt(saveData1.getBalance_amount().toString());

                                           }
                                            listView1.setAdapter(adapter1);
                                            t11.setText("total overall balance:"+amt);


                                       }

                                       @Override
                                       public void onCancelled(@NonNull DatabaseError databaseError) {
                                           Toast.makeText(viewList.this,"something is wrong!!",Toast.LENGTH_SHORT).show();
                                           Intent t=new Intent(viewList.this,navigation.class);
                                           startActivity(t);


                                       }
                                   }
        );
    }
}
