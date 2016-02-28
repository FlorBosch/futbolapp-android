package ar.com.futbolapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.com.futbolapp.R;
import ar.com.futbolapp.domain.Player;

/**
 * Created by Ignacio on 28/02/2016.
 */
public class BenchRankingAdapter extends ArrayAdapter<Player> {

    private List<Player> players;

    private Context context;

    public BenchRankingAdapter(Context context, int resource, List<Player> objects) {
        super(context, resource, objects);
        this.context = context;
        this.players = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.bench_player_ranking_list_item, parent, false);
        setRowValues(position, rowView);
        return rowView;
    }

    private void setRowValues(int position, View rowView) {
        TextView number = (TextView) rowView.findViewById(R.id.bench_player_ranking_number);
        number.setText(String.valueOf(position));
        TextView name = (TextView) rowView.findViewById(R.id.bench_player_ranking_name);
        name.setText(players.get(position).getName());
        TextView avg = (TextView) rowView.findViewById(R.id.bench_player_ranking_average);
        avg.setText(String.valueOf(players.get(position).getAverage()));
    }
}
