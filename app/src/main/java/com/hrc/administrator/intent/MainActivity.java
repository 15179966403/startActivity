package com.hrc.administrator.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btncell, btntonghuajilu, btndadianhua, btnweb, btnchuanemail, btnsellemail, btnradio;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncell = (Button) findViewById(R.id.btncell);
        btntonghuajilu = (Button) findViewById(R.id.btntonghuajilu);
        btndadianhua = (Button) findViewById(R.id.btndadianhua);
        btnweb = (Button) findViewById(R.id.btnweb);
        btnchuanemail = (Button) findViewById(R.id.btnchuanemail);
        btnsellemail = (Button) findViewById(R.id.btnsellemail);
        btnradio = (Button) findViewById(R.id.btnradio);
        editText = (EditText) findViewById(R.id.editText);
        btncell.setOnClickListener(this);
        btntonghuajilu.setOnClickListener(this);
        btndadianhua.setOnClickListener(this);
        btnweb.setOnClickListener(this);
        btnchuanemail.setOnClickListener(this);
        btnsellemail.setOnClickListener(this);
        btnradio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btncell:
                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editText.getText().toString()));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callintent);
                break;
            case R.id.btntonghuajilu:
                Intent callButtonIntent=new Intent(Intent.ACTION_CALL_BUTTON);
                Log.d("btn","按钮被点击");
                startActivity(callButtonIntent);
                break;
            case R.id.btndadianhua:
                Intent dialIntent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+editText.getText().toString()));
                startActivity(dialIntent);
                break;
            case R.id.btnweb:
                Intent webIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
                startActivity(webIntent);
                break;
            case R.id.btnchuanemail:
                Uri uri=Uri.parse("mailto:342005059@qq.com");
                Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(intent);
                break;
            case R.id.btnsellemail:

                break;
            case R.id.btnradio:
                Intent audioIntent=new Intent(Intent.ACTION_GET_CONTENT);
                audioIntent.setType("audio/*");
                startActivity(Intent.createChooser(audioIntent,"选择音频程序"));
                break;
        }
    }
}
