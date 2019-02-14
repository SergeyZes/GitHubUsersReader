package zesley.sergey.githubusersreader;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import zesley.sergey.githubusersreader.Detailed.OneUser;

public interface AllUsersView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showAllUsers(List<OneUser> usrs);

}
