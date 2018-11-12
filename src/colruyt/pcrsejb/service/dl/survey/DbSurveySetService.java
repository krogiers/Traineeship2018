package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.*;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DbSurveySetService extends DbService implements SurveySetService {
	
	private UserService userService = new DbUserService();

	private static final String FIND_USER_BY_SURVEY = "select * from users where ID = (select USER_ID from userprivileges where id =(SELECT userprivileges_id from surveysets s where S.MANAGERSURVEY = ? or S.MEMBERSURVEY = ? or S.CONSENSUSSURVEY = ?));";
	private static final String FIND_SURVEYS_BY_USER = "select * from surveySets s where id = (select USERPrivileges_ID from userprivileges where user_Id = ?)";
	private static final String FIND_SURVEYS_BY_USER_AND_YEAR = "select * from surveySets s where id = (select USERPrivileges_ID from userprivileges where user_Id = ?) and year = ?";
	private static final String FIND_USER_BY_ID = "select * from surveysets ss where ss.id = ?";
	private static final String GET_MEMBER_SURVEY_DATA = "select * from surveysets ss inner join surveys sy on ss.memberysurvey= sy.id inner join ratings where ss.id= ?";
	private static final String GET_RATING_BY_ID = "select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?";
	private static final String GET_MANAGER_SURVEY = "select * from surveysets ss inner join surveys sy on ss.managersurvey = sy.id  where ss.id= ?";
	private static final String GET_MANAGER_RATINGS = "select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?";
    private static final String GET_CONSENSUS_SURVEY = "select * from surveysets ss inner join surveys sy on ss.consensusservey = sy.id  where ss.id= ?";
	private static final String GET_CONSENSUS_RATINGS = "select id,surveys_id,energy,commentary,competences_id from surveysets ss inner join surveys sy on ss.membersurvey= sy.id inner join ratings r on sy.id = r.surveys_id where surveys_id = ?";

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
    public SurveySet getElement(SurveySet surveySet) {
        try(Connection conn = this.createConnection()){

            PreparedStatement state = conn.prepareStatement(FIND_USER_BY_ID);
            state.setInt(1,surveySet.getSurveySetID());
            ResultSet set = state.executeQuery();

            surveySet =  this.convertSingleSurveySet(set);
            // TODO Add surveys + Ratings
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
            PreparedStatement memberSurvey = conn.prepareStatement(GET_MEMBER_SURVEY_DATA);
            ResultSet ms = memberSurvey.executeQuery();
            Survey vey = toSingleSurvey(ms,new TeamMemberSurvey());

            //GetRatings
            PreparedStatement memberratings = conn.prepareStatement(GET_RATING_BY_ID);
            memberratings.setInt(1,vey.getId());

            //AddRatings To Survey
            vey.setRatingList(getRatings( memberratings.executeQuery()));


            set.getSurveySet().put(SurveyKind.TeamMember,vey);

            //Get manager Survey Data
            PreparedStatement managerSurvey = conn.prepareStatement(GET_MANAGER_SURVEY);
            ResultSet mas = managerSurvey.executeQuery();
            Survey manvey = toSingleSurvey(mas,new TeamManagerSurvey());



            PreparedStatement managerratings = conn.prepareStatement(GET_MANAGER_RATINGS);
            memberratings.setInt(1,manvey.getId());

            manvey.setRatingList(getRatings( managerratings.executeQuery()));

            set.getSurveySet().put(SurveyKind.TeamManager,manvey);


            //Get Consensus Survey Data
            PreparedStatement consensusSurvey = conn.prepareStatement(GET_CONSENSUS_SURVEY);
            ResultSet cs = consensusSurvey.executeQuery();
            Survey convey = toSingleSurvey(cs,new ConsensusSurvey());


            PreparedStatement consensusRating  = conn.prepareStatement(GET_CONSENSUS_RATINGS);
            consensusRating.setInt(1,convey.getId());

            convey.setRatingList(getRatings(consensusRating.executeQuery()));

            set.getSurveySet().put(SurveyKind.Consensus,convey);
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
    
    private List<SurveySet> convertToSurveySetList(ResultSet rs) throws SQLException {
    	List<SurveySet> surveySets = new ArrayList<SurveySet>();

        while(rs.next()){
            SurveySet surveySet = new SurveySet();
            surveySet.setSurveySetID(rs.getInt("id"));
            surveySets.add(getElement(surveySet));
        }
        return surveySets;
	}


    @Override
    public List<SurveySet> findSurveySetsByUser(User u) {
    	List<SurveySet> surveySets = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_SURVEYS_BY_USER);

            statement.setInt(1, u.getId());

            ResultSet rs =  statement.executeQuery();
            surveySets = convertToSurveySetList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return surveySets;
    }

	@Override
    public SurveySet findSurveySetsByUserAndDate(User u, LocalDate year) {
		SurveySet surveySet = null;
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_SURVEYS_BY_USER_AND_YEAR);
            statement.setInt(1, u.getId());
            statement.setDate(2, Date.valueOf(year));
            ResultSet rs =  statement.executeQuery();
            surveySet =  convertSingleSurveySet(rs);
           surveySet =  upgradeSurveySet(surveySet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return surveySet;
    }

	@Override
	public User findUserBySurvey(Survey survey) {
		User user = null;
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_USER_BY_SURVEY);

            statement.setInt(1,survey.getId());
            statement.setInt(2,survey.getId());
            statement.setInt(3,survey.getId());

            ResultSet rs =  statement.executeQuery();
            user = userService.convertToSingleUser(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
	}

	@Override
	public SurveySet findLastSurveySetForUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
