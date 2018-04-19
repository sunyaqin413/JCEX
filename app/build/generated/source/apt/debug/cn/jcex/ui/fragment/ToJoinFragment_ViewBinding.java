// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ToJoinFragment_ViewBinding<T extends ToJoinFragment> implements Unbinder {
  protected T target;

  private View view2131230766;

  public ToJoinFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mTvHeader = finder.findRequiredViewAsType(source, R.id.tv_header, "field 'mTvHeader'", TextView.class);
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    view = finder.findRequiredView(source, R.id.btn_join, "field 'mBtnJoin' and method 'onViewClicked'");
    target.mBtnJoin = finder.castView(view, R.id.btn_join, "field 'mBtnJoin'", Button.class);
    view2131230766 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.mSmartRefreshLayout = finder.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'mSmartRefreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvHeader = null;
    target.mRecycleView = null;
    target.mBtnJoin = null;
    target.mSmartRefreshLayout = null;

    view2131230766.setOnClickListener(null);
    view2131230766 = null;

    this.target = null;
  }
}
