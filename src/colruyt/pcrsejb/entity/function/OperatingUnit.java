package colruyt.pcrsejb.entity.function;

/**
 * Klasse voor het aanmaken van een OperatingUnit
 * @author jda1mbw
 */
public class OperatingUnit {

    private String name;

    /**
     * Constructor voor OperatingUnit
     * @param name
     */
	public OperatingUnit(String name) {
		setName(name);
	}

	
	/**
	 * Methode voor het opvragen van de naam van een OperatingUnit
	 * @return name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Methode voor het instellen van de naam van een OperatingUnit
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
