package builder_design_pattern;

public class User {

    private final int userId;
    private final String userName;
    private final String userEmail;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userEmail = builder.userEmail;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
    }

    public static class Builder {
        private int userId;
        private String userName;
        private String userEmail;

        public static Builder useBuilder() {
            return new Builder();
        }

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}