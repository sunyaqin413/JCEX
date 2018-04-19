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
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SearchFragment_ViewBinding<T extends SearchFragment> implements Unbinder {
  protected T target;

  private View view2131231011;

  public SearchFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mEtSearch = finder.findRequiredViewAsType(source, R.id.et_search, "field 'mEtSearch'", EditText.class);
    view = finder.findRequiredView(source, R.id.tv_cancel, "field 'mTvCancel' and method 'onViewClicked'");
    target.mTvCancel = finder.castView(view, R.id.tv_cancel, "field 'mTvCancel'", TextView.class);
    view2131231011 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mEtSearch = null;
    target.mTvCancel = null;
    target.mRecycleView = null;

    view2131231011.setOnClickListener(null);
    view2131231011 = null;

    this.target = null;
  }
}
