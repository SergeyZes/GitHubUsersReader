package zesley.sergey.githubusersreader;

import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import zesley.sergey.githubusersreader.Fragments.OneUserFragment;

public interface MainActivityView extends MvpView {
    @StateStrategyType(SingleStateStrategy .class)
    void showFragment(Fragment fragment);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideMessage();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showMessage();

    @StateStrategyType(SingleStateStrategy .class)
    void showUser(int index, String name, OneUserFragment fragment);


}
