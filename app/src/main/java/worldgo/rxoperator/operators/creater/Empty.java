package worldgo.rxoperator.operators.creater;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Empty extends BaseOperate<Object> {

    @Override
    protected void invoke() {
        //创建一个不发射任何数据但是正常终止的Observable
        Observable.empty().subscribe(subscriber);
    }
}
