package cn.jcex.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import cn.jcex.R;

/**
 * 类描述:通讯录字母检索的自定义控件
 *
 * @author sunyaqin
 * @version 1.0
 * @data 2018/4/11  12:04
 */

public class QuickSearchView extends View{
    private final int ALPHANUM = 27;    //字符个数
    private final int TEXTSIZE = 30;    //字体大小

    private int itemHeight;                 //每个字符所占的高度
    private OnAlphaClickListener mListener; //回调接口
    private Paint mPaint;                   //画笔
    private PopupWindow pop;                //提示文字的弹窗
    private TextView tv_text;               //弹窗的文字
    private boolean isOnTouch;              //是否已按下

    public QuickSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(TEXTSIZE);
        initPop(context);
    }

    /**
     * 初始化弹窗
     */
    private void initPop(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.pop_alphasearch, null);
        pop = new PopupWindow(view);
        pop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        tv_text = (TextView) view.findViewById(R.id.tv_text);
    }

    /**
     * 设置监听器
     */
    public void setOnAlphaClickListener(OnAlphaClickListener l){
        mListener = l;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //按下状态有灰色背景，松开状态没有背景
        if (isOnTouch) {
            mPaint.setColor(Color.GRAY);
            //绘制背景
            canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        }

        //字体颜色，按下状态为白色，松开状态为灰色
        if (isOnTouch) {
            mPaint.setColor(Color.WHITE);
        }else {
            mPaint.setColor(Color.BLACK);
        }
        //字体大小
        for (int i = 0; i < ALPHANUM; i++){
            //要画的字符
            Character c;
            if (i == 26) c = '#';
            else c = (char) ('A' + i);

            //获取字符的宽高
            Rect bound = new Rect();
            mPaint.getTextBounds(c.toString(), 0, 1, bound);

            //绘制字符
            canvas.drawText(c.toString(), (getWidth() - bound.width()) / 2, itemHeight * (i + 1) - (itemHeight - bound.height()) / 2, mPaint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //计算每一个字符所占的高度
        itemHeight = getHeight() / ALPHANUM;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            isOnTouch = true;
            char c = getOnTouchAlpha((int) event.getY());
            if (c != '\0') {
                //显示弹窗
                showPop(c);
                //回调接口
                if (mListener != null) {
                    mListener.onClick(c);
                }
            }
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            isOnTouch = false;
            //隐藏弹窗
            hidePop();
        }
        invalidate();
        return true;
    }

    /**
     * 显示弹窗
     */
    private void showPop(Character c){
        tv_text.setText(c.toString());
        pop.showAtLocation(this, Gravity.CENTER, 0, 0);
    }

    /**
     * 隐藏弹窗
     */
    private void hidePop(){
        pop.dismiss();
    }

    /**
     * 获取触摸到的字符
     * @param y 相对于控件按下的y坐标
     * @return 对应的字符
     */
    private char getOnTouchAlpha(int y){
        int index = y / itemHeight;
        if (index < 0) return '\0';
        char c;
        if (index < 26){
            c = (char) ('A' + index);
        }else {
            c = '#';
        }
        return c;
    }

    /**
     * 按下的字母改变时回调的接口
     */
    public interface OnAlphaClickListener {
        /**
         * @param c 按下的字母
         */
        void onClick(Character c);
    }
}
