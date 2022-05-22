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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairing_List extends AppCompatActivity {
    private RecyclerView l_view;
    private List<String> pairs;
    Button pairing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pairing_list);

        pairing=findViewById(R.id.back_button_id_pairing);

        l_view=findViewById(R.id.listView_id);
        Bundle bn=getIntent().getExtras();
        pairs = new ArrayList<String>();
        this.pairs= Arrays.asList(DataHelper.plist);


//      Toast.makeText(this, pairs.get(5), Toast.LENGTH_SHORT).show();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        l_view.setLayoutManager(linearLayoutManager);

        CustomAdaptorPairedDevices customAdaptorPairedDevices = new CustomAdaptorPairedDevices(Pairing_List.this,(List) pairs);
        l_view.setAdapter(customAdaptorPairedDevices);


        pairing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                pairing.startAnimation(animation);
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
            }
        });



    }
}
