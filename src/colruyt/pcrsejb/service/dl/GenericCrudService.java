package colruyt.pcrsejb.service.dl;

import java.util.Collection;

public interface GenericCrudService<E,T> {
	
	
	public  E save(E element);
	public E getElement(E element);
	public Collection<E> getAllElements();
	public void deleteElement(E element);
	//public void updateElement(E element);
	
	
	

}
