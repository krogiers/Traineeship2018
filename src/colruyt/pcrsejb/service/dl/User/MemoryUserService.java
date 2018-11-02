package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryUserService implements UserService {

    private static List<User> db = new ArrayList<>();


    @Override
    public User save(User user) {


        user.setId(db.size() + 1);
        db.add(user);
        return user;
    }

    @Override
    public User getElement(User user) {


        return this.db.get(user.getId());
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
        System.out.println(this.db);
        return this.db.stream().filter(x ->
            (x.getFirstName().toLowerCase().substring(0,2)
                    + x.getLastName().toLowerCase().substring(0,3)).equals(shortName)
            ).collect(Collectors.toList());
    }

    @Override
    public void addPrivilegesToUser(Privilege privi, User user) {

    }


}
