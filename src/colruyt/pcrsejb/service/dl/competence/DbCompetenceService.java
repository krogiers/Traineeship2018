package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;

import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DbCompetenceService extends DbService implements CompetenceService{


    @Override
    public Collection<FunctionCompetence> findAllFunctionCompetences()
    {
    	return null;
    }

    @Override
    public Collection<CraftCompetence> findAllCraftCompetences() {
        return null;
    }

    @Override
    public Competence addElement(Competence element) {
        return null;
    }

    @Override
    public Competence getElement(Integer index) {
        return null;
    }

    @Override
    public Collection<Competence> getAllElements() {
        //TODO: afwerken
    	List<Competence> competences = new ArrayList<>(); 
        try(Connection conn = this.createConnection())
        {
        	PreparedStatement statement = conn.prepareStatement("Select * from competences");
        	ResultSet rs = statement.executeQuery();
        	//competences = rs.convertToCompetenceList();
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
        return null;
    }

    
    private List<Competence> convertToCompetenceList(ResultSet rs)
    {
    	//TODO
    	return null;
    	
    }
    @Override
    public void deleteElement(Competence element) {

    }
}
