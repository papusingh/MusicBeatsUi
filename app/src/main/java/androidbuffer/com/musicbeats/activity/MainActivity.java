package androidbuffer.com.musicbeats.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import androidbuffer.com.musicbeats.R;
import androidbuffer.com.musicbeats.adapter.ViewPagerAdapter;
import androidbuffer.com.musicbeats.data.BaseEnum;
import androidbuffer.com.musicbeats.fragment.HomeFragment;
import androidbuffer.com.musicbeats.fragment.SearchFragment;
import androidbuffer.com.musicbeats.fragment.UploadFragment;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MyFragmentHolderActivity";
    ViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        setViewPager(viewPager);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcon();
    }

    private void setTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.search_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.upload_icon);
    }

    //add fragment to tabs
    private void setViewPager(ViewPager viewPager){
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment(),"");
        viewPagerAdapter.addFragment(new SearchFragment(),"");
        viewPagerAdapter.addFragment(new UploadFragment(),"");
        viewPager.setAdapter(viewPagerAdapter);
    }

    public void attachFragment(BaseEnum baseEnum) {
        Log.d(TAG, "attachFragment not handled in you actiity which extends MyFragmentHolderActivity");
    }
}
