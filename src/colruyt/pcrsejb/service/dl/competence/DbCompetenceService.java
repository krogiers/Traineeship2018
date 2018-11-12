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

public class DbCompetenceService extends DbService implements CompetenceService{

    private static final String GET_ELEMENT = "Select * from competences c join competencedescriptions cd on c.ID = competences_ID where c.ID = ?";
    private static final String GET_ALL_FUNCTION_COMPETENCES = "SELECT * FROM COMPETENCES C JOIN COMPETENCEDESCRIPTIONS CD ON C.ID = CD.COMPETENCES_ID  WHERE FUNCTIONS_ID = 1";
    private static final String GET_ALL_CRAFT_COMPETENCES = "SELECT * FROM COMPETENCES C JOIN COMPETENCEDESCRIPTIONS CD ON C.ID = CD.COMPETENCES_ID  WHERE FUNCTIONROLES_ID = 1";
    private static final String ADD_COMPETENCE = "INSERT into competences (id, functions_id, operatingunits_ID, Functionroles_ID, NAME) values ((select max(id) from competences)+1,?,?,?,?)";
    private static final String UPDATE_COMPETENCE = "INSERT into competences (id, functions_id, operatingunits_ID, Functionroles_ID, NAME) values ((select max(id) from competences)+1,?,?,?,?)";
    private static final String ADD_DESCRIPTION_TO_COMPETENCE = "INSERT INTO competenceDescriptions (ID, COMPETENCES_ID, DESCRIPTION) values ((select max(id) from competenceDescriptions)+1, ?, ?)";
    private static final String DELETE_COMPETENCE = "Delete from competences where id = ?";
    private static final String DELETE_COMPETENCE_DESCRIPTION = "Delete from competencedescriptions where competences_id = ?";


    @Override
    public Collection<Competence> findAllFunctionCompetences(){ return getCompetenceList(GET_ALL_FUNCTION_COMPETENCES); }

    @Override
    public Collection<Competence> findAllCraftCompetences() {
        return getCompetenceList(GET_ALL_CRAFT_COMPETENCES);
    }

    @Override
    public Competence save(Competence element) {
        try(Connection conn = this.createConnection()) {
            PreparedStatement statement;

            if(element.getCompetenceID() != null){
                statement = conn.prepareStatement(UPDATE_COMPETENCE, new String[] {"ID"});
            }
            else{
                statement = conn.prepareStatement(ADD_COMPETENCE, new String[] {"ID"});
            }
            if(element instanceof BehavioralCompetence){
                statement.setInt(1, 0); //Function competence
            }else if(element instanceof OperatingUnitCompetence){
                statement.setInt(2, 1); //Operating unit competence
            }else if(element instanceof CraftCompetence){
                statement.setInt(3, 1); //Craft competence
            }
            //else { DomainCompetence }

            statement.setString(4, element.getName());

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                element.setCompetenceID(rs.getInt("ID"));
            }
            if(element.getDescription() != null){
                statement = conn.prepareStatement(ADD_DESCRIPTION_TO_COMPETENCE, new String[] {"ID"});
                statement.setInt(1, element.getCompetenceID());
                statement.setString(2, element.getDescription());
                statement.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public Competence getElement(Competence competence) {
        try (Connection conn = this.createConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
            preparedStatement.setInt(1, competence.getCompetenceID());
            ResultSet rs = preparedStatement.executeQuery();
            competence = convertToSingleCompetence(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competence;
    }

    @Override
    public Collection<Competence> getAllElements() {
        List<Competence> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from COMPETENCES c join competencedescriptions cd on c.ID = cd.Competences_ID");

            ResultSet rs =  statement.executeQuery();
            users = convertToCompetenceList(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public Competence convertToSingleCompetence(ResultSet rs) throws SQLException {

        Competence competence = null;
        if(rs.next()){
            if(rs.getString("Funcions_ID") != null){
                competence = new BehavioralCompetence();
            }else if(rs.getString("OperatingUnits_ID") != null){
                competence = new OperatingUnitCompetence();
            }else if(rs.getString("Functionroles_ID") != null){
                competence = new CraftCompetence();
            }else{
                competence = new DomainCompetence();
            }

            competence.setCompetenceID(rs.getInt("ID"));
            competence.setName(rs.getString("NAME"));
            competence.setDescription("DESCRIPTION");
        }
        return competence;
    }

    private List<Competence> convertToCompetenceList(ResultSet rs) throws SQLException {

        List<Competence> user = new ArrayList<Competence>();
        while(rs.next()){
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String function = rs.getString("FUNCTIONS_ID");
            String operatingunit = rs.getString("OPERATINGUNITS_ID");
            String functionrol = rs.getString("FUNCTIONROLES_ID");
            String description = rs.getString("DESCRIPTION");
            Competence u;
            if(operatingunit != null){
                u = new OperatingUnitCompetence(id, name);
            }else if(function != null){
                u = new CraftCompetence(id, name, description);
            }else  if(functionrol != null){
                u = new BehavioralCompetence(id, name, description);
            }else{
                u = new DomainCompetence(id, name);
            }

            user.add(u);
        }
        return user;
    }

    @Override
    public void deleteElement(Competence element) {

        try(Connection conn = this.createConnection()){
            PreparedStatement statement;

            if(element.getDescription() != null) {
                statement = conn.prepareStatement(DELETE_COMPETENCE_DESCRIPTION);
                statement.setInt(1, element.getCompetenceID());
                statement.executeQuery();
            }
            statement =  conn.prepareStatement(DELETE_COMPETENCE);
            statement.setInt(1,element.getCompetenceID());
            statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Competence> getCompetenceList(String sql){
        List<Competence> competences = new ArrayList<>();
        try(Connection conn = this.createConnection()){
            PreparedStatement statement =  conn.prepareStatement(sql);

            ResultSet rs =  statement.executeQuery();
            competences = convertToCompetenceList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competences;
    }
}
