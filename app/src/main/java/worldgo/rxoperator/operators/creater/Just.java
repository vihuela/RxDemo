package worldgo.rxoperator.operators.creater;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Just extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //创建一个发射指定值的Observable
        Observable.just(1, "2", "3", 4).subscribe(subscriber);
    }
}
