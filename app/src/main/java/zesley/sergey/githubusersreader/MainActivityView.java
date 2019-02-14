package zesley.sergey.githubusersreader;

import android.support.v4.app.Fragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainActivityView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showFragment(Fragment fragment);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideMessage();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showMessage();


}
