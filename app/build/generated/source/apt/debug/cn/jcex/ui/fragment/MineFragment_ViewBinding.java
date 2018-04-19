// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import cn.jcex.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class MineFragment_ViewBinding<T extends MineFragment> implements Unbinder {
  protected T target;

  private View view2131230853;

  private View view2131230847;

  private View view2131231018;

  private View view2131231029;

  private View view2131230922;

  private View view2131230921;

  private View view2131230938;

  private View view2131230919;

  private View view2131230923;

  private View view2131230918;

  private View view2131230934;

  private View view2131230933;

  private View view2131230924;

  public MineFragment_ViewBinding(final T target, Finder finder, Object source) {
    this.target = target;

    View view;
    view = finder.findRequiredView(source, R.id.iv_set, "field 'mIvSet' and method 'onViewClicked'");
    target.mIvSet = finder.castView(view, R.id.iv_set, "field 'mIvSet'", ImageView.class);
    view2131230853 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.iv_head, "field 'mIvHead' and method 'onViewClicked'");
    target.mIvHead = finder.castView(view, R.id.iv_head, "field 'mIvHead'", ImageView.class);
    view2131230847 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.tv_login, "field 'mTvLogin' and method 'onViewClicked'");
    target.mTvLogin = finder.castView(view, R.id.tv_login, "field 'mTvLogin'", TextView.class);
    view2131231018 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.tv_register, "field 'mTvRegister' and method 'onViewClicked'");
    target.mTvRegister = finder.castView(view, R.id.tv_register, "field 'mTvRegister'", TextView.class);
    view2131231029 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mIvOrder = finder.findRequiredViewAsType(source, R.id.iv_order, "field 'mIvOrder'", ImageView.class);
    target.mSmartRefreshLayout = finder.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'mSmartRefreshLayout'", SmartRefreshLayout.class);
    view = finder.findRequiredView(source, R.id.rl_mine_order, "method 'onViewClicked'");
    view2131230922 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_forecast, "method 'onViewClicked'");
    view2131230921 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_track, "method 'onViewClicked'");
    view2131230938 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_cost, "method 'onViewClicked'");
    view2131230919 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_pick_records, "method 'onViewClicked'");
    view2131230923 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_address, "method 'onViewClicked'");
    view2131230918 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_service_online, "method 'onViewClicked'");
    view2131230934 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_service_line, "method 'onViewClicked'");
    view2131230933 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = finder.findRequiredView(source, R.id.rl_sales_line, "method 'onViewClicked'");
    view2131230924 = view;
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

    target.mIvSet = null;
    target.mIvHead = null;
    target.mTvLogin = null;
    target.mTvRegister = null;
    target.mIvOrder = null;
    target.mSmartRefreshLayout = null;

    view2131230853.setOnClickListener(null);
    view2131230853 = null;
    view2131230847.setOnClickListener(null);
    view2131230847 = null;
    view2131231018.setOnClickListener(null);
    view2131231018 = null;
    view2131231029.setOnClickListener(null);
    view2131231029 = null;
    view2131230922.setOnClickListener(null);
    view2131230922 = null;
    view2131230921.setOnClickListener(null);
    view2131230921 = null;
    view2131230938.setOnClickListener(null);
    view2131230938 = null;
    view2131230919.setOnClickListener(null);
    view2131230919 = null;
    view2131230923.setOnClickListener(null);
    view2131230923 = null;
    view2131230918.setOnClickListener(null);
    view2131230918 = null;
    view2131230934.setOnClickListener(null);
    view2131230934 = null;
    view2131230933.setOnClickListener(null);
    view2131230933 = null;
    view2131230924.setOnClickListener(null);
    view2131230924 = null;

    this.target = null;
  }
}
