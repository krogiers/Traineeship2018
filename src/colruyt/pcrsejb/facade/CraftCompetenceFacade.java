package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.competence.*;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceBoConverter;
import colruyt.pcrsejb.entity.competence.*;
import colruyt.pcrsejb.service.bl.*;

import java.util.*;

/**
 The type Craft competence facade. */
public class CraftCompetenceFacade{
    //TODO
    
    private CraftCompetenceServiceBL CraftCompetenceServiceBL = new CraftCompetenceServiceBL();
    private CraftCompetenceBoConverter CraftCompetenceBoConverter = new CraftCompetenceBoConverter();
    private CraftCompetenceConverter CraftCompetenceConverter = new CraftCompetenceConverter();
    
    public void addCraftCompetence(CraftCompetenceBo newCraftCompetence) {
        CraftCompetenceServiceBL.addCraftCompetence(CraftCompetenceBoConverter
                .convertTo(newCraftCompetence));
    }
    
    public List<CraftCompetenceBo> getAllCraftCompetences() {
        List<CraftCompetenceBo> CraftCompetences = new ArrayList<>();
        for (CraftCompetence c : CraftCompetenceServiceBL.getAllCraftCompetences()) {
            CraftCompetences.add(CraftCompetenceConverter.convertTo(c));
        }
        return CraftCompetences;
    }

    public void removeCraftCompetenceByName(String user) {
        List<CraftCompetenceBo> CraftCompetences = getAllCraftCompetences();
        for(CraftCompetenceBo ccbo : CraftCompetences){
            if(ccbo.getName().equals(user)){
                CraftCompetences.remove(ccbo);
            }
        }
    }
}