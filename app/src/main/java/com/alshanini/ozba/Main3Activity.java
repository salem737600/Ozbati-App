package com.alshanini.ozba;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.InterstitialAd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Main3Activity extends AppCompatActivity{
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

data db2=new data(this);
    database db=new database(this);


    EditText item,price;
    TextView  phonet;
    TextView textView2;
    ListView listView2;

    DatabaseReference reff2;
    DatabaseReference reff5;
    membe membe;
    me me;
    long maxid=0;
    float time;
    float time1;
    float time2,time3,time4;
    String val;
    String val1;
    String val2,val3,val4;
    float bb1;
    String tt;




EditText name22,phone22;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6936942312420166/6421845722");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());



        name22=(EditText)findViewById(R.id.name);
        phone22=(EditText)findViewById(R.id.phone);
        save=(Button)findViewById(R.id.savet);




        membe = new membe();
        me = new me();

        reff2 = FirebaseDatabase.getInstance().getReference("membe");
        reff5 = FirebaseDatabase.getInstance().getReference("me");





        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                String phonee=phone22.getText().toString();
                String namee=name22.getText().toString();
                String id="10";
                boolean result = db2.insertdata(namee, phonee);
                db2.updateData("1",namee,phonee);

                if (result == true) {

                    Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                }

                query();
                tt=db.getstring(phonee);
            }
        });
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

    }




    public void query() {
        String a=phone22.getText().toString();
        Query query =( FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone") .startAt(a).endAt(a));
        query.addListenerForSingleValueEvent(valueEventListener);


    }

    public void query3() {
        String a=phone22.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone1").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener3);


    }
    public void query4() {
        String a=phone22.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone2").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener4);

    }

    public void query5() {
        String a=phone22.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone3").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener5);

    }
    public void query6() {
        String a=phone22.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone4").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener6);

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue()!=null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value=snapshot.child("name").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String phone1=snapshot.child("phone1").getValue().toString();
                    String phone2=snapshot.child("phone2").getValue().toString();
                    String phone3=snapshot.child("phone3").getValue().toString();
                    String phone4=snapshot.child("phone4").getValue().toString();
                    final String id=  snapshot.child("id").getValue().toString();
                    String namee=name22.getText().toString();
                    reff5.child(id).child("name").setValue(namee);



                    boolean result = db.insertdata(id, phone);
                    if (result == true) {
                        Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {
                query3();
                String phonee=phone22.getText().toString();
                tt=db.getstring(phonee);
            }




        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

    ValueEventListener valueEventListener3 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue()!=null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value=snapshot.child("name").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String phone1=snapshot.child("phone1").getValue().toString();
                    String phone2=snapshot.child("phone2").getValue().toString();
                    String phone3=snapshot.child("phone3").getValue().toString();
                    String phone4=snapshot.child("phone4").getValue().toString();
                    final    String id=  snapshot.child("id").getValue().toString();
                    String namee=name22.getText().toString();
                    reff5.child(id).child("name1").setValue(namee);


                    boolean result = db.insertdata(id, phone1);
                    if (result == true) {
                        Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {
                query4();
                String phonee=phone22.getText().toString();
                tt=db.getstring(phonee);



            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

    ValueEventListener valueEventListener4= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue()!=null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value=snapshot.child("name").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String phone1=snapshot.child("phone1").getValue().toString();
                    String phone2=snapshot.child("phone2").getValue().toString();
                    String phone3=snapshot.child("phone3").getValue().toString();
                    String phone4=snapshot.child("phone4").getValue().toString();
                    final   String id=  snapshot.child("id").getValue().toString();
                    String namee=name22.getText().toString();
                    reff5.child(id).child("name2").setValue(namee);


                    boolean result = db.insertdata(id, phone2);
                    if (result == true) {
                        Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {

                query5();
                String phonee=phone22.getText().toString();
                tt=db.getstring(phonee);




            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

    ValueEventListener valueEventListener5= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue()!=null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value=snapshot.child("name").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String phone1=snapshot.child("phone1").getValue().toString();
                    String phone2=snapshot.child("phone2").getValue().toString();
                    String phone3=snapshot.child("phone3").getValue().toString();
                    String phone4=snapshot.child("phone4").getValue().toString();
                    final   String id=  snapshot.child("id").getValue().toString();
                    String namee=name22.getText().toString();
                    reff5.child(id).child("name3").setValue(namee);

                    boolean result = db.insertdata(id, phone3);
                    if (result == true) {
                        Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {
                query6();
                String phonee=phone22.getText().toString();
                tt=db.getstring(phonee);




            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

    ValueEventListener valueEventListener6= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue()!=null) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // member value = snapshot.getValue(member.class);
                    String value=snapshot.child("name").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String phone1=snapshot.child("phone1").getValue().toString();
                    String phone2=snapshot.child("phone2").getValue().toString();
                    String phone3=snapshot.child("phone3").getValue().toString();
                    String phone4=snapshot.child("phone4").getValue().toString();
                    final   String id=  snapshot.child("id").getValue().toString();
                    String namee=name22.getText().toString();
                    reff5.child(id).child("name4").setValue(namee);


                    boolean result = db.insertdata(id, phone4);
                    if (result == true) {
                        Toast.makeText(Main3Activity.this, R.string.number_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(Main3Activity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {
                Toast.makeText(Main3Activity.this, R.string.number_notat_anygroup, Toast.LENGTH_LONG).show();


            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };




}
