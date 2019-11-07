package com.example.AttendanceSystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class teacher extends Student {
    public static String mactea;
    public static int Total_attendance;
    protected Button sa, ga1, ca1;

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
        setContentView(R.layout.activity_teacher);
        sa = (Button) findViewById(R.id.start_attendance);
        ga1 = (Button) findViewById(R.id.give_attendance);
        ca1 = (Button) findViewById(R.id.check_attendance);
    }

    public void Start(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        mactea = getMacAddr();
        Total_attendance++;
        sa.setText(mactea);
    }
}
