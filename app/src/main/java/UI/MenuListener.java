package UI;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;




//点击菜单按钮之后，弹出Poppup菜单
public  class MenuListener     {
    public static final int SUBMENU=101;

    static final String TAG_deug="MenuListener_debug";
     Handler mainActivityHandler;

    ListView subMenu;

    private MenuListener(Handler handler){
        this.mainActivityHandler=handler;
    }

    public static void registListener(final Activity context, final NavigationView navigationView, final Handler handler){
        new MenuListener(handler).registListener(context,navigationView);
    }

    public  void registListener(final Activity context, final NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Log.i(MenuListener.TAG_deug,menuItem.getTitle().toString());
                PopupMenu popuMenu=new PopupMenu(context,navigationView);
                switch (menuItem.getItemId()){
                    case R.id.nv_component:
                        sendMessage(R.id.nv_component);
                        break;
                    case R.id.nav_media:
                        sendMessage(R.id.nav_media);
                        break;
                    case R.id.nav_Draw:
                        sendMessage(R.id.nav_Draw);
                        break;
                    case R.id.nav_function:
                        sendMessage(R.id.nav_function);
                        break;
                    case R.id.nav_store:
                        sendMessage(R.id.nav_store);
                        break;
                    case R.id.nav_sensor:
                        sendMessage(R.id.nav_sensor);
                        break;
                    case R.id.nav_connect:
                        sendMessage(R.id.nav_connect);
                        break;
                }

                return false;
            }
        });

    }

    private void sendMessage(int id){
        Message message=new Message();
        Bundle bundle=new Bundle();
        bundle.putInt("MenuID",id);
        message.setData(bundle);
        message.what=SUBMENU;
        mainActivityHandler.sendMessage(message);
    }
}
