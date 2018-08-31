package androidbuffer.com.musicbeats.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.model.MusicModel;

/**
 * Created by incred-dev on 4/7/18.
 */

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.MyViewHolder> {

    private List<MusicModel> musicModelList;

    public MusicListAdapter(List<MusicModel> musicModelList) {
        this.musicModelList = musicModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music_list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MusicModel model = musicModelList.get(position);
        if (model != null){
//            Glide.with(holder.imageView.getContext()).load(model.getImgUrl()).into(holder.imageView);
            holder.tvSongName.setText(model.getSongName());
        }
    }

    @Override
    public int getItemCount() {
        Log.d("tag","size is"+musicModelList.size());
        return musicModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvSongName, playBtn;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivMusicPic);
            tvSongName = itemView.findViewById(R.id.tvTitle);
            playBtn = itemView.findViewById(R.id.tvPlayButton);
        }
    }
}
