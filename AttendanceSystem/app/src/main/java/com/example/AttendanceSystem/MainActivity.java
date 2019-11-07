package com.example.AttendanceSystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.AttendanceSystem.MESSAGE";
    protected Button info;
    protected EditText pass;
    protected EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = (Button) findViewById(R.id.button);
        pass = (EditText) findViewById(R.id.pass);
        user = (EditText) findViewById(R.id.user);


        info.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                info.setText(pass.getText().toString());
                Validate((user.getText().toString()), (pass.getText().toString()));
            }
        });

    }


    @SuppressLint("SetTextI18n")
   /* public void sendMessage(View view) {
        info.setText("Works");
        Validate(user.getText().toString(),pass.getText().toString());
    }
    */

    private void Validate(String user, String pass) {
        if ((user.equals("aryan")) && (pass.equals("1234"))) {
            Toast.makeText(MainActivity.this, "This is student login!",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Student.class);
            EditText editText = (EditText) findViewById(R.id.user);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);

        } else if ((user.equals("teach")) && (pass.equals("1234"))) {
            Toast.makeText(MainActivity.this, "This is teacher login!",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, teacher.class);
            EditText editText = (EditText) findViewById(R.id.user);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}
