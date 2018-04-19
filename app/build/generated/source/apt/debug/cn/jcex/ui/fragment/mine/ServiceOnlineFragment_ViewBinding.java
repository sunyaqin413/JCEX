// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.mine;

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

public class ServiceOnlineFragment_ViewBinding<T extends ServiceOnlineFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131231033;

  private View view2131231036;

  public ServiceOnlineFragment_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    view = finder.findRequiredView(source, R.id.tv_search, "method 'onViewClicked'");
    view2131231033 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.tv_service_people, "method 'onViewClicked'");
    view2131231036 = view;
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
    target.mRecycleView = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131231033.setOnClickListener(null);
    view2131231033 = null;
    view2131231036.setOnClickListener(null);
    view2131231036 = null;

    this.target = null;
  }
}
