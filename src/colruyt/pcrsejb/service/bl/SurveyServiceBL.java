package colruyt.pcrsejb.service.bl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.DomainCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.competence.LeveledCompetence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;
import colruyt.pcrsejb.entity.competence.RoleCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.entity.survey.ConsensusRating;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveyKind;
import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.entity.survey.TeamManagerSurvey;
import colruyt.pcrsejb.entity.survey.TeamMemberSurvey;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.rating.RatingService;
import colruyt.pcrsejb.service.dl.survey.MemorySurveySetService;
import colruyt.pcrsejb.service.dl.survey.SurveySetService;

public class SurveyServiceBL {

    private SurveySetService surveyService = new MemorySurveySetService();
    private TeamServiceBL teamService =  new TeamServiceBL();
    private UserServiceBL userService = new UserServiceBL();
    private RatingService ratingService;

    public List<SurveySet> findSurveySetsByUser(User u){

            return surveyService.findSurveySetsByUser(u);

    }

    public SurveySet findSurveySetsByUserAndYear(User u , LocalDate year){
        return surveyService.findSurveySetsByUserAndDate(u,year);
    }

    public SurveySet save(SurveySet toSave){
        //TOdo:Validate ?? wat is een geldige Survey

          return surveyService.save(toSave);
    }


    public void notifyTeamManager(){

        //Todo: Event ???
    }
    
    
    public SurveySet createSurveySetFor(User user) {
    	
    	//Get Team of user
    	Team team = teamService.getTeam(user);
    	//Get TeamManager of User
    	User teamManager = teamService.getOwnerOfTeam(team);
    	
    	//Get Ratings For Functie .... 
    	Function func = this.userService.getFunctionForPerson(user);
    	
    	List<Rating> rat = getRatings(func);

    	SurveySet set = new SurveySet();
    	
    	Survey member = new TeamMemberSurvey();
    	member.setRatingList(rat);
    	
    	Survey manager = new TeamManagerSurvey();
    	manager.setRatingList(rat);
    	
    	Survey consensus = new ConsensusSurvey();
    	consensus.setRatingList(this.getConsensusRatings(func));
    	
    	set.getSurveySet().put(SurveyKind.TeamMember, member);
    	
    	set.getSurveySet().put(SurveyKind.TeamManager, manager);
    	
    	set.getSurveySet().put(SurveyKind.Consensus, consensus );
	   
    	
    	return set;
    	
    }
    
    private List<Rating> getConsensusRatings(Function func){
    	List<Rating> rat = new ArrayList<Rating>();
        	
        	//Add Alle Competences 
    	   for(FunctionCompetence fucomp :  func.getFunctionCompetenceSet()) {
    		   
    		   if(fucomp instanceof LeveledCompetence) {
    			   LeveledCompetence lc = (LeveledCompetence) fucomp;
    			   
    			   rat.add(new ConsensusRating(lc.getMinLevel(),false,(Competence)lc,""));
    			   
    			   
    		   }
    		   
    		 
    		   
    	   }
        
    	   //Competences Voor Rollen
    	   for(Role rol: func.getRoleSet()) {
    		   for(RoleCompetence rolecomp : rol.getRoleCompetenceList()) {
    			   
    			   rat.add(new ConsensusRating(0,false,(Competence)rolecomp,""));
    			   
    		   }
    			   
    		   
    	    }
    	   
    	   //DomainCompetences
    	   for(DomainCompetence domcomp : this.ratingService.getAllDomainCompetences()) {
    		   
    		   
    		   rat.add(new ConsensusRating(0,false,(Competence)domcomp,""));
    		   
    	   }
    	   
    	 //DomainCompetences
    	   for(OperatingUnitCompetence oucomp : this.ratingService.getAllOperatingUnitCompetencesFor(func.getOperatingUnit())) {
    		   
    		   
    		   rat.add(new ConsensusRating(0,false,(Competence)oucomp,""));
    		   
    	   }
    	   return rat;
        	
        }
    
    private List<Rating> getRatings(Function func ){
	List<Rating> rat = new ArrayList<Rating>();
    	
    	//Add Alle Competences 
	   for(FunctionCompetence fucomp :  func.getFunctionCompetenceSet()) {
		   
		   if(fucomp instanceof LeveledCompetence) {
			   LeveledCompetence lc = (LeveledCompetence) fucomp;
			   
			   rat.add(new Rating(lc.getMinLevel(),false,(Competence)lc));
			   
			   
		   }
		   
		 
		   
	   }
    
	   //Competences Voor Rollen
	   for(Role rol: func.getRoleSet()) {
		   for(RoleCompetence rolecomp : rol.getRoleCompetenceList()) {
			   
			   rat.add(new Rating(0,false,(Competence)rolecomp));
			   
		   }
			   
		   
	    }
	   
	   //DomainCompetences
	   for(DomainCompetence domcomp : this.ratingService.getAllDomainCompetences()) {
		   
		   
		   rat.add(new Rating(0,false,(Competence)domcomp));
		   
	   }
	   
	 //DomainCompetences
	   for(OperatingUnitCompetence oucomp : this.ratingService.getAllOperatingUnitCompetencesFor(func.getOperatingUnit())) {
		   
		   
		   rat.add(new Rating(0,false,(Competence)oucomp));
		   
	   }
	   return rat;
    	
    }
    

	public User findUserBySurvey(Survey survey) {
		return surveyService.findUserBySurvey(survey);
	}

	public SurveySet getLastSurveySetForUser(User user) {
		return surveyService.findLastSurveySetForUser(user);
	}






}
