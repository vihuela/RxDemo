package worldgo.rxoperator.operators.transform;

import android.os.SystemClock;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class ConcatMap extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //与FlatMap一致，只是输出按照顺序
        Observable.just(2, 1).concatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(final Integer integer) {
                return Observable.create(new Observable.OnSubscribe<Integer>() {
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        Log.d("ConcatMap", "------>thread:" + Thread.currentThread().getName());
                        SystemClock.sleep(TimeUnit.SECONDS.toMillis(integer));
                        subscriber.onNext(integer);
                        subscriber.onCompleted();
                    }
                }).subscribeOn(Schedulers.newThread());
            }
        }).subscribe(subscriber);
    }
}
