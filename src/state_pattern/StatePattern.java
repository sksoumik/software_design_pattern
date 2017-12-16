package state_pattern;

public class StatePattern {

    public static void main(String[] args) {
        AlertStateContext stateContext  = new AlertStateContext();
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();

        stateContext.setState(new Vibration()); // turns again into Vibration state
        stateContext.alert();
    }
}
