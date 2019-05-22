package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery patriotBattery;
    private static Integer BULLET_COUNTER = 20;
    private Executor executor;

    public BetterRadar(PatriotBattery patriotBattery, Executor executors) {
        this.patriotBattery = patriotBattery;
        this.executor = executors;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(this::run);
    }

    @Override
    public void run() {

        for (int i = 0; i < BULLET_COUNTER; i++) {
            patriotBattery.launchPatriot();
        }

    }
}
