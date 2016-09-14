package worldgo.rxoperator.operators.combination;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/12.
 */
public class Merge extends BaseOperate<Integer> {
    @Override
    protected void invoke() {
        //合并
        Observable.merge(Observable.just(1,2),Observable.just(3,4)).subscribe(subscriber);
    }
}
