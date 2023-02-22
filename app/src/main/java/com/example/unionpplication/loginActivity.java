package com.example.unionpplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_REGISTER = 1;
    private Button btnLogin;
    private EditText etAccount,etPassword;
    private String userName="zydong";
    private String pass="123";
    private CheckBox cbRemember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("登录");

        initView();
        initData();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = etAccount.getText().toString();
                String password = etPassword.getText().toString();
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(loginActivity.this,"未注册成功",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.equals(account,userName)){
                    if(TextUtils.equals(password,pass)){
                        Toast.makeText(loginActivity.this,"恭喜你！成功登录",Toast.LENGTH_LONG).show();
                        if(cbRemember.isChecked()){
                            SharedPreferences spf=getSharedPreferences("spfRecorid",MODE_PRIVATE);
                            SharedPreferences.Editor edit=spf.edit();
                            edit.putString("account",account);
                            edit.putString("password",password);
                            edit.putBoolean("isRemember",true);
                            edit.apply();
                        }else{
                            SharedPreferences spf=getSharedPreferences("spfRecorid",MODE_PRIVATE);
                            SharedPreferences.Editor edit=spf.edit();
                            edit.putBoolean("isRemember",false);
                            edit.apply();
                        }

                        Intent intent =new Intent(loginActivity.this,MainActivity.class);
                        intent.putExtra("account",account);
                        startActivity(intent);
                        loginActivity.this.finish();

                    }else{
                        Toast.makeText(loginActivity.this,"密码错误",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(loginActivity.this,"用户名不正确",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private void initData() {
        SharedPreferences spf=getSharedPreferences("spfRecorid",MODE_PRIVATE);
        boolean isRemember=spf.getBoolean("isRemember",false);
        String account=spf.getString("account","");
        String password=spf.getString("password","");
        userName=account;
        pass=password;

        if(isRemember){
            etAccount.setText(account);
            etPassword.setText(password);
            cbRemember.setChecked(true);
        }
    }

    private void initView() {
        btnLogin= findViewById(R.id.btn_login);
        etAccount=findViewById(R.id.et_account);
        etPassword=findViewById(R.id.et_password);
        cbRemember=findViewById(R.id.cb_remember);
    }

    public void toRegister(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivityForResult(intent,REQUEST_CODE_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_REGISTER && resultCode==RegisterActivity.RESULT_CODE_REGISTER && data!=null){
            Bundle extras= data.getExtras();

            String account=extras.getString("account","");
            String password=extras.getString("password","");
            etAccount.setText(account);
            etPassword.setText(password);
            userName=account;
            pass=password;
        }
    }
}