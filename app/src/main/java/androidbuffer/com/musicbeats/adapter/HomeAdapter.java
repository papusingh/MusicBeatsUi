package androidbuffer.com.musicbeats.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.callBack.AlbumCallBack;
import androidbuffer.com.musicbeats.callBack.MusicListCallBack;
import androidbuffer.com.musicbeats.model.HomeModel;


/**
 * Created by incred-dev on 8/6/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private Context mContext;
    private List<HomeModel> homeModelList;
    private AlbumCallBack albumCallBack;

    public HomeAdapter(List<HomeModel> homeModelList, AlbumCallBack albumCallBack) {
        this.homeModelList = homeModelList;
        this.albumCallBack = albumCallBack;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        HomeModel homeModel = homeModelList.get(position);
        if (homeModel != null){
            holder.heading.setText(homeModel.getHeading());
            holder.subHeading.setText(homeModel.getSubHeading());
            HomeInnerAdapter innerAdapter = new HomeInnerAdapter(holder.rvInnerHome.getContext(),homeModel.getHomeInnerModelList(), new MusicListCallBack() {
                @Override
                public void onClick(int innerPosition) {
                    albumCallBack.onClick(innerPosition,position);
                }
            });
            holder.rvInnerHome.setAdapter(innerAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return homeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading, subHeading;
        RecyclerView rvInnerHome;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.tvHeading);
            subHeading = itemView.findViewById(R.id.tvSubHeading);

            rvInnerHome = itemView.findViewById(R.id.rvInnerHomeScreen);
            rvInnerHome.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            rvInnerHome.setHasFixedSize(true);
        }
    }
}
