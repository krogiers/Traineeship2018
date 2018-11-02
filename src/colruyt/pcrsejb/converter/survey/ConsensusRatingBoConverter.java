package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.bo.survey.ConsensusRatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.*;
import colruyt.pcrsejb.entity.survey.ConsensusRating;

public class ConsensusRatingBoConverter implements GenericConverter<ConsensusRating,ConsensusRatingBo> {


    @Override
    public ConsensusRating convertTo(ConsensusRatingBo from) {
        ConsensusRating consensusRating = null;
        CompetenceBo competenceBo = from.getCompetenceBo();
        CompetenceBoConverter conv = new CompetenceBoConverter();
        if (competenceBo instanceof CraftCompetenceBo) {
            consensusRating = new ConsensusRating(from.getLevel(), from.isEnergy(),
                    conv.convertTo((CraftCompetenceBo) competenceBo), from.getComment());
        } else if (competenceBo instanceof BehavioralCompetenceBo) {
            consensusRating = new ConsensusRating(from.getLevel(), from.isEnergy(),
                    conv.convertTo((BehavioralCompetenceBo) competenceBo), from.getComment());
        }
        return consensusRating;
    }



}
