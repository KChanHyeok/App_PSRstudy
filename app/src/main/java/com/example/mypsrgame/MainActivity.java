package com.example.mypsrgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView img_player;
    ImageView img_computer;
    TextView textView_result;

    //0:no_input
    //1:paper
    //2:sissor
    //3:rock
    int player_input = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_player = (ImageView)findViewById(R.id.imageView_palyer);
        img_computer = (ImageView)findViewById(R.id.imageView_com);
        textView_result = (TextView)findViewById(R.id.textView_result);
        textView_result.setText("");
        player_input = 0;
    }

    public void onClick(View v)
    {
        if(v.getId() == R.id.button_paper){
            img_player.setImageResource(R.drawable.paper);
            player_input = 1;
        }
        if (v.getId() == R.id.button_sissor)
        {
            img_player.setImageResource(R.drawable.sissor);
            player_input = 2;
        }
        if (v.getId() == R.id.button_rock)
        {
            img_player.setImageResource(R.drawable.rock);
            player_input = 3;
        }
        if (v.getId() == R.id.button_start)
        {
            double aValue = Math.random();

            int computer_input = (int)(aValue * 10) % 3 + 1;


            if (computer_input == 1) { //보
                img_computer.setImageResource(R.drawable.paper);
                if(player_input ==1) //보VS보
                    textView_result.setText("비김!");
                    else if(player_input == 2 ) //가위vs보
                        textView_result.setText("승리!");
                    else if(player_input == 3) //바위VS 보
                        textView_result.setText("패배!");
                }
            if (computer_input == 2) { //가위
                img_computer.setImageResource(R.drawable.paper);
                if(player_input ==1) //보VS가위
                    textView_result.setText("패배!");
                else if(player_input == 2 ) //가위vs가위
                    textView_result.setText("비김!");
                else if(player_input == 3) //바위VS 보
                    textView_result.setText("승리!");
            }
            if (computer_input == 3) { //바위
                img_computer.setImageResource(R.drawable.paper);
                if(player_input ==1) //보VS바위
                    textView_result.setText("승리!");
                else if(player_input == 2 ) //가위vs바위
                    textView_result.setText("패배!");
                else if(player_input == 3) //바위VS바위
                    textView_result.setText("비김!");
            }
            }
        if (v.getId()== R.id.button_reset)
        {
            player_input = 0;
            textView_result.setText("");
            img_player.setImageResource(0);
            img_computer.setImageResource(0);
        }
    }

}