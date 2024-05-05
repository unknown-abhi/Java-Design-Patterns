package iterator_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class UserManagementImple implements Iterator {

    private List<User> list;
    private int length;
    private int index = 0;

    public UserManagementImple(ArrayList<User> usersList) {
        this.list = usersList;
        this.length = usersList.size();
    }

    @Override
    public boolean hasNext() {
        if (index >= length) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            User user = list.get(index);
            index++;
            return user;
        }
        return null;
    }
}
