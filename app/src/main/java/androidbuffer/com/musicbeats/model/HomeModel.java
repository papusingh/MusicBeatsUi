package androidbuffer.com.musicbeats.model;

import java.util.List;

/**
 * Created by incred-dev on 8/6/18.
 */

public class HomeModel implements BaseModel {

    private String heading;

    private String subHeading;

    private List<HomeInnerModel> homeInnerModelList;

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }

    public List<HomeInnerModel> getHomeInnerModelList() {
        return homeInnerModelList;
    }

    public void setHomeInnerModelList(List<HomeInnerModel> homeInnerModelList) {
        this.homeInnerModelList = homeInnerModelList;
    }
}
