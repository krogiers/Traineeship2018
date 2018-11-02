package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.service.dl.DbService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

public class DbSurveySetService extends DbService implements SurveySetService {



    @Override
    public SurveySet save(SurveySet element) {
        try(Connection conn = this.createConnection()){


            PreparedStatement state = conn.prepareStatement("INSERT INTO SurveySet");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NotImplementedException();
    }

    @Override
    public SurveySet getElement(Integer index) {
        try(Connection conn = this.createConnection()){

            PreparedStatement state = conn.prepareStatement("select * from surveysets ss inner join surveys sy on ss.managersurvey = sy.id or ss.membersurvey = sy.id or ss.consensussurvey = sy.id where userprivileges_id = ?");
            ResultSet set = state.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

    @Override
    public Collection<SurveySet> getAllElements() {
        return null;
    }

    @Override
    public void deleteElement(SurveySet element) {

    }



    public SurveySet convertSingleSurveySet(ResultSet rs) throws SQLException {
        SurveySet surveySet = null;
        if(rs.next()) {
            surveySet = new SurveySet();
            surveySet.setSurveySetID(rs.getInt("ID"));
            surveySet.setSurveyYear( rs.getDate("Year").toLocalDate() );
            while (rs.next()) {


            }
        }
        return surveySet;

    }
}
