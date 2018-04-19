// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import cn.jcex.view.QuickSearchView;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SelectTransportModeFragment_ViewBinding<T extends SelectTransportModeFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131231031;

  public SelectTransportModeFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    view = finder.findRequiredView(source, R.id.tv_left, "field 'mTvLeft' and method 'onViewClicked'");
    target.mTvLeft = finder.castView(view, R.id.tv_left, "field 'mTvLeft'", TextView.class);
    view2131231017 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvHeader = finder.findRequiredViewAsType(source, R.id.tv_header, "field 'mTvHeader'", TextView.class);
    target.mEtSearch = finder.findRequiredViewAsType(source, R.id.et_search, "field 'mEtSearch'", EditText.class);
    target.mTvCountry = finder.findRequiredViewAsType(source, R.id.tv_country, "field 'mTvCountry'", TextView.class);
    target.mTvCity = finder.findRequiredViewAsType(source, R.id.tv_city, "field 'mTvCity'", TextView.class);
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    target.mQuickView = finder.findRequiredViewAsType(source, R.id.quick_view, "field 'mQuickView'", QuickSearchView.class);
    view = finder.findRequiredView(source, R.id.tv_right, "field 'mTvRight' and method 'onViewClicked'");
    target.mTvRight = finder.castView(view, R.id.tv_right, "field 'mTvRight'", TextView.class);
    view2131231031 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvLeft = null;
    target.mTvHeader = null;
    target.mEtSearch = null;
    target.mTvCountry = null;
    target.mTvCity = null;
    target.mRecycleView = null;
    target.mQuickView = null;
    target.mTvRight = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131231031.setOnClickListener(null);
    view2131231031 = null;

    this.target = null;
  }
}
