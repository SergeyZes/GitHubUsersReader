package zesley.sergey.githubusersreader.Presenters;

import android.os.Bundle;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import zesley.sergey.githubusersreader.Fragments.AllUsersFragment;
import zesley.sergey.githubusersreader.Fragments.OneUserFragment;
import zesley.sergey.githubusersreader.MainActivityView;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {
    private static final String TAG = "MainActivityPresenter";
    public AllUsersFragment allUsersFragment;
    public OneUserFragment oneUserFragment;

    public MainActivityPresenter() {
        allUsersFragment = new AllUsersFragment();
        allUsersFragment.setAcivityPresenter(this);
        oneUserFragment = new OneUserFragment();


        getViewState().showFragment(allUsersFragment);
        Log.i(TAG,"MainActivityPresenter");
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
        getViewState().showUser(index,name,oneUserFragment);
    }

    public void showAllUsersFragment(){
        getViewState().showFragment(allUsersFragment);

    }


}
