package com.example.lcmhcf;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView input;
    TextView output;
    TextView output2;
    TextView output3;
    TextView output4;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        input =(TextView) findViewById(R.id.textView);
        output = (TextView) findViewById(R.id.textView2);
        output2 = (TextView) findViewById(R.id.textView3);
        output3 = (TextView) findViewById(R.id.textView4);
        output4 = (TextView) findViewById(R.id.textView5);
        button.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
//    @Override
    public void onClick(View v) {
        if(v == button)
        {
            String inpt = input.getText().toString();
            ArrayList<String> Values = new ArrayList<>(Arrays.asList(inpt.split("\\s*,\\s*")));
            System.out.println(Values);
            System.out.println(LCM(Values));
            output.setText(String.valueOf(LCM(Values)));
            output2.setText(String.valueOf(nGCD(Values)));
            output3.setText(String.valueOf(SD(Values)));
            output4.setText(String.valueOf(SD(Values)*SD(Values)));
        }
    }
    public double SD(ArrayList<String> input){
        double sum = 0,mean;
        int n = input.size();
        for(int i=0;i<n;i++)
        {
            sum=sum+Integer.parseInt(input.get(i));
        }
        mean=sum/n;
        System.out.println("Mean :"+mean);
        sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=Math.pow((Integer.parseInt(input.get(i))-mean),2);

        }
        mean=sum/(n-1);

        return Math.sqrt(mean);
    }
    public int LCM(ArrayList<String> input) {
        int ans = Integer.parseInt(String.valueOf(input.get(0)));
        for (int i = 1; i < input.size(); i++) {
            ans = (((Integer.parseInt(String.valueOf(input.get(i))) * ans)) /
                    findGCD(Integer.parseInt(String.valueOf(input.get(i))), ans));
        }
        return ans;
    }

    public int findGCD(int a, int b){
        if(b == 0)
            return a;
        return findGCD(b, a%b);
    }
    public int nGCD(ArrayList<String> input){
        int result = Integer.parseInt(input.get(0));
        for (int i = 1; i < input.size(); i++)
        {
            result = findGCD(Integer.parseInt(input.get(i)), result);
            if(result == 1)
            {
                return 1;
            }
        }
        return result;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
