package colruyt.pcrsejb.bo.privileges;

public abstract class PrivilegeBo {

    private int id,privilegeId;
    private boolean active;

    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public PrivilegeBo(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public PrivilegeBo() {
    }

    public PrivilegeBo(boolean active) {
        this.active = active;
    }
}
