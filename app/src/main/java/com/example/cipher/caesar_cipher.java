package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class caesar_cipher extends AppCompatActivity implements View.OnClickListener {
    private Button decryptC,encryptC,mainMenu;
    private EditText msg,key;
    private TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar_cipher);

        decryptC=findViewById(R.id.decryptC);
        encryptC=findViewById(R.id.encryptC);
        mainMenu=findViewById(R.id.mainMenu);
        res=findViewById(R.id.res);
        msg=findViewById(R.id.msg);
        key=findViewById(R.id.key);

        decryptC.setOnClickListener(this);
        encryptC.setOnClickListener(this);
        mainMenu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.encryptC:

                mainCode();
                break;
            case R.id.decryptC:
                mainCodee();
                break;
            case R.id.mainMenu:
                Intent intent = new Intent(caesar_cipher.this, MainActivity.class);
                startActivity(intent);
                setContentView(R.layout.activity_main);
                break;

        }
    }

    public void mainCode(){
        String plaintext= msg.getText().toString();
        int k = Integer.parseInt(key.getText().toString());
        String ciphertext="";
        char alphabet;
        for(int i=0; i < plaintext.length();i++)
        {
            // Shift one character at a time
            alphabet = plaintext.charAt(i);

            // if alphabet lies between a and z
            if(alphabet >= 'a' && alphabet <= 'z')
            {
                // shift alphabet
                alphabet = (char) (alphabet + k);
                // if shift alphabet greater than 'z'
                if(alphabet > 'z') {
                    // reshift to starting position
                    alphabet = (char) (alphabet+'a'-'z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }

            // if alphabet lies between 'A'and 'Z'
            else if(alphabet >= 'A' && alphabet <= 'Z') {
                // shift alphabet
                alphabet = (char) (alphabet + k);

                // if shift alphabet greater than 'Z'
                if(alphabet > 'Z') {
                    //reshift to starting position
                    alphabet = (char) (alphabet+'A'-'Z'-1);
                }
                ciphertext = ciphertext + alphabet;
            }
            else {
                ciphertext = ciphertext + alphabet;
            }

        }
        res.setText("Encrypted Text is: "+ciphertext);
    }
public void mainCodee(){

        String cipher=msg.getText().toString();
        int ke = Integer.parseInt(key.getText().toString());
        String plain="";

    for(int i=0; i < cipher.length();i++)

    {
        // Shift one character at a time
        char alpha = cipher.charAt(i);
        // if alphabet lies between a and z
        if(alpha >= 'a' && alpha <= 'z')
        {
            // shift alphabet
            alpha = (char) (alpha - ke);

            // shift alphabet lesser than 'a'
            if(alpha < 'a') {
                //reshift to starting position
                alpha = (char) (alpha-'a'+'z'+1);
            }
            plain = plain + alpha;
        }
        // if alphabet lies between A and Z
        else if(alpha >= 'A' && alpha <= 'Z')
        {
            // shift alphabet
            alpha = (char) (alpha - ke);

            //shift alphabet lesser than 'A'
            if (alpha < 'A') {
                // reshift to starting position
                alpha = (char) (alpha-'A'+'Z'+1);
            }
            plain = plain + alpha;
        }
        else
        {
            plain = plain + alpha;
        }
    }
    res.setText("decrpted Text: "+ plain);
}

}
