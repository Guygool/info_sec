import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        File_Reader message1 = new File_Reader("C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\message_long");
        File_Reader message2 = new File_Reader("C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\message_short");
        File_Reader key = new File_Reader("C:\\Users\\user\\Desktop\\BGU-ISE\\year 3\\semester6\\אבטחה\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\key_long");
        Encriptor encriptor = new Encriptor(message1,key);
//        System.out.println(message1.getContent());
        System.out.println(hex(encriptor.getInitialKey().getContent()));
        System.out.println(hex(encriptor.getKey1()));
        System.out.println(hex(encriptor.getKey2()));
        long time2 = System.currentTimeMillis();
        System.out.println((time2 - time1));
//        System.out.println(hex(message1.getContent()));
//        System.out.println(new String(message1.getContent()));
//        System.out.println(message2.getContent());
//        System.out.println(new String(message2.getContent()));

    }


    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
            // upper case
            // result.append(String.format("%02X", aByte));
        }
        return result.toString();
    }

}
