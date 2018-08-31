package androidbuffer.com.musicbeats.model;

/**
 * Created by incred-dev on 3/7/18.
 */

public class MusicModel  implements BaseModel {

    private String imgUrl;

    private String songName;

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
}
