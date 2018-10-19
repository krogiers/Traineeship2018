package colruyt.pcrsejb.entity.survey;

import colruyt.pcrsejb.entity.competence.*;

import java.util.*;

public class ConsensusRating extends Rating {

    private String comment;
    
    /** Constructs a new ConsensusRating. */
    public ConsensusRating(){
    }
    
    public ConsensusRating(String comment){
        this.comment = comment;
    }
    
    public ConsensusRating(int level, boolean energy, Competence competence, String comment){
        super(level, energy, competence);
        this.comment = comment;
    }
    
    /**
     * Getter for property 'comment'.
     *
     * @return Value for property 'comment'.
     */
    public String getComment(){
        return comment;
    }
    
    /**
     * Setter for property 'comment'.
     *
     * @param comment Value to set for property 'comment'.
     */
    public void setComment(String comment){
        this.comment = comment;
    }
    
    /** {@inheritDoc} */
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
    
    /** {@inheritDoc} */
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), getComment());
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString(){
        return "ConsensusRating{" + "comment='" + comment + '\'' + "} " + super.toString();
    }
}
