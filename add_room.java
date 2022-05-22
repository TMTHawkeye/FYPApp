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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class add_room extends AppCompatActivity {
    private TextView room_detail_id;
    private Button add_button;
    private String room_no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_room);

        room_detail_id=findViewById(R.id.appliance_detail_id);
        add_button=findViewById(R.id.add_button);

       add_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
               ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
               animation.setInterpolator(bounce);
               add_button.startAnimation(animation);
               Intent intent=new Intent(getApplicationContext(),HomeScreen.class);
               DataHelper.ROOM_KEY=room_detail_id.getText().toString();
               startActivity(intent);
           }
       });
    }
}
