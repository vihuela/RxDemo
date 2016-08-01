package worldgo.rxoperator.operators.creater;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Never extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //创建一个不发射数据也不终止的Observable
        Observable.never().subscribe(subscriber);
    }
}
