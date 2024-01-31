public class Colors {
    public static String red() {
        return "\u001B[31m";
    }

    public static String green() {
        return "\u001B[32m";
    }

    public static String yellow() {
        return "\u001B[33m";
    }

    public static String blue() {
        return "\u001B[34m";
    }

    public static String magenta() {
        return "\u001B[35m";
    }

    public static String cyan() {
        return "\u001B[36m";
    }

    public static String reset() {
        return "\u001B[0m";
    }

    public static void testColors() {
        System.out.println("Testing colors for text.");
        System.out.println(red() + "This text is red." + reset());
        System.out.println(green() + "This text is green." + reset());
        System.out.println(yellow() + "This text is yellow." + reset());
        System.out.println(blue() + "This text is blue." + reset());
        System.out.println(magenta() + "This text is magenta." + reset());
        System.out.println(cyan() + "This text is cyan." + reset());
    }
}
