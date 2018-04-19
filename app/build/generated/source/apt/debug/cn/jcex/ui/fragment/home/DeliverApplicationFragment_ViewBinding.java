// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

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

public class DeliverApplicationFragment_ViewBinding<T extends DeliverApplicationFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131230925;

  private View view2131230929;

  private View view2131230769;

  public DeliverApplicationFragment_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mTextView = finder.findRequiredViewAsType(source, R.id.textView, "field 'mTextView'", TextView.class);
    target.mTvAddress = finder.findRequiredViewAsType(source, R.id.tv_address, "field 'mTvAddress'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_address, "field 'mRlSelectAddress' and method 'onViewClicked'");
    target.mRlSelectAddress = finder.castView(view, R.id.rl_select_address, "field 'mRlSelectAddress'", RelativeLayout.class);
    view2131230925 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mEtBags = finder.findRequiredViewAsType(source, R.id.et_bags, "field 'mEtBags'", EditText.class);
    target.mEtWeight = finder.findRequiredViewAsType(source, R.id.et_weight, "field 'mEtWeight'", EditText.class);
    target.mTvTime = finder.findRequiredViewAsType(source, R.id.tv_time, "field 'mTvTime'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_time, "field 'mRlSelectTime' and method 'onViewClicked'");
    target.mRlSelectTime = finder.castView(view, R.id.rl_select_time, "field 'mRlSelectTime'", RelativeLayout.class);
    view2131230929 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.btn_submit, "field 'mBtnSubmit' and method 'onViewClicked'");
    target.mBtnSubmit = finder.castView(view, R.id.btn_submit, "field 'mBtnSubmit'", Button.class);
    view2131230769 = view;
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
    target.mTextView = null;
    target.mTvAddress = null;
    target.mRlSelectAddress = null;
    target.mEtBags = null;
    target.mEtWeight = null;
    target.mTvTime = null;
    target.mRlSelectTime = null;
    target.mBtnSubmit = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131230925.setOnClickListener(null);
    view2131230925 = null;
    view2131230929.setOnClickListener(null);
    view2131230929 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;

    this.target = null;
  }
}
