package worldgo.rxoperator.operators.transform;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class Map extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        Observable.just(1, 2, 3).subscribeOn(AndroidSchedulers.mainThread()).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + Thread.currentThread().getName() + "#update";
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
