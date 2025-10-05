public class Rectangle {
    double width;
    double height;
    double area;
    String name;

    public Rectangle(double width, double height, double area, String name)
    {
        this.width = width;
        this.height = height;
        this.area = width * height;
        this.name = name;
    }
}
