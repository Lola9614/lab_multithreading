package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar implements Runnable {

    private PatriotBattery patriotBattery;
    private Integer bulletCounter;
    private Executor executor;

    public BetterRadar(PatriotBattery patriotBattery, Integer bulletCounter, Executor executors) {
        this.patriotBattery = patriotBattery;
        this.bulletCounter = bulletCounter;
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

        for (int i = 0; i < bulletCounter; i++) {
            patriotBattery.launchPatriot();
        }

    }
}
