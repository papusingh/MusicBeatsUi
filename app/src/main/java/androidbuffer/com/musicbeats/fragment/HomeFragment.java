package androidbuffer.com.musicbeats.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.activity.MusicListActivity;
import androidbuffer.com.musicbeats.adapter.HomeAdapter;
import androidbuffer.com.musicbeats.callBack.AlbumCallBack;
import androidbuffer.com.musicbeats.callBack.GenericCallBack;
import androidbuffer.com.musicbeats.model.HomeInnerModel;
import androidbuffer.com.musicbeats.model.HomeModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by incred-dev on 7/6/18.
 */

public class HomeFragment extends MyFragment implements GenericCallBack{

    @BindView(R.id.rvHomeFull)
    RecyclerView rvHome;

    private HomeAdapter homeAdapter;
    private List<HomeModel> homeModelList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addData();
        initMembers();
    }

    //TODO hard coded data in home model
    private void addData(){
        HomeModel homeModel = new HomeModel();
        for (int j = 0; j < 5; j++){
            HomeInnerModel homeInnerModel = new HomeInnerModel();

            List<HomeInnerModel> homeInnerModelList = new ArrayList<>();

            for (int i = 0; i < 10 ;i++){
                homeInnerModel.setImgUrl("http://kb4images.com/Image/number-102820.html");
                homeInnerModel.setSongName("tere raske k...");
                homeInnerModel.setSongMovie("Parmanu");

                homeInnerModelList.add(homeInnerModel);
            }


            homeModel.setHomeInnerModelList(homeInnerModelList);
            homeModel.setHeading("Remix");
            homeModel.setSubHeading("Popular play lists");

            homeModelList.add(homeModel);
        }

    }

    private void initMembers(){
        homeAdapter = new HomeAdapter(homeModelList,getAlbumListener());
        setRecyclerView();
    }

    //TODO open new Activity here
    private AlbumCallBack getAlbumListener() {
        return new AlbumCallBack() {
            @Override
            public void onClick(int innerPosition, int outerPosition) {
                Toast.makeText(mContext,"The album item "+innerPosition+" is clicked at position "+outerPosition,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MusicListActivity.class);
                startActivity(intent);
            }
        };
    }

    private void setRecyclerView(){
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setHasFixedSize(true);
        rvHome.setAdapter(homeAdapter);
    }

    @Override
    public void onClick(int posittion) {
        Toast.makeText(getActivity(),"Parent at position "+posittion,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInnerClick(int positionParent, int positionChild) {
        Toast.makeText(getActivity(),"Parent at position "+positionParent+"and child at "+positionChild,Toast.LENGTH_SHORT).show();
    }
}
