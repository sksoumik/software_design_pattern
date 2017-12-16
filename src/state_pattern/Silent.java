package state_pattern;

public class Silent implements MobileAlertState {


    @Override
    public void alert(AlertStateContext cn) {
        System.out.println("SILENT STATE...");

    }
}
