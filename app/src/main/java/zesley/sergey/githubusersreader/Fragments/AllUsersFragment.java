package zesley.sergey.githubusersreader.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zesley.sergey.githubusersreader.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllUsersFragment extends Fragment {


    public AllUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_users, container, false);
        RecyclerView allUsersList = view.findViewById(R.id.fragment_all_user_list);
        allUsersList.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

}
