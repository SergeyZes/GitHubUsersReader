package zesley.sergey.githubusersreader;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import zesley.sergey.githubusersreader.Detailed.OneUser;

public interface AllUsersView extends MvpView {
    @StateStrategyType(SingleStateStrategy.class)
    void showAllUsers(List<OneUser> usrs);

    @StateStrategyType(SingleStateStrategy.class)
    void showUser(int index, String name);


 }
