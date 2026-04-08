package builder_design_pattern;

public class MainApp {
    public static void main(String[] args) {

        User user = new User.Builder()
                .userId(4610)
                .userName("Abhishek")
                .userEmail("abhi@dev.in")
                .build();

        System.out.println(user);

        User user2 = User.Builder.useBuilder()
                .userId(123)
                .userName("Dev")
                .userEmail("dev@dev.in")
                .build();

        System.out.println(user2);
    }
}