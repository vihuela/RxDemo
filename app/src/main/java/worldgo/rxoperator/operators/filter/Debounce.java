package worldgo.rxoperator.operators.filter;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class Debounce extends BaseOperate<Integer> {
    @Override
    protected void invoke() {
        //过滤发射过快的数据
        Observable.range(1, 1000, Schedulers.newThread()).flatMap(new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                //避免发射过快
                return Observable.just(integer).debounce(2, TimeUnit.SECONDS);//throttleWithTimeout类似
            }
        })

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action1);
    }
}
