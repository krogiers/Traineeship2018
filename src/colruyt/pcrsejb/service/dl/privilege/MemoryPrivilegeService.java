package colruyt.pcrsejb.service.dl.privilege;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import colruyt.pcrsejb.entity.privileges.Privilege;

public class MemoryPrivilegeService implements AbstractPrivilegeService {


    private List<Privilege> privilegeList = new ArrayList<>();

    @Override
    public void addElement(Privilege element) {
        this.privilegeList.add(element);
    }

    @Override
    public Privilege getElement(Long index) {
        return this.privilegeList.get(index.intValue());
    }

    @Override
    public Collection<Privilege> getAllElements() {
        return this.privilegeList;
    }

    @Override
    public void deleteElement(Privilege element) {
        this.privilegeList.remove(element);
    }
}
