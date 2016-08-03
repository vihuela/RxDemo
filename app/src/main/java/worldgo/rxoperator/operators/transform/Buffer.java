package worldgo.rxoperator.operators.transform;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/1.
 */
public class Buffer extends BaseOperate<String> {

    @Override
    protected void invoke() {
        //包裹原始Observable，并修改
        Observable.just("a", "b", "c", "d", "e", "f").buffer(2, 2).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> strings) {
                traversalList(strings);
            }
        });
    }
}
