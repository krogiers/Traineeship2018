package colruyt.pcrsejb.entity.survey;

import colruyt.pcrsejb.entity.competence.Competence;

import java.util.*;

/**
 The type Rating. */
public class Rating {

    private int level;
    private boolean energy;
    private Competence competence;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     Constructs a new Rating.
     */
    public Rating(){
    }
    
    
    /**
     Instantiates a new Rating.
     @param level the level
     @param energy the energy
     @param competence the competence
     */
    public Rating(int level, boolean energy, Competence competence){
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
        if(!(o instanceof Rating))
            return false;
        Rating rating = (Rating) o;
        return getLevel() == rating.getLevel() && isEnergy() == rating.isEnergy() && Objects.equals(getCompetence(), rating.getCompetence());
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode(){
        return Objects.hash(getLevel(), isEnergy(), getCompetence());
    }
    
    /** {@inheritDoc} */
    @Override
    public String toString(){
        return "Rating{" + "level=" + level + ", energy=" + energy + ", competence=" + competence + '}';
    }
}
