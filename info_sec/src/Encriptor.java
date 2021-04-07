import java.util.Arrays;

public class Encriptor {

    private File_Reader message;
    private File_Reader initialKey;
    private byte[] key1;
    private byte[] key2;
    public Encriptor(File_Reader message, File_Reader initialKey) {
        this.message = message;
        this.initialKey = initialKey;
        splitKey(initialKey);
    }

    private void splitKey( File_Reader keyToSplit){
        byte[] arr =keyToSplit.getContent();
        byte[] k1 = Arrays.copyOfRange(arr,0,(arr.length/2));
        byte[] k2 = Arrays.copyOfRange(arr,(arr.length/2),arr.length);
        this.key1=k1;
        this.key2=k2;
    }

    public File_Reader getMessage() {
        return message;
    }

    public File_Reader getInitialKey() {
        return initialKey;
    }

    public byte[] getKey1() {
        return key1;
    }

    public byte[] getKey2() {
        return key2;
    }
}
