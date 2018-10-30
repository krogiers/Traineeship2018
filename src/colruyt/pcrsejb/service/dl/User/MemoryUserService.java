package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryUserService implements UserService {

    private List<User> db = new ArrayList<>();

    @Override
    public void addElement(User user) {
        db.add(user);

    }

    @Override
    public User getElement(Long index) {
        return this.db.get((index.intValue()));
    }

    @Override
    public List<User> getAllElements() {

        return this.db;
    }

    @Override
    public void deleteElement(User user) {
        this.db.remove(user);

    }

    @Override
    public List<User> findUsersByPrivilege(Privilege privilege){
        return this.db.stream().filter(x -> x.getPrivileges().contains(privilege)).collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByFirstName(String name) {
        return this.db.stream().filter(x-> x.getFirstName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<User> findUsersByShortName(String shortName) {
        return this.db.stream().filter(x -> (x.getFirstName().substring(0,2)
                + x.getLastName().substring(0,3)).equals(shortName)).collect(Collectors.toList());
    }


}
