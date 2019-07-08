package Save;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Config {
    private static String Pfad;
    private static int target;
    private static List<List<String>> Anzahlen;

    public  Config(){
        Anzahlen= new ArrayList<List<String>> ();
        List<String> Content=new ArrayList<String>();
        System.out.println(String.valueOf(Config.class.getProtectionDomain().getCodeSource().getLocation().getPath())+"conf");
        File file=new File(String.valueOf(Config.class.getProtectionDomain().getCodeSource().getLocation().getPath()).substring(1,String.valueOf(Config.class.getProtectionDomain().getCodeSource().getLocation().getPath()).length()-28)+"conf");
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br =new BufferedReader(fr);

            String line;
            while((line=br.readLine())!=null){
                if (!line.contains("#")) {
                    Content.add(line);
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pfad=Content.get(0);
        target=Integer.parseInt(Content.get(1));
        for (int a=2;a<Content.size();a++){
             String Anzahl=Content.get(a).split(":")[0];
             List<String> tres=new ArrayList<String>();
             tres.add(Anzahl);
             for (int b=0;b<Content.get(a).split(",").length;b++){
                 if (b==0){
                     tres.add(Content.get(a).split(",")[0].substring(3).replace("]",""));
                     System.out.println(Content.get(a).split(",")[0].substring(3).replace("]",""));
                 }else{
                     tres.add(Content.get(a).split(",")[b].replace("]",""));
                     System.out.println(Content.get(a).split(",")[b].replace("]",""));
                 }

             }
             Anzahlen.add(tres);
        }
        System.out.println(Anzahlen);

    }
    public static List<String> getSystems(){
        List<String> Res=new ArrayList<String>();
        for (int a=0;a<Anzahlen.size();a++){
            for (int b=1;b<Anzahlen.get(a).size();b++){
                Res.add(Anzahlen.get(a).get(b));
            }
        }
        return Res;
    }
    public static int getAnzahl(String Sys){
        int Res=0;
        for (int a=0;a<Anzahlen.size();a++){
            if (Anzahlen.get(a).contains(Sys)){
                Res=Integer.parseInt(Anzahlen.get(a).get(0));
            }
        }
        return Res;
    }
    public static String getPfad(){
        return Pfad;
    }
    public static int getTarget(){
        return target;
    }


}
