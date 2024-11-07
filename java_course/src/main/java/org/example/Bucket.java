public class Bucket {
    public int volume =  0;

    public Bucket(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (this.volume == 0) this.volume = 0;
        this.volume = volume;
    }
}
