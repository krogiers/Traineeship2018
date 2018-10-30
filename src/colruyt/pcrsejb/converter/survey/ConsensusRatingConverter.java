package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusRatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.survey.ConsensusRating;

public class ConsensusRatingConverter implements GenericConverter<ConsensusRatingBo,ConsensusRating> {

    @Override
    public ConsensusRatingBo convertTo(ConsensusRating from) {
        ConsensusRatingBo consensusRatingBo = null;
        Competence competence = from.getCompetence();
        if (competence instanceof CraftCompetence) {
            CraftCompetenceConverter conv = new CraftCompetenceConverter();
            consensusRatingBo = new ConsensusRatingBo(from.getLevel(), from.isEnergy(),
                    conv.convertTo((CraftCompetence) competence), from.getComment());
        } else if (competence instanceof BehavioralCompetence) {
            BehavioralCompetenceConverter conv = new BehavioralCompetenceConverter();
            consensusRatingBo = new ConsensusRatingBo(from.getLevel(), from.isEnergy(),
                    conv.convertTo((BehavioralCompetence) competence), from.getComment());
        }
        return consensusRatingBo;

    }



}