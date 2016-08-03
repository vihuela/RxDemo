package worldgo.rxoperator.operators.transform;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class GroupBy extends BaseOperate<Object> {
    @Override
    protected void invoke() {

        Observable.range(1, 100).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                //分组条件
                return integer % 2 == 0 ? 1 : -1;
            }
        }).subscribe(new Action1<GroupedObservable<Integer, Integer>>() {
            @Override
            public void call(GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                //仅筛选偶数
                if (integerIntegerGroupedObservable.getKey() == 1)
                    integerIntegerGroupedObservable.subscribe(action1);
            }
        });

    }
}
