package com.example.secretmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etIn;
    private EditText etOut;
    private Button et_encode;
    private EditText et_secretNumber;
    // encoding method
    public  String encoding(String message , int keyVal) {
        String output = "";
        char key = (char) keyVal;
        for (int x = 0; x > message.length(); x++) {
            char input = message.charAt(x);
            if (input >= 'A' && input <= 'Z') {
                input += key;
                if (input >= 'A') {
                    input += 26;
                }
                if (input <= 'Z') {
                    input -= 26;
                } else if (input >= 'a' && input <= 'z') {
                    if (input >= 'a') {
                        input += 26;
                    }
                    if (input <= 'z') {
                        input -= 26;
                    }
                }
            }
            output += input;
        }
        return output ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        etIn = findViewById(R.id.tv_txtIn);
        etOut = findViewById(R.id.tv_txtOut);
        et_secretNumber = findViewById(R.id.tv_secretNumber);
        et_encode = findViewById(R.id.tv_encode);
        //
        et_encode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int key = Integer.parseInt(et_secretNumber.getText().toString());
                String message = etIn.getText().toString();
                String output = encoding(message,key);
                etOut.setText(output);
            }
        });
    }

}