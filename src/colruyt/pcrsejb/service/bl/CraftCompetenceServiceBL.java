package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.competence.*;
import colruyt.pcrsejb.service.dl.competence.*;
import colruyt.pcrsejb.entity.competence.CraftCompetence;

import java.util.*;

public class CraftCompetenceServiceBL{
    private AbstractCraftCompetenceService craftCompetencedb = new MemoryCraftCompetenceService();
    public void addCraftCompetence(Competence convertTo){
        if(convertTo instanceof CraftCompetence) {
            craftCompetencedb.addElement((CraftCompetence) convertTo);
        }
    }
    
    public Collection<CraftCompetence> getAllCraftCompetences(){
        return craftCompetencedb.getAllElements();
    }
}
