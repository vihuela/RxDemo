package worldgo.rxoperator.operators.creater;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
@SuppressWarnings("all")
public class Interval extends BaseOperate<Object> {

    private int i = 0;

    @Override
    protected void invoke() {
        //创建一个按固定时间间隔发射整数序列的Observable
        Observable.interval(2, 1, TimeUnit.SECONDS).subscribe(subscriber);
    }
}
