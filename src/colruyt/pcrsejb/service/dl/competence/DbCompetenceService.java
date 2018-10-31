package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.service.dl.DbService;

import java.util.Collection;

public class DbCompetenceService extends DbService implements CompetenceService{


    @Override
    public Collection<FunctionCompetence> findAllFunctionCompetences() {
        return null;
    }

    @Override
    public Collection<CraftCompetence> findAllCraftCompetences() {
        return null;
    }

    @Override
    public Competence addElement(Competence element) {
        return null;
    }

    @Override
    public Competence getElement(Integer index) {
        return null;
    }

    @Override
    public Collection<Competence> getAllElements() {
        return null;
    }

    @Override
    public void deleteElement(Competence element) {

    }
}
