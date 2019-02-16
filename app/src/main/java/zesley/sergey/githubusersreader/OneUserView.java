package zesley.sergey.githubusersreader;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface OneUserView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void showUserData(String id,String name,String avatar);

}
