package worldgo.rxoperator.operators.filter;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class DistinctUntilChanged extends BaseOperate<Integer> {
    @Override
    protected void invoke() {
        Observable.just(1, 2, 1, 2, 1, 4, 5, 6, 10).distinctUntilChanged().subscribe(subscriber);
    }
}
