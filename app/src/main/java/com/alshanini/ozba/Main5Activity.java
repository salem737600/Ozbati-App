package com.alshanini.ozba;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static com.alshanini.ozba.R.id.bottomNavigationView;
import static java.lang.Integer.*;

public class Main5Activity extends MainActivity {

    private AdView mAdView;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView14;
    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;
    TextView textView20;





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        textView1=(TextView)findViewById(R.id.textview1) ;
         textView2=(TextView)findViewById(R.id.textview2) ;
        textView3=(TextView)findViewById(R.id.textview3) ;
        textView4=(TextView)findViewById(R.id.textview4) ;
        textView5=(TextView)findViewById(R.id.textview5) ;
        textView6=(TextView)findViewById(R.id.textview6) ;
        textView7=(TextView)findViewById(R.id.textview7) ;
        textView8=(TextView)findViewById(R.id.textview8) ;
        textView9=(TextView)findViewById(R.id.textview9) ;
        textView10=(TextView)findViewById(R.id.textview10) ;
        textView11=(TextView)findViewById(R.id.textview11) ;
        textView12=(TextView)findViewById(R.id.textview12) ;
        textView13=(TextView)findViewById(R.id.textview13) ;
        textView14=(TextView)findViewById(R.id.textview14) ;
        textView15=(TextView)findViewById(R.id.textview15) ;
        textView16=(TextView)findViewById(R.id.textview16) ;
        textView17=(TextView)findViewById(R.id.textview17) ;
        textView18=(TextView)findViewById(R.id.textview18) ;
        textView19=(TextView)findViewById(R.id.textview19) ;
        textView20=(TextView)findViewById(R.id.textview20) ;

        final LinearLayout linear=(LinearLayout)findViewById(R.id.linear3) ;
query13();

      Button button=(Button) findViewById(R.id.button) ;
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder alertdialogBuilder=new AlertDialog.Builder(Main5Activity.this);
        alertdialogBuilder.setMessage(R.string.sure_exit_grp);
        alertdialogBuilder.setCancelable(false);
        alertdialogBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String phonett = phonet.getText().toString().trim();
                String  tt11=db.getstring(phonett);
                query11();

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

        BottomNavigationView bottomNavigationview= findViewById(bottomNavigationView);
        bottomNavigationview.setSelectedItemId(R.id.thirdFragment);

        bottomNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.firstFragment:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.secondFragment:
                        startActivity(new Intent(getApplicationContext(),Main4Activity.class));
                        overridePendingTransition(0,0);

                        return true;

