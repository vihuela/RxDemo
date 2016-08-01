package worldgo.rxoperator.operators.creater;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Throw extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //不发射数据以一个错误终止的Observable
        Observable.error(new Throwable("customer")).subscribe(subscriber);
    }
}
