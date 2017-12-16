package adapter_pattern;

public class BirdAdapter implements ToyBird {

    Bird bird;

    public BirdAdapter(Bird bird)
    {
        this.bird = bird;
    }


    @Override
    public void squeak() {
        bird.makeVoice();
    }
}
