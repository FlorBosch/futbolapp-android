package ar.com.futbolapp.ui.matchlist;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.ui.BaseViewHolder;
import butterknife.BindView;

class MatchListViewAdapter extends RecyclerView.Adapter<MatchListViewAdapter.ViewHolder> {

    private List<String> matches;

    MatchListViewAdapter(List<String> matches) {
        this.matches = matches;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_match, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBindView(matches.get(position));
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    class ViewHolder extends BaseViewHolder<String> {

        @BindView(R.id.match_name)
        TextView nameView;

        ViewHolder(View view) {
            super(view);
        }

        @Override
        public void onBindView(String item) {
            super.onBindView(item);
            nameView.setText(item);
        }
    }

}
