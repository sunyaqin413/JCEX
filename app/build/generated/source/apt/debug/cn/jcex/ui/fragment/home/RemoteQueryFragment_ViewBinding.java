// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class RemoteQueryFragment_ViewBinding<T extends RemoteQueryFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131230926;

  private View view2131230927;

  private View view2131230769;

  public RemoteQueryFragment_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mIvTopScan = finder.findRequiredViewAsType(source, R.id.iv_top_scan, "field 'mIvTopScan'", ImageView.class);
    target.mTvRemoteClass = finder.findRequiredViewAsType(source, R.id.tv_remote_class, "field 'mTvRemoteClass'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_class, "field 'mRlSelectClass' and method 'onViewClicked'");
    target.mRlSelectClass = finder.castView(view, R.id.rl_select_class, "field 'mRlSelectClass'", RelativeLayout.class);
    view2131230926 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvDestination = finder.findRequiredViewAsType(source, R.id.tv_destination, "field 'mTvDestination'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_country, "field 'mRlSelectCountry' and method 'onViewClicked'");
    target.mRlSelectCountry = finder.castView(view, R.id.rl_select_country, "field 'mRlSelectCountry'", RelativeLayout.class);
    view2131230927 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mEtPostcode = finder.findRequiredViewAsType(source, R.id.et_postcode, "field 'mEtPostcode'", EditText.class);
    target.mEtAddress = finder.findRequiredViewAsType(source, R.id.et_address, "field 'mEtAddress'", EditText.class);
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
    target.mIvTopScan = null;
    target.mTvRemoteClass = null;
    target.mRlSelectClass = null;
    target.mTvDestination = null;
    target.mRlSelectCountry = null;
    target.mEtPostcode = null;
    target.mEtAddress = null;
    target.mBtnSubmit = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131230926.setOnClickListener(null);
    view2131230926 = null;
    view2131230927.setOnClickListener(null);
    view2131230927 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;

    this.target = null;
  }
}
