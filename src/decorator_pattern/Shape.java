package decorator_pattern;


import sun.security.provider.SHA;

//Shape Interface
interface Shape {
     void draw();
}


//Rectangle
class Rectangle implements Shape{


    @Override
    public void draw() {
        System.out.println("Shape:Rectangle");
    }
}

//Circle
class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

//ShapeDecorator
 abstract class ShapeDecoractor implements Shape{
    protected Shape decoratedShape;
    public ShapeDecoractor(Shape decoratedShape)
    {
     this.decoratedShape =decoratedShape;
    }
    public void draw(){
        decoratedShape.draw();
    }

}
class RedShapeDecorator extends ShapeDecoractor {


    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    public void draw(){
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
    private void setRedBorder(Shape decoratedShape)
    {
        System.out.println("Border color: Red");
    }
}

//DecoratorPatternDemo

class DecoratorPatternDemo{
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border: ");
        circle.draw();
        System.out.println("\n Circle with red border");
        redCircle.draw();
        System.out.println("\n Rectangle with red border ");
        redRectangle.draw();
    }
}

