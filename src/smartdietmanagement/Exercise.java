package smartdietmanagement;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Jez
 */

public class Exercise {

    Timer timer;

    public Exercise(int seconds) {
        timer = new Timer();
        timer.schedule(new ExerciseReminder(), seconds * 1000);
    }

    class ExerciseReminder extends TimerTask {

        public void run() {
            System.out.format("Time to exercise!%n");
            timer.cancel();
        }
    }
}