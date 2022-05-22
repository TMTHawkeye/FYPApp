package com.example.fyp_prototypefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class applianceList extends AppCompatActivity {

    private FloatingActionButton flt;
    private RecyclerView recyclerView;
    private Button back;
    private List<String> Rooms;
    private TextView room_id;
    private String ROOM_KEY="room_id";
    private String room_no="nill";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_room_list);

        flt = findViewById(R.id.floatingActionButton_id);
        recyclerView = findViewById(R.id.recycler_view_id);
        room_id = findViewById(R.id.appliance_detail_id);
        back=findViewById(R.id.back_button_id);

        Rooms = new ArrayList<String>();

        if(DataHelper.value_for_layout==1)
        {
            flt.setVisibility(View.INVISIBLE);
        }
        else if(DataHelper.value_for_layout==2)
        {
            flt.setVisibility(View.VISIBLE);
        }

        flt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                flt.startAnimation(animation);
                Intent intent = new Intent(getApplicationContext(), add_room.class);
                startActivity(intent);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                back.startAnimation(animation);
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
            }
        });



        room_no = DataHelper.ROOM_KEY;
        for(int i=1;i<11;i++)
        {
            Rooms.add("Room # "+i);
        }





        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdaptorControlAppliance customAdaptor = new CustomAdaptorControlAppliance(applianceList.this, (ArrayList<String>) Rooms);
        recyclerView.setAdapter(customAdaptor);


    }

}
