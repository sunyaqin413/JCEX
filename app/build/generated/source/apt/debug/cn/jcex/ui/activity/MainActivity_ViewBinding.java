// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.activity;

import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  public MainActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mFlContainer = finder.findRequiredViewAsType(source, R.id.fl_container, "field 'mFlContainer'", FrameLayout.class);
    target.mRbFragmentHome = finder.findRequiredViewAsType(source, R.id.rb_fragment_home, "field 'mRbFragmentHome'", RadioButton.class);
    target.mRbFragmentJoin = finder.findRequiredViewAsType(source, R.id.rb_fragment_join, "field 'mRbFragmentJoin'", RadioButton.class);
    target.mRbFragmentStation = finder.findRequiredViewAsType(source, R.id.rb_fragment_station, "field 'mRbFragmentStation'", RadioButton.class);
    target.mRbCfragmentMine = finder.findRequiredViewAsType(source, R.id.rb_cfragment_mine, "field 'mRbCfragmentMine'", RadioButton.class);
    target.mRgFragment = finder.findRequiredViewAsType(source, R.id.rg_fragment, "field 'mRgFragment'", RadioGroup.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mFlContainer = null;
    target.mRbFragmentHome = null;
    target.mRbFragmentJoin = null;
    target.mRbFragmentStation = null;
    target.mRbCfragmentMine = null;
    target.mRgFragment = null;

    this.target = null;
  }
}
