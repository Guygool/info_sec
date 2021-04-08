import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class main {

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        String path = "C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\cipher_long";
        String key = "C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\key_long";
        String message ="C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\message_long";
        File_Reader r = new File_Reader();
        try {
            byte[] x = r.read(message);
            Encriptor enc = new Encriptor(path, key);
            byte[] y = enc.encript("");
            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]){
                    System.out.println(i+" "+ x[i]+" " +y[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Encriptor encriptor = new Encriptor(message1,key);
//        System.out.println(message1.getContent());
//        System.out.println(hex(encriptor.getInitialKey().getContent()));
//        System.out.println(hex(encriptor.getKey1()));
//        System.out.println(hex(encriptor.getKey2()));
//        long time2 = System.currentTimeMillis();
//        System.out.println((time2 - time1));
//        System.out.println(hex(message1.getContent()));
//        System.out.println(new String(message1.getContent()));
//        System.out.println(message2.getContent());
//        System.out.println(new String(message2.getContent()));

    }




}
