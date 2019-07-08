package BackupHelper;

import Save.Config;
import Save.Log;

import java.util.List;

public class tib {
    private String Name;
    private int Anzahl;

    private String Sys;
    private String Type;
    private String ID;
    private String Number;

    tib(String p_Name){
        Name=p_Name;
        createData();
        Anzahl=Config.getAnzahl(Sys);
        if (!(Config.getAnzahl(Sys)==0)) {
            Anzahl=Config.getAnzahl(Sys);
        }else{
            Log.w(Sys+" ist nicht in Configdatei enthalten");
            Anzahl=0;
        }


    }
    private void createData(){
        String[] Name_arr=Name.split("_");
        Sys=Name_arr[0];
        Type=Name_arr[1];
        ID=Name_arr[2];
        Number=Name_arr[3].substring(1);
    }
    public int getAnzahl(){
        return Anzahl;
    }
    public String getName(){
        return Name;
    }
    public String getSys(){
        return Sys;
    }
    public String getType(){
        return Type;
    }
    public String getID(){
        return ID;
    }
    public int getNumber(){
        return Integer.parseInt(Number);
    }



}
