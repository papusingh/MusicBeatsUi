package androidbuffer.com.musicbeats.callBack;

import android.view.View;

import java.util.List;

import androidbuffer.com.musicbeats.model.HomeInnerModel;

/**
 * Created by incred-dev on 8/6/18.
 */

public interface GenericCallBack {
    void onClick(int posittion);
    void onInnerClick(int positionParent,int positionChild);
}
