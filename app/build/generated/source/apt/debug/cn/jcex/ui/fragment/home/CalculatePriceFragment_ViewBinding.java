// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class CalculatePriceFragment_ViewBinding<T extends CalculatePriceFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131230928;

  private View view2131230931;

  private View view2131230769;

  private View view2131230932;

  public CalculatePriceFragment_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mTvDestination = finder.findRequiredViewAsType(source, R.id.tv_destination, "field 'mTvDestination'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_destination, "field 'mRlSelectDestination' and method 'onViewClicked'");
    target.mRlSelectDestination = finder.castView(view, R.id.rl_select_destination, "field 'mRlSelectDestination'", RelativeLayout.class);
    view2131230928 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvWeight = finder.findRequiredViewAsType(source, R.id.tv_weight, "field 'mTvWeight'", EditText.class);
    target.mTextView = finder.findRequiredViewAsType(source, R.id.textView, "field 'mTextView'", TextView.class);
    target.mTvVolume = finder.findRequiredViewAsType(source, R.id.tv_volume, "field 'mTvVolume'", EditText.class);
    target.mTvType = finder.findRequiredViewAsType(source, R.id.tv_type, "field 'mTvType'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_type, "field 'mRlSelectType' and method 'onViewClicked'");
    target.mRlSelectType = finder.castView(view, R.id.rl_select_type, "field 'mRlSelectType'", RelativeLayout.class);
    view2131230931 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    view = finder.findRequiredView(source, R.id.btn_submit, "field 'mBtnSubmit' and method 'onViewClicked'");
    target.mBtnSubmit = finder.castView(view, R.id.btn_submit, "field 'mBtnSubmit'", Button.class);
    view2131230769 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_select_weight, "method 'onViewClicked'");
    view2131230932 = view;
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
    target.mTvDestination = null;
    target.mRlSelectDestination = null;
    target.mTvWeight = null;
    target.mTextView = null;
    target.mTvVolume = null;
    target.mTvType = null;
    target.mRlSelectType = null;
    target.mRecycleView = null;
    target.mBtnSubmit = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131230928.setOnClickListener(null);
    view2131230928 = null;
    view2131230931.setOnClickListener(null);
    view2131230931 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;
    view2131230932.setOnClickListener(null);
    view2131230932 = null;

    this.target = null;
  }
}
