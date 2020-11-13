package com.alshanini.ozba;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.alshanini.ozba.R.id.bottomNavigationView;
import static com.alshanini.ozba.R.id.textView1;
import static com.alshanini.ozba.R.id.textview2;

public class Main4Activity extends MainActivity {
    ArrayAdapter<String> arrayAdapteraccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ListView listViewaccount=(ListView)findViewById(R.id.listviewaccount);
        Button remove=(Button)findViewById(R.id.rem) ;

        BottomNavigationView bottomNavigationview= findViewById(bottomNavigationView);
        bottomNavigationview.setSelectedItemId(R.id.secondFragment);

        bottomNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.firstFragment:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.secondFragment:

                        return true;

                    case R.id.thirdFragment:
                        startActivity(new Intent(getApplicationContext(),Main5Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });








        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertdialogBuilder=new AlertDialog.Builder(Main4Activity.this);
                alertdialogBuilder.setMessage(R.string.sure_delete);
                alertdialogBuilder.setCancelable(false);
                alertdialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String phonett = phonet.getText().toString().trim();
                        String  tt11=db.getstring(phonett);
                        query10(tt11);

                    }
                });
                alertdialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog=alertdialogBuilder.create();
                alertDialog.show();

            }




        });

        arrayAdapteraccount = new myaddapter(this,myarraylist2,myarraylist3,myarraylist4,myarraylist5,myarraylist6);
        listViewaccount.setAdapter(arrayAdapteraccount);

        String phonett = phonet.getText().toString().trim();

        tt=db.getstring(phonett);

        query2(tt);


    }

    class myaddapter extends ArrayAdapter<String>{
        Context context;
        ArrayList<String> rTitle;
        ArrayList<String> rdescription;
        ArrayList<String> rprice;
        ArrayList<String> rimage;
        ArrayList<String> rdate;




        myaddapter(Context c, ArrayList<String> title, ArrayList<String> description, ArrayList<String> image,ArrayList<String> pricen,ArrayList<String> date) {
            super(c,R.layout.row , textView1, title);
            this.context=c;
            this.rTitle=title;
            this.rdescription=description;
            this.rimage=image;
            this.rprice=pricen;
            this.rdate=date;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);

            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView image=row.findViewById(R.id.image);
            TextView mTitle=row.findViewById(textView1);
            TextView mdescription=row.findViewById(textview2);
            TextView mprice=row.findViewById(R.id.textview4);
            TextView mdate=row.findViewById(R.id.textview3);



            image.setImageResource(R.drawable.ic_row);
            mTitle.setText(rTitle.get(position));
            mdescription.setText(rdescription.get(position));
            mprice.setText(rprice.get(position));
            mdate.setText(rdate.get(position));

            return row;
        }
    }














    public void query2(String tt1){

        if(!tt1.isEmpty()) {

            Query query2 = FirebaseDatabase.getInstance().getReference("memb")
                    .orderByChild("id").startAt(tt1).endAt(tt1);
            query2.addListenerForSingleValueEvent(valueEventListener1);
        }else
            Toast.makeText(Main4Activity.this,R.string.no_purchases,Toast.LENGTH_LONG).show();
    }
    ValueEventListener valueEventListener1 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            myarraylist2.clear();
            myarraylist3.clear();
            myarraylist4.clear();
            myarraylist5.clear();
            myarraylist6.clear();


            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    // String value=snapshot.child("name").getValue().toString();
                    //   String id=  snapshot.child("id").getValue().toString();

                    String phone=snapshot.child("phone").getValue().toString();
                    String item=snapshot.child("item").getValue().toString();
                    String price=snapshot.child("price").getValue().toString();
                    String date=snapshot.child("date").getValue().toString();
                    myarraylist2.add(phone );
                    myarraylist3.add( item);
                    myarraylist4.add(price);
                    myarraylist5.add(price);
                    myarraylist6.add(date);




                }
            arrayAdapteraccount.notifyDataSetChanged();


            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

}