package worldgo.rxoperator;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import worldgo.rxoperator.ui.BaseActivity;
import worldgo.rxoperator.ui.MainFrg;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new MainFrg(), null);
    }

    @Override
    protected int getFragmentContentId() {
        return R.id.rootContent;
    }
}
