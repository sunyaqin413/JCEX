// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.activity;

import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import cn.jcex.R;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class SplashActivity_ViewBinding<T extends SplashActivity> implements Unbinder {
  protected T target;

  public SplashActivity_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mIvSplash = finder.findRequiredViewAsType(source, R.id.iv_splash, "field 'mIvSplash'", ImageView.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mIvSplash = null;

    this.target = null;
  }
}
