package colruyt.pcrsejb.bo.privileges;

public class AdminPrivilegeBo extends PrivilegeBo {


	public AdminPrivilegeBo() {
		super();
		setId(5);
	}

	public AdminPrivilegeBo(int id, boolean active) {
		super(id, active);
		setId(id);
	}
}
