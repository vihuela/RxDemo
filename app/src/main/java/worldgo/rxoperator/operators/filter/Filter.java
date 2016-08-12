package worldgo.rxoperator.operators.filter;

import rx.Observable;
import rx.functions.Func1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class Filter extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        Observable.just(1, 2, 3).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 1;//过滤条件
            }
        }).subscribe(subscriber);
    }
}
