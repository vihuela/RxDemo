package worldgo.rxoperator.operators.transform;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import worldgo.rxoperator.operators.BaseOperate;

/**
 * @author ricky.yao on 2016/8/3.
 */
public class FlatMapIterable extends BaseOperate<Object> {
    @Override
    protected void invoke() {
        Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                List<String> strings = new ArrayList<String>();
                Collections.addAll(strings, "one", "two", "three");
                subscriber.onNext(strings);
            }
        }).flatMapIterable(new Func1<List<String>, Iterable<String>>() {
            @Override
            public Iterable<String> call(List<String> strings) {
                //迭代Observable
                return strings;
            }
        }).filter(new Func1<String, Boolean>() {
            @Override
            public Boolean call(String s) {
                return !TextUtils.isEmpty(s);
            }
        }).map(new Func1<String, String>() {
            @Override
            public String call(String s) {

                return s + "12";
            }
        }).subscribe(action1);
    }
}
