package worldgo.rxoperator.operators.transform;

import android.os.SystemClock;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/1.
 */
public class FlatMap extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        // FlatMap 将一个发射数据的Observable变换为多个Observables

        Observable.just(2, 1).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(final Integer integer) {
                return Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Log.d("FlatMap", "------>thread:" + Thread.currentThread().getName());
                        SystemClock.sleep(TimeUnit.SECONDS.toMillis(integer));
                        subscriber.onNext(integer);
                        subscriber.onCompleted();
                    }
                }).subscribeOn(Schedulers.newThread());
            }
        }).subscribe(subscriber);
    }
}
