package audioManager;

public class Video extends MediaFile {
    String copyRight;

    public Video(String fileName, String description, String creator, float size, String copyRight) {
        super(fileName, description, creator, size);
        this.copyRight = copyRight;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    @Override
    public String toString() {
        return "Video{" +
                "copyRight='" + copyRight + '\'' +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", size=" + size +
                '}';
    }
}
