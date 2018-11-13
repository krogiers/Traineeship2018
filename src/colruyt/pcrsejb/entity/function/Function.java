package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class Function {

    private int id;
    private String title;
    private Set<Role> roleSet = new HashSet<>();
    private Set<FunctionCompetence> functionCompetenceSet = new HashSet<>();
    private OperatingUnit operatingUnit;

    public Function() {
    }

    public Function(Integer functionID, String title) {
        setId(functionID);
        setTitle(title);
        this.roleSet = new HashSet<>();
        this.functionCompetenceSet = new HashSet<>();
    }

    public Function(String title) {
        this.setTitle(title);
        this.roleSet = new HashSet<>();
        this.functionCompetenceSet = new HashSet<>();
    }

    public Function(Integer id, String title, OperatingUnit operatingUnit) {
        this.id = id;
        this.title = title;
        this.operatingUnit = operatingUnit;
    }

    public Function(String title, HashSet<Role> roleSet, HashSet<FunctionCompetence> functionCompetenceSet) {
        super();
        this.setTitle(title);
        this.setRoleSet(roleSet);
        this.setFunctionCompetenceSet(functionCompetenceSet);
    }

    public Function(Integer functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet) {
        this.id = functionID;
        this.title = title;
        this.roleSet = roleSet;
        this.functionCompetenceSet = functionCompetenceSet;
    }

    public Function(Integer id) {
        setId(id);
    }

    public Function(Integer id, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet, OperatingUnit operatingUnit) {
        this.id = id;
        this.title = title;
        this.roleSet = roleSet;
        this.functionCompetenceSet = functionCompetenceSet;
        this.operatingUnit = operatingUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer functionID) {
        this.id = functionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(HashSet<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Set<FunctionCompetence> getFunctionCompetenceSet() {
        return functionCompetenceSet;
    }

    public void setFunctionCompetenceSet(HashSet<FunctionCompetence> functionCompetenceSet) {
        this.functionCompetenceSet = functionCompetenceSet;
    }
    
    public OperatingUnit getOperatingUnit() {
        return operatingUnit;
    }

    public void setOperatingUnit(OperatingUnit operatingUnit) {
        this.operatingUnit = operatingUnit;
    }

    @Override
    public String toString() {
        return "Function [title=" + title + ", roleSet=" + roleSet + ", functionCompetenceSet=" + functionCompetenceSet
                + "]";
    }

}
