package worldgo.rxoperator.operators.transform;

import rx.Observable;
import rx.functions.Func2;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/4.
 */
public class Scan extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        //连续地对数据序列的每一项应用一个函数，然后连续发射结果
        Observable.just(0, 1, 2, 3, 4).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer sum, Integer item) {
                return sum + item;
            }
        }).subscribe(action1);
    }
}
