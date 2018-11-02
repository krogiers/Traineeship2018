package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.*;

import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Db competence service.
 */
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
    public Competence save(Competence element) {
        return null;
    }

    @Override
    public Competence getElement(Integer index) {
        return null;
    }

    @Override
    public Collection<Competence> getAllElements() {
        List<Competence> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from COMPETENCES");

            ResultSet rs =  statement.executeQuery();
            users = convertToCompetenceList(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    private List<Competence> convertToCompetenceList(ResultSet rs) throws SQLException {

        List<Competence> user = new ArrayList<Competence>();
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String function = rs.getString("FUNCTIONS_ID");
            String operatingunit = rs.getString("OPERATINGUNITS_ID");
            String functionrol = rs.getString("FUNCTIONROLES_ID");
            Competence u;
            if(operatingunit != null){
                u = new OperatingUnitCompetence(id, name);
            }else if(function != null){
                u = new CraftCompetence(id, name);
            }else  if(functionrol != null){
                u = new BehavioralCompetence(id, name);
            }else{
                u = new DomainCompetence(id, name);
            }

            user.add(u);
        }
        return user;
    }

    @Override
    public void deleteElement(Competence element) {

    }
}
