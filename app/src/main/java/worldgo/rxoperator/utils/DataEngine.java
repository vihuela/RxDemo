package worldgo.rxoperator.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import worldgo.rxoperator.model.Catalog;
import worldgo.rxoperator.operators.creater.Create;
import worldgo.rxoperator.operators.creater.Defer;
import worldgo.rxoperator.operators.creater.Empty;
import worldgo.rxoperator.operators.creater.Interval;
import worldgo.rxoperator.operators.creater.Just;
import worldgo.rxoperator.operators.creater.Never;
import worldgo.rxoperator.operators.creater.Range;
import worldgo.rxoperator.operators.creater.Repeat;
import worldgo.rxoperator.operators.creater.Start;
import worldgo.rxoperator.operators.creater.Throw;
import worldgo.rxoperator.operators.creater.Timer;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class DataEngine {
    public static List<Catalog> getCataLogs() {
        List<Catalog> subCatalogs = new ArrayList<>();
        subCatalogs.add(getCreate());
        return subCatalogs;
    }

    /**
     * 创建操作
     */
    private static Catalog getCreate() {
        List<Catalog.SubCatalog> catalogList = new ArrayList<>();
        Collections.addAll(catalogList,
                new Catalog.SubCatalog("Create", new Event(Create.class, "invoke", null)),
                new Catalog.SubCatalog("Defer", new Event(Defer.class, "invoke", null)),
                new Catalog.SubCatalog("Empty", new Event(Empty.class, "invoke", null)),
                new Catalog.SubCatalog("Never", new Event(Never.class, "invoke", null)),
                new Catalog.SubCatalog("Error", new Event(Throw.class, "invoke", null)),
                new Catalog.SubCatalog("Interval", new Event(Interval.class, "invoke", null)),
                new Catalog.SubCatalog("Just", new Event(Just.class, "invoke", null)),
                new Catalog.SubCatalog("Range", new Event(Range.class, "invoke", null)),
                new Catalog.SubCatalog("Repeat", new Event(Repeat.class, "invoke", null)),
                new Catalog.SubCatalog("Start(Todo)", new Event(Start.class, "invoke", null)),
                new Catalog.SubCatalog("Timer", new Event(Timer.class, "invoke", null))
        );
        return new Catalog("创建操作", catalogList);
    }
}
