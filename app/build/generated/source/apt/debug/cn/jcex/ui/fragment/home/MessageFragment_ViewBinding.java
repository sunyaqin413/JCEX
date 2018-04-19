// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MessageFragment_ViewBinding<T extends MessageFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  public MessageFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
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
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mRecycleView = null;
    target.mTvLeft = null;
    target.mTvHeader = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;

    this.target = null;
  }
}
