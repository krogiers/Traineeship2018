package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.service.dl.competence.AbstractCraftCompetenceService;
import colruyt.pcrsejb.service.dl.competence.MemoryCraftCompetenceService;

import java.util.Collection;

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

    public void removeCraftCompetence(CraftCompetence craftCompetence) {
    }

    public void updateCraftCompetence(CraftCompetence craftCompetence) {
    }
}
