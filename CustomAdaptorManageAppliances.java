package com.example.fyp_prototypefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptorManageAppliances extends RecyclerView.Adapter {
    List<String> rooms;
    Context context;

    public CustomAdaptorManageAppliances(Context context,ArrayList rooms) {
        this.rooms = rooms;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.appliance_disconnect_layout,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
       ViewHolder viewHolder=(ViewHolder)holder;
//        Toast.makeText(this.context, "Custom Adaptor View Holder ", Toast.LENGTH_SHORT).show();
        viewHolder.room.setText(rooms.get(position));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                viewHolder.delete_room.setVisibility(View.INVISIBLE);
//
//            }
//        });

        Button b=holder.itemView.findViewById(R.id.button_delete);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.room.setVisibility(View.INVISIBLE);
                viewHolder.delete_room.setVisibility(View.INVISIBLE);
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.rooms.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{
        TextView room;
        Button delete_room;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room= itemView.findViewById(R.id.appliance_textView_id);
            delete_room=itemView.findViewById(R.id.button_delete);
        }
    }
}
