package worldgo.rxoperator.operators.transform;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class Map extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        // Map 操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射 这些结果的Observable。
        Observable.just(1, 2, 3).subscribeOn(AndroidSchedulers.mainThread()).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + Thread.currentThread().getName() + "#update";
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
