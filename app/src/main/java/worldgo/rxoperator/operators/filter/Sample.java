package worldgo.rxoperator.operators.filter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class Sample extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //定期发射Observable近发射的数据项
        Observable.range(1, 100000, Schedulers.newThread()).sample(100, TimeUnit.MILLISECONDS).subscribe(subscriber);
    }
}
