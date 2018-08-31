package androidbuffer.com.musicbeats.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import androidbuffer.com.musicbeats.activity.MainActivity;
import androidbuffer.com.musicbeats.data.BaseEnum;

/**
 * Created by incred-dev on 7/6/18.
 */

public class MyFragment extends Fragment {

    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    public boolean isLive(){
        return this != null && isAdded() && getActivity() != null;
    }

    public void attachFragment(BaseEnum baseEnum){
        if (!isLive() || !(getActivity() instanceof MainActivity)) return;

        ((MainActivity) getActivity()).attachFragment(baseEnum);
    }

}
