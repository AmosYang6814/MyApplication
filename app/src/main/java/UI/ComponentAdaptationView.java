package UI;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class ComponentAdaptationView extends LinearLayout {
    View targetView;
    Context context;
   public  ComponentAdaptationView(Context context){
        super(context);
        this.context=context;
        setWrapLay();
        DrawBoard();
    }


    //设置包围
    private void setWrapLay(){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(lp);
    }


    //携带内部View的封装类
    public ComponentAdaptationView(Context context,View targetView){
       this(context);
       this.targetView=targetView;
       this.addView(targetView);
    }

    //绘制边框
    private void DrawBoard(){
       this.setBackground(context.getResources().getDrawable(R.drawable.component_adaptation_viewback_ground));
    }


    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    //获取targetView的对象.用于设置对象属性
    public View getTargetView(){
       return  targetView;
    };


}
