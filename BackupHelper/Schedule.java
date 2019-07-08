package BackupHelper;

import Save.Config;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedule {
    public Schedule(String p_Path,int target){
        ScheduledExecutorService scheduler= Executors.newScheduledThreadPool(1);
        System.out.println(getHoursUntilTarget(target));
        scheduler.scheduleAtFixedRate(new nTask(p_Path),getHoursUntilTarget(target),24,TimeUnit.HOURS);
    }
    public static int getHoursUntilTarget(int targetHour) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.MINUTE)>=30) {
            int hour = calendar.get(Calendar.HOUR_OF_DAY)+1;
            return hour < targetHour ? targetHour - hour : targetHour - hour + 24;
        }else{
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            return hour < targetHour ? targetHour - hour : targetHour - hour + 24;
        }

    }


}
