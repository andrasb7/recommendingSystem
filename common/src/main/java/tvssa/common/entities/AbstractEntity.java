package tvssa.common.entities;

public abstract class AbstractEntity {
	
	public abstract Long getId();
	
	@Override
	public String toString() {
		return "[" + this.getClass() + "ID = " + this.getId() + "]";
	}
	
}
