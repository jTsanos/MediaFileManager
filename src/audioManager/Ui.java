package audioManager;

import java.util.Scanner;



public class Ui {


    public Choice selectedMediaFile(){
        Scanner scanner = new Scanner(System.in);
        int selectedItem;
        System.out.println("1.for audio 2.for video 0.for exit");
        selectedItem = scanner.nextInt();
        while(selectedItem != 1 && selectedItem != 2 &&selectedItem != 0){
            System.out.println("Βαλε 1 για audio ή 2 για Video ειπαμε!!!");
            selectedItem = scanner.nextInt();
        }
       if (selectedItem == 1){
           return Choice.AUDIOFILE;
       }else if(selectedItem == 2) {
           return Choice.VIDEOFILE;
       }else if(selectedItem == 0){
           return Choice.EXIT;
       }
    return null;
    }



    public Choice menuForAudio(){

        System.out.println("1.Add aN AudioFile\n" +
                "2.Remove aN AudioFile \n" +
                "3.Desplay fileList\n" +
                "4.Clear fileList \n" +
                "5.Total MediaFiles \n" +
                "6.save MediaFiles\n" +
                "7.Save Audios \n" +
                "8.Load MediaFiles \n" +
                "9.Load Audio.txt \n" +
                "10.search MediaList  by name\n" +
                "11 Sart menu \n" +
                "0.Exit");

        int choice;

        Scanner scanner = new Scanner(System.in);

        try{
            choice = scanner.nextInt();
            switch(choice){
                case 1: return Choice.ADD_AUDIO;
                case 2: return Choice.REMOVE_AUDIO;
                case 3: return Choice.DISPLAY_FILELIST;
                case 4: return Choice.CLEAR_FILELIST;
                case 5: return Choice.TOTAL_MEDIAFILES;
                case 6: return Choice.SAVE;
                case 7: return Choice.SAVE_AUDIO;
                case 8: return Choice.LOAD_FILELIST;
                case 9: return Choice.LOAD_AUDIO;
                case 10:return Choice.SEARCH;
                case 11:return Choice.START_MENU;
                case 0: return Choice.EXIT;
                default: return Choice.ERROR;
            }
        }catch (Exception e){
            return Choice.ERROR;
        }
    }



public Audio createAudio(){
    Scanner scanner = new Scanner(System.in);
    String filename;
    String description;
    String creator;
    float size = 0;
    String copyRight;
    do {
        System.out.println("Give the AudioFile filename (Only .mp3 or .mp4)");
        filename = scanner.next();
        if (!filename.contains(".mp3") && !filename.contains(".mp4")){
            filename = null;
        }
    }while( filename == null);
    System.out.println("Give the AudioFile description");
    description = scanner.next();
    System.out.println("Give the AudioFile creator");
    creator = scanner.next();
    System.out.println("Give the AudioFile size");
    try{
        size = scanner.nextFloat();
    }catch (Exception e){
        System.out.println("ΑΡΙΘΜΟ ΣΤΟ SIZE");
    }
    System.out.println("Give the AudioFile copyRight");
    copyRight = scanner.next();


    Audio audioFile = new Audio(filename, description, creator, size, copyRight);

    return audioFile;
}

    public Choice menuForVideo(){
        System.out.println("1.Add a VideoFile \n" +
                "2.Remove a videoFile \n" +
                "3.Desplay fileList\n" +
                "4.Clear fileList \n" +
                "5.Total MediaFiles\n" +
                "6.save MediaFiles \n" +
                "7.Save Videos\n" +
                "8.Load MediaFiles \n" +
                "9.Load Video.txt \n" +
                "10.Search mediaList by name\n" +
                "11 for start menu\n" +
                " 0.Exit");



        int choice;

        Scanner scanner = new Scanner(System.in);

        try{
            choice = scanner.nextInt();
            switch(choice){
                case 1: return Choice.ADD_VIDEO;
                case 2: return Choice.REMOVE_VIDEO;
                case 3: return Choice.DISPLAY_FILELIST;
                case 4: return Choice.CLEAR_FILELIST;
                case 5: return Choice.TOTAL_MEDIAFILES;
                case 6: return Choice.SAVE;
                case 7: return Choice.SAVE_VIDEO;
                case 8: return Choice.LOAD_FILELIST;
                case 9 :return Choice.LOAD_VIDEO;
                case 10:return Choice.SEARCH;
                case 11:return Choice.START_MENU;
                case 0: return Choice.EXIT;
                default: return Choice.ERROR;
            }
        }catch (Exception e){
            return Choice.ERROR;
        }
    }

