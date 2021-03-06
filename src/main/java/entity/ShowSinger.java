package entity;

import java.util.List;

public class ShowSinger {
    private int singerId=0;
    private String singerName=null;
    private String portrait=null;
    private String musicName=null;
    private int focus=0;
    private List<Music> music=null;

    public ShowSinger() {
    }

    public ShowSinger(int singerId, String singerName, String portrait, String musicName, int focus, List<Music> music) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.portrait = portrait;
        this.musicName = musicName;
        this.focus = focus;
        this.music = music;
    }

    @Override
    public String toString() {
        return "ShowSinger{" +
                "singerId=" + singerId +
                ", singerName='" + singerName + '\'' +
                ", portrait='" + portrait + '\'' +
                ", musicName='" + musicName + '\'' +
                ", focus=" + focus +
                ", music=" + music +
                '}';
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }
}
