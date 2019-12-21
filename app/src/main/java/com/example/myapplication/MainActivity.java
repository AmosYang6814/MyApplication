package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import UI.BackGroundBoard;
import UI.MenuListener;

public class MainActivity extends AppCompatActivity {
    private String TAG="MainActivity_Test";
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ListView subMenuList;
    private ArrayAdapter<String> menuAdapter;
    private BackGroundBoard BackgroundView;


    //hander发送的信号
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.i(TAG,"接收到Message");
            super.handleMessage(msg);
            switch (msg.what){
                case MenuListener.SUBMENU:
                    int data=msg.getData().getInt("MenuID");
                    ShowSubMenu(data);
                    break;
            }

        }
    };



    /**
     * View初始化
     */
    private void InitView(){
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        subMenuList=findViewById(R.id.SubMenu);
        menuAdapter=new ArrayAdapter<String>(this,R.layout.anchor);
        subMenuList.setAdapter(menuAdapter);
        BackgroundView=(BackGroundBoard) findViewById(R.id.BackgroundView);
    }

    /**
     * 显示二级菜单
     */
    private void ShowSubMenu(int chooseId){
        Log.i(TAG,"进入showList");
        menuAdapter.clear();
        switch (chooseId){
            case R.id.nv_component:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.de_comonent));
                break;
            case R.id.nav_media:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.media_component));
                break;
            case R.id.nav_Draw:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.draw_component));
                break;
            case R.id.nav_function:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.pakeage_component));
                break;
            case R.id.nav_store:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.store_component));
                break;
            case R.id.nav_sensor:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.sensor_component));
                break;
            case R.id.nav_connect:
                menuAdapter.addAll(this.getResources().getStringArray(R.array.connect_component));
                break;

        }
        subMenuList.setVisibility(View.VISIBLE);
        menuAdapter.notifyDataSetChanged();
    }

    /**
     * 隐藏二级菜单
     * @return
     */
    private  void hideSubMenu() {
        if(subMenuList.getVisibility()== View.VISIBLE){
            subMenuList.setVisibility(View.GONE);
            menuAdapter.clear();
            menuAdapter.notifyDataSetChanged();
            return ;
        }

    }

    private View addView2() {
        // TODO 动态添加布局(java方式)
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout view = new LinearLayout(this);
        view.setLayoutParams(lp);//设置布局参数
        view.setOrientation(LinearLayout.HORIZONTAL);// 设置子View的Linearlayout// 为垂直方向布局
        //定义子View中两个元素的布局
        ViewGroup.LayoutParams vlp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams vlp2 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv1 = new TextView(this);
        TextView tv2 = new TextView(this);
        tv1.setLayoutParams(vlp);//设置TextView的布局
        tv2.setLayoutParams(vlp2);
        tv1.setText("姓名:");
        tv2.setText("李四");
        tv2.setPadding(calculateDpToPx(50), 0, 0, 0);//设置边距
        view.addView(tv1);//将TextView 添加到子View 中
        view.addView(tv2);//将TextView 添加到子View 中
        return view;
    }

    private int calculateDpToPx(int padding_in_dp){
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (padding_in_dp * scale + 0.5f);
    }

    /**
     * 监听器设置
     */
    private void setListener(){
        subMenuList.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.i(TAG,"Foucus改变");
                if(!hasFocus)hideSubMenu();
            }
        });

        BackgroundView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("事件追踪","点击空白区域");

                hideSubMenu();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        setListener();

        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        MenuListener.registListener(this, navigationView,handler);

        BackgroundView.addView(addView2());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


    /**
     * 内部类实现手势监听
     */
     class touchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            
            return false;
        }
    }
}
