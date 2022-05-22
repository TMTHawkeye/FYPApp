package com.example.fyp_prototypefinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptorControlAppliance extends RecyclerView.Adapter {
    List<String> rooms;
    Context context;

    public CustomAdaptorControlAppliance(Context context, ArrayList rooms) {
        this.rooms = rooms;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rooms_list_layout,parent,false);

        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        ViewHolder viewHolder1=(ViewHolder)holder;
//        Toast.makeText(this.context, "Custom Adaptor View Holder ", Toast.LENGTH_SHORT).show();
        viewHolder1.room.setText(rooms.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ControlAppliance.class);
                    view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.rooms.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder{


        TextView room;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            room= itemView.findViewById(R.id.rooms_textView_id);
        }
    }
}
