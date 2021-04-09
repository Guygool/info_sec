import java.io.IOException;
import java.util.Arrays;
public class Encriptor {

    private byte[] key1;
    private byte[] key2;
    private File_Reader reader;

    public Encriptor() {
        this.reader = new File_Reader();
    }

    //split the input key to 2 even halves.
    private void splitKey( byte[] initialKey){
        byte[] k1 = Arrays.copyOfRange(initialKey,0,(initialKey.length/2));
        byte[] k2 = Arrays.copyOfRange(initialKey,(initialKey.length/2),initialKey.length);
        this.key1=k1;
        this.key2=k2;
    }

    public void encript(String messagePath,String keyPath, String outputPath){

        try {
            byte[] message = this.reader.read(messagePath);
            byte[] initialKey = this.reader.read(keyPath);
            splitKey(initialKey);

            byte[] c1 = AES1(this.key1,message);
            byte[] cipher = AES1(this.key2,c1);

            this.reader.write(outputPath,cipher);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private byte[] AES1(byte[] enncryptionKey, byte[] message){
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
                toRet[index] = (byte)(swap[j][i]^ keyAsMat[j][i]);
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
            for (int i = 0; i < 4; i++) {
                mat[i][r] = arr[start];
                start++;
            }
        }
        return mat;

    }

    public void extractKeys(String messagePath, String CipherPath, String outputPath){
        File_Reader reader = new File_Reader();
        try {
            byte[] message = reader.read(messagePath);
            byte[] cipher = reader.read(CipherPath);
            //Xoring the message and cipher
            byte[] blockMessage = java.util.Arrays.copyOfRange(message, 0,16);
            byte[] blockCipher = java.util.Arrays.copyOfRange(cipher, 0,16);

            byte[] cipherXorMessage = toXor(toArray(blockCipher),toArray(blockMessage));

            byte[] key2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            byte[] key1 = cipherXorMessage;

            byte[] keyPair = new byte[32];

            for (int i = 0; i <key2.length ; i++) {
                keyPair[i]= key2[i];
            }
            for (int i = 0; i <key1.length ; i++) {
                keyPair[i+16]= key1[i];
            }
            reader.write(outputPath,keyPair);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
