package colruyt.pcrsejb.entity.survey;

import colruyt.pcrsejb.entity.competence.Competence;

import java.util.*;

public class Rating {

    private int level;
    private boolean energy;
    private Competence competence;
    
    
    public Rating(){
    }
    
    public Rating(int level, boolean energy, Competence competence){
        this.level = level;
        this.energy = energy;
        this.competence = competence;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
    public boolean isEnergy(){
        return energy;
    }
    
    public void setEnergy(boolean energy){
        this.energy = energy;
    }
    
    public Competence getCompetence(){
        return competence;
    }
    
    public void setCompetence(Competence competence){
        this.competence = competence;
    }
    
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Rating))
            return false;
        Rating rating = (Rating) o;
        return getLevel() == rating.getLevel() && isEnergy() == rating.isEnergy() && Objects.equals(getCompetence(), rating.getCompetence());
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(getLevel(), isEnergy(), getCompetence());
    }
    
    @Override
    public String toString(){
        return "Rating{" + "level=" + level + ", energy=" + energy + ", competence=" + competence + '}';
    }
}
