package androidbuffer.com.musicbeats.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.Util;
import androidbuffer.com.musicbeats.callBack.MusicListCallBack;
import androidbuffer.com.musicbeats.fragment.SearchFragment;
import androidbuffer.com.musicbeats.model.HomeInnerModel;

/**
 * Created by incred-dev on 8/6/18.
 */

public class HomeInnerAdapter extends RecyclerView.Adapter<HomeInnerAdapter.ViewHoldere> {

    private List<HomeInnerModel> homeInnerModelList;
    Context context;
    MusicListCallBack musicListCallBack;

    public HomeInnerAdapter(Context context,List<HomeInnerModel> homeInnerModelList,MusicListCallBack musicListCallBack) {
        this.context = context;
        this.homeInnerModelList = homeInnerModelList;
        this.musicListCallBack = musicListCallBack;
    }

    @Override
    public ViewHoldere onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inner_home, parent, false);
        return new ViewHoldere(view);
    }

    @Override
    public void onBindViewHolder(final ViewHoldere holder, final int position) {
        HomeInnerModel homeInnerModel = homeInnerModelList.get(position);
        if (homeInnerModel != null){
            holder.songName.setText(homeInnerModel.getSongName());
            holder.movieName.setText(homeInnerModel.getSongMovie());
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    musicListCallBack.onClick(holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return homeInnerModelList.size();
    }

    public class ViewHoldere extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView songName, movieName;

        public ViewHoldere(final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivItem);
            songName = itemView.findViewById(R.id.tvSongTitle);
            movieName = itemView.findViewById(R.id.tvSongMovie);

        }
    }
}