    public Video createVideo(){
        Scanner scanner = new Scanner(System.in);
        String filename;
        String description;
        String creator;
        float size = 0;
        String copyRight;
        do {
            System.out.println("Give the VideoFile filename (Only .wav or .wmv)");
            filename = scanner.next();
            if (!filename.contains(".wav") && !filename.contains(".wmv")){
                filename = null;
            }
        }while( filename == null);
        System.out.println("Give the VideoFile description");
        description = scanner.next();
        System.out.println("Give the VideoFile creator");
        creator = scanner.next();
        System.out.println("Give the VideoFile size");
        try{
            size = scanner.nextFloat();
        }catch (Exception e){
            System.out.println("ΑΡΙΘΜΟ ΣΤΟ SIZE");
        }

        System.out.println("Give the VideoFile copyRight");
        copyRight = scanner.next();


        Video videoFile = new Video(filename, description, creator, size, copyRight);


        return videoFile;
    }

    public void manageMediaFileList(FileList myMediaFile){

        Choice choice =  selectedMediaFile();
        if (choice == Choice.AUDIOFILE){
            do {
                choice = menuForAudio();
                switch (choice) {
                    case ADD_AUDIO:
                        MediaFile audioFile = createAudio();
                        myMediaFile.addFile(audioFile);
                        myMediaFile.addAudioFile(audioFile);
                        break;
                    case REMOVE_AUDIO:
                        int index;
                        System.out.println("Giave a number");
                        Scanner scanner = new Scanner(System.in);
                        index = scanner.nextInt();
                        myMediaFile.removeFile(index);
                        break;
                    case DISPLAY_FILELIST:
                        myMediaFile.displayFileList();
                        break;
                    case CLEAR_FILELIST:
                        myMediaFile.clearFileList();
                        break;
                    case TOTAL_MEDIAFILES:
                        System.out.println(myMediaFile.getTotalFiles());
                    case SAVE:
                        myMediaFile.saveFileList("MyMediaFiles.txt");
                        break;
                    case SAVE_AUDIO:
                    myMediaFile.saveFileListAudio("Audio.txt");
                    break;
                    case LOAD_FILELIST:
                        myMediaFile.loadFileList("MyMediaFiles.txt");
                        break;
                    case LOAD_AUDIO:
                       myMediaFile.loadFileListAudio("Audio.txt");
                        myMediaFile.getAudioFileList();
                        break;
                    case SEARCH:
                        String nameForSearch;
                        System.out.println("BAΛΕ ΝΑΜΕ ARXEIOY");
                        Scanner scannerTwo = new Scanner(System.in);
                        nameForSearch = scannerTwo.next();
                       myMediaFile.searchByName(nameForSearch);
                        break;
                    case START_MENU:
                        manageMediaFileList(myMediaFile);
                        break;
                    case EXIT:
                        break;
                    case ERROR:
                        System.out.println("You gave an error number");
                        break;
                }
            }while (choice != Choice.EXIT) ;
        }else if (choice == Choice.VIDEOFILE){
            do {
                choice = menuForVideo();
                switch (choice) {
                    case ADD_VIDEO:
                        MediaFile videoFile = createVideo();
                        myMediaFile.addFile(videoFile);
                        myMediaFile.addVideoFile(videoFile);
                        break;
                    case REMOVE_VIDEO:
                        int index;
                        System.out.println("Giave a number");
                        Scanner scanner = new Scanner(System.in);
                        index = scanner.nextInt();
                        myMediaFile.removeFile(index);
                        break;
                    case DISPLAY_FILELIST:
                        myMediaFile.displayFileList();
                        break;
                    case CLEAR_FILELIST:
                        myMediaFile.clearFileList();
                        break;
                    case TOTAL_MEDIAFILES:
                        System.out.println(myMediaFile.getTotalFiles());
                        manageMediaFileList(myMediaFile);
                    case SAVE:
                        myMediaFile.saveFileList("MyMediaFiles.txt");
                        break;
                    case SAVE_VIDEO:
                        myMediaFile.saveFileListVideo("Videos.txt");
                        break;
                    case LOAD_FILELIST:
                        myMediaFile.loadFileList("MyMediaFiles.txt");
                        break;
                    case LOAD_VIDEO:
                        myMediaFile.loadFileListVideo("Videos.txt");
                        myMediaFile.getVideoFileList();
                        break;
                    case SEARCH:
                        String nameForSearch;
                        System.out.println("BAΛΕ ΝΑΜΕ ARXEIOY");
                        Scanner scannerTwo = new Scanner(System.in);
                        nameForSearch = scannerTwo.next();
                        myMediaFile.searchByName(nameForSearch);
                        break;
                    case START_MENU:
                        manageMediaFileList(myMediaFile);
                        break;
                    case EXIT:
                        break;
                    case ERROR:
                        System.out.println("You gave an error number");
                        break;
                }
            }while (choice != Choice.EXIT) ;
        }


    }

}