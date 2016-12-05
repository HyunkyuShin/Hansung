package com.example.administrator.hansunguniv;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_switch);



        startActivity(new Intent(this,SplashActivity.class)); //스플래시 엑티비티 호출

        // 백버튼 누르면 이전 프래그먼트로 돌아가게 함
       // final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        //fragmentTransaction.replace(R.id.fragment, new SecondFragment());
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();

        Button button = (Button)findViewById(R.id.button_first);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(0);
            }
        });
        button = (Button)findViewById(R.id.button_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(1);
            }
        });

        button = (Button)findViewById(R.id.button_third);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(2);
            }
        });

        button = (Button)findViewById(R.id.button_forth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchFragment(0);//Intent intent = new Intent(this, AddActivity.class);
                //startActivity(intent);    //startActivity(new Intent(this, MainActivity.class));   => 버튼 3개째때 '일정 추가 편집 activity'로 넘어가게 할 때 사용.
            }
        });

    }

    final FirstFragment firstFragment = new FirstFragment();
    final SecondFragment secondFragment = new SecondFragment();
    final ThirdFragment thirdFragment = new ThirdFragment();

    protected void switchFragment(int id) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (id == 0)
            fragmentTransaction.replace(R.id.fragment, firstFragment);

        else if (id ==1)
            fragmentTransaction.replace(R.id.fragment, secondFragment);

        else
            fragmentTransaction.replace(R.id.fragment, thirdFragment);
        fragmentTransaction.commit();
    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_subactivity:
                switchFragment(0);
                return true;
            case R.id.action_navdrawer:
                switchFragment(1);
                return true;
            case R.id.action_subactivity2:
                switchFragment(2);
                return true;
            case R.id.action_subactivity3:
                Intent intent = new Intent(this, AddActivity.class);
                 startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}
