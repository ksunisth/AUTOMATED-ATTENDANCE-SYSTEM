package com.example.AttendanceSystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class Student extends AppCompatActivity {
    protected Button ga, ca;
    protected String message;
    protected int student_attendance;

    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    String hex = Integer.toHexString(b & 0xFF);
                    if (hex.length() == 1)
                        hex = "0".concat(hex);
                    res1.append(hex.concat(":"));
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
        }
        return "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);
        ga = (Button) findViewById(R.id.give_attendance);
        ca = (Button) findViewById(R.id.check_attendance);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //ga.setOnClickListener(new View.OnClickListener() {
        //public void onClick(View v) {
        //ga.setText(getMacAddr());
        //Validate((user.getText().toString()),(pass.getText().toString()));
        //}
        //});
    }

    public void check(View view) {
        Intent intent = new Intent(this, student_tries.class);
        startActivity(intent);
        //String mac = getMacAddr();
        //ga.setText(mac);
        //if(mac.equals(mactea)){
        //    ga.setText(message);
        //    getAttendance();
        //}
    }

    protected void getAttendance() {
        //student_attendance ++;

    }

    public void CheckAtten(View view) {
        //ga.setText("Y             T              P\n"+student_attendance+"                "+Total_attendance+"              "+(student_attendance/Total_attendance));

    }


}
