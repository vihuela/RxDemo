package worldgo.rxoperator.operators.creater;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Range extends BaseOperate<Integer> {

    @Override
    protected void invoke() {
        //创建一个发射特定整数序列的Observable,n,n+1....,n+m-1
        Observable.range(100, 250).subscribe(subscriber);
    }
}
