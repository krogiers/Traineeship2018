package colruyt.pcrsejb.entity.DONOTUSEANYMOREprivileges;

public abstract class Privilege {

    private int id;
    private boolean active;

    public Integer getId() {
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

    public Privilege(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Privilege(boolean active) {
        this.active = active;
    }

    public Privilege() {
    }
}
