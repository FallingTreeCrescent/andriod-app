package com.example.unionpplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.os.StrictMode;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //private UserDao userDao;

    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //userDao=new UserDao();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment=(NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        NavController navController= navHostFragment.getNavController();
        AppBarConfiguration configuration= new AppBarConfiguration.Builder(bottomNavigationView.getMenu()).build();
        NavigationUI.setupActionBarWithNavController(this,navController,configuration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        /*StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            userDao.select("journey_user");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //tvContent=findViewById(R.id.tv_content);
        //Intent intent= getIntent();
        //String account=intent.getStringExtra("account");
        //tvContent.setText("welcome "+account);
    }

    //public void logout(View view) {
       // Intent intent=new Intent(this,loginActivity.class);
        //startActivity(intent);
        //this.finish();
    //}//退出按钮
}