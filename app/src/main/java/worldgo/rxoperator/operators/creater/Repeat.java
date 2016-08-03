package worldgo.rxoperator.operators.creater;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Repeat extends BaseOperate<Integer> {

    @Override
    protected void invoke() {
        //创建一个发射特定数据重复多次的Observable,需要onCompleted触发
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onCompleted();
            }
        })
               /* .repeat(3)*///onCompleted之前的流程走3遍
                .repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {//有条件的重新订阅和发射原来的Observable
                    @Override
                    public Observable<?> call(Observable<? extends Void> observable) {
                        return Observable.timer(2, TimeUnit.SECONDS);
                    }
                }).subscribe(subscriber);
    }
}
