

public class main {
    public static void main(String[] args) {
        File_Reader message1 = new File_Reader("C:\\Users\\user\\Downloads\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\message_long");
        File_Reader message2 = new File_Reader("C:\\Users\\user\\Downloads\\שאלה 2 - קבצי בדיקה\\self_testing_files_2021\\message_short");
        System.out.println(message1.getContent());
        System.out.println(new String(message1.getContent()));
        System.out.println(message2.getContent());
        System.out.println(new String(message2.getContent()));
    }
}
