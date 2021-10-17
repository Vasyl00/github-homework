public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        print(args[0]);
        int count = Integer.valueOf(args[1]);
        mas_print(args[0], count);
    }

    public static void print(String input_line) {
        System.out.println(input_line);
    }

    public static void mas_print(String input_line, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(input_line);
        }
    }
}
