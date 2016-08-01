package worldgo.rxoperator.ui;

import java.util.List;

import worldgo.rxoperator.model.Catalog;
import worldgo.rxoperator.utils.DataEngine;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class SubFrg extends BaseFragment<Catalog.SubCatalog> {

    @Override
    protected void itemClick(int pos) {
        Catalog.SubCatalog subCatalog = getList().get(pos);
        try {
            subCatalog.event.invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Catalog.SubCatalog> getList() {
        return DataEngine.getCataLogs().get(getArguments().getInt("index")).subCatalog;
    }
}
