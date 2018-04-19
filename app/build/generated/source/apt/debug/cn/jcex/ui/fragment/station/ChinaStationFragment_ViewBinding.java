// Generated code from Butter Knife. Do not modify!
package cn.jcex.ui.fragment.station;

import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import cn.jcex.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ChinaStationFragment_ViewBinding<T extends ChinaStationFragment> implements Unbinder {
  protected T target;

  public ChinaStationFragment_ViewBinding(T target, Finder finder, Object source) {
    this.target = target;

    target.mRecycleView = finder.findRequiredViewAsType(source, R.id.recycleView, "field 'mRecycleView'", RecyclerView.class);
    target.mSmartRefreshLayout = finder.findRequiredViewAsType(source, R.id.smart_refresh_layout, "field 'mSmartRefreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mRecycleView = null;
    target.mSmartRefreshLayout = null;

    this.target = null;
  }
}
