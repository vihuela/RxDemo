package worldgo.rxoperator.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import worldgo.rxoperator.R;
import worldgo.rxoperator.model.BaseModel;

/**
 * @author ricky.yao on 2016/7/28.
 */
public abstract class BaseFragment<T extends BaseModel> extends Fragment {
    protected BaseActivity hostActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        hostActivity = (BaseActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_rv, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.rv);

        BaseQuickAdapter<T> adapter = new BaseQuickAdapter<T>(R.layout.item_tv, getList()) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, T catalog) {
                baseViewHolder.setText(R.id.tv, catalog.title);
            }
        };
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                itemClick(i);
            }
        });
        rv.setAdapter(adapter);
    }

    protected abstract void itemClick(int pos);

    protected abstract List<T> getList();


}
