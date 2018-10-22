package colruyt.pcrsejb.service.dl;

import colruyt.pcrsejb.service.dl.competence.AbstractCompetenceService;

import java.util.Collection;
import java.util.List;

public class GenericListService<T> implements GenericCrudService<T,Long> {

    private List<T> lijst;

    @Override
    public void addElement(T element) {
        lijst.add(element);
    }

    @Override
    public T getElement(Long index) {
        return lijst.get(index.intValue());
    }

    @Override
    public Collection<T> getAllElements() {
        return lijst;
    }

    @Override
    public void deleteElement(T element) {
        this.lijst.remove(element);

    }
}
