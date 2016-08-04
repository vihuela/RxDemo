package worldgo.rxoperator.operators.creater;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Timer extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //创建一个Observable，它在一个给定的延迟后发射一个特殊的值。
        Observable.timer(2, TimeUnit.SECONDS).subscribe(action1);
    }
}
