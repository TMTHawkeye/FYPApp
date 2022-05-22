package com.example.fyp_prototypefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.fyp_prototypefinal.login_user.bluetoothAdaptor;
import static com.example.fyp_prototypefinal.login_user.mmSocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class ControlAppliance extends AppCompatActivity {
    Switch bulb1,bulb2,bulb3;
    Button back;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_control_appliance);

        bulb1=findViewById(R.id.bulb1);
        bulb2=findViewById(R.id.bulb2);
        bulb3=findViewById(R.id.bulb3);
        back=findViewById(R.id.back_button_id);

        bulb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bluetoothAdaptor.isEnabled()) {
                    ConnectedThread connectedThread = new ConnectedThread(mmSocket);
                    if (isChecked) {
                        connectedThread.write("5");
                    } else {
                        connectedThread.write("1");
                    }
                } else {
                    Toast.makeText(ControlAppliance.this, "Please Turn On the Bluetooth", Toast.LENGTH_SHORT).show();
                    bulb1.setChecked(false);
                }
            }
        });

        bulb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bluetoothAdaptor.isEnabled()) {
                    ConnectedThread connectedThread = new ConnectedThread(mmSocket);
                    if (isChecked) {
                        connectedThread.write("6");
                    } else {
                        connectedThread.write("2");
                    }
                } else {
                    Toast.makeText(ControlAppliance.this, "Please Turn On the Bluetooth", Toast.LENGTH_SHORT).show();
                    bulb2.setChecked(false);

                }
            }
        });

        bulb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bluetoothAdaptor.isEnabled()) {
                    ConnectedThread connectedThread = new ConnectedThread(mmSocket);
                    if (isChecked) {
                        connectedThread.write("7");
                    } else {
                        connectedThread.write("3");
                    }
                } else {
                    Toast.makeText(ControlAppliance.this, "Please Turn On the Bluetooth", Toast.LENGTH_SHORT).show();
                    bulb3.setChecked(false);

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),applianceList.class);
                startActivity(intent);
            }
        });


    }
}