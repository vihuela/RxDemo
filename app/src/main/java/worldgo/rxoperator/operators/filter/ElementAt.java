package worldgo.rxoperator.operators.filter;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/5.
 */
public class ElementAt extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //返回某个位置
        Observable.just(1,2,3,4).elementAt(2).subscribe(subscriber);
    }
}
