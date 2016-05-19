package com.estsoft.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ACTION_SHARED_ACTIVITY = "com.estsoft.android.action.SHARE_ACTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int viewId = v.getId();

        switch (viewId){
            case R.id.button1:
                Intent intent = new Intent( Intent.ACTION_CALL,  Uri.parse("tel:010-3889-5769") );
                startActivity(intent);      // 아이스크림 샌드위치 버젼까지는 그냥 사용 가능하나, 마쉬멜로우 버젼부터는
                                            // 더 안전하게 짜야 함. 권한 없는 경우~~~
                break;
            case R.id.button2:
                Intent intent2 = new Intent( Intent.ACTION_PICK );
                intent2.setData(Uri.parse("content://com.android.contacts/data/phones"));
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3 = new Intent( Intent.ACTION_VIEW );
                intent3.setData(Uri.parse("http://www.estsoft.com"));
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4 = new Intent( ACTION_SHARED_ACTIVITY );
                startActivity(intent4);
                break;
            default:
                break;
        }

    }

}
