// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.activity.toJoin;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class JoinInUsActivity_ViewBinding<T extends JoinInUsActivity> implements Unbinder {
  protected T target;

  private View view2131231017;

  private View view2131230769;

  public JoinInUsActivity_ViewBinding(final T target, Finder finder, Object source) {
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
    target.mEtName = finder.findRequiredViewAsType(source, R.id.et_name, "field 'mEtName'", EditText.class);
    target.mEtEmail = finder.findRequiredViewAsType(source, R.id.et_email, "field 'mEtEmail'", EditText.class);
    target.mEtAddress = finder.findRequiredViewAsType(source, R.id.et_address, "field 'mEtAddress'", EditText.class);
    target.mEtMoney = finder.findRequiredViewAsType(source, R.id.et_money, "field 'mEtMoney'", EditText.class);
    target.mEtPhone = finder.findRequiredViewAsType(source, R.id.et_phone, "field 'mEtPhone'", EditText.class);
    target.mBtn01 = finder.findRequiredViewAsType(source, R.id.btn_01, "field 'mBtn01'", Button.class);
    target.mBtn02 = finder.findRequiredViewAsType(source, R.id.btn_02, "field 'mBtn02'", Button.class);
    target.mBtn03 = finder.findRequiredViewAsType(source, R.id.btn_03, "field 'mBtn03'", Button.class);
    view = finder.findRequiredView(source, R.id.btn_submit, "field 'mBtnSubmit' and method 'onViewClicked'");
    target.mBtnSubmit = finder.castView(view, R.id.btn_submit, "field 'mBtnSubmit'", Button.class);
    view2131230769 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRgContact = finder.findRequiredViewAsType(source, R.id.rg_contact, "field 'mRgContact'", RadioGroup.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTvLeft = null;
    target.mTvHeader = null;
    target.mEtName = null;
    target.mEtEmail = null;
    target.mEtAddress = null;
    target.mEtMoney = null;
    target.mEtPhone = null;
    target.mBtn01 = null;
    target.mBtn02 = null;
    target.mBtn03 = null;
    target.mBtnSubmit = null;
    target.mRgContact = null;

    view2131231017.setOnClickListener(null);
    view2131231017 = null;
    view2131230769.setOnClickListener(null);
    view2131230769 = null;

    this.target = null;
  }
}
