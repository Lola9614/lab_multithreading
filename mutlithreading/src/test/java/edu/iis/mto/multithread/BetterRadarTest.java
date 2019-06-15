package edu.iis.mto.multithread;

import edu.iis.mto.multithread.RepeatRule.Repeat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public  class BetterRadarTest {

    private BetterRadar betterRadar;
    private PatriotBattery patriotBattery;
    private Executor executor;

    @Rule
    public RepeatRule repatRule;

    @Before
    public void setup(){
        patriotBattery = mock(PatriotBattery.class);
        executor = new RadarExecutor("same");
        betterRadar = new BetterRadar(patriotBattery,3, executor);
        repatRule = new RepeatRule();
    }


    @Test
    @Repeat(times = 5000)
    public void launchPatriotThreeTimeWhenThreeIsPassed(){
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(3)).launchPatriot();
    }
}
