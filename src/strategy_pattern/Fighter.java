package strategy_pattern;

public abstract class Fighter {
    KickBehavior kickBehavior;
    JumpBehavior jumpBehavior;

    public Fighter(KickBehavior kickBehavior, JumpBehavior jumpBehavior)
    {
        this.jumpBehavior = jumpBehavior;
        this.kickBehavior = kickBehavior;
    }
    public void  jump(){
        jumpBehavior.jump();
    }
    public void kick()
    {
        kickBehavior.kick();
    }
    public void punch()
    {
        System.out.println("Default Punch");
    }
    public void roll()
    {
        System.out.println("Default roll");

    }

    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }
    public  abstract void display();
}

//Encapsulated Kick behaviors
interface KickBehavior{

    public void kick();
}
class LightningKick implements KickBehavior{

    @Override
    public void kick() {
        System.out.println("Lightning Kick");

    }
}
class TornadoKick implements KickBehavior{

    @Override
    public void kick() {
        System.out.println("Tornado Kick");
    }
}

//Encapsulated jump behavior
interface JumpBehavior{

    void jump();
}
class ShortJump implements JumpBehavior{

    @Override
    public void jump() {
        System.out.println("Short Jump");
    }
}
class LongJump implements JumpBehavior{

    @Override
    public void jump() {
        System.out.println("Long Jump");
    }
}

// Characters

class Ryo extends Fighter{


    public Ryo(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    @Override
    public void display() {
        System.out.println("Ryo");


    }
}
class Kan extends Fighter{


    public Kan(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    @Override
    public void display() {
        System.out.println("Kan");

    }
}
class Chunli extends Fighter{

    public Chunli(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    @Override
    public void display() {
        System.out.println("Chunli");
    }
}
//Driver Class
class StreetFighter{
    public static void main(String[] args) {
        // let make some behaviors first
        JumpBehavior shortjump = new ShortJump();
        JumpBehavior longjump = new LongJump();
        KickBehavior lightning = new LightningKick();
        KickBehavior tornado = new TornadoKick();

        // Make a fighter with desired behavior
        Fighter kan = new Kan(tornado,shortjump);
        kan.display(); // Display of Kan Class
        kan.punch(); //Default Punch
        kan.kick(); // Tornado Kick
        kan.jump(); //Short Jump
        kan.setJumpBehavior(longjump);
        kan.jump();

    }

}