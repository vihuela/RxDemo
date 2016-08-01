package worldgo.rxoperator.operators.creater;

import rx.Observable;
import rx.Subscriber;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 *
 * 创建
 */
public class Create extends BaseOperate<String> {

    public void invoke() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("next");
            }
        }).subscribe(subscriber);
    }
}
