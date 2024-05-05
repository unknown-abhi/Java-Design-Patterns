package iterator_design_pattern;

import java.util.ArrayList;

public class UserManagement {

    private ArrayList<User> usersList = new ArrayList<>();

    public void addUser(User user) {
        usersList.add(user);
    }

    public void removeUser(User user) {
        usersList.remove(user);
    }

    public User getUser(int index) {
        return usersList.get(index);
    }

    public Iterator getIterator() {
        return new UserManagementImple(usersList);
    }
}
