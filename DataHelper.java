package com.example.fyp_prototypefinal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class DataHelper extends AppCompatActivity {

    public static String ROOM_KEY="";
    public static int value_for_layout=0;
    public static int count=0;
    public static String plist[];
    public BluetoothSocket mmSocket;
//    public static String deviceHardwareAddress;
//    public static String deviceName;
////    public static BluetoothAdapter bluetoothAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        plist=new String[count];
//        MainActivity mainActivity=new MainActivity();
//        bluetoothAdapter=mainActivity.bluetoothAdaptor;


    }
}
