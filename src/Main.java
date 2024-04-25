import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File myFile;
        myFile = new File("data/myFile.txt");
        if(!myFile.exists())
            myFile.createNewFile();
        System.out.println("Can read: "+ myFile.canRead());
        System.out.println("Can write: "+ myFile.canWrite());
        System.out.println("Name file: " + myFile.getName());
        System.out.println(myFile.delete()); // Đăng xuất -> xóa file

        try{
            FileWriter fileWriter = new FileWriter(myFile);
            /*
            * su dung truc tiep fileWriter -> ton tai nguyen hon
            * so voi buffer writer toc do doc cham hon
            * Thay bang BufferWriter
            * */
//            fileWriter.write("Xin chao moi nguoi\n");
//            fileWriter.write("hello");
//            fileWriter.close();
            /*
            Su dung bo nho BufferWriter (bo nho dem)
            *  Noi luu tru tam thoi de tan hieu qua cua thao tac
            * doc ghi file, neu khong bo nho se cap phat truc tiep
            * an vao RAM,
            * Truyen vao mot doi tuong FileWrite
            * BufferWriter writer = new BufferWriter(newFileWriter(aFile));
            */

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("C02\n");
            bufferedWriter.write("Xin chao");
            bufferedWriter.newLine();
            bufferedWriter.write("33333");
            bufferedWriter.close(); // viet xong thi dong lai
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
            // Doc File
            try{
                FileReader fileReader = new FileReader(myFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                boolean notReachLastLine = (line = bufferedReader.readLine())!=null;
                while(notReachLastLine){
                    System.out.println(line);
                    notReachLastLine = (line = bufferedReader.readLine())!=null;
                }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
    }
}