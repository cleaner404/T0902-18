package com.example.cleaner208.t0902_182;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private final static String MyFileName="myfile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnw=(Button)findViewById(R.id.btn_w);
        Button btnr=(Button)findViewById(R.id.btn_r);
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutputStream out=null;
                try{
                    FileOutputStream fileOutputStream=openFileOutput(MyFileName,MODE_PRIVATE);
                    out=new BufferedOutputStream(fileOutputStream);
                    String content="2014000002";
                    try{
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    }
                    finally{
                        if (out!=null)
                            out.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream in=null;
                try{
                    FileInputStream fileInputStream=openFileInput(MyFileName);
                    in=new BufferedInputStream(fileInputStream);

                    int c;
                    StringBuilder stringBuilder=new StringBuilder("");
                    try{
                        while((c=in.read())!=-1){
                            stringBuilder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this,"姓名：李云龙"+"学号:"+stringBuilder.toString(),Toast.LENGTH_LONG).show();
                    }
                    finally{
                        if(in!=null)
                            in.close();
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
