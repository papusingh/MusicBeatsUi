package androidbuffer.com.musicbeats.model;

import java.util.List;

/**
 * Created by incred-dev on 8/6/18.
 */

public class HomeInnerModel implements BaseModel {

    private String imgUrl;

    private String songName;

    private String songMovie;


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongMovie(String movie) {
        this.songMovie = movie;
    }

    public String getSongMovie() {
        return songMovie;
    }
}
