package worldgo.rxoperator.operators.combination;

import rx.Observable;
import rx.functions.Func2;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/12.
 */
public class Zip extends BaseOperate<Boolean> {
    @Override
    protected void invoke() {
        Observable.zip(Observable.just(1, 2), Observable.just(3, 10), new Func2<Integer, Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer, Integer integer2) {
                //1 3
                //2 10
                return integer + integer2 > 10;
            }
        }).subscribe(subscriber);
    }
}