                    case R.id.thirdFragment:
                          return true;
                }
                return false;
            }
        });


        String phonett = phonet.getText().toString().trim();

        tt=db.getstring(phonett);
        queryt(tt);


    }




    public void queryt(String tt1){

        Query query2= FirebaseDatabase.getInstance().getReference("me")
                .orderByChild("id").startAt(tt1).endAt(tt1);
        query2.addListenerForSingleValueEvent(valueEventListener1);
    }
    ValueEventListener valueEventListener1 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            myarraylist2.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    // String value=snapshot.child("name").getValue().toString();
                    //   String id=  snapshot.child("id").getValue().toString();
                    String total=snapshot.child("total").getValue().toString();
                    String total1=snapshot.child("total1").getValue().toString();
                    String total2=snapshot.child("total2").getValue().toString();
                    String total3=snapshot.child("total3").getValue().toString();
                    String total4=snapshot.child("total4").getValue().toString();
                    String name=snapshot.child("name").getValue().toString();
                    String name1=snapshot.child("name1").getValue().toString();
                    String name2=snapshot.child("name2").getValue().toString();
                    String name3=snapshot.child("name3").getValue().toString();
                    String name4=snapshot.child("name4").getValue().toString();
                    int number= parseInt(snapshot.child("number").getValue().toString());

                   if(number==5) {
                       textView1.setText(name); textView2.setText("="); textView3.setText(total);
                       textView4.setText(name1); textView5.setText("="); textView6.setText(total1);
                       textView7.setText(name2); textView8.setText("="); textView9.setText(total2);
                       textView10.setText(name3); textView11.setText("="); textView12.setText(total3);
                       textView13.setText(name4); textView14.setText("=");textView15.setText(total4);


                   }else if(number==4){
                       textView1.setText(name); textView2.setText("="); textView3.setText(total);
                       textView4.setText(name1); textView5.setText("="); textView6.setText(total1);
                       textView7.setText(name2); textView8.setText("="); textView9.setText(total2);
                       textView10.setText(name3); textView11.setText("="); textView12.setText(total3);

                   }
                   else if(number==3){
                       textView1.setText(name); textView2.setText("="); textView3.setText(total);
                       textView4.setText(name1); textView5.setText("="); textView6.setText(total1);
                       textView7.setText(name2); textView8.setText("="); textView9.setText(total2);

                   }else if(number==2){
                       textView1.setText(name); textView2.setText("="); textView3.setText(total);
                       textView4.setText(name1); textView5.setText("="); textView6.setText(total1);

                       }else if(number==1){
                       textView1.setText(name); textView2.setText("="); textView3.setText(total);
                       }





                }



            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };


    public void query13(){
        String phonett = phonet.getText().toString().trim();
        String  tt11=db.getstring(phonett);
        if(!tt11.isEmpty()) {
            Query query2 = FirebaseDatabase.getInstance().getReference("mem")
                    .orderByChild("id").startAt(tt11).endAt(tt11);
              query2.addListenerForSingleValueEvent(valueEventListener13);
        }else
            Toast.makeText(Main5Activity.this,R.string.doesntexist,Toast.LENGTH_LONG).show();
    }
    ValueEventListener valueEventListener13 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            myarraylist2.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String phonett = phonet.getText().toString().trim();
                    String  tt11=db.getstring(phonett);

                    String size = (String) snapshot.child("size").getValue();
                    String size1 = (String) snapshot.child("size1").getValue();
                    String size2 = (String) snapshot.child("size2").getValue();
                    String size3 = (String) snapshot.child("size3").getValue();
                    String size4 = (String) snapshot.child("size4").getValue();




                    textView16.setText(size);
                    textView17.setText(size1);
                    textView18.setText(size2);
                    textView19.setText(size3);
                    textView20.setText(size4);




                }



            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };



    public void query11(){
        String phonett = phonet.getText().toString().trim();
        String  tt11=db.getstring(phonett);
        if(!tt11.isEmpty()) {
            Query query2 = FirebaseDatabase.getInstance().getReference("member");
            query2.addListenerForSingleValueEvent(valueEventListener11);

        }else
            Toast.makeText(Main5Activity.this,R.string.doesntexist,Toast.LENGTH_LONG).show();

    }


    ValueEventListener valueEventListener11= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() != null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value = (String) snapshot.child("name").getValue();
                    String phone = (String) snapshot.child("phone").getValue();
                    String phone1 = (String) snapshot.child("phone1").getValue();
                    String phone2 = (String) snapshot.child("phone2").getValue();
                    String phone3 = (String) snapshot.child("phone3").getValue();
                    String phone4 = (String) snapshot.child("phone4").getValue();
                    final String id = (String) snapshot.child("id").getValue();

                    int number= parseInt(value);
                    String phonett = phonet.getText().toString().trim();
                    String  tt11=db.getstring(phonett);

                    if(phonett.equals(phone)){
                        reff.child(tt11).child("phone").setValue(phone+"eee");
                        db.delete(tt11);
                        number--;
                        reff.child(tt11).child("name").setValue(String.valueOf(number));
                        reff4.child(tt11).child("number").setValue(String.valueOf(number));
                        reff4.child(tt11).child("myprice").setValue(String.valueOf("0"));
                        reff5.child(tt11).child("total").setValue(String.valueOf("0"));
                        reff4.child(tt11).child("size").setValue("Exit");

                        Toast.makeText(Main5Activity.this,R.string.number_exited,Toast.LENGTH_LONG).show();

                    }
                    if(phonett.equals(phone1)){
                        reff.child(tt11).child("phone1").setValue(phone+"fff");
                        db.delete(tt11);
                        number--;
                        reff.child(tt11).child("name").setValue(String.valueOf(number));
                        reff4.child(tt11).child("number").setValue(String.valueOf(number));
                        reff4.child(tt11).child("myprice1").setValue(String.valueOf("0"));
                        reff5.child(tt11).child("total1").setValue(String.valueOf("0"));
                        reff4.child(tt11).child("size1").setValue("Exit");


                        Toast.makeText(Main5Activity.this,R.string.number_exited,Toast.LENGTH_LONG).show();

                    }
                    if(phonett.equals(phone2)){
                        reff.child(tt11).child("phone2").setValue(phone2+"ggg");
                        db.delete(tt11);
                        number--;
                        reff.child(tt11).child("name").setValue(String.valueOf(number));
                        reff4.child(tt11).child("number").setValue(String.valueOf(number));
                        reff4.child(tt11).child("myprice2").setValue(String.valueOf("0"));
                        reff5.child(tt11).child("total2").setValue(String.valueOf("0"));
                        reff4.child(tt11).child("size2").setValue("Exit");
                        Toast.makeText(Main5Activity.this,R.string.number_exited,Toast.LENGTH_LONG).show();

                    }
                    if(phonett.equals(phone3)){
                        reff.child(tt11).child("phone3").setValue(phone3+"hhh");
                        db.delete(tt11);
                        number--;
                        reff.child(tt11).child("name").setValue(String.valueOf(number));
                        reff4.child(tt11).child("number").setValue(String.valueOf(number));
                        reff4.child(tt11).child("myprice3").setValue(String.valueOf("0"));
                        reff5.child(tt11).child("total3").setValue(String.valueOf("0"));
                        reff4.child(tt11).child("size3").setValue("Exit");
                        Toast.makeText(Main5Activity.this,R.string.number_exited,Toast.LENGTH_LONG).show();

                    }
                    if(phonett.equals(phone4)){
                        reff.child(tt11).child("phone4").setValue(phone4+"iii");
                        db.delete(tt11);
                        number--;
                        reff.child(tt11).child("name").setValue(String.valueOf(number));
                        reff4.child(tt11).child("number").setValue(String.valueOf(number));
                        reff4.child(tt11).child("myprice4").setValue(String.valueOf("0"));
                        reff5.child(tt11).child("total4").setValue(String.valueOf("0"));
                        reff4.child(tt11).child("size4").setValue("exit");

                        Toast.makeText(Main5Activity.this,R.string.number_exited,Toast.LENGTH_LONG).show();

                    }


                }
            }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };



}













