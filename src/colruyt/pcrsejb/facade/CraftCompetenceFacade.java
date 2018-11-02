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
    
    private CraftCompetenceServiceBL craftCompetenceServiceBL = new CraftCompetenceServiceBL();
    private CraftCompetenceBoConverter craftCompetenceBoConverter = new CraftCompetenceBoConverter();
    private CraftCompetenceConverter craftCompetenceConverter = new CraftCompetenceConverter();
    
    public void addCraftCompetence(CraftCompetenceBo newCraftCompetence) {
        craftCompetenceServiceBL.addCraftCompetence(craftCompetenceBoConverter
                .convertTo(newCraftCompetence));
    }
    
    public List<CompetenceBo> getAllCraftCompetences() {
        ArrayList<CompetenceBo> craftCompetences = new ArrayList<>();
        for (CraftCompetence c : craftCompetenceServiceBL.getAllCraftCompetences()) {
            craftCompetences.add(craftCompetenceConverter.convertTo(c));
        }
        return craftCompetences;
    }

    public void removeCraftCompetenceByName(CraftCompetenceBo craftCompetence) {
        craftCompetenceServiceBL.removeCraftCompetence(craftCompetenceBoConverter.convertTo(craftCompetence));

    }

    public void updateCraftCompetence(CraftCompetenceBo craftCompetence){
        craftCompetenceServiceBL.updateCraftCompetence(craftCompetenceBoConverter.convertTo(craftCompetence));
    }
}
