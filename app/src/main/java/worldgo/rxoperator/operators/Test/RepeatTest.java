package worldgo.rxoperator.operators.test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class RepeatTest extends BaseOperate<Object> {
    private int i = 0;
    private Subscriber<Long> subscriber;

    @Override
    protected void invoke() {
        subscriber = new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                if (i > 10) subscriber.unsubscribe();
                else {
                    i++;
                    System.out.println(">>>>>>:" + i);
                }
            }
        };
        Observable.interval(2, 1, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
