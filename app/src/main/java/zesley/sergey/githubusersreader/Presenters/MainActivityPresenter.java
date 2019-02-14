package zesley.sergey.githubusersreader.Presenters;

import android.os.Bundle;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import zesley.sergey.githubusersreader.Fragments.AllUsersFragment;
import zesley.sergey.githubusersreader.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    private AllUsersFragment allUsersFragment;

    public MainActivityPresenter() {
        allUsersFragment = new AllUsersFragment();
        allUsersFragment.setAcivityPresenter(this);


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

    public void showUser(int index, String name) {
    }


}
