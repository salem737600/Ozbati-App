package com.alshanini.ozba;


import com.google.android.gms.ads.InterstitialAd;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

import static com.alshanini.ozba.R.*;
import static com.alshanini.ozba.R.id.bottomNavigationView;

public class MainActivity extends Main2Activity {



    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    data db2=new data(this);
    database db=new database(this);
    EditText item,price;
    TextView  phonet;

    Button save;
    DatabaseReference reff2;

private long backpressedtime;
    membe membe;
    mem mem;
    long maxid=0;
    float time;
    float time1;
    float time2,time3,time4;
    String val;
    String val1;
    String val2,val3,val4;
    float bb1;
    String formattedDate;


    memb memb;
    ArrayList<String> myarraylist2 = new ArrayList<String>();
    ArrayList<String> myarraylist3 = new ArrayList<String>();
    ArrayList<String> myarraylist4 = new ArrayList<String>();
    ArrayList<String> myarraylist5 = new ArrayList<String>();
    ArrayList<String> myarraylist6 = new ArrayList<String>();




    ArrayAdapter<String> arrayAdapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);



        String ttt=db2.getstr(1);
        phonet=(TextView) findViewById(id.phonet);
        item=(EditText)findViewById(id.itemt);
        price=(EditText)findViewById(id.pricet);
        save=(Button) findViewById(id.savet);
        TextView savet2=(TextView)findViewById(id.savet2) ;
        TextView savet1=(TextView)findViewById(id.savet1) ;




        BottomNavigationView bottomNavigationview= findViewById(bottomNavigationView);
        bottomNavigationview.setSelectedItemId(R.id.firstFragment);

        bottomNavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case id.firstFragment:
                        return true;
                    case id.secondFragment:
                        startActivity(new Intent(getApplicationContext(),Main4Activity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case id.thirdFragment:
                        startActivity(new Intent(getApplicationContext(),Main5Activity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });




        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);

        phonet.setText(ttt);


        arrayAdapter2 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, myarraylist2);


        savet1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent intent=new Intent(MainActivity.this,Main3Activity.class);
        startActivity(intent);
    }
});
        savet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });







        membe = new membe();
        memb =new memb();



        reff2 = FirebaseDatabase.getInstance().getReference("membe");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String phonett = phonet.getText().toString().trim();
            String itemt = item.getText().toString().trim();
            int pricet = Integer.parseInt(price.getText().toString().trim());
            membe.setPhone(phonett);
            membe.setItem(itemt);
            membe.setPrice(pricet);
            reff2.child(String.valueOf(maxid + 1)).setValue(membe);
            query();
            tt = db.getstring(phonett);
            query2(tt);

            // reff2.push().setValue(membe);
            //Toast.makeText(Main2Activity.this, "success ", Toast.LENGTH_LONG).show();
        }
    });



    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(layout.dialog,null);
        final Button share = (Button) mView.findViewById(R.id.shr);
        final Button feadback = (Button)mView.findViewById(R.id.fead);
        final Button exit = (Button) mView.findViewById(R.id.exit);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage ="شباب سويت تطبيق بسيط لإداره مصاريف العزبه بحيث اولا  واحد منكم يدخل ارقام جميع افراد العزبه وعددهم وبعد ذلك كل واحد اشترى اي حاجه يسجلها في التطبيق ... في النهايه يطلع لك جميع المشتريات وكم على كل واحد سواءا بالموجب او بالسالب"+"\n\n"+"لتحميل التطبيق لأجهزه الاندرويد"+"\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=com.alshanini.ozba" + "\n\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "choose one"));

            }
        });

        feadback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.alshanini.ozba");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK | Intent.FLAG_ACTIVITY_NEW_DOCUMENT |Intent.FLAG_ACTIVITY_NO_HISTORY);
                try {
                    startActivity(goToMarket);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.alshanini.ozba")));
                }


            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                //Process.killProcess(Process.myPid());
                //  System.exit(1);
                finishAffinity();
            }
        });
        alertdialogBuilder.setView(mView);
        AlertDialog dialog = alertdialogBuilder.create();
        dialog.show();
    }


    public void query() {
        String a=phonet.getText().toString();
        Query query =( FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone") .startAt(a).endAt(a));
        query.addListenerForSingleValueEvent(valueEventListener);


    }

    public void query3() {
        String a=phonet.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone1").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener3);


    }
    public void query4() {
        String a=phonet.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone2").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener4);

    }

    public void query5() {
        String a=phonet.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone3").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener5);

    }
    public void query6() {
        String a=phonet.getText().toString();
        Query query = FirebaseDatabase.getInstance().getReference("member")
                .orderByChild("phone4").startAt(a).endAt(a);
        query.addListenerForSingleValueEvent(valueEventListener6);

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
                    final    String id=  snapshot.child("id").getValue().toString();
                    int price1=Integer.parseInt(price.getText().toString());
                    reff4.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = (String) dataSnapshot.child("myprice").getValue(String.class);
                            val1= (String) dataSnapshot.child("myprice1").getValue(String.class);
                            val2= (String) dataSnapshot.child("myprice2").getValue(String.class);
                            val3= (String) dataSnapshot.child("myprice3").getValue(String.class);
                            val4= (String) dataSnapshot.child("myprice4").getValue(String.class);
                            int number=Integer.parseInt((String)dataSnapshot.child("number").getValue(String.class));

                            time = Float.parseFloat(val);
                            time1=Float.parseFloat(val1);
                            time2=Float.parseFloat(val2);
                            time3=Float.parseFloat(val3);
                            time4=Float.parseFloat(val4);
                            String price1 = price.getText().toString();
                            float price11 = Integer.parseInt(price1);
                            float bb = time + price11;
                            float sum=bb+time1+time2+time3+time4;
                            float div=sum/number;
                             bb1=bb-div;
                          float  bb2=time1-div;
                          float  bb3=time2-div;
                          float  bb4=time3-div;
                          float  bb5=time4-div;
                            reff4.child(id).child("myprice").setValue(String.valueOf(bb));
                            reff5.child(id).child("total").setValue(String.valueOf(bb1));
                            reff5.child(id).child("total1").setValue(String.valueOf(bb2));
                            reff5.child(id).child("total2").setValue(String.valueOf(bb3));
                            reff5.child(id).child("total3").setValue(String.valueOf(bb4));
                            reff5.child(id).child("total4").setValue(String.valueOf(bb5));


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });
                    memb.setId(id);
                    memb.setPhone(phonet.getText().toString());
                    memb.setItem(item.getText().toString());
                    memb.setPrice(Integer.parseInt(price.getText().toString()));
                    memb.setDate(formattedDate);
                    reff3.push().setValue(memb);
                    boolean result = db.insertdata(id, phone);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, string.item_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {

                query3();
                String phonnett= phonet.getText().toString().trim();
                tt=db.getstring(phonnett);

                query2(tt);
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
                    reff4.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = (String) dataSnapshot.child("myprice").getValue(String.class);
                            val1= (String) dataSnapshot.child("myprice1").getValue(String.class);
                            val2= (String) dataSnapshot.child("myprice2").getValue(String.class);
                            val3= (String) dataSnapshot.child("myprice3").getValue(String.class);
                            val4= (String) dataSnapshot.child("myprice4").getValue(String.class);
                            int number=Integer.parseInt((String)dataSnapshot.child("number").getValue(String.class));



                            time = Float.parseFloat(val);
                            time1=Float.parseFloat(val1);
                            time2=Float.parseFloat(val2);
                            time3=Float.parseFloat(val3);
                            time4=Float.parseFloat(val4);
                            String price1 = price.getText().toString();
                            float price11 = Integer.parseInt(price1);
                            float bb = time1 + price11;
                            float sum=bb+time+time2+time3+time4;
                            float div=sum/number;
                            bb1=bb-div;
                            float  bb2=time-div;
                            float  bb3=time2-div;
                            float  bb4=time3-div;
                            float  bb5=time4-div;
                            reff4.child(id).child("myprice1").setValue(String.valueOf(bb));
                            reff5.child(id).child("total1").setValue(String.valueOf(bb1));
                            reff5.child(id).child("total").setValue(String.valueOf(bb2));
                            reff5.child(id).child("total2").setValue(String.valueOf(bb3));
                            reff5.child(id).child("total3").setValue(String.valueOf(bb4));
                            reff5.child(id).child("total4").setValue(String.valueOf(bb5));

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });


                    memb.setId(id);
                    memb.setPhone(phonet.getText().toString());
                    memb.setItem(item.getText().toString());
                    memb.setPrice(Integer.parseInt(price.getText().toString()));
                    memb.setDate(formattedDate);
                    reff3.push().setValue(memb);
                    boolean result = db.insertdata(id, phone1);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, string.item_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {

                query4();
                String phonnett= phonet.getText().toString().trim();
                tt=db.getstring(phonnett);

                query2(tt);

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

                    reff4.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = (String) dataSnapshot.child("myprice").getValue(String.class);
                            val1= (String) dataSnapshot.child("myprice1").getValue(String.class);
                            val2= (String) dataSnapshot.child("myprice2").getValue(String.class);
                            val3= (String) dataSnapshot.child("myprice3").getValue(String.class);
                            val4= (String) dataSnapshot.child("myprice4").getValue(String.class);
                            int number=Integer.parseInt((String)dataSnapshot.child("number").getValue(String.class));



                            time = Float.parseFloat(val);
                            time1=Float.parseFloat(val1);
                            time2=Float.parseFloat(val2);
                            time3=Float.parseFloat(val3);
                            time4=Float.parseFloat(val4);
                            String price1 = price.getText().toString();
                            int price11 = Integer.parseInt(price1);
                            float bb = time2 + price11;
                            float sum=bb+time1+time+time3+time4;
                            float div=sum/number;
                            bb1=bb-div;
                            float  bb2=time1-div;
                            float  bb3=time-div;
                            float  bb4=time3-div;
                            float  bb5=time4-div;
                            reff4.child(id).child("myprice2").setValue(String.valueOf(bb));
                            reff5.child(id).child("total2").setValue(String.valueOf(bb1));
                            reff5.child(id).child("total1").setValue(String.valueOf(bb2));
                            reff5.child(id).child("total").setValue(String.valueOf(bb3));
                            reff5.child(id).child("total3").setValue(String.valueOf(bb4));
                            reff5.child(id).child("total4").setValue(String.valueOf(bb5));

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });


                    memb.setId(id);
                    memb.setPhone(phonet.getText().toString());
                    memb.setItem(item.getText().toString());
                    memb.setPrice(Integer.parseInt(price.getText().toString()));
                    memb.setDate(formattedDate);
                    reff3.push().setValue(memb);
                    boolean result = db.insertdata(id, phone2);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, string.item_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {

                query5();
                String phonnett= phonet.getText().toString().trim();
                tt=db.getstring(phonnett);

                query2(tt);


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

                    reff4.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = (String) dataSnapshot.child("myprice").getValue(String.class);
                            val1= (String) dataSnapshot.child("myprice1").getValue(String.class);
                            val2= (String) dataSnapshot.child("myprice2").getValue(String.class);
                            val3= (String) dataSnapshot.child("myprice3").getValue(String.class);
                            val4= (String) dataSnapshot.child("myprice4").getValue(String.class);
                            int number=Integer.parseInt((String)dataSnapshot.child("number").getValue(String.class));



                            time = Float.parseFloat(val);
                            time1=Float.parseFloat(val1);
                            time2=Float.parseFloat(val2);
                            time3=Float.parseFloat(val3);
                            time4=Float.parseFloat(val4);
                            String price1 = price.getText().toString();
                            int price11 = Integer.parseInt(price1);
                            float bb = time3 + price11;
                            float sum=bb+time1+time2+time+time4;
                            float div=sum/number;
                            bb1=bb-div;
                            float  bb2=time1-div;
                            float  bb3=time2-div;
                            float  bb4=time-div;
                            float  bb5=time4-div;
                            reff4.child(id).child("myprice3").setValue(String.valueOf(bb));
                            reff5.child(id).child("total3").setValue(String.valueOf(bb1));
                            reff5.child(id).child("total1").setValue(String.valueOf(bb2));
                            reff5.child(id).child("total2").setValue(String.valueOf(bb3));
                            reff5.child(id).child("total").setValue(String.valueOf(bb4));
                            reff5.child(id).child("total4").setValue(String.valueOf(bb5));
                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });



                    memb.setId(id);
                    memb.setPhone(phonet.getText().toString());
                    memb.setItem(item.getText().toString());
                    memb.setPrice(Integer.parseInt(price.getText().toString()));
                    memb.setDate(formattedDate);
                    reff3.push().setValue(memb);
                    boolean result = db.insertdata(id, phone3);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, string.item_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {

                query6();
                String phonnett= phonet.getText().toString().trim();
                tt=db.getstring(phonnett);

                query2(tt);


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

                    reff4.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = (String) dataSnapshot.child("myprice").getValue(String.class);
                            val1= (String) dataSnapshot.child("myprice1").getValue(String.class);
                            val2= (String) dataSnapshot.child("myprice2").getValue(String.class);
                            val3= (String) dataSnapshot.child("myprice3").getValue(String.class);
                            val4= (String) dataSnapshot.child("myprice4").getValue(String.class);
                            int number=Integer.parseInt((String)dataSnapshot.child("number").getValue(String.class));



                            time = Float.parseFloat(val);
                            time1=Float.parseFloat(val1);
                            time2=Float.parseFloat(val2);
                            time3=Float.parseFloat(val3);
                            time4=Float.parseFloat(val4);
                            String price1 = price.getText().toString();
                            int price11 = Integer.parseInt(price1);
                            float bb = time4 + price11;
                            float sum=bb+time1+time2+time3+time;
                            float div=sum/number;
                            bb1=bb-div;
                            float  bb2=time1-div;
                            float  bb3=time2-div;
                            float  bb4=time3-div;
                            float  bb5=time-div;
                            reff4.child(id).child("myprice4").setValue(String.valueOf(bb));
                            reff5.child(id).child("total4").setValue(String.valueOf(bb1));
                            reff5.child(id).child("total1").setValue(String.valueOf(bb2));
                            reff5.child(id).child("total2").setValue(String.valueOf(bb3));
                            reff5.child(id).child("total3").setValue(String.valueOf(bb4));
                            reff5.child(id).child("total").setValue(String.valueOf(bb5));

                        }



                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }

                    });



                    memb.setId(id);
                    memb.setPhone(phonet.getText().toString());
                    memb.setItem(item.getText().toString());
                    memb.setPrice(Integer.parseInt(price.getText().toString()));
                    memb.setDate(formattedDate);
                    reff3.push().setValue(memb);
                    boolean result = db.insertdata(id, phone4);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, string.item_added, Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_LONG).show();
                    }

                }

            }else
            {
                Toast.makeText(MainActivity.this, string.doesntexist, Toast.LENGTH_LONG).show();


            }


        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };




     public void query2(String tt1){
         if(!tt1.isEmpty()) {

             Query query2 = FirebaseDatabase.getInstance().getReference("memb")
                     .orderByChild("id").startAt(tt1).endAt(tt1);
             query2.addListenerForSingleValueEvent(valueEventListener1);
         }else              Toast.makeText(MainActivity.this, string.doesntexist,Toast.LENGTH_LONG).show();

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
                    // String phone=snapshot.child("phone").getValue().toString();
                    //   String id=  snapshot.child("id").getValue().toString();
                    String phone=snapshot.child("phone").getValue().toString();
                    String item=snapshot.child("item").getValue().toString();
                    String price=snapshot.child("price").getValue().toString();
                    String date=snapshot.child("date").getValue().toString();





                    myarraylist2.add(phone );
                    myarraylist3.add(item);
                    myarraylist4.add(price);
                    myarraylist5.add(price);
                    myarraylist6.add(date);





                }


                 arrayAdapter2.notifyDataSetChanged();

            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };

    public void query10(String tt11){

        Query query2=FirebaseDatabase.getInstance().getReference("memb")
                .orderByChild("id").startAt(tt11).endAt(tt11);
        query2.addListenerForSingleValueEvent(valueEventListener10);
    }
    ValueEventListener valueEventListener10 = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            myarraylist2.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    snapshot.getRef().removeValue();
                    String phonett = phonet.getText().toString().trim();
                    String  tt11=db.getstring(phonett);
                    String zero="0";
                    reff4.child(tt11).child("myprice").setValue(String.valueOf(zero));
                    reff4.child(tt11).child("myprice1").setValue(String.valueOf(zero));
                    reff4.child(tt11).child("myprice2").setValue(String.valueOf(zero));
                    reff4.child(tt11).child("myprice3").setValue(String.valueOf(zero));
                    reff4.child(tt11).child("myprice4").setValue(String.valueOf(zero));

                    reff5.child(tt11).child("total").setValue(zero);
                    reff5.child(tt11).child("total1").setValue(zero);
                    reff5.child(tt11).child("total2").setValue(zero);
                    reff5.child(tt11).child("total3").setValue(zero);
                    reff5.child(tt11).child("total4").setValue(zero);


                    Toast.makeText(MainActivity.this, string.itemsrem,Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(MainActivity.this,Main4Activity.class);
                    startActivity(intent);



                }



            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };





}












