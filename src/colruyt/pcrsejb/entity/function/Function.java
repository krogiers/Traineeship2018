package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.Set;

public class Function {

    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;
}
