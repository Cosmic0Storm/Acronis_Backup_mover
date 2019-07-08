package Save;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {
    private static final String Filename="Backup.log";
    private static FileWriter fw;
    private static FileReader fr;


    public static void  w(String str){
        try {
            fw=new FileWriter(Filename,true);
            Calendar now =Calendar.getInstance();
            SimpleDateFormat b_format=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date(System.currentTimeMillis());
            fw.write("["+b_format.format(date)+"]>("+String.valueOf(now.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(now.get(Calendar.MINUTE)+")>"+str+"\n"));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String r() {
        try {
            fr=new FileReader(Filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String FileContent = null;
        FileContent=fr.toString();
        BufferedReader br =new BufferedReader(fr);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                FileContent+=line+"\n";
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return FileContent;
    }
}
