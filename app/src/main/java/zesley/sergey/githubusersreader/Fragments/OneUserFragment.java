package zesley.sergey.githubusersreader.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.squareup.picasso.Picasso;

import zesley.sergey.githubusersreader.OneUserView;
import zesley.sergey.githubusersreader.Presenters.OneUserPresenter;
import zesley.sergey.githubusersreader.R;

public class OneUserFragment extends MvpAppCompatFragment implements OneUserView {

    @InjectPresenter(type = PresenterType.GLOBAL)
    OneUserPresenter presenter2;

    private ImageView userFace;
    private TextView userId;
    private TextView userName;
    private TextView userHtml;

    public OneUserFragment() {
        // Required empty public constructor
        setRetainInstance(true);
    }
    public void showUser(int index, String name) {
        if(presenter2==null){
            this.getMvpDelegate().onCreate();
        }
        presenter2.showUser(index, name);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_user, container, false);
        userFace = view.findViewById(R.id.user_face);
        userId = view.findViewById(R.id.user_id);
        userName = view.findViewById(R.id.user_name);
        userHtml = view.findViewById(R.id.user_html);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showUserData(String id, String name, String avatar, String html) {
        userId.setText(id);
        userName.setText(name);
        userHtml.setText(html);

        if(avatar.equals("404")) userFace.setImageBitmap(null); else Picasso.get().load(avatar).into(userFace);

    }

}
