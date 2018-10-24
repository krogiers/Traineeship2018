package colruyt.pcrsejb.bo.survey;

import colruyt.pcrsejb.entity.competence.Competence;

import java.util.Objects;

/**
 The type Consensus rating. */
public class ConsensusRatingBo extends RatingBo {

    private String comment;
    
    /**
     Instantiates a new Consensus rating.
     */
    public ConsensusRatingBo(){
    }
    
    /**
     Instantiates a new Consensus rating.
     @param comment the comment
     */
    public ConsensusRatingBo(String comment){
        this.comment = comment;
    }
    
    /**
     Instantiates a new Consensus rating.
     @param level the level
     @param energy the energy
     @param competence the competence
     @param comment the comment
     */
    public ConsensusRatingBo(int level, boolean energy, Competence competence, String comment){
        super(level, energy, competence);
        this.comment = comment;
    }
    
    /**
     Get comment string.
     @return the string
     */
    public String getComment(){
        return comment;
    }
    
    /**
     Set comment.
     @param comment the comment
     */
    public void setComment(String comment){
        this.comment = comment;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof ConsensusRatingBo))
            return false;
        if(!super.equals(o))
            return false;
        ConsensusRatingBo that = (ConsensusRatingBo) o;
        return Objects.equals(getComment(), that.getComment());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), getComment());
    }
    
    @Override
    public String toString(){
        return "ConsensusRatingBoBo{" + "comment='" + comment + '\'' + "} " + super.toString();
    }
}
