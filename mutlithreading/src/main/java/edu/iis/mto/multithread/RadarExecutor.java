package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class RadarExecutor implements Executor {

    private String threadType;

    public RadarExecutor(String threadType) {
        this.threadType = threadType;
    }

    @Override
    public void execute(Runnable command) {

        if(threadType.equalsIgnoreCase("same")){
            command.run();
        }else {
            new Thread(command).run();
        }
    }
}
