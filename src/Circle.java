public class Circle {
    double radius;
    double area;
    String name;
    double pi = 3.14159;

    public Circle(double radius, String name)
    {
        this.radius = radius;
        this.area = pi * Math.pow(radius, 2);
        this.name = name;
    }
}
