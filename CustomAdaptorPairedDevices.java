package com.example.fyp_prototypefinal;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdaptorPairedDevices extends RecyclerView.Adapter {
    List<String> pairs;
    Context context;
    private String deviceName=null;
    private String deviceAddress;

    public static CreateConnectThread createConnectThread;




    public CustomAdaptorPairedDevices(Context context, List pairs) {
        this.pairs = pairs;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rooms_list_layout,parent,false);
        ViewHolder v1=new ViewHolder(v);
        return v1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CustomAdaptorPairedDevices.ViewHolder viewHolder2=(CustomAdaptorPairedDevices.ViewHolder)holder;
//        Toast.makeText(this.context, "Custom Adaptor View Holder ", Toast.LENGTH_SHORT).show();
        viewHolder2.pair.setText(pairs.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
//                MainActivity mainActivity=new MainActivity();
//                Intent intent = new Intent(view.getContext(), SelectDeviceActivity.class);
//                intent.putExtra("pairs",pairs.get(position).toString());

//                IntentAttrHelper.deviceHardwareAddress=pairs.get(position).toString();
                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


                createConnectThread = new CreateConnectThread(bluetoothAdapter,"00:21:09:00:12:5D");
                createConnectThread.run();
//                createConnectThread.cancel();
//

//                Toast.makeText(context, IntentAttrHelper.deviceHardwareAddress, Toast.LENGTH_SHORT).show();
//                context.startActivity(intent);
                Toast.makeText(context, "Connected" +
                        "", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(view.getContext(), HomeScreen.class);
                context.startActivity(intent1);


            }
        });
    }


    @Override
    public int getItemCount() {
        return this.pairs.size();
    }
//    @Override
//    public long getItemId(int position) {
//
//    }
    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView pair;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pair= itemView.findViewById(R.id.rooms_textView_id);
        }
    }


}
