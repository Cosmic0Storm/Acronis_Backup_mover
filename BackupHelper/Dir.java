package BackupHelper;

import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Dir {
    private File Path;
    private tib[] _Files_;
     Dir(String p_Path){
        Path=new File(p_Path);
        List<String> Inh=listDir();
        _Files_=new tib[Inh.size()];
        for (int a=0;a<Inh.size();a++){
            tib Datei=new tib(Inh.get(a));
            _Files_[a]=Datei;
        }
    }
    private List<String> listDir(){
        List<String> Res=new ArrayList<String>();
        for (File fileEntry:Path.listFiles()){
            if (fileEntry.isDirectory()){

            }else{
                Res.add(fileEntry.getName());
            }
        }
        return Res;
    }
    public List<List<tib>> find_matching_tib() {
        List<List<tib>> Res = new ArrayList<List<tib>>();
        for (int a = 0; a < _Files_.length; a++){
            if (_Files_[a].getNumber() == 1) {
                int b = a+1;
                List<tib> Group_Files = new ArrayList<tib>();
                while (b < _Files_.length) {
                    if ((_Files_[b].getSys().toString().equals(_Files_[a].getSys().toString()))&&(_Files_[b].getID().toString().equals(_Files_[a].getID().toString()))) {
                        if ((_Files_[b].getNumber() > _Files_[a].getNumber()) && (_Files_[b].getNumber() <= _Files_[b].getAnzahl())) {
                            if (Group_Files.size() == 0) {
                                Group_Files.add(0,_Files_[a]);
                            }
                            Group_Files.add(_Files_[b]);
                        }
                    }
                    b++;
                }
                if (Group_Files.size()==_Files_[a].getAnzahl()){
                    Res.add(Group_Files);
                }
            }
        }
        return Res;
    }


}
