package adapter_pattern;

public class AdapterMain {

    public static void main(String[] args) {

        Crow crow              = new Crow();
        PlasticToyBird toyBird = new PlasticToyBird();
        ToyBird  birdAdapter   = new BirdAdapter(crow);

        System.out.println("Crow..");
        crow.flyBird();
        crow.makeVoice();

        System.out.println("ToyBird..");
        toyBird.squeak();

        System.out.println("BirdAdapter");
        birdAdapter.squeak();


    }
}