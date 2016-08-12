package worldgo.rxoperator.operators.filter;

import android.os.SystemClock;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class ThrottleWithTimeOut extends BaseOperate<Integer> {
    private long[] times = new long[]{50, 150};

    @Override
    protected void invoke() {

        Observable.range(1, 100, Schedulers.newThread()).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                long time = times[new SecureRandom().nextInt(2)];
                SystemClock.sleep(time);
                return Observable.just(integer);

            }
        })
                .throttleWithTimeout(100, TimeUnit.MILLISECONDS)//通过时间来限流
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1);
    }
}
