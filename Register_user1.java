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
import static com.example.fyp_prototypefinal.CreateConnectThread.mmSocket;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register_user1 extends AppCompatActivity {

    Button reg_id;
    TextView login_id;

    ConnectedThread connectedThread;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register_page2);

        reg_id=findViewById(R.id.register_id);
        reg_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                reg_id.startAnimation(animation);
//
//                String btnState;
//                connectedThread = new ConnectedThread(mmSocket);
//

                Intent intent=new Intent(getApplicationContext(), login_user.class);
                startActivity(intent);

            }
        });

        login_id=findViewById(R.id.login_id);
        login_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
                ButtonBounceInterpolator bounce=new ButtonBounceInterpolator(0.2,20);
                animation.setInterpolator(bounce);
                login_id.startAnimation(animation);
                Intent intent=new Intent(getApplicationContext(),login_user.class);
                startActivity(intent);
            }
        });


    }
}
