package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText musernameet,mpasswordet;
        Button mregisterbtn,mloginbtn;
        String musernamestr,mpasswordstr;
        MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        musernameet=findViewById(R.id.usernameet);
        mpasswordet=findViewById(R.id.passwordet);
        mregisterbtn=findViewById(R.id.registerbtn);
        mloginbtn=findViewById(R.id.loginbtn);
        myHelper=new MyHelper(this);
        mpasswordstr=mpasswordet.getText().toString();
        musernamestr=musernameet.getText().toString();
    }
    public void register(View view) {
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (musernameet.length() == 0 || mpasswordet.length() == 0) {
            Toast.makeText(this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
        } else {
            values.put("username", musernamestr);
            values.put("password", mpasswordstr);
            db.insert("info", null, values);
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

    public void login(View view){
//        SQLiteDatabase db = myHelper.getWritableDatabase();
//        String sql="select * from info where username=? and password=?";
//        Cursor cursor = db.rawQuery(sql, new String[]{musernamestr,mpasswordstr});
//            if (cursor.moveToFirst()==true) {
//                Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
//                cursor.close();
//            }
//            else {
//                Toast.makeText(this, "用户名和密码错误，请重试", Toast.LENGTH_SHORT).show();
//                cursor.close();
//            }
//        cursor.close();
        if(musernamestr=="123"&&mpasswordstr=="456") {
            Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "用户名或密码错误，请重试！", Toast.LENGTH_SHORT).show();
        }
}