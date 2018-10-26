package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceBoConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceBoConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingBoConverter implements GenericConverter<Rating,RatingBo> {


    @Override
    public Rating convertTo(RatingBo from) {
        Rating rating = null;
        CompetenceBo competenceBo = from.getCompetenceBo();
        if (competenceBo instanceof CraftCompetenceBo) {
            CraftCompetenceBoConverter conv = new CraftCompetenceBoConverter();
            rating = new Rating(from.getLevel(), from.isEnergy(), conv.convertTo((CraftCompetenceBo) competenceBo));
        } else if (competenceBo instanceof BehavioralCompetenceBo) {
            BehavioralCompetenceBoConverter conv = new BehavioralCompetenceBoConverter();
            rating = new Rating(from.getLevel(), from.isEnergy(), conv.convertTo((BehavioralCompetenceBo) competenceBo));
        }
        return rating;
    }
}
