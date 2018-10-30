package colruyt.pcrsejb.service.dl;

import java.util.Collection;

public interface GenericCrudService<E,T> {
	
	
	public  void addElement(E element);
	public E getElement(T index);
	public Collection<E> getAllElements();
	public void deleteElement(E element);
	//public void updateElement(E element);
	
	
	

}
