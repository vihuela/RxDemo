package worldgo.rxoperator.operators.filter;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class Take extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //获取前两个...
        Observable.just("1", 2, 3, 4, 5).take(2).subscribe(subscriber);
    }
}
