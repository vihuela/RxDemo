package worldgo.rxoperator.operators.combination;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func4;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/12.
 */
public class CombineLatest extends BaseOperate<Boolean> {
    @Override
    protected void invoke() {
        // CombineLatest 集合最近若干个节点
        Observable.combineLatest(
                Observable.create(new Observable.OnSubscribe<Integer>() {//1个
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(1);
                    }
                }),
                Observable.create(new Observable.OnSubscribe<Integer>() {//1个
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(2);
                    }
                }),
                Observable.create(new Observable.OnSubscribe<Integer>() {//1个
                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        subscriber.onNext(3);
                    }
                }),
                Observable.just(10, 20), //2个
                new Func4<Integer, Integer, Integer, Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer, Integer integer2, Integer integer3, Integer integer4) {
                        System.out.println(integer + " " + integer2 + " " + integer3 + " " + integer4);
                        return integer + integer2 + integer3 + integer4 > 10;
                    }
                }
        ).subscribe(subscriber);
    }
}
