package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

public class Rsa extends AppCompatActivity implements View.OnClickListener {
    private Button gen,mainMenuuR;
    private TextView keyPair1,keyPair2;
    private EditText kR1,kR2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        gen=findViewById(R.id.gen);
        mainMenuuR=findViewById(R.id.mainMenuuR);
        keyPair1=findViewById(R.id.keyPair1);
        keyPair2 = findViewById(R.id.keyPair2);
        kR1= findViewById(R.id.kR1);
        kR2= findViewById(R.id.kR2);

        gen.setOnClickListener(this);
        mainMenuuR.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gen:
                int p,q,n,cf,e=1,d=1,i,j,fl=0;
                q = Integer.parseInt(kR1.getText().toString());
                p = Integer.parseInt(kR2.getText().toString());
                if(isPrime(q)&& isPrime(p)){

                n = p*q;
                cf = (p-1) * (q-1);
                // System.out.println(p+" "+q+" "+n+" "+cf);
                ArrayList<Integer> fac_n = new ArrayList<Integer>();
                for (i=2;i<=n/2;i++){
                    if (n%i==0){
                        fac_n.add(i);
                    }
                }
                ArrayList<Integer> fac_cf = new ArrayList<Integer>();
                for (i=2;i<=cf/2;i++){
                    if (cf%i==0){
                        fac_cf.add(i);
                    }
                }
                HashSet<Integer> fac = new HashSet<Integer>();
                fac.addAll(fac_n);
                fac.addAll(fac_cf);
                List<Integer> lst = new ArrayList<Integer>(fac);
                Collections.sort(lst);
                // System.out.println(lst);
                for (i=2;i<cf;i++){
                    if (!(lst.contains(i))){
                        for (j=2;j<=i/2;j++){
                            fl=0;
                            if (i%j==0){
                                if (lst.contains(j)){
                                    fl=1;
                                    break;
                                }
                            }
                        }
                        if (fl==0) {
                            e=i;
                            break;
                        }
                    }
                }
                i=2;
                while (true){
                    if ((i!=e) && ((e * i)%cf == 1)){
                        d = i;
                        break;
                    }
                    i++;
                }


                keyPair1.setText("Encryption Keys are: "+String.valueOf(e)+","+String.valueOf(n));
                    keyPair2.setText("Decryption Keys are: "+String.valueOf(d)+","+String.valueOf(n));
                }

               else if(!isPrime(p)){

                    kR2.setError("Enter a Prime Number");
                }
               else{
                    kR1.setError("Enter a Prime Number");
                }
                break;
            case R.id.mainMenuuR:
                Intent intent = new Intent(Rsa.this, MainActivity.class);
                startActivity(intent);
                setContentView(R.layout.activity_main);
                break;
        }
    }

    public boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }




}





