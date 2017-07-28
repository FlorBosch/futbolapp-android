package ar.com.futbolapp.ui.playerlist;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;
import ar.com.futbolapp.ui.BaseViewHolder;
import butterknife.BindView;

class PlayerListViewAdapter extends RecyclerView.Adapter<PlayerListViewAdapter.ViewHolder> {

    private List<Player> playerList;

    PlayerListViewAdapter(List<Player> players) {
        this.playerList = players;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_player, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBindView(playerList.get(position));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class ViewHolder extends BaseViewHolder<Player> {

        @BindView(R.id.player_name)
        TextView nameView;

        @BindView(R.id.player_profile_picture)
        ImageView profilePicture;

        ViewHolder(View view) {
            super(view);
        }

        @Override
        public void onBindView(Player item) {
            super.onBindView(item);
            nameView.setText(item.getName());
            loadImage(item.getProfilePicture());
        }

        private void loadImage(String url) {
            Glide.with(getContext())
                    .load(url)
                    .placeholder(R.drawable.ic_person)
                    .error(R.drawable.ic_notifications)
                    .into(profilePicture);
        }
    }

}
