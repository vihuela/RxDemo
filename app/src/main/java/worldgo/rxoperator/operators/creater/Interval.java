package worldgo.rxoperator.operators.creater;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Interval extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //创建一个按固定时间间隔发射整数序列的Observable
        Observable.interval(500, 100, TimeUnit.MILLISECONDS).subscribe(subscriber);
    }
}
