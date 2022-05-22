package com.example.fyp_prototypefinal;

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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class login_user extends AppCompatActivity {

    public static final int CONNECTING_STATUS = 1;
    public static final int MESSAGE_READ = 2;

    String deviceName;
    String deviceHardwareAddress;


    String pList[];

    int REQUEST_CODE = 1;

    Set<BluetoothDevice> paired_devices;

    //    public static BluetoothAdapter bluetoothAdaptor = null;
    public static Handler handler;
    public static BluetoothSocket mmSocket;

    private Button login_btn;
    private TextView register_id;
    private Button showPaired_id;
    private Switch showSettings;
    private ImageView bluetoothIcon;
    public static BluetoothAdapter bluetoothAdaptor = null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);

        login_btn=findViewById(R.id.login_id);
        showSettings = findViewById(R.id.switchBluetooth);
        bluetoothIcon = findViewById(R.id.bluetoothIcon_id);
        showPaired_id = findViewById(R.id.showPaired_id);


        bluetoothAdaptor = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdaptor.isEnabled()) {
            showSettings.setChecked(true);
            bluetoothIcon.setImageResource(R.drawable.ic_action_on);

        } else {
            showSettings.setChecked(false);
            bluetoothIcon.setImageResource(R.drawable.ic_action_off);
        }

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                login_btn.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
            }
        });

        register_id=findViewById(R.id.register_id);

        register_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                register_id.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),Register_user.class);
                startActivity(intent);
            }
        });

        showPaired_id.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                showPaired_id.startAnimation(animation);
                if (!bluetoothAdaptor.isEnabled()) {
                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i, REQUEST_CODE);
                    showSettings.setChecked(true);
                    bluetoothIcon.setImageResource(R.drawable.ic_action_on);
                    return;
                } else {
                    get_List();
                    showSettings.setChecked(true);
                    bluetoothIcon.setImageResource(R.drawable.ic_action_on);

                }
            }
        });

        showSettings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                showSettings.startAnimation(animation);
                if (b) {
                    Intent intentOpenBluetoothSettings = new Intent();
                    intentOpenBluetoothSettings.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);

                    startActivity(intentOpenBluetoothSettings);
                    if (bluetoothAdaptor.isEnabled()) {
                        bluetoothIcon.setImageResource(R.drawable.ic_action_on);
                        Toast.makeText(login_user.this, "Enabled", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    if (bluetoothAdaptor.isEnabled()) {
//                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        bluetoothAdaptor.disable();
                        bluetoothIcon.setImageResource(R.drawable.ic_action_off);

                        Toast.makeText(login_user.this, "Disabled", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }

        });

        handler = new Handler(Looper.getMainLooper());

    }
    public void onActivityResult(int request_code, int result_code, Intent data) {
        super.onActivityResult(request_code, result_code, data);
        if (result_code == REQUEST_CODE) {
            if (result_code == RESULT_OK) {
                Toast.makeText(this, "Bluetooth Successfully turned on", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @SuppressLint("MissingPermission")
    public void get_List() {
        paired_devices = bluetoothAdaptor.getBondedDevices();
        int count = paired_devices.size();
        DataHelper.count = count;
        int j = 0;
        pList = new String[count];
        for (BluetoothDevice device : paired_devices) {
            deviceName = device.getName();
            deviceHardwareAddress = device.getAddress();
            pList[j] = device.getName().toString();
            j++;
        }

        DataHelper.plist = pList;
        Intent intent = new Intent(this, Pairing_List.class);
        startActivity(intent);
    }


}
