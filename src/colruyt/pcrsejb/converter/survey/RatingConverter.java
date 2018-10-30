package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingConverter implements GenericConverter<RatingBo,Rating> {


    @Override
    public RatingBo convertTo(Rating from) {
        RatingBo ratingBo = null;
        Competence competence = from.getCompetence();
        if (competence instanceof CraftCompetence) {
            CraftCompetenceConverter conv = new CraftCompetenceConverter();
            ratingBo = new RatingBo(from.getLevel(), from.isEnergy(), conv.convertTo((CraftCompetence) competence));
        } else if (competence instanceof BehavioralCompetence) {
            BehavioralCompetenceConverter conv = new BehavioralCompetenceConverter();
            ratingBo = new RatingBo(from.getLevel(), from.isEnergy(), conv.convertTo((BehavioralCompetence) competence));
        }
        return ratingBo;
    }
}
