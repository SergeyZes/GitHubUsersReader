package zesley.sergey.githubusersreader.Detailed;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import zesley.sergey.githubusersreader.R;

public class AllUsersAdapter extends RecyclerView.Adapter<AllUsersAdapter.ViewHolder> {
    private final List<OneUser> allUsers;
    private final OnUserClickListener listener;

    public AllUsersAdapter(List<OneUser> allUsers, OnUserClickListener listener) {
        this.allUsers = allUsers;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String userName = allUsers.get(i).getName();
        viewHolder.userLabel.setText(userName);
        viewHolder.itemView.setOnClickListener(v -> listener.onClick(i, userName));
    }

    @Override
    public int getItemCount() {
        return allUsers.size();
    }


    public interface OnUserClickListener {
        void onClick(int index, String name);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userLabel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userLabel = itemView.findViewById(R.id.one_user_label);
        }
    }
}
