package worldgo.rxoperator.operators.creater;

import rx.Observable;
import rx.functions.Func0;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 *         <p>
 *
 */
public class Defer extends BaseOperate<Integer> {


    int intOrigin = -1;

    public void invoke() {
        intOrigin = 10;
        //一般用法
        Observable.just(intOrigin).subscribe(action1);
        intOrigin = 20;//值以改变
        //defer,直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable
        Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(intOrigin);
            }
        }).subscribe(action1);
    }

}
