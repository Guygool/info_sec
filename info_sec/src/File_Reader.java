import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;

public class File_Reader
{

    // the File_Reader object as the name may suggest recives a file Path and puts it into an object variable.

    private byte[] content;

    public byte[] getContent() {
        return content;
    }
    public File_Reader(String path) {
        try {
            this.content =  read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] read(String pathToRead) throws IOException {
        Path path = Paths.get(pathToRead);
        byte[] data = Files.readAllBytes(path);
//        System.out.println(data);
//        System.out.println(new String(data));
        return data;
    }
}