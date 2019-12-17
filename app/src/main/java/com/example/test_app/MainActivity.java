package com.example.test_app;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        super.onCreate(null);
        setContentView(R.layout.activity_main);

        onButtonClick();

    }
    public void onButtonClick(){
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent intent = new Intent(getApplicationContext(),add_item_activity.class);
                startActivity(intent);

            }
        });

    }

}
