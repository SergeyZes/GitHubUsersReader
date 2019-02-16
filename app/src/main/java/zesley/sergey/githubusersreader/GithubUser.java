package zesley.sergey.githubusersreader;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GithubUser {
    private String login = "";

    @SerializedName("avatar_url")
    private String avatar;

    @SerializedName("id")
    @Expose
    private String id;


    @Nullable
    public String getAvatar() {
        return avatar;
    }

    @Nullable
    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }
}
