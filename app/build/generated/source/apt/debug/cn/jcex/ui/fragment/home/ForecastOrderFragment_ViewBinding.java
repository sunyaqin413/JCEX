// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.home;

import android.support.v7.widget.RecyclerView;
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

public class ForecastOrderFragment_ViewBinding<T extends ForecastOrderFragment> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131231031;

  private View view2131230928;

  private View view2131230930;

  private View view2131230931;

  private View view2131231008;

  private View view2131230769;

  private View view2131230767;

  public ForecastOrderFragment_ViewBinding(final T target, Finder finder, Object source) {
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
    view = finder.findRequiredView(source, R.id.tv_right, "field 'mTvRight' and method 'onViewClicked'");
    target.mTvRight = finder.castView(view, R.id.tv_right, "field 'mTvRight'", TextView.class);
    view2131231031 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mIvTopScan = finder.findRequiredViewAsType(source, R.id.iv_top_scan, "field 'mIvTopScan'", ImageView.class);
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
    target.mTvTransportMode = finder.findRequiredViewAsType(source, R.id.tv_transport_mode, "field 'mTvTransportMode'", TextView.class);
    view = finder.findRequiredView(source, R.id.rl_select_transport_mode, "field 'mRlSelectTransportMode' and method 'onViewClicked'");
    target.mRlSelectTransportMode = finder.castView(view, R.id.rl_select_transport_mode, "field 'mRlSelectTransportMode'", RelativeLayout.class);
    view2131230930 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvWeight = finder.findRequiredViewAsType(source, R.id.tv_weight, "field 'mTvWeight'", EditText.class);
    target.mTextView = finder.findRequiredViewAsType(source, R.id.textView, "field 'mTextView'", TextView.class);
    target.mTvVolume = finder.findRequiredViewAsType(source, R.id.tv_volume, "field 'mTvVolume'", EditText.class);
    target.mTvOrderId = finder.findRequiredViewAsType(source, R.id.tv_order_id, "field 'mTvOrderId'", EditText.class);
    view = finder.findRequiredView(source, R.id.rl_select_type, "field 'mRlSelectType' and method 'onViewClicked'");
    target.mRlSelectType = finder.castView(view, R.id.rl_select_type, "field 'mRlSelectType'", RelativeLayout.class);
    view2131230931 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mTvType = finder.findRequiredViewAsType(source, R.id.tv_type, "field 'mTvType'", TextView.class);
    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    target.mTvName = finder.findRequiredViewAsType(source, R.id.tv_name, "field 'mTvName'", EditText.class);
    target.mTvCount = finder.findRequiredViewAsType(source, R.id.tv_count, "field 'mTvCount'", EditText.class);
    target.mEtPrice = finder.findRequiredViewAsType(source, R.id.et_price, "field 'mEtPrice'", EditText.class);
    view = finder.findRequiredView(source, R.id.tv_add_info, "field 'mTvAddInfo' and method 'onViewClicked'");
    target.mTvAddInfo = finder.castView(view, R.id.tv_add_info, "field 'mTvAddInfo'", TextView.class);
    view2131231008 = view;
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
    view = finder.findRequiredView(source, R.id.btn_save, "field 'mBtnSave' and method 'onViewClicked'");
    target.mBtnSave = finder.castView(view, R.id.btn_save, "field 'mBtnSave'", Button.class);
    view2131230767 = view;
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
    target.mTvRight = null;
    target.mIvTopScan = null;
    target.mTvDestination = null;
    target.mRlSelectDestination = null;
    target.mTvTransportMode = null;
    target.mRlSelectTransportMode = null;
    target.mTvWeight = null;
    target.mTextView = null;
    target.mTvVolume = null;
    target.mTvOrderId = null;
    target.mRlSelectType = null;
    target.mTvType = null;
    target.mRecycleView = null;
    target.mTvName = null;
    target.mTvCount = null;
    target.mEtPrice = null;
    target.mTvAddInfo = null;
    target.mBtnSubmit = null;
    target.mBtnSave = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131231031.setOnClickListener(null);
    view2131231031 = null;
    view2131230928.setOnClickListener(null);
    view2131230928 = null;
    view2131230930.setOnClickListener(null);
    view2131230930 = null;
    view2131230931.setOnClickListener(null);
    view2131230931 = null;
    view2131231008.setOnClickListener(null);
    view2131231008 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;
    view2131230767.setOnClickListener(null);
    view2131230767 = null;

    this.target = null;
  }
}
