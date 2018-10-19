package colruyt.pcrsejb.dl;

import java.util.Collection;
import java.util.List;

public interface GenericCrudService<E,T> {
	
	
	public  void addElement(E element);
	public E getElement(T index);
	public Collection<E> getAllElements();
	public void deleteElement(E element);
	
	
	

}
