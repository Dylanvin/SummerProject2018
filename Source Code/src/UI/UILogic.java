package UI;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UILogic {
    private int counter;
    private UIDisplay UID;
    public UILogic(UIDisplay UID){
        this.UID = UID;
    }
    public void timer(){
        Runnable counterRunnable = new Runnable() {
            public void run() {
                counter = counter + 1;
                UID.setTime(counter);
                System.out.println(counter);
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(counterRunnable, 0, 1, TimeUnit.SECONDS);
    }
}
