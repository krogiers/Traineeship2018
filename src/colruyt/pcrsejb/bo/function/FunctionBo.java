package colruyt.pcrsejb.bo.function;

import colruyt.pcrsejb.bo.competence.FunctionCompetenceBo;
import colruyt.pcrsejb.bo.operatingunit.OperatingUnitBo;
import colruyt.pcrsejb.bo.role.RoleBo;

import java.util.HashSet;
import java.util.Set;

public class FunctionBo {

    private int ID;
    private String title;
    private Set<RoleBo> roleBoSet = new HashSet<>();
    private Set<FunctionCompetenceBo> functionCompetenceBoSet = new HashSet<>();
    private OperatingUnitBo operatingUnitBo;

    public FunctionBo() {
    }

    public FunctionBo(String title) {
        this.setTitle(title);
        this.roleBoSet = new HashSet<>();
        this.functionCompetenceBoSet = new HashSet<>();
    }

    public FunctionBo(String title, HashSet<RoleBo> roleBoSet, HashSet<FunctionCompetenceBo> functionCompetenceBoSet) {
        super();
        this.setTitle(title);
        this.setRoleBoSet(roleBoSet);
        this.setFunctionCompetenceBoSet(functionCompetenceBoSet);
    }

    public FunctionBo(int ID, String title, Set<RoleBo> roleBoSet, Set<FunctionCompetenceBo> functionCompetenceBoSet) {
        this.ID = ID;
        this.title = title;
        this.roleBoSet = roleBoSet;
        this.functionCompetenceBoSet = functionCompetenceBoSet;
    }

    public FunctionBo(int ID, String title, OperatingUnitBo operatingUnitBo) {
        this.ID = ID;
        this.title = title;
        this.operatingUnitBo = operatingUnitBo;
    }

    public FunctionBo(int ID, String title, Set<RoleBo> roleBoSet, Set<FunctionCompetenceBo> functionCompetenceBoSet, OperatingUnitBo operatingUnitBo) {
        this.ID = ID;
        this.title = title;
        this.roleBoSet = roleBoSet;
        this.functionCompetenceBoSet = functionCompetenceBoSet;
        this.operatingUnitBo = operatingUnitBo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<RoleBo> getRoleBoSet() {
        return roleBoSet;
    }

    public void setRoleBoSet(HashSet<RoleBo> roleSet) {
        this.roleBoSet = roleSet;
    }

    public Set<FunctionCompetenceBo> getFunctionCompetenceBoSet() {
        return functionCompetenceBoSet;
    }

    public void setFunctionCompetenceBoSet(HashSet<FunctionCompetenceBo> functionCompetenceBoSet) {
        this.functionCompetenceBoSet = functionCompetenceBoSet;
    }

    public OperatingUnitBo getOperatingUnitBo() {
        return operatingUnitBo;
    }

    public void setOperatingUnitBo(OperatingUnitBo operatingUnitBo) {
        this.operatingUnitBo = operatingUnitBo;
    }

    @Override
    public String toString() {
        return "FunctionBo [title=" + title + ", roleSet=" + roleBoSet + ", functionCompetenceSet=" + functionCompetenceBoSet
                + "]";
    }


}
