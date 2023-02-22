package com.example.unionpplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Create_model_Activity extends AppCompatActivity {


    public TextView tv;
    public Button btn1;
    public Button btn2;
    public String str;
    public EditText et;
    public EditText et2;
    public EditText et3;
    public EditText et4;
    public EditText et5;
    public EditText et6;
    public EditText et7;
    public EditText et8;
    public EditText et9;
    public EditText et10;



    public final String file_name = "ttt.text";

    public SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_model);

        //sharepreference example   文件io
        sp=getSharedPreferences("config",MODE_PRIVATE);
        int c_count=sp.getInt("count",0);//如果第一次没有，就设为0
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt("count",++c_count);
        editor.commit();



        tv=findViewById(R.id.tv);

        et = findViewById(R.id.et);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        et10 =findViewById(R.id.et10);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {//响应事件
            @Override
            public void onClick(View view) {
                //write text from EditText to File
                try {//文件都需要try-catch
                    FileOutputStream fos = openFileOutput(file_name,MODE_PRIVATE);
                    PrintStream ps = new PrintStream(fos);
                    ps.println(et.getText());
                    ps.println(et2.getText());
                    ps.println(et3.getText());
                    ps.println(et4.getText());
                    ps.println(et5.getText());
                    ps.println(et6.getText());
                    ps.println(et7.getText());
                    ps.println(et8.getText());
                    ps.println(et9.getText());
                    ps.println(et10.getText());
                    ps.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write text from  File to TextView
                try {
                    FileInputStream fis = openFileInput(file_name);
                    byte[] buff = new byte[1024];
                    int hasRead = 0;
                    StringBuilder sb = new StringBuilder("");
                    while((hasRead = fis.read(buff))>0){
                        sb.append(new String (buff,0,hasRead));
                    }
                    fis.close();
                    tv.setText(sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}