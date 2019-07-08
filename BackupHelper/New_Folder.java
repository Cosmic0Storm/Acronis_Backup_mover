package BackupHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class New_Folder {
    private String Name;
    private String Path_;
    private String TopPath;
     New_Folder(String Operating_Path, String Sys_Name){
        SimpleDateFormat b_format=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date(System.currentTimeMillis());
        Name=b_format.format(date);
        TopPath=Operating_Path;
        Path_=Operating_Path+"\\"+Name+"-"+Sys_Name;
        new File(Path_).mkdirs();

    }
    public void move_Files_to(String Name) throws IOException {
        String Target= Path_ + "\\" + Name;
        String source=TopPath+"\\"+Name;
        Path mover= Files.move(Paths.get(source),Paths.get(Target));
    }
}
