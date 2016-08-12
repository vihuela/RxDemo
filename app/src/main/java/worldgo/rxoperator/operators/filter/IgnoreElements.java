package worldgo.rxoperator.operators.filter;

import rx.Observable;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class IgnoreElements extends BaseOperate<Integer> {

    @Override
    protected void invoke() {

        Observable.range(1, 100, Schedulers.newThread()).ignoreElements().subscribe(subscriber);
    }
}
