// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class StationFragment_ViewBinding<T extends StationFragment> implements Unbinder {
  protected T target;

  private View view2131230821;

  public StationFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mTvHeader = finder.findRequiredViewAsType(source, R.id.tv_header, "field 'mTvHeader'", TextView.class);
    view = finder.findRequiredView(source, R.id.et_search, "field 'mEtSearch' and method 'onViewClicked'");
    target.mEtSearch = finder.castView(view, R.id.et_search, "field 'mEtSearch'", EditText.class);
    view2131230821 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.mTabLayout = finder.findRequiredViewAsType(source, R.id.tab_layout, "field 'mTabLayout'", TabLayout.class);
    target.mViewPager = finder.findRequiredViewAsType(source, R.id.view_pager, "field 'mViewPager'", ViewPager.class);
    target.mSmartRefreshLayout = finder.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'mSmartRefreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvHeader = null;
    target.mEtSearch = null;
    target.mTabLayout = null;
    target.mViewPager = null;
    target.mSmartRefreshLayout = null;

    view2131230821.setOnClickListener(null);
    view2131230821 = null;

    this.target = null;
  }
}
