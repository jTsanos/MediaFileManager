package audioManager;

public class Audio extends MediaFile {
    String copyRight;
public static final String TYPE = "Audio";

    public Audio(String fileName, String description, String creator, float size, String copyRight) {
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
        return "Audio{" +
                ", fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", size=" + size + '\'' +
                ", copyRight='" + copyRight +
                '}';
    }
}
