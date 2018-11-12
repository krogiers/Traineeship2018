package colruyt.pcrsejb.service.dl;

import java.util.Collection;

public interface GenericCrudService<E,T> {
	
	
	E save(E element);
	E getElement(E element);
	Collection<E> getAllElements();
	void deleteElement(E element);
	//public void updateElement(E element);
	
	
	

}
