package builder_design_pattern;

public class User {

    private final int userId;
    private final String userName;
    private final String userEmail;

    private User(InnerUserBuilder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userEmail = builder.userEmail;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public String toString() {
        return "User [userId=" + this.userId + ", userName=" + this.userName + ", userEmail=" + this.userEmail + "]";
    }

    // inner class to create object
    static class InnerUserBuilder {
        private int userId;
        private String userName;
        private String userEmail;

        // public InnerUserBuilder() {
        // }

        public static InnerUserBuilder userBuilder() {
            return new InnerUserBuilder();
        }

        // setters
        public InnerUserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public InnerUserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public InnerUserBuilder setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public User buildUser() {
            User user = new User(this);
            return user;
        }

    }

}
