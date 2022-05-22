package com.example.fyp_prototypefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ManageAppliance_1 extends AppCompatActivity {
    FloatingActionButton flt_1;
    RecyclerView recyclerView;
    Button back;

    private List<String> Appliances;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_manage_appliance_1);
        flt_1=findViewById(R.id.flt_1);
        recyclerView = findViewById(R.id.recycler_view_id);
        back=findViewById(R.id.back_button_id3);

        Appliances = new ArrayList<String>();

        flt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                flt_1.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),add_appliance.class);
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
                Intent intent=new Intent(getApplicationContext(),RoomList.class);
                startActivity(intent);
            }
        });


        for(int i=1;i<11;i++)
        {
            Appliances.add("Appliance # "+i);
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

////        CustomAdaptor customAdaptor=new CustomAdaptor(ManageAppliance_1.this,(ArrayList<String>)Rooms );
////        recyclerView.setAdapter(customAdaptor);
        CustomAdaptorManageAppliances customAdaptor1 = new CustomAdaptorManageAppliances(ManageAppliance_1.this,(ArrayList<String>)Appliances);
        recyclerView.setAdapter(customAdaptor1);
    }
}
