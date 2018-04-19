package cn.rimcloud.my_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 类描述：ScrollView下嵌套的ListView.
 *
 * @author 陈建邦
 * @version 1.0
 * @date 2015/12/22 09:47
 */
public class ScrollListView extends ListView {

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollListView(Context context) {
        super(context);
    }

    public ScrollListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
