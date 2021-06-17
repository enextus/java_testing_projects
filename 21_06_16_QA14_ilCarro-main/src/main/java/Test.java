class Main {

    public static void main(String[] args) {

        Object obj;
        obj = "10";

        printClassName(obj);
    }

    public static void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                " is " + obj.getClass().getName());

        System.out.println("\n");

        System.out.println("The name of class Main is: " + Main.class.getName());
        System.out.println("The name of class Main is: " + Main.class.getClasses());
    }

}
