import java.util.ArrayList;

public class Main{
    static ArrayList<Circle> circles = new ArrayList<>();
    static ArrayList<Rectangle> rects = new ArrayList<>();
    

    public static void view_circle()
    {
        if (circles.isEmpty())
        {
            System.out.println("Circle List is Empty!");
            return;
        }
        for (Circle c : circles) {
            System.out.printf("| %s \t| %.1f   | %.1f |\n", c.name, c.radius, c.area);
        }
    }

    public static void view_rect()
    {
        if (rects.isEmpty())
        {
            System.out.println("Rectangle List is Empty!");
            return;
        }
        for (Rectangle r : rects) {
            System.out.printf("| %s \t| %.1f | %.1f | %.1f |\n", r.name, r.width, r.height, r.area);
        }
    }


    public static void view_rects_template()
    {
        System.out.println("Circle Library");
        System.out.println("=============================");
        System.out.println("| Name \t| Width | Height | Area \t|");
        System.out.println("=============================");
        view_rect();
        System.out.println("=============================");
    }

    public static void view_circle_template()
    {
        System.out.println("Circle Library");
        System.out.println("=============================");
        System.out.println("| Name \t| Radius | Area \t|");
        System.out.println("=============================");
        view_circle();
        System.out.println("=============================");
    }
    
    public static void view_menu_view()
    {
        System.out.println("Shape Library");
        System.out.println("==================");
        System.out.println("1. View Circle");
        System.out.println("2. View Rectangle");
        System.out.println("0. Exit");
    }
    
    public static void main_menu_view()
    {
        System.out.println("Shape Library");
        System.out.println("==================");
        System.out.println("1. View Library");
        System.out.println("2. Insert Shape");
        System.out.println("0. Exit");
    }


    public static void main(String[] args) {
        
    }
}