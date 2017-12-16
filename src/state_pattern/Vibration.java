package state_pattern;

public class Vibration implements MobileAlertState {

    @Override
    public void alert(AlertStateContext cn) {
        System.out.println("VIBRATION STATE...");
    }
}
