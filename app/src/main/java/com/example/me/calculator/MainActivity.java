package com.example.me.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.me.calculator.Calculate.Calculate;


public class MainActivity extends AppCompatActivity {
String str = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        //Remove title bar

//Remove notification bar



        this.setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);
    }

    public void invalidResult(){
        if (str.equals("Invalid Input") || str.equals("NaN") || str.equals("Infinity"))
            str="0";
    }

    public void addToCalc(View view){
        invalidResult();
        Button b = (Button) view;
        if (str.equals("0")){
            str = b.getText().toString();
        }
        else {
            str = str.concat(b.getText().toString());
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);
    }

    public void delAll(View view){
        invalidResult();
        str="0";
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);
    }
    public void delLast(View view){
        invalidResult();
        str=str.substring(0,str.length()-1);
        if (str.length() == 0){
            str = "0";
        }
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);

    }
    public void compute(View view){
        invalidResult();
        Calculate asyncTask = new Calculate(this);
        asyncTask.execute(str);
    }
    public void showResult(String result){
        str = result;
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(str);
    }

}
