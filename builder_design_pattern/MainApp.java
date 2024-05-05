package builder_design_pattern;

public class MainApp {
    public static void main(String[] args) {

        User user = new User.InnerUserBuilder()
                .setUserId(4610)
                .setUserName("Abhishek")
                .setUserEmail("abhi@dev.in")
                .buildUser();

        System.out.println(user);

        User user2 = User.InnerUserBuilder.userBuilder()
                .setUserId(123)
                .setUserEmail("dev@dev.in")
                .setUserName("Dev")
                .buildUser();

        System.out.println(user2);
    }
}
