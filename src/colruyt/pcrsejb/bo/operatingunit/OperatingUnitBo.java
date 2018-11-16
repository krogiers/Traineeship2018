package colruyt.pcrsejb.bo.operatingunit;

import java.util.HashSet;

import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;

public class OperatingUnitBo {

    private int operatingUnitId;
    private String operatingUnitName;
	private HashSet<OperatingUnitCompetence> operatingUnitCompetences;

    public OperatingUnitBo(int operatingUnitId, String operatingUnitName) {
        this.operatingUnitId = operatingUnitId;
        this.operatingUnitName = operatingUnitName;
    }

    public int getOperatingUnitId() {
        return operatingUnitId;
    }

    public void setOperatingUnitId(int operatingUnitId) {
        this.operatingUnitId = operatingUnitId;
    }

    public String getOperatingUnitName() {
        return operatingUnitName;
    }

    public void setOperatingUnitName(String operatingUnitName) {
        this.operatingUnitName = operatingUnitName;
    }
}
