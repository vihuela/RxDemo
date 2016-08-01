package worldgo.rxoperator.ui;

import android.os.Bundle;

import java.util.List;

import worldgo.rxoperator.model.Catalog;
import worldgo.rxoperator.utils.DataEngine;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class MainFrg extends BaseFragment<Catalog> {

    @Override
    protected void itemClick(int pos) {
        Bundle bundle = new Bundle();
        bundle.putInt("index", pos);
        hostActivity.addFragment(new SubFrg(), bundle);
    }

    @Override
    protected List<Catalog> getList() {
        return DataEngine.getCataLogs();
    }

}
