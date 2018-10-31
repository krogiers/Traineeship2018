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
            String firstname = rs.getString("NAME");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            Competence u = null;


            user.add(u);
        }
        return user;
    }

    @Override
    public void deleteElement(Competence element) {

    }
}
