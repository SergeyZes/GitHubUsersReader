package zesley.sergey.githubusersreader.Presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import zesley.sergey.githubusersreader.Fragments.AllUsersFragment;
import zesley.sergey.githubusersreader.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    private AllUsersFragment allUsersFragment;

    public MainActivityPresenter() {
        allUsersFragment = new AllUsersFragment();
        getViewState().showFragment(allUsersFragment);
    }
    public void onDismissMessage(){
        getViewState().hideMessage();
    }

    public void addNewUser(String usr){
        if (usr==null || usr.isEmpty()) return;
        allUsersFragment.addNewUser(usr);
    }
    public void showMessage(){
        getViewState().showMessage();
    }
}
