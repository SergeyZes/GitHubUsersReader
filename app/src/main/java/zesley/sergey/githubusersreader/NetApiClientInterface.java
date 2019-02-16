package zesley.sergey.githubusersreader;

import io.reactivex.Observable;

public interface NetApiClientInterface {
    Observable<GithubUser> getUser(String user);

}
