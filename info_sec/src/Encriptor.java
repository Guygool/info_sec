import java.io.IOException;
import java.util.Arrays;
public class Encriptor {

    private byte[] message;
    private byte[] initialKey;
    private byte[] key1;
    private byte[] key2;

    public Encriptor(String messagePath, String initialKeyPath) {
        File_Reader r = new File_Reader();

        try {
            this.message = r.read(messagePath);
            this.initialKey = r.read(initialKeyPath);
            splitKey();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //split the input key to 2 even halves.
    private void splitKey( ){
        byte[] k1 = Arrays.copyOfRange(this.initialKey,0,(this.initialKey.length/2));
        byte[] k2 = Arrays.copyOfRange(this.initialKey,(this.initialKey.length/2),this.initialKey.length);
        this.key1=k1;
        this.key2=k2;
    }

    public byte[] encript(String outputPath){
        byte[] c1 = AES1(this.key1,this.message);
        byte[] cipher = AES1(this.key2,c1);
//        System.out.println("res");
//        System.out.println(new String(cipher));
        return cipher;
    }

    public byte[] AES1(byte[] enncryptionKey, byte[] message){
        byte[] cipherText = new byte[message.length];
        int start=0;
        int indexC=0;
        while(start <= message.length-16){
            byte[][] splitArray = toArray(java.util.Arrays.copyOfRange(message, start, start + 16));
            start+=16;
            byte[][] swap = swapArray(splitArray);
            byte[][] keyAsMat = toArray(enncryptionKey);
            byte[] xor = toXor(swap,keyAsMat);
            for (byte x :xor){
                cipherText[indexC]=x;
                indexC++;
            }
        }
        return cipherText;
    }

    private byte[] toXor(byte[][] swap, byte[][] keyAsMat) {
        byte[] toRet = new byte[16];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                toRet[index] = (byte)(swap[j][i]^ keyAsMat[i][j]);
                index++;
            }
        }
        return toRet;
    }

    private byte[][] swapArray(byte[][] splitArray) {
        byte[][] toRet = new byte[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                toRet[i][j] = splitArray[j][i];
            }
        }
        return toRet;
    }

    private byte[][] toArray(byte[] arr){
        byte[][] mat = new byte[4][4];
        int start = 0;
        for (int r = 0; r < 4; r++) {
            mat[r] = java.util.Arrays.copyOfRange(arr, start, start + 4);
            start += 4;
        }
        return mat;

    }

//    public File_Reader getMessage() {
//        return message;
//    }
//
//    public File_Reader getInitialKey() {
//        return initialKey;
//    }

    public byte[] getKey1() {
        return key1;
    }

    public byte[] getKey2() {
        return key2;
    }
}
