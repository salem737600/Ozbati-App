package com.alshanini.ozba;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class Main2Activity extends  Main3Activity {
    private AdView mAdView;

    database db = new database(this);
    EditText nametext,trying;
    EditText agetext;
    EditText phonetext;
    EditText higttext;
    EditText phonetext1;
    EditText higttext1;
    Button insertbutton;
     DatabaseReference reff  ;
    DatabaseReference reff3;
    DatabaseReference reff4;
    DatabaseReference reff5;
    member member;
    memb memb;
    mem mem;
    me me;
    Button move;
    TextView showtext;
    String a="Omer";
    long maxid=0;
    String tt;
    String alredyexist;

    ArrayList<String> myarraylist = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        nametext = (EditText) findViewById(R.id.txtname);
        phonetext = (EditText) findViewById(R.id.txtphone);
        phonetext1 = (EditText) findViewById(R.id.txtphone1);
        agetext = (EditText) findViewById(R.id.txtage);
        higttext = (EditText) findViewById(R.id.txtht);
        higttext1 = (EditText) findViewById(R.id.txtht1);
        insertbutton = (Button) findViewById(R.id.insert);



alredyexist=getString(R.string.alreadyexist);


        member = new member();
        memb =new memb();
        mem=new mem();
        me=new me();

        reff = FirebaseDatabase.getInstance().getReference("member");
        reff3 = FirebaseDatabase.getInstance().getReference("memb");
        reff4 = FirebaseDatabase.getInstance().getReference("mem");
        reff5 = FirebaseDatabase.getInstance().getReference("me");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // reff.addListenerForSingleValueEvent(valueEventListener);

        //select from member where id=laal




        insertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int name=Integer.parseInt(nametext.getText().toString().trim());
                String phone = agetext.getText().toString().trim();
                reff.orderByChild("name").startAt(name).endAt(name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int name=Integer.parseInt(nametext.getText().toString().trim());
                        String phone = agetext.getText().toString().trim();
                        String phone2 = higttext.getText().toString().trim();
                        String phone1 = phonetext.getText().toString().trim();
                        String phone4 = higttext1.getText().toString().trim();
                        String phone3= phonetext1.getText().toString().trim();

                        if(name<=5) {

                            reff.orderByChild("phone").startAt(phone).endAt(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    int name = Integer.parseInt(nametext.getText().toString().trim());
                                    String phone = agetext.getText().toString().trim();
                                    String phone2 = higttext.getText().toString().trim();
                                    String phone1 = phonetext.getText().toString().trim();
                                    String phone4 = higttext1.getText().toString().trim();
                                    String phone3 = phonetext1.getText().toString().trim();

                                    //    member.setName(nametext.getText().toString().trim());
                                    if (!dataSnapshot.exists()) {
                                        reff.orderByChild("phone1").startAt(phone).endAt(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                int name = Integer.parseInt(nametext.getText().toString().trim());
                                                String phone = agetext.getText().toString().trim();
                                                String phone2 = higttext.getText().toString().trim();
                                                String phone1 = phonetext.getText().toString().trim();
                                                String phone4 = higttext1.getText().toString().trim();
                                                String phone3 = phonetext1.getText().toString().trim();

                                                //    member.setName(nametext.getText().toString().trim());
                                                if (!dataSnapshot.exists()) {

                                                    reff.orderByChild("phone2").startAt(phone).endAt(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            int name = Integer.parseInt(nametext.getText().toString().trim());
                                                            String phone = agetext.getText().toString().trim();
                                                            String phone2 = higttext.getText().toString().trim();
                                                            String phone1 = phonetext.getText().toString().trim();
                                                            String phone4 = higttext1.getText().toString().trim();
                                                            String phone3 = phonetext1.getText().toString().trim();

                                                            //    member.setName(nametext.getText().toString().trim());
                                                            if (!dataSnapshot.exists()) {

                                                                reff.orderByChild("phone3").startAt(phone).endAt(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                        String phone = agetext.getText().toString().trim();
                                                                        String phone2 = higttext.getText().toString().trim();
                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                        String phone3 = phonetext1.getText().toString().trim();

                                                                        //    member.setName(nametext.getText().toString().trim());
                                                                        if (!dataSnapshot.exists()) {
                                                                            reff.orderByChild("phone4").startAt(phone).endAt(phone).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                                    String phone = agetext.getText().toString().trim();
                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                    String phone3 = phonetext1.getText().toString().trim();

                                                                                    //    member.setName(nametext.getText().toString().trim());
                                                                                    if (!dataSnapshot.exists()) {

                                        reff.orderByChild("phone").startAt(phone1).endAt(phone1).addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                int name = Integer.parseInt(nametext.getText().toString().trim());
                                                String phone = agetext.getText().toString().trim();
                                                String phone2 = higttext.getText().toString().trim();
                                                String phone1 = phonetext.getText().toString().trim();
                                                String phone4 = higttext1.getText().toString().trim();
                                                String phone3 = phonetext1.getText().toString().trim();

                                                String s = phone;

                                                if (!dataSnapshot.exists()) {
                                                    reff.orderByChild("phone1").startAt(phone1).endAt(phone1).addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            int name = Integer.parseInt(nametext.getText().toString().trim());
                                                            String phone = agetext.getText().toString().trim();
                                                            String phone2 = higttext.getText().toString().trim();
                                                            String phone1 = phonetext.getText().toString().trim();
                                                            String phone4 = higttext1.getText().toString().trim();
                                                            String phone3 = phonetext1.getText().toString().trim();



                                                            if (!dataSnapshot.exists()) {
                                                                reff.orderByChild("phone2").startAt(phone1).endAt(phone1).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                        String phone = agetext.getText().toString().trim();
                                                                        String phone2 = higttext.getText().toString().trim();
                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                        String phone3 = phonetext1.getText().toString().trim();

                                                                        String s = phone;

                                                                        if (!dataSnapshot.exists()) {
                                                                            reff.orderByChild("phone3").startAt(phone1).endAt(phone1).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                                    String phone = agetext.getText().toString().trim();
                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                    String phone3 = phonetext1.getText().toString().trim();

                                                                                    String s = phone;

                                                                                    if (!dataSnapshot.exists()) {
                                                                                        reff.orderByChild("phone4").startAt(phone1).endAt(phone1).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                                                                                     @Override
                                                                                                                                                                                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                                                                                                         int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                                                                                                                                         String phone = agetext.getText().toString().trim();
                                                                                                                                                                                         String phone2 = higttext.getText().toString().trim();
                                                                                                                                                                                         String phone1 = phonetext.getText().toString().trim();
                                                                                                                                                                                         String phone4 = higttext1.getText().toString().trim();
                                                                                                                                                                                         String phone3 = phonetext1.getText().toString().trim();

                                                                                                                                                                                         String s = phone;

                                                                                                                                                                                         if (!dataSnapshot.exists()) {


                                                    reff.orderByChild("phone").startAt(phone2).endAt(phone2).addListenerForSingleValueEvent(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            int name = Integer.parseInt(nametext.getText().toString().trim());
                                                            String phone = agetext.getText().toString().trim();
                                                            String phone2 = higttext.getText().toString().trim();
                                                            String phone1 = phonetext.getText().toString().trim();
                                                            String phone4 = higttext1.getText().toString().trim();
                                                            String phone3 = phonetext1.getText().toString().trim();
                                                            //  member.setName(nametext.getText().toString().trim());
                                                            String s = phone;

                                                            if (!dataSnapshot.exists()) {
                                                                reff.orderByChild("phone1").startAt(phone2).endAt(phone2).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                        String phone = agetext.getText().toString().trim();
                                                                        String phone2 = higttext.getText().toString().trim();
                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                        String phone3 = phonetext1.getText().toString().trim();
                                                                        //  member.setName(nametext.getText().toString().trim());
                                                                        String s = phone;

                                                                        if (!dataSnapshot.exists()) {
                                                                            reff.orderByChild("phone2").startAt(phone2).endAt(phone2).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                                    String phone = agetext.getText().toString().trim();
                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                    String phone3 = phonetext1.getText().toString().trim();
                                                                                    //  member.setName(nametext.getText().toString().trim());
                                                                                    String s = phone;

                                                                                    if (!dataSnapshot.exists()) {
                                                                                        reff.orderByChild("phone3").startAt(phone2).endAt(phone2).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                            @Override
                                                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                                                String phone = agetext.getText().toString().trim();
                                                                                                String phone2 = higttext.getText().toString().trim();
                                                                                                String phone1 = phonetext.getText().toString().trim();
                                                                                                String phone4 = higttext1.getText().toString().trim();
                                                                                                String phone3 = phonetext1.getText().toString().trim();
                                                                                                //  member.setName(nametext.getText().toString().trim());
                                                                                                String s = phone;

                                                                                                if (!dataSnapshot.exists()) {


                                                        reff.orderByChild("phone4").startAt(phone2).endAt(phone2).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                 @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                           int name = Integer.parseInt(nametext.getText().toString().trim());
                                                                            String phone = agetext.getText().toString().trim();
                                                                           String phone2 = higttext.getText().toString().trim();
                                                                            String phone1 = phonetext.getText().toString().trim();
                                                                            String phone4 = higttext1.getText().toString().trim();
                                                                            String phone3 = phonetext1.getText().toString().trim();
                                                                         //  member.setName(nametext.getText().toString().trim());

                                                           if (!dataSnapshot.exists()) {
                                                           reff.orderByChild("phone").startAt(phone3).endAt(phone3).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                    @Override
                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                        String name = nametext.getText().toString().trim();
                                                                        String phone = agetext.getText().toString().trim();
                                                                        String phone2 = higttext.getText().toString().trim();
                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                        String phone3 = phonetext1.getText().toString().trim();
                                                                        //        member.setName(nametext.getText().toString().trim());
                                                                        String s = phone;

                                                                        if (!dataSnapshot.exists()) {
                                                                            reff.orderByChild("phone1").startAt(phone3).endAt(phone3).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String name = nametext.getText().toString().trim();
                                                                                    String phone = agetext.getText().toString().trim();
                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                    String phone3 = phonetext1.getText().toString().trim();
                                                                                    //        member.setName(nametext.getText().toString().trim());
                                                                                    String s = phone;

                                                                                    if (!dataSnapshot.exists()) {
                                                                                        reff.orderByChild("phone2").startAt(phone3).endAt(phone3).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                            @Override
                                                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                String name = nametext.getText().toString().trim();
                                                                                                String phone = agetext.getText().toString().trim();
                                                                                                String phone2 = higttext.getText().toString().trim();
                                                                                                String phone1 = phonetext.getText().toString().trim();
                                                                                                String phone4 = higttext1.getText().toString().trim();
                                                                                                String phone3 = phonetext1.getText().toString().trim();
                                                                                                //        member.setName(nametext.getText().toString().trim());
                                                                                                String s = phone;

                                                                                                if (!dataSnapshot.exists()) {
                                                                                                    reff.orderByChild("phone3").startAt(phone3).endAt(phone3).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                        @Override
                                                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                            String name = nametext.getText().toString().trim();
                                                                                                            String phone = agetext.getText().toString().trim();
                                                                                                            String phone2 = higttext.getText().toString().trim();
                                                                                                            String phone1 = phonetext.getText().toString().trim();
                                                                                                            String phone4 = higttext1.getText().toString().trim();
                                                                                                            String phone3 = phonetext1.getText().toString().trim();
                                                                                                            //        member.setName(nametext.getText().toString().trim());
                                                                                                            String s = phone;

                                                                                                            if (!dataSnapshot.exists()) {
                                                                                                                reff.orderByChild("phone4").startAt(phone3).endAt(phone3).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                    @Override
                                                                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                                        String name = nametext.getText().toString().trim();
                                                                                                                        String phone = agetext.getText().toString().trim();
                                                                                                                        String phone2 = higttext.getText().toString().trim();
                                                                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                                                                        String phone3 = phonetext1.getText().toString().trim();
                                                                                                                        //        member.setName(nametext.getText().toString().trim());
                                                                                                                        String s = phone;

                                                                                                                        if (!dataSnapshot.exists()) {
                                                                            reff.orderByChild("phone").startAt(phone4).endAt(phone4).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                @Override
                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                    String name = nametext.getText().toString().trim();
                                                                                    String phone = agetext.getText().toString().trim();
                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                    String phone3 = phonetext1.getText().toString().trim();

                                                                                    if (!dataSnapshot.exists()) {
                                                                                        reff.orderByChild("phone1").startAt(phone4).endAt(phone4).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                            @Override
                                                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                String name = nametext.getText().toString().trim();
                                                                                                String phone = agetext.getText().toString().trim();
                                                                                                String phone2 = higttext.getText().toString().trim();
                                                                                                String phone1 = phonetext.getText().toString().trim();
                                                                                                String phone4 = higttext1.getText().toString().trim();
                                                                                                String phone3 = phonetext1.getText().toString().trim();

                                                                                                if (!dataSnapshot.exists()) {

                                                                                                    reff.orderByChild("phone2").startAt(phone4).endAt(phone4).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                        @Override
                                                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                            String name = nametext.getText().toString().trim();
                                                                                                            String phone = agetext.getText().toString().trim();
                                                                                                            String phone2 = higttext.getText().toString().trim();
                                                                                                            String phone1 = phonetext.getText().toString().trim();
                                                                                                            String phone4 = higttext1.getText().toString().trim();
                                                                                                            String phone3 = phonetext1.getText().toString().trim();

                                                                                                            if (!dataSnapshot.exists()) {
                                                                                                                reff.orderByChild("phone3").startAt(phone4).endAt(phone4).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                    @Override
                                                                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                                        String name = nametext.getText().toString().trim();
                                                                                                                        String phone = agetext.getText().toString().trim();
                                                                                                                        String phone2 = higttext.getText().toString().trim();
                                                                                                                        String phone1 = phonetext.getText().toString().trim();
                                                                                                                        String phone4 = higttext1.getText().toString().trim();
                                                                                                                        String phone3 = phonetext1.getText().toString().trim();

                                                                                                                        if (!dataSnapshot.exists()) {
                                                                                                                            reff.orderByChild("phone4").startAt(phone4).endAt(phone4).addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                                                @Override
                                                                                                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                                                    String name = nametext.getText().toString().trim();
                                                                                                                                    String phone = agetext.getText().toString().trim();
                                                                                                                                    String phone2 = higttext.getText().toString().trim();
                                                                                                                                    String phone1 = phonetext.getText().toString().trim();
                                                                                                                                    String phone4 = higttext1.getText().toString().trim();
                                                                                                                                    String phone3 = phonetext1.getText().toString().trim();

                                                                                                                                    if (!dataSnapshot.exists()) {

                                                                                        if(!phone.matches("")) {
                                                                                            member.setId(String.valueOf(maxid + 1));
                                                                                            member.setName(name);
                                                                                            member.setPhone(phone);
                                                                                            Toast.makeText(Main2Activity.this, R.string.success, Toast.LENGTH_LONG).show();


                                                                                            if(!phone1.matches("")) {
                                                                                            member.setPhone1(phone1);
                                                                                        }else{
                                                                                            member.setPhone1(phone+"aaa");
                                                                                        }
                                                                                        if(!phone2.matches("")) {
                                                                                            member.setPhone2(phone2);
                                                                                        }
                                                                                        else{
                                                                                            member.setPhone2(phone+"bbb");
                                                                                        }
                                                                                        if(!phone3.matches("")) {
                                                                                            member.setPhone3(phone3);
                                                                                        }else{
                                                                                            member.setPhone3(phone+"ccc");
                                                                                        }
                                                                                        if(!phone4.matches("")) {
                                                                                                member.setPhone4(phone4);
                                                                                            }else{
                                                                                            member.setPhone4(phone+"ddd");
                                                                                        }
                                                                                        }else {
                                                                                            Toast.makeText(Main2Activity.this,R.string.firstnumberempty,Toast.LENGTH_LONG).show();
                                                                                        }

                                                                                        mem.setId(String.valueOf(maxid + 1));
                                                                                        mem.setNumber(name);
                                                                                        mem.setMyprice("0");
                                                                                        mem.setMyprice1("0");
                                                                                        mem.setMyprice2("0");
                                                                                        mem.setMyprice3("0");
                                                                                        mem.setMyprice4("0");
                                                                                        mem.setSize("");
                                                                                        mem.setSize1("");
                                                                                        mem.setSize2("");
                                                                                        mem.setSize3("");
                                                                                        mem.setSize4("");
                                                                                        me.setId(String.valueOf(maxid + 1));
                                                                                        me.setTotal("0");
                                                                                        me.setTotal1("0");
                                                                                        me.setTotal2("0");
                                                                                        me.setTotal3("0");
                                                                                        me.setTotal4("0");
                                                                                        me.setNumber(name);
                                                                                        me.setName("0");
                                                                                        me.setName1("0");
                                                                                        me.setName2("0");
                                                                                        me.setName3("0");
                                                                                        me.setName4("0");
                                                                                        reff5.child(String.valueOf(maxid + 1)).setValue(me);
                                                                                        reff4.child(String.valueOf(maxid + 1)).setValue(mem);
                                                                                        reff.child(String.valueOf(maxid + 1)).setValue(member);



                                                                                    } else {
                                                                                        Toast.makeText(Main2Activity.this, "sorry this " + phone4 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                    }


                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                                                                        } else {
                                                                                                                            Toast.makeText(Main2Activity.this, "sorry this " + phone4 +alredyexist, Toast.LENGTH_LONG).show();


                                                                                                                        }


                                                                                                                    }

                                                                                                                    @Override
                                                                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                                                    }
                                                                                                                });
                                                                                                            } else {
                                                                                                                Toast.makeText(Main2Activity.this, "sorry this " + phone4 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                                            }


                                                                                                        }

                                                                                                        @Override
                                                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                                        }
                                                                                                    });
                                                                                                } else {
                                                                                                    Toast.makeText(Main2Activity.this, "sorry this " + phone4 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                                }


                                                                                            }

                                                                                            @Override
                                                                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                            }
                                                                                        });
                                                                                    } else {
                                                                                        Toast.makeText(Main2Activity.this, "sorry this " + phone4 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                    }


                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });


                                                                        } else {
                                                                            Toast.makeText(Main2Activity.this, "sorry this " + phone3 + alredyexist, Toast.LENGTH_LONG).show();


                                                                        }

                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                    }
                                                                });
                                                                                                            } else {
                                                                                                                Toast.makeText(Main2Activity.this, "sorry this " + phone3 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                                            }

                                                                                                        }

                                                                                                        @Override
                                                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                                        }
                                                                                                    });
                                                                                                } else {
                                                                                                    Toast.makeText(Main2Activity.this, "sorry this " + phone3 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                                }

                                                                                            }

                                                                                            @Override
                                                                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                            }
                                                                                        });
                                                                                    } else {
                                                                                        Toast.makeText(Main2Activity.this, "sorry this " + phone3 +alredyexist, Toast.LENGTH_LONG).show();


                                                                                    }

                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });
                                                                        } else {
                                                                            Toast.makeText(Main2Activity.this, "sorry this " + phone3 + alredyexist, Toast.LENGTH_LONG).show();


                                                                        }

                                                                    }

                                                               @Override
                                                               public void onCancelled(@NonNull DatabaseError databaseError) {

                                                               }
                                                           });


                                                            } else {
                                                                Toast.makeText(Main2Activity.this, "sorry this " + phone2 + alredyexist, Toast.LENGTH_LONG).show();


                                                            }

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                                                                } else {
                                                                                                    Toast.makeText(Main2Activity.this, "sorry this " + phone2 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                                }

                                                                                            }

                                                                                            @Override
                                                                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                            }
                                                                                        });


                                                                                    } else {
                                                                                        Toast.makeText(Main2Activity.this, "sorry this " + phone2 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                    }

                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });

                                                                        } else {
                                                                            Toast.makeText(Main2Activity.this, "sorry this " + phone2 + alredyexist, Toast.LENGTH_LONG).show();


                                                                        }

                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                    }
                                                                });

                                                            } else {
                                                                Toast.makeText(Main2Activity.this, "sorry this " + phone2 + alredyexist, Toast.LENGTH_LONG).show();


                                                            }

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });




                                                                                                    } else {
                                                    Toast.makeText(Main2Activity.this, "sorry this " + phone1 +alredyexist, Toast.LENGTH_LONG).show();


                                                }

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                                                        } else {
                                                                            Toast.makeText(Main2Activity.this, "sorry this " + phone1 + alredyexist, Toast.LENGTH_LONG).show();


                                                                        }

                                                                    }

                                                                    @Override
                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                    }
                                                                });
                                                            } else {
                                                                Toast.makeText(Main2Activity.this, "sorry this " + phone1 + alredyexist, Toast.LENGTH_LONG).show();


                                                            }

                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });
                                                } else {
                                                    Toast.makeText(Main2Activity.this, "sorry this " + phone1 + alredyexist, Toast.LENGTH_LONG).show();


                                                }

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                                                                    } else {
                                                                                        Toast.makeText(Main2Activity.this, "sorry this " + phone1 + alredyexist, Toast.LENGTH_LONG).show();


                                                                                    }

                                                                                }

                                                                                @Override
                                                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                }
                                                                            });


                                    } else {
                                        Toast.makeText(Main2Activity.this, "sorry this " + phone + alredyexist, Toast.LENGTH_LONG).show();


                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                                    } else {
                                        Toast.makeText(Main2Activity.this, "sorry this " + phone + alredyexist, Toast.LENGTH_LONG).show();


                                    }

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });

                        } else {
                            Toast.makeText(Main2Activity.this, "sorry this " + phone + alredyexist, Toast.LENGTH_LONG).show();


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            } else {
                Toast.makeText(Main2Activity.this, "sorry this " + phone +alredyexist, Toast.LENGTH_LONG).show();


            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
} else {
        Toast.makeText(Main2Activity.this, "sorry this " + phone + alredyexist, Toast.LENGTH_LONG).show();


        }

        }

@Override
public void onCancelled(@NonNull DatabaseError databaseError) {

        }
        });
                        }
                else{
                    Toast.makeText(Main2Activity.this, R.string.morefive, Toast.LENGTH_LONG).show();


                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        String phone1 = phonetext.getText().toString().trim();


            }
        });
    }







/*reff.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s
    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});
*/

      /*  reff.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    if (dataSnapshot.exists()) {
                                                        minid = (int) (dataSnapshot.getChildrenCount());
                                                    }

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                                }
        });*/


/*
 reff.runTransaction(new Transaction.Handler() {
    @NonNull
    @Override
    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
        if(mutableData.getValue()==null) {
            mutableData.setValue(1);
        }else {
            int count = mutableData.getValue(Integer.class);

            mutableData.setValue(count + 1);

        }
        return Transaction.success(mutableData);
    }

    @Override
    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {

    }
});
*/






}
