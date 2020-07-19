package kr.angelhackseoul.guardiansofsprout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class StoreListAdapter extends ArrayAdapter<StoreA> {

    Context context;
    ArrayList<StoreA> list;

    public StoreListAdapter(@NonNull Context context, int resource,ArrayList<StoreA> list) {
        super(context, resource);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item, null, true);
        StoreA store = list.get(position);
        Log.d("jj",store.getStore().getName());
        TextView name = (TextView) convertView.findViewById(R.id.listStoreName);
        TextView distance = (TextView) convertView.findViewById(R.id.listStoreDist);
        TextView address = (TextView) convertView.findViewById(R.id.listStoreAddr);
        name.setText(store.getStore().getName());
        distance.setText(store.getDistance()+"");

        address.setText(store.getStore().getAddress());
//        Log.d("adaptercall", position + "");
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(R.layout.list_item, null, true);
//        Store store = list.get(position);
//        TextView distance = (TextView) convertView.findViewById(R.id.list_distance);
//        distance.setText(((int) catcher.getDistance()) + "m");
//        TextView name = (TextView) convertView.findViewById(R.id.list_name);
//        name.setText(catcher.getName());
//        TextView score = (TextView) convertView.findViewById(R.id.list_score);
//        score.setText(catcher.getScore() + "");
//        TextView count = (TextView) convertView.findViewById(R.id.list_scoreCount);
//        count.setText("(" + catcher.getReviewcount() + ")");
//        RatingBar ratingBar = convertView.findViewById(R.id.list_star);
//        ratingBar.setRating(catcher.getScore());
        return convertView;

//        return super.getView(position, convertView, parent);
    }
}
