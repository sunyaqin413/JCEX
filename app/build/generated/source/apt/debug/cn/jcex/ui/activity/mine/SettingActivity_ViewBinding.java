// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.activity.mine;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import cn.jcex.view.CheckSwitchButton;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SettingActivity_ViewBinding<T extends SettingActivity> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131230920;

  private View view2131230939;

  private View view2131230935;

  private View view2131230768;

  public SettingActivity_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mChkBtnSettingSound = finder.findRequiredViewAsType(source, R.id.chkBtn_setting_sound, "field 'mChkBtnSettingSound'", CheckSwitchButton.class);
    target.mChkBtnSettingVibration = finder.findRequiredViewAsType(source, R.id.chkBtn_setting_vibration, "field 'mChkBtnSettingVibration'", CheckSwitchButton.class);
    target.mRlSettingVibration = finder.findRequiredViewAsType(source, R.id.rl_setting_vibration, "field 'mRlSettingVibration'", RelativeLayout.class);
    view = finder.findRequiredView(source, R.id.rl_feedback, "field 'mRlFeedback' and method 'onViewClicked'");
    target.mRlFeedback = finder.castView(view, R.id.rl_feedback, "field 'mRlFeedback'", RelativeLayout.class);
    view2131230920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_version, "field 'mRlVersion' and method 'onViewClicked'");
    target.mRlVersion = finder.castView(view, R.id.rl_version, "field 'mRlVersion'", RelativeLayout.class);
    view2131230939 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_setting_about, "field 'mRlSettingAbout' and method 'onViewClicked'");
    target.mRlSettingAbout = finder.castView(view, R.id.rl_setting_about, "field 'mRlSettingAbout'", RelativeLayout.class);
    view2131230935 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.btn_setting_logout, "field 'mBtnSettingLogout' and method 'onViewClicked'");
    target.mBtnSettingLogout = finder.castView(view, R.id.btn_setting_logout, "field 'mBtnSettingLogout'", Button.class);
    view2131230768 = view;
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
    target.mChkBtnSettingSound = null;
    target.mChkBtnSettingVibration = null;
    target.mRlSettingVibration = null;
    target.mRlFeedback = null;
    target.mRlVersion = null;
    target.mRlSettingAbout = null;
    target.mBtnSettingLogout = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131230920.setOnClickListener(null);
    view2131230920 = null;
    view2131230939.setOnClickListener(null);
    view2131230939 = null;
    view2131230935.setOnClickListener(null);
    view2131230935 = null;
    view2131230768.setOnClickListener(null);
    view2131230768 = null;

    this.target = null;
  }
}
