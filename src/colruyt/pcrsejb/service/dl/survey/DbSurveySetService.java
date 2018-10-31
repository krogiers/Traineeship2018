package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.service.dl.DbService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class DbSurveySetService extends DbService implements SurveySetService {



    @Override
    public SurveySet addElement(SurveySet element) {
        try(Connection conn = this.createConnection()){

            PreparedStatement state = conn.prepareStatement("INSERT INTO SurveySet ");

            //TODO: Implemenet;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NotImplementedException();
    }

    @Override
    public SurveySet getElement(Integer index) {
        try(Connection conn = this.createConnection()){

            PreparedStatement state = conn.prepareStatement("Select * from SurveySet ");

            //TODO: Implemenet;


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
}
