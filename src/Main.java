import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main{
    static ArrayList<Circle> circles = new ArrayList<>();
    static ArrayList<Rectangle> rects = new ArrayList<>();
    
    public static String getShapeName()
    {
        Scanner input = new Scanner(System.in);
        String name;
        do { 
            System.out.printf("Input Name [3-25 character(s)|exit]: ");
            name = input.nextLine();
        } while (name.length() < 3 || name.length() > 25);
        return name;
    }

    public static double getRadius()
    {
        Scanner input = new Scanner(System.in);
        double radius;
        do { 
            System.out.printf("Input Radius [1-100]: ");
            radius = input.nextDouble();
            input.nextLine();
        } while (radius < 1 || radius > 100);
        return radius;
    }


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
    
    public static void insert_menu_template()
    {
        System.out.println("Shape Library");
        System.out.println("==================");
        System.out.println("1. Insert Circle");
        System.out.println("2. Insert Rectangle");
        System.out.println("0. Exit");
    }

    public static void delete_shape_template()
    {
        System.out.println("Shape Library");
        System.out.println("==================");
        System.out.println("1. Delete Circle");
        System.out.println("2. Delete Rectangle");
        System.out.println("0. Exit");
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
        System.out.println("3. Remove Shape");
        System.out.println("0. Exit");
    }

    public static void view_rects_main()
    {
        Scanner input = new Scanner(System.in);
        if (rects.isEmpty())
        {
            System.out.println("No Rectangle data yet!");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        view_rects_template();
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }


    public static void view_circle_main()
    {
        Scanner input = new Scanner(System.in);
        if (circles.isEmpty())
        {
            System.out.println("No Circle data yet!");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        view_circle_template();
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }

    public static void view_shape_menu()
    {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int menuSelect;
        do { 
            view_menu_view();
            do { 
                System.out.printf("Choose >> ");
                menuSelect = input.nextInt();
                input.nextLine();
            } while (menuSelect < 0 || menuSelect > 2);
            switch (menuSelect) {
                case 1:
                    view_circle_main();
                    break;
                case 2:
                    view_rects_main();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (running);
    }

    public static void add_rect()
    {
        Scanner input = new Scanner(System.in);
        if (rects.size() > 25)
        {
            System.out.println("Max rectangles reached! Delete to add new ones!");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        String name = getShapeName();
        if (name.equals("exit")) return;
        double width = 0, height = 0;
        String[] parts;
        do { 
            System.out.printf("Input Size [WidthxHeight]: ");
            String userInput = input.nextLine();
            parts = userInput.split("x");
            if (parts.length == 2)
            {
                width = Double.parseDouble(parts[0].trim());
                height = Double.parseDouble(parts[1].trim());
            }
        } while (parts.length != 2);
        Rectangle r = new Rectangle(width, height, name);
        rects.add(r);
        System.out.printf("Rectangle %s has been inserted!\n", name);
        System.out.println("Press ENTER to continue...");
        input.nextLine();

    }

    public static void add_circle()
    {
        Scanner input = new Scanner(System.in);
        if (circles.size() > 25)
        {
            System.out.println("Max circles reached! Delete to add new ones!");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        String name = getShapeName();
        if (name.equals("exit")) return;
        double radius = getRadius();
        Circle c = new Circle(radius, name);
        circles.add(c);
        System.out.printf("Circle %s has been inserted\n", name);
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }

    public static void insert_shape_main()
    {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int menuSelect;
        do { 
            insert_menu_template();
            do { 
                System.out.printf("Choose >> ");
                menuSelect = input.nextInt();
                input.nextLine();
            } while (menuSelect < 0 || menuSelect > 2);
            switch (menuSelect) {
                case 1:
                    add_circle();
                    break;
                case 2:
                    add_rect();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (running);
    }

    public static void delete_rect()
    {
        Scanner input = new Scanner(System.in);
        if (rects.isEmpty())
        {
            System.out.println("No rectangles registered");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        Iterator<Rectangle> it = rects.iterator();
        view_rects_template();
        String name = getShapeName();
        while (it.hasNext())
        {
            Rectangle r = it.next();
            if (r.name.equals(name)) 
            {
                it.remove();
                System.out.printf("Rectangle %s successfully deleted!\n", name);
                System.out.println("Press ENTER to continue...");
                input.nextLine();
                return;
            }
        }
        System.out.println("Rectangle not found!");
        System.out.println("Press ENTER to continue...");
        input.nextLine();
        
    }


    public static void delete_circle()
    {
        Scanner input = new Scanner(System.in);
        if (circles.isEmpty())
        {
            System.out.println("No circles registered");
            System.out.println("Press ENTER to continue...");
            input.nextLine();
            return;
        }
        Iterator<Circle> it = circles.iterator();
        view_circle_template();
        String name = getShapeName();
        while (it.hasNext())
        {
            Circle c = it.next();
            if (c.name.equals(name))
            {
                it.remove();
                System.out.printf("Cirlce %s successfully deleted!\n", name);
                System.out.println("Press ENTER to continue...");
                input.nextLine();
                return;
            }
        }
        System.out.println("Circle not found!");
        System.out.println("Press ENTER to continue...");
        input.nextLine();
    }

    public static void delete_shape_main()
    {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int menuSelect;
        do { 
            delete_shape_template();
            do { 
                System.out.printf("Choose >> ");
                menuSelect = input.nextInt();
                input.nextLine();
            } while (menuSelect < 0 || menuSelect > 2);
            switch (menuSelect) {
                case 1:
                    delete_circle();
                    break;
                case 2:
                    delete_rect();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (running);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int menuSelect;
        do { 
            main_menu_view();
            do { 
                System.out.printf("Choose >> ");
                menuSelect = input.nextInt();
                input.nextLine();
            } while (menuSelect < 0 || menuSelect > 3);
            switch (menuSelect) {
                case 1:
                    view_shape_menu();
                    break;
                case 2:
                    insert_shape_main();
                    break;
                case 3:
                    delete_shape_main();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    throw new AssertionError();
            }
        } while (running);

    }
}