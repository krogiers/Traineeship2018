package colruyt.pcrsejb.service.dl.role;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class MemoryRoleService implements RoleService {

    private static List<Role> roleList = new ArrayList<>();

    @Override
    public Role save(Role element) {

        element.setId(roleList.size() + 1);
        this.roleList.add(element);
        return element;
    }

    @Override
    public Role getElement(Role role) {
        return this.roleList.get(role.getId());
    }

    @Override
    public Collection<Role> getAllElements() {
        return this.roleList;
    }

    @Override
    public void deleteElement(Role element) {
        this.deleteElement(element);
    }

    @Override
    public HashSet<Role> getAllRolesForFunction(Function function) {
        return null;
    }
}
