package colruyt.pcrsejb.util.validators.team;

import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.exceptions.validation.team.TeamHasMoreThanOneManagerException;
import colruyt.pcrsejb.util.exceptions.validation.team.TeamHasNoCurrentManagerException;
import colruyt.pcrsejb.util.validators.GenericValidator;

public class TeamValidator implements GenericValidator<Team> {


    @Override
    public void validate(Team toValidate) throws ValidationException {

        try {
            this.CheckTeamManagerCount(toValidate);
        } catch (TeamHasMoreThanOneManagerException e) {
            throw new ValidationException(e);
        } catch (TeamHasNoCurrentManagerException e) {
           throw new ValidationException(e);
        }

    }

    public void CheckTeamManagerCount(Team team) throws TeamHasMoreThanOneManagerException, TeamHasNoCurrentManagerException {

        long amount = team.getEnrolmentsHashSet().stream().filter(x-> x.getPrivilege() instanceof TeamManagerPrivilege && x.isActive()).count();

        if(amount > 1){
            throw new TeamHasMoreThanOneManagerException();

        }
        else if(amount == 0){

            throw new TeamHasNoCurrentManagerException();
        }

    }


}
