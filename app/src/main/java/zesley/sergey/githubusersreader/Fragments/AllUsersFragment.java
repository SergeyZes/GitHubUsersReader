package zesley.sergey.githubusersreader.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;

import java.util.List;

import zesley.sergey.githubusersreader.Detailed.AllUsersAdapter;
import zesley.sergey.githubusersreader.Detailed.OneUser;
import zesley.sergey.githubusersreader.Presenters.AllUsersPresenter;
import zesley.sergey.githubusersreader.Presenters.MainActivityPresenter;
import zesley.sergey.githubusersreader.R;
import zesley.sergey.githubusersreader.AllUsersView;


public class AllUsersFragment extends MvpAppCompatFragment implements AllUsersView,AllUsersAdapter.OnUserClickListener {
    private static final String TAG="AllUsersPresenter";

    private RecyclerView allUsersList;

    @InjectPresenter(type = PresenterType.GLOBAL)
    AllUsersPresenter presenter;

    private MainActivityPresenter mMainActivityPresenter;
    public void setAcivityPresenter(MainActivityPresenter mMainActivityPresenter){
        this.mMainActivityPresenter=mMainActivityPresenter;
    }

    public AllUsersFragment() {
        // Required empty public constructor
        setRetainInstance(true);
        Log.i(TAG,"AllUsersFragment");
    }

    public void addNewUser(String usr){
        presenter.addNewUser(usr);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_users, container, false);
        allUsersList = view.findViewById(R.id.fragment_all_user_list);
        allUsersList.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    @Override
    public void showAllUsers(List<OneUser> usrs) {
        allUsersList.setAdapter(new AllUsersAdapter(usrs,this));
    }

    @Override
    public void showUser(int index, String name) {
        mMainActivityPresenter.showUser(index,name);
    }

    @Override
    public void onClick(int index, String name) {
       showUser(index,name);
        //presenter.showUser(index,name);
    }
}
