package colruyt.pcrsejb.service.dl.role;

import colruyt.pcrsejb.entity.role.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryRoleService implements AbstractRoleService {

    private List<Role> roleList = new ArrayList<>();

    @Override
    public void addElement(Role element) {
        this.roleList.add(element);
    }

    @Override
    public Role getElement(Integer index) {
        return this.roleList.get(index.intValue());
    }

    @Override
    public Collection<Role> getAllElements() {
        return this.roleList;
    }

    @Override
    public void deleteElement(Role element) {
        this.deleteElement(element);
    }
}
