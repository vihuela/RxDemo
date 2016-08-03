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
import worldgo.rxoperator.operators.transform.Buffer;
import worldgo.rxoperator.operators.transform.ConcatMap;
import worldgo.rxoperator.operators.transform.FlatMap;
import worldgo.rxoperator.operators.transform.FlatMapIterable;
import worldgo.rxoperator.operators.transform.GroupBy;
import worldgo.rxoperator.operators.transform.Map;
import worldgo.rxoperator.operators.transform.SwitchMap;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class DataEngine {
    /**
     * Rxjava中， subscribeOn及observeOn方法切换线程发生的位置为什么设计为不同的？
     * <p/>
     * <p/>
     * 我的理解是subscribeOn是影响生产者（Observable）生产数据的线程的，
     * 通常我们只需要指定生产者在某一个特定的线程生产数据就可以满足我们的需求，
     * 至少我还没遇到过需要在生产数据的过程中去切换生产者所在的线程的情况。
     * 绝大多数我们需要变化线程的场景都是在数据生产之后，Rx里面就使用observeOn来指定各种operator和subcriber的线程，
     * 因为这些本质上都是数据的消费者。消费者可以任意切换自己接受处理数据的线程，足以满足我们的需求。
     * <p/>
     * 链接：http://www.zhihu.com/question/41779170/answer/92412570
     * <p/>
     * 总结：  subscribe生产中仅需一次，observeOn消费者可能会多次
     */
    public static List<Catalog> getCataLogs() {
        List<Catalog> subCatalogs = new ArrayList<>();
        subCatalogs.add(getCreate());
        subCatalogs.add(getTransForm());
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

    /**
     * 变换操作
     */
    private static Catalog getTransForm() {
        List<Catalog.SubCatalog> catalogList = new ArrayList<>();
        Collections.addAll(catalogList,
                new Catalog.SubCatalog("Buffer", new Event(Buffer.class, "invoke", null)),
                new Catalog.SubCatalog("FlatMap", new Event(FlatMap.class, "invoke", null)),
                new Catalog.SubCatalog("FlatMapIterable", new Event(FlatMapIterable.class, "invoke", null)),
                new Catalog.SubCatalog("ConcatMap", new Event(ConcatMap.class, "invoke", null)),
                new Catalog.SubCatalog("SwitchMap", new Event(SwitchMap.class, "invoke", null)),
                new Catalog.SubCatalog("GroupBy", new Event(GroupBy.class, "invoke", null)),
                new Catalog.SubCatalog("Map", new Event(Map.class, "invoke", null)),
                new Catalog.SubCatalog("Scan", new Event(Throw.class, "invoke", null)),
                new Catalog.SubCatalog("Window", new Event(Interval.class, "invoke", null))
        );
        return new Catalog("变换操作", catalogList);
    }
}
