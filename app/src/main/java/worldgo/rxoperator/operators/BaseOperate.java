package worldgo.rxoperator.operators;

import android.util.Log;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * @author ricky.yao on 2016/7/28.
 */
public abstract class BaseOperate<T extends Object> {
    protected String tag = ">>>>>>>>>" + "请查看" + this.getClass().getSimpleName() + "类";

    protected Subscriber<T> subscriber = new Subscriber<T>() {
        @Override
        public void onCompleted() {
            Log.d(tag, "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(tag, "onError:" + (e != null ? e.getMessage() : "e is null"));
        }

        @Override
        public void onNext(T t) {
            Log.d(tag, "onNext:" + Thread.currentThread().getName() + ":" + t.toString());
        }
    };
    protected Action1<T> action1 = new Action1<T>() {
        @Override
        public void call(T t) {
            Log.d(tag, "call:" + Thread.currentThread().getName() + ":" + t.toString());
        }
    };

    /**
     * 默认反射方法名
     */
    protected abstract void invoke();

    /**
     * 遍历List
     */
    protected void traversalList(List<T> ts) {
        for (T t : ts) {
            Log.d(tag, t.toString());
        }
        Log.d(tag, "------------");
    }

}
