package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusRatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.survey.ConsensusRating;

public class ConsensusRatingConverter implements GenericConverter<ConsensusRatingBo,ConsensusRating> {

    @Override
    public ConsensusRatingBo convertTo(ConsensusRating from) {
        ConsensusRatingBo consensusRatingBo = null;
        Competence competence = from.getCompetence();
        CompetenceConverter conv = new CompetenceConverter();
        if (competence instanceof CraftCompetence) {
            consensusRatingBo = new ConsensusRatingBo(from.getLevel(), from.isEnergy(),
                    conv.convertTo(competence), from.getComment());
        } else if (competence instanceof BehavioralCompetence) {
            consensusRatingBo = new ConsensusRatingBo(from.getLevel(), from.isEnergy(),
                    conv.convertTo(competence), from.getComment());
        }
        return consensusRatingBo;

    }



}