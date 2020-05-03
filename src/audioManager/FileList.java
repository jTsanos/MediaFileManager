package audioManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileList {

    ArrayList<MediaFile> mediaFileList = new ArrayList<>();
    ArrayList<Audio> audioFileList = new ArrayList<>();
    ArrayList<Video> videoFileList = new ArrayList<>();

    public void getAudioFileList() {
         System.out.println(audioFileList);
    }

    public void getVideoFileList() {
        System.out.println(videoFileList);
    }


    public void addFile(MediaFile mediaFile){
        mediaFileList.add(mediaFile);

    }

    public void addAudioFile(MediaFile mediaFile){
        audioFileList.add((Audio)mediaFile);

    }

    public void addVideoFile(MediaFile mediaFile){
        videoFileList.add((Video)mediaFile);

    }

    public void removeFile(int index){
        if (index >= 0 && index < mediaFileList.size()) {
            mediaFileList.remove(index);
        }
    }

    public void clearFileList() {
        mediaFileList.clear();
    }

    public void  displayFileList(){

        System.out.println(mediaFileList);

    }

    public float  getTotalFiles (){
        float totalFiles = 0;

        //1st method
        for(MediaFile f : mediaFileList){
            totalFiles ++;
        }
        return totalFiles;
    }

    public float  getTotalFileSize (){
        float totalFileSize = 0;

        //1st method
        for(MediaFile f : mediaFileList){
            totalFileSize += f.getSize();
        }
        return totalFileSize;
    }

    public void saveFileList(String filename){

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for(MediaFile mediaFile : mediaFileList){
                printWriter.println(mediaFile.toString());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }
    }

    public void saveFileListAudio(String filename){

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for(MediaFile mediaFile : mediaFileList){
                if (mediaFile.getFileName().contains(".mp3") || mediaFile.getFileName().contains(".mp4")){
                    printWriter.println(mediaFile.toString());
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }
    }

    public void saveFileListVideo(String filename){

        try {
            PrintWriter printWriter = new PrintWriter(new File(filename));
            for(MediaFile mediaFile : mediaFileList){
                if (mediaFile.getFileName().contains(".wav") || mediaFile.getFileName().contains(".wmv")){
                    printWriter.println(mediaFile.toString());
                }
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("The file cannot be saved");
        }
    }

    public void loadFileListAudio(String filename){
        audioFileList.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String words [] = line.split(",");
                Audio audioFile = new Audio(words[0],words[1],words[2],Float.parseFloat(words[3]),words[4]);
                audioFileList.add(audioFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFileListVideo(String filename){
        videoFileList.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String words [] = line.split(",");
                Video videoFile = new Video(words[0],words[1],words[2],Float.parseFloat(words[3]),words[4]);
                videoFileList.add(videoFile);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadFileList(String filename){
        mediaFileList.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String words [] = line.split(",");
                if(!line.contains(".wav") && !line.contains(".wmv")){
                    MediaFile videoFile = new Video(words[0],words[1],words[2],Float.parseFloat(words[3]),words[4]);
                    mediaFileList.add(videoFile);
                }
                if(!line.contains(".mp3") && !line.contains(".mp4")){
                    MediaFile audioFile = new Audio(words[0],words[1],words[2],Float.parseFloat(words[3]),words[4]);
                    mediaFileList.add(audioFile);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MediaFile searchByName(String nameForSearch){
       boolean fileExist = false;
        for ( MediaFile m : mediaFileList){
            if (m.getFileName().equals(nameForSearch)){
                System.out.println(m);
                fileExist = true;
                return m;
            }
        }
        if(fileExist) System.out.println("DEN YPARXEI1");
        return null;
    }

    @Override
    public String toString() {
        return "FileList{" +
                "mediaFileList=" + mediaFileList +
                ", audioFileList=" + audioFileList +
                ", videoFileList=" + videoFileList +
                '}';
    }
}
