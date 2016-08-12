package worldgo.rxoperator.operators.transform;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class SwitchMap extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //当原始Observable发射 一个新的数据（Observable）时，它将取消订阅并停止监视产生执之前那个数据的 Observable，只监视当前这一个。
        //就是取消上一个请求
        Observable.just(1, 2, 3, 4, 5).switchMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                return Observable.just(integer).subscribeOn(Schedulers.newThread());
            }
        }).subscribe(subscriber);
    }
}
