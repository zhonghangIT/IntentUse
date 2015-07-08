package com.lingzhuo.useintent.intentuse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1;//显示启动界面
    private Button mButton2;//隐式启动界面
    private Button mButton3;//启动打电话
    private Button mButton4;//启动发短信
    private Button mButton5;//启动网页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1= (Button) findViewById(R.id.button1);
        mButton2= (Button) findViewById(R.id.button2);
        mButton3= (Button) findViewById(R.id.button3);
        mButton4= (Button) findViewById(R.id.button4);
        mButton5= (Button) findViewById(R.id.button5);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Intent intent1=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2=new Intent();
                intent2.setAction("com.lingzhuo.testthird");
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3=new Intent( );
                intent3.setAction( Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:18612117174"));
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4=new Intent();
                intent4.setAction(Intent.ACTION_SENDTO);
                intent4.setData(Uri.parse("smsto:18612117174"));
                intent4.putExtra("sms_body","我想发送的内容");
                startActivity(intent4);
                break;
            case R.id.button5:
                Intent intent5=new Intent();
                intent5.setAction(Intent.ACTION_VIEW);
                intent5.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent5);
                break;
        }
    }
}
