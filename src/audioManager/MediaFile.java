package audioManager;

import org.w3c.dom.ls.LSOutput;

public abstract class MediaFile {
    String fileName;
    String description;
    String creator;
    float size;

    public MediaFile(String fileName, String description, String creator, float size) {
        this.fileName = fileName;
        this.description = description;
        this.creator = creator;
        this.size = size;
    }

    public String getFileName() {
        if (!fileName.contains(".mp3") && !fileName.contains(".mp4") && !fileName.contains(".wav") && !fileName.contains(".wmv")){
            fileName = null;
        }
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", size=" + size +
                '}';
    }
}
