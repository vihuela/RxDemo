package worldgo.rxoperator.operators.filter;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class Last extends BaseOperate<Object> {
    @Override
    protected void invoke() {

        //逻辑和First一致。。
        Observable.range(1, 100, Schedulers.newThread()).last().subscribe(subscriber);
    }
}
