package zesley.sergey.githubusersreader.Presenters;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zesley.sergey.githubusersreader.GithubUser;
import zesley.sergey.githubusersreader.NetApiClient;
import zesley.sergey.githubusersreader.OneUserView;

@InjectViewState
public class OneUserPresenter extends MvpPresenter<OneUserView> implements Observer<GithubUser> {
    private final static String TAG = "OneUserPresenter";

    public void showUser(int index, String name) {
        NetApiClient.getInstance().getUser(name).subscribe(this);

    }

    @Override
    public void attachView(OneUserView view) {
        super.attachView(view);
    }

    public OneUserPresenter() {
        Log.i(TAG,"constructor");
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(GithubUser githubUser) {
        getViewState().showUserData(githubUser.getId(),githubUser.getLogin(),githubUser.getAvatar(),githubUser.getHtml_url());
    }

    @Override
    public void onError(Throwable e) {
        getViewState().showUserData("",e.getMessage(),"404","");
    }

    @Override
    public void onComplete() {
        Log.i(TAG,"onComplete");

    }
}
