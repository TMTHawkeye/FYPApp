package com.example.fyp_prototypefinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Set;

public class HomeScreen extends AppCompatActivity {
    private Button control_appliance;
    private Button manageAppliances;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_homescreen);

        control_appliance = findViewById(R.id.ctrl_button);
        manageAppliances = findViewById(R.id.mng_button);

        control_appliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                control_appliance.startAnimation(animation);
                Intent intent = new Intent(getApplicationContext(), applianceList.class);
                DataHelper.value_for_layout = 1;
                startActivity(intent);
            }
        });

        manageAppliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                manageAppliances.startAnimation(animation);
                Intent intent = new Intent(getApplicationContext(), RoomList.class);
                DataHelper.value_for_layout = 2;
                startActivity(intent);
            }
        });
    }
}



