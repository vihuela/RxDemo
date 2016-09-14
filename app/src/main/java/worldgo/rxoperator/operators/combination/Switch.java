package worldgo.rxoperator.operators.combination;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/12.
 */
public class Switch extends BaseOperate<String> {
    @Override
    protected void invoke() {
        //每隔2s返回一个Observable，这个Observable每隔1s发射一条数据，在第二个Observable产生之前有4s时间，产生了四条数据。当新的Observable产生时，之前的Observable就被丢弃了
        Observable<Observable<String>> observable = Observable.interval(2, 2, TimeUnit.SECONDS)
                .map(new Func1<Long, Observable<String>>() {
                    @Override
                    public Observable<String> call(Long aLong) {
                        return Observable.interval(1, 1, TimeUnit.SECONDS)
                                .map(new Func1<Long, String>() {
                                    @Override
                                    public String call(Long aLong) {
                                        return aLong + "";
                                    }
                                }).take(4);
                    }
                }).take(4);


        Observable.switchOnNext(observable).subscribe(subscriber);
    }
}
