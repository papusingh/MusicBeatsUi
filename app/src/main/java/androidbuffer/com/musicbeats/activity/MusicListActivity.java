package androidbuffer.com.musicbeats.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.adapter.MusicListAdapter;
import androidbuffer.com.musicbeats.model.MusicModel;

/**
 * Created by incred-dev on 4/7/18.
 */

public class MusicListActivity extends BaseActivity {

    RecyclerView recyclerView;
    private List<MusicModel> musicModelList = new ArrayList<>();
    MusicListAdapter musicListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_music_list);

        recyclerView = findViewById(R.id.rvMusicList);

        addData();
        initAdapter();
    }

    private void addData(){
        for (int i = 0; i < 20; i++){
            MusicModel model = new MusicModel();
            model.setImgUrl("http://kb4images.com/Image/number-102820.html");
            model.setSongName("Tumko dekha to ye khayal aaya");
            musicModelList.add(model);
        }
    }

    private void initAdapter(){
        musicListAdapter = new MusicListAdapter(musicModelList);
        setRecyclerView();
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(musicListAdapter);
    }
}
