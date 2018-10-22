package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.user.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryUserService implements AbstractUserService {

    private List<User> db = new ArrayList<>();

    @Override
    public void addElement(User user) {
        db.add(user);

    }

    @Override
    public User getElement(Long index) {
        return this.db.get((index.intValue()));
    }

    @Override
    public List<User> getAllElements() {

        return this.db;
    }

    @Override
    public void deleteElement(User user) {
        this.db.remove(user);

    }

    public Collection<User> findAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }


}
