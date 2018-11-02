package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.*;
import colruyt.pcrsejb.service.dl.DbService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

            PreparedStatement state = conn.prepareStatement("select * from surveysets ss where ss.id = ?");
            ResultSet set = state.executeQuery();

          SurveySet surveySet =  this.convertSingleSurveySet(set);
          // Add surveys + Ratings
         surveySet =  this.upgradeSurveySet(surveySet);


            return surveySet;




        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NotImplementedException();
    }

    private SurveySet upgradeSurveySet(SurveySet set) throws SQLException {

        try(Connection conn = this.createConnection()) {

            //Get Member Survey Data
            PreparedStatement memberSurvey = conn.prepareStatement("select * from surveysets ss inner join surveys sy on ss.memberysurvey= sy.id inner join ratings where ss.id= ?");
            ResultSet ms = memberSurvey.executeQuery();
            Survey vey = toSingleSurvey(ms,new TeamMemberSurvey());

            //GetRatings
            PreparedStatement memberratings = conn.prepareStatement("select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?");
            memberratings.setInt(1,vey.getId());

            //AddRatings To Survey
            vey.setRatingList(getRatings( memberratings.executeQuery()));


            set.getSurveySet().add(vey);

            //Get manager Survey Data
            PreparedStatement managerSurvey = conn.prepareStatement("select * from surveysets ss inner join surveys sy on ss.managersurvey = sy.id  where ss.id= ?");
            ResultSet mas = managerSurvey.executeQuery();
            Survey manvey = toSingleSurvey(mas,new TeamManagerSurvey());



            PreparedStatement managerratings = conn.prepareStatement("select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?");
            memberratings.setInt(1,manvey.getId());

            manvey.setRatingList(getRatings( managerratings.executeQuery()));

            set.getSurveySet().add(manvey);


            //Get Consensus Survey Data
            PreparedStatement consensusSurvey = conn.prepareStatement("select * from surveysets ss inner join surveys sy on ss.consensusservey = sy.id  where ss.id= ?");
            ResultSet cs = consensusSurvey.executeQuery();
            Survey convey = toSingleSurvey(cs,new ConsensusSurvey());


            PreparedStatement consensusRating  = conn.prepareStatement("select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?");
            consensusRating.setInt(1,convey.getId());

            convey.setRatingList(getRatings(consensusRating.executeQuery()));

            set.getSurveySet().add(convey);
        }
        return set;
    }

    @Override
    public Collection<SurveySet> getAllElements() {
        return null;
    }

    @Override
    public void deleteElement(SurveySet element) {

    }

    private Survey toSingleSurvey(ResultSet rs,Survey e) throws SQLException {
        if(rs.next()){
            e.setId(rs.getInt("id"));
            e.setDateCompleted(rs.getDate("datecompleted").toLocalDate());
        }
        return e;

    }

    private List<Rating> getRatings(ResultSet set) throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        while(set.next()){
          int id =   set.getInt("id");
          boolean energy =  set.getBoolean("energy");
          String commentary =  set.getString("commentary");

          int level = set.getInt("rating");

            Rating rating;
          if(commentary == null || commentary.isEmpty()) {
              rating = new Rating();
          }
          else{
              rating = new ConsensusRating();
              ( (ConsensusRating) rating).setComment(commentary);
          }

          rating.setLevel(level);
          rating.setEnergy(energy);
          rating.setId(id);

        }

        return ratings;

    }





    public SurveySet convertSingleSurveySet(ResultSet rs) throws SQLException {
        SurveySet surveySet = null;
        if(rs.next()) {
            surveySet = new SurveySet();
            surveySet.setSurveySetID(rs.getInt("ID"));
            surveySet.setSurveyYear( rs.getDate("Year").toLocalDate() );

        }
        return surveySet;


    }




}
