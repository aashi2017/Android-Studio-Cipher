package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Multi extends AppCompatActivity implements View.OnClickListener {
    private Button encryptM,mainMenuM;
    private EditText val1,val2;
    private TextView op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        encryptM = findViewById(R.id.encryptM);
        mainMenuM = findViewById(R.id.mainMenuM);
        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        op = findViewById(R.id.op);

        encryptM.setOnClickListener(this);
        mainMenuM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.encryptM:
                int a = Integer.parseInt(val1.getText().toString());
                int m = Integer.parseInt(val2.getText().toString());
                int ans =  modInverse(a,m);

                op.setText(String.valueOf(ans));

                break;
            case R.id.mainMenuM:
                Intent intent = new Intent(Multi.this, MainActivity.class);
                startActivity(intent);
                setContentView(R.layout.activity_main);
                break;

        }
    }
    public  int modInverse(int a, int m)
    {
        a = a % m;
        for (int x = 1; x < m; x++)
            if ((a * x) % m == 1)
                return x;
        return 1;
    }

}
