package colruyt.pcrsejb.entity.survey;

import colruyt.pcrsejb.entity.competence.*;

import java.util.*;

/**
 The type Consensus rating. */
public class ConsensusRating extends Rating {

    private String comment;
    
    /**
     Instantiates a new Consensus rating.
     */
    public ConsensusRating(){
    }
    
    /**
     Instantiates a new Consensus rating.
     @param comment the comment
     */
    public ConsensusRating(String comment){
        this.comment = comment;
    }
    
    /**
     Instantiates a new Consensus rating.
     @param level the level
     @param energy the energy
     @param competence the competence
     @param comment the comment
     */
    public ConsensusRating(int level, boolean energy, Competence competence, String comment){
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
        if(!(o instanceof ConsensusRating))
            return false;
        if(!super.equals(o))
            return false;
        ConsensusRating that = (ConsensusRating) o;
        return Objects.equals(getComment(), that.getComment());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), getComment());
    }
    
    @Override
    public String toString(){
        return "ConsensusRating{" + "comment='" + comment + '\'' + "} " + super.toString();
    }
}
