package colruyt.pcrsejb.bo.survey;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.entity.competence.Competence;

import java.util.Objects;

/**
 The type RatingBo. */
public class RatingBo {

    private int level;
    private boolean energy;
    private CompetenceBo competenceBo;
    
    
    /**
     Constructs a new RatingBo.
     */
    public RatingBo(){
    }
    
    
    /**
     Instantiates a new RatingBo.
     @param level the level
     @param energy the energy
     @param competenceBo the competence
     */
    public RatingBo(int level, boolean energy, CompetenceBo competenceBo){
        setLevel(level);
        setEnergy(energy);
        setCompetenceBo(competenceBo);
    }
    
    /**
     Getter for property 'level'.
     @return Value for property 'level'.
     */
    public int getLevel(){
        return level;
    }
    
    /**
     Setter for property 'level'.
     @param level Value to set for property 'level'.
     */
    public void setLevel(int level){
        this.level = level;
    }
    
    /**
     Getter for property 'energy'.
     @return Value for property 'energy'.
     */
    public boolean isEnergy(){
        return energy;
    }
    
    /**
     Setter for property 'energy'.
     @param energy Value to set for property 'energy'.
     */
    public void setEnergy(boolean energy){
        this.energy = energy;
    }
    
    /**
     Getter for property 'competence'.
     @return Value for property 'competence'.
     */
    public CompetenceBo getCompetenceBo(){
        return competenceBo;
    }
    
    /**
     Setter for property 'competence'.
     @param competenceBo Value to set for property 'competence'.
     */
    public void setCompetenceBo(CompetenceBo competenceBo){
        this.competenceBo = competenceBo;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof RatingBo))
            return false;
        RatingBo ratingBo = (RatingBo) o;
        return getLevel() == ratingBo.getLevel() && isEnergy() == ratingBo.isEnergy() && Objects.equals(getCompetenceBo(),
                ratingBo.getCompetenceBo());
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode(){
        return Objects.hash(getLevel(), isEnergy(), getCompetenceBo());
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString(){
        return "RatingBo{" + "level=" + level + ", energy=" + energy + ", competence=" + competenceBo + '}';
    }
}
