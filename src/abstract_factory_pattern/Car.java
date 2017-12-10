package abstract_factory_pattern;

enum CarType{
    MICRO, MINI, LUXURY;
}
enum Location{
    DEFAULT, BANGLADESH, INDIA;
}
abstract class Car {
    Car(CarType model, Location location)
    {
        this.model    = model;
        this.location = location;
    }
    abstract void construct();
    CarType model      = null;
    Location location   = null;


    CarType getModel()
    {
        return model;
    }

    void setModel(CarType model)
    {
        this.model =  model;
    }

    Location getLocation()
    {
        return location;
    }

    void setLocation(Location location)
    {
        this.location  =  location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model=" + model +
                ", location=" + location +
                '}';
    }
}

class LuxuryCar extends Car{
    LuxuryCar(Location location)
    {
        super(CarType.LUXURY,location);
        construct();
    }

    @Override
     protected void construct() {
        System.out.println("Connecting to luxury car");

    }
}
class MicroCar extends Car{
    public MicroCar(Location location) {
        super(CarType.MICRO, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Connecting to micro car");

    }
}
class MiniCar extends Car{
    public MiniCar(Location location) {
        super(CarType.MINI, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Connecting to mini car");

    }
}

class BangladeshCarFactory{
    static Car buildCar(CarType model)
    {
        Car car   = null;
        switch (model)
        {
            case MINI:
                car  = new MiniCar(Location.BANGLADESH);
                break;
            case MICRO:
                car  = new MicroCar(Location.BANGLADESH);
                break;
            case LUXURY:
                car  = new LuxuryCar(Location.BANGLADESH);
                break;

            default:
                break;
        }
        return car;

    }
}


class DefaultCarFactory
{
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(Location.DEFAULT);
                break;

            case MINI:
                car = new MiniCar(Location.DEFAULT);
                break;

            case LUXURY:
                car = new LuxuryCar(Location.DEFAULT);
                break;

            default:
                break;

        }
        return car;
    }
}


class INDIACarFactory
{
    static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(Location.INDIA);
                break;

            case MINI:
                car = new MiniCar(Location.INDIA);
                break;

            case LUXURY:
                car = new LuxuryCar(Location.INDIA);
                break;

            default:
                break;

        }
        return car;
    }
}
// Car Factory For Bangladesh
class CarFactoryBD
{
    private CarFactoryBD()
    {

    }
    public static Car buildCar(CarType type)
    {
        Car car = null;

        Location location = Location.BANGLADESH;

        switch(location)
        {
            case BANGLADESH:
                car = BangladeshCarFactory.buildCar(type);
                break;

            case INDIA:
                car = INDIACarFactory.buildCar(type);
                break;

            default:
                car = DefaultCarFactory.buildCar(type);

        }

        return car;

    }
}
// Car Factory For India
class CarFactoryIn
{
    private CarFactoryIn()
    {

    }
    public static Car buildCar(CarType type)
    {
        Car car = null;

        Location location = Location.INDIA;

        switch(location)
        {
            case BANGLADESH:
                car = BangladeshCarFactory.buildCar(type);
                break;

            case INDIA:
                car = INDIACarFactory.buildCar(type);
                break;

            default:
                car = DefaultCarFactory.buildCar(type);

        }

        return car;

    }
}

// Driver Class
class AbstractFactory{
    public static void main(String[] args) {
        System.out.println(CarFactoryBD.buildCar(CarType.MICRO));
        System.out.println(CarFactoryBD.buildCar(CarType.MINI));
        System.out.println(CarFactoryBD.buildCar(CarType.LUXURY));

        System.out.println(CarFactoryIn.buildCar(CarType.LUXURY));
        System.out.println(CarFactoryIn.buildCar(CarType.MICRO));
        System.out.println(CarFactoryIn.buildCar(CarType.MINI));

    }
}