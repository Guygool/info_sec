import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class main {

    public static void main(String[] args) {
        Encriptor enc = new Encriptor();

        if(args[0].equals("-e") || args[0].equals("-d")){
            String messagePath="";
            String keyPath="";
            String outPutPath="";
            if(args[1].equals("-k")){
                keyPath = args[2];
            }
            if(args[3].equals("-i")){
                messagePath = args[4];
            }
            if(args[5].equals("-o")){
                outPutPath = args[6];
            }
            enc.encript(messagePath,keyPath,outPutPath);
        }
        if(args[0].equals("-b")){
            String messagePath="";
            String cipher="";
            String outPutPath="";
            if(args[1].equals("-m")){
                messagePath = args[2];
            }
            if(args[3].equals("-c")){
                cipher = args[4];
            }
            if(args[5].equals("-o")){
                outPutPath = args[6];
            }
            enc.extractKeys(messagePath,cipher,outPutPath);

        }

    }

}
