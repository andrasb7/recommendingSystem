package tvssa.common.dao;

import tvssa.common.entities.AbstractEntity;

public interface DataAcessObject<E extends AbstractEntity> {
	
	public E create(final E entity);
	
	public void update(final E entity);
	
	public void delete(final E entity) ;
	
	public E findByID(Object id);

}
