package colruyt.pcrsejb.bo.survey;

import colruyt.pcrsejb.entity.competence.Competence;

import java.util.Objects;

/**
 The type RatingBo. */
public class RatingBo {

    private int level;
    private boolean energy;
    private Competence competence;
    
    
    /**
     Constructs a new RatingBo.
     */
    public RatingBo(){
    }
    
    
    /**
     Instantiates a new RatingBo.
     @param level the level
     @param energy the energy
     @param competence the competence
     */
    public RatingBo(int level, boolean energy, Competence competence){
        setLevel(level);
        setEnergy(energy);
        setCompetence(competence);
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
    public Competence getCompetence(){
        return competence;
    }
    
    /**
     Setter for property 'competence'.
     @param competence Value to set for property 'competence'.
     */
    public void setCompetence(Competence competence){
        this.competence = competence;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof RatingBo))
            return false;
        RatingBo ratingBo = (RatingBo) o;
        return getLevel() == ratingBo.getLevel() && isEnergy() == ratingBo.isEnergy() && Objects.equals(getCompetence(), ratingBo.getCompetence());
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode(){
        return Objects.hash(getLevel(), isEnergy(), getCompetence());
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString(){
        return "RatingBo{" + "level=" + level + ", energy=" + energy + ", competence=" + competence + '}';
    }
}
