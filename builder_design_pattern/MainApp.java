package builder_design_pattern;

public class MainApp {
    public static void main(String[] args) {
        // Example usage of the Builder pattern for creating `User` instances.
        // Approach 1: instantiate the inner builder directly and chain setters,
        // then call `buildUser()` to get the immutable `User` object.
        User user = new User.InnerUserBuilder()
                .setUserId(4610)
                .setUserName("Abhishek")
                .setUserEmail("abhi@dev.in")
                .buildUser();

        // Print the created user (relies on User.toString() implementation).
        System.out.println(user);

        // Approach 2: use a convenience static factory method `userBuilder()`
        // which returns a pre-configured `InnerUserBuilder` instance. This
        // demonstrates that the builder can be obtained either by `new`
        // or via a static helper, both producing the same fluent API.
        User user2 = User.InnerUserBuilder.userBuilder()
                .setUserId(123)
                .setUserEmail("dev@dev.in")
                .setUserName("Dev")
                .buildUser();

        System.out.println(user2);
    }
}
