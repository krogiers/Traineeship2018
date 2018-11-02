package colruyt.pcrsejb.service.dl.team;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;

import java.util.ArrayList;
import java.util.Collection;

public class MemoryTeamService implements TeamService {

	private ArrayList<Team> db = new ArrayList<>();
	
	
	@Override
	public Team save(Team team) {

		team.setTeamID(db.size() + 1);
		db.add(team);
		return team;
	}

	@Override
	public Team getElement(Team team) {
		return this.db.get(team.getTeamID());
	}

	@Override
	public Collection<Team> getAllElements() {
		return this.db;
	}

	@Override
	public void deleteElement(Team team) {
		this.db.remove(team);
	}

	@Override
	public Team findTeamOfUser(User user) {
		Team returning = null;
		for (Team team : getAllElements()) {
			for (Enrolment enrolment : team.getEnrolmentsHashSet()) {
				if (enrolment.getUser() == user && enrolment.isActive()) {
					returning = team;
				}
			}
		}
		return returning;
		/*
		  try (Connection conn = this.createConnection();){
		
			String sql = "Select USERS.FIRSTNAME, USERS.LASTNAME\r\n" + 
	        		"from teamenrolments te\r\n" + 
	        		"join userprivileges u on te.userprivileges_id = u.ID\r\n" + 
	        		"join users on u.User_ID = users.ID\r\n" + 
	        		"where Privilege = 'T'\r\n" + 
	        		"AND te.team_id =  (     select team_id\r\n" + 
	        		"                        from teamenrolments t\r\n" + 
	        		"                        Join users on t.ID = users.ID\r\n" + 
	        		"                        where users.ID = ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, AppStarter.currentUser.getId());
	        ResultSet rs = ps.executeQuery();
	        System.out.println(rs);
	        if(rs.next()) {
	        	String fname = rs.getString(1);
	        	String lname = rs.getString(2);
	        	System.out.println(fname + " " + lname);
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

}
