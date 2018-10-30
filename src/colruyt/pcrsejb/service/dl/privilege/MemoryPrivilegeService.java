package colruyt.pcrsejb.service.dl.privilege;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



//TODO: DELETE DEZE KLASSSEEEEEEEE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
public class MemoryPrivilegeService implements PrivilegeService {


    private List<Privilege> privilegeList = new ArrayList<>();

    @Override
    public Privilege addElement(Privilege element) {
        this.privilegeList.add(element);
        return element;
    }

    @Override
    public Privilege getElement(Integer index) {
        return this.privilegeList.get(index);
    }

    @Override
    public Collection<Privilege> getAllElements() {
        return this.privilegeList;
    }

    @Override
    public void deleteElement(Privilege element) {
        this.privilegeList.remove(element);
    }

    @Override
    public List<Privilege> findPrivilegesForUser(User u) {
        return null;
    }

    @Override
    public void addPrivilegesToUser(Privilege privi, User user) {

    }
}
