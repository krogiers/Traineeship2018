package colruyt.pcrsejb;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.service.dl.competence.CompetenceService;
import colruyt.pcrsejb.service.dl.competence.DbCompetenceService;
import colruyt.pcrsejb.converter.competence.CompetenceBoConverter;

public class Main {

    public static void main(String[] args) {
        GenericConverter converter = new CompetenceBoConverter();
        CompetenceBo competenceBo = new CraftCompetenceBo();

        CompetenceService competenceFacade = new DbCompetenceService();

        competenceFacade.save((Competence)converter.convertTo(competenceBo));


    }
}