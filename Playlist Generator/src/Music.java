public class Music {

    private int genre_id;
    private int track_id;
    private int track_duration;
    private int track_popularity;


    public Music (int genre_id, int track_id, int track_duration, int track_popularity){
        this.genre_id = genre_id;
        this.track_id = track_id;
        this.track_duration = track_duration;
        this.track_popularity = track_popularity;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public int getTrack_duration() {
        return track_duration;
    }

    public void setTrack_duration(int track_duration) {
        this.track_duration = track_duration;
    }

    public int getTrack_popularity() {
        return track_popularity;
    }

    public void setTrack_popularity(int track_popularity) {
        this.track_popularity = track_popularity;
    }


    @Override
    public String toString() {
        return  genre_id + ","
                + track_id + ","
                + track_duration + ","
                + track_popularity;
    }

}
