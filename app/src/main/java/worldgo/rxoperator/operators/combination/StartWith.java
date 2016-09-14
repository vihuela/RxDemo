package worldgo.rxoperator.operators.combination;

import rx.Observable;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/12.
 */
public class StartWith extends BaseOperate<Integer> {
    @Override
    protected void invoke() {
        //Observable在发射数据之前先发射一个指定的数据序列
        Observable.just(1,2).startWith(4).subscribe(subscriber);
    }
}
