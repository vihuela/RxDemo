package worldgo.rxoperator.operators.filter;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class Skip extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //忽略3个
        Observable.just("1", 2, 3, 4, 5).skip(3).subscribe(subscriber);//skipLast同理
    }
}
