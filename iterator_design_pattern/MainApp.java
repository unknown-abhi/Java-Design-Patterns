package iterator_design_pattern;

public class MainApp {

    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();

        userManagement.addUser(new User("101", "Abhi"));
        userManagement.addUser(new User("102", "Kumar"));
        userManagement.addUser(new User("103", "ABM"));

        Iterator iterator = userManagement.getIterator();

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            System.out.println(user.getUserId() + " " + user.getUserName());
        }
    }

} 
