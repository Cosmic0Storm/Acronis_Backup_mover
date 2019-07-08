package BackupHelper;

import Save.Log;

import java.io.IOException;
import java.util.List;

public class nTask implements Runnable {
    private String Path;
    nTask(String p_Path){
        Path=p_Path;
    }
    @Override
    public void run() {
        long Time1=System.currentTimeMillis();
        Dir NAS=new Dir(Path);
        List<List<tib>> matching_tib=NAS.find_matching_tib();
        if (!matching_tib.isEmpty()){
            for (int a=0;a<matching_tib.size();a++){
                New_Folder N=new New_Folder(Path,matching_tib.get(a).get(0).getSys());
                for (int b=0;b<matching_tib.get(a).size();b++){
                    try {
                        Log.w("Move:->"+matching_tib.get(a).get(b).getName());
                        N.move_Files_to(matching_tib.get(a).get(b).getName());
                    }catch (IOException e){
                        Log.w("Exception->"+e.getStackTrace().toString());
                    }
                }
            }

        }
        long Time2=System.currentTimeMillis();
        Log.w("Benötigte Zeit->"+Long.toString(Time2-Time1));
    }
}
