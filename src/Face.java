public class Face {
    int eyes;
    public Face(int eyes) {
        this.eyes = eyes;
    }

    public String getName() {
        if (this.eyes <= 6) {
            return Integer.toString(eyes);
        }
        return "";
    }

    public long getEyes() {
        return eyes;
    }
}
