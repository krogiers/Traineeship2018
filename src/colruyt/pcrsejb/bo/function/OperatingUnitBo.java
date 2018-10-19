package colruyt.pcrsejb.bo.function;

/**
 * Klasse voor het aanmaken van een OperatingUnitBo
 * 
 * @author jda1mbw
 */
public class OperatingUnitBo {

	private String name;

	/**
	 * Constructor voor OperatingUnitBo
	 * 
	 * @param name
	 */
	public OperatingUnitBo(String name) {
		setName(name);
	}

	/**
	 * Methode voor het opvragen van de naam van een OperatingUnitBo
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Methode voor het instellen van de naam van een OperatingUnitBo
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
