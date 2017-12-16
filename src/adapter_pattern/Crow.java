package adapter_pattern;

public class Crow implements Bird {


    @Override
    public void flyBird() {
        System.out.println("Bird flying");
    }

    @Override
    public void makeVoice() {
        System.out.println("Kaa Kaa Kaa...");

    }
}
