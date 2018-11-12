package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceBoConverter;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingBoConverter implements GenericConverter<Rating,RatingBo> {


    @Override
    public Rating convertTo(RatingBo from) {
        Rating rating = null;
        CompetenceBo competenceBo = from.getCompetenceBo();
        CompetenceBoConverter conv = new CompetenceBoConverter();
        if (competenceBo instanceof CraftCompetenceBo) {
            rating = new Rating(from.getLevel(), from.isEnergy(), conv.convertTo(competenceBo));
        } else if (competenceBo instanceof BehavioralCompetenceBo) {
            rating = new Rating(from.getLevel(), from.isEnergy(), conv.convertTo(competenceBo));
        }
        return rating;
    }
}
