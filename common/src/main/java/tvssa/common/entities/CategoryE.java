package tvssa.common.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity(name ="Category")
@Table(name ="CATEGORY")
@NamedQueries({ @NamedQuery(name = CategoryE.FIND_BY_ID, query = "select c from Category c where c.Id = :id"),
	@NamedQuery(name = CategoryE.FIND_BY_NAME, query = "select c from Category c where c.name = :name") })
public class CategoryE extends AbstractEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4137468271450342954L;
	
	public static final String TABLE_NAME= "CATEGORY";
	public static final String FIND_BY_ID = "CategoryE.findById";
	public static final String FIND_BY_NAME = "CategoryE.findByName";

	@GeneratedValue
	@Id
	@Column(name = "\"ID\"")
	private Long Id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(mappedBy="userCategories")
	private List<UserE> users = new ArrayList<>();

	@ManyToMany(mappedBy="seriesCategories")
	private List<SeriesE> seriesCategory = new ArrayList<>();
	
	public CategoryE(){}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserE> getUsers() {
		return users;
	}

	public void setUsers(List<UserE> users) {
		this.users = users;
	}

	public List<SeriesE> getSeriesCategory() {
		return seriesCategory;
	}

	public void setSeriesCategory(List<SeriesE> seriesCategory) {
		this.seriesCategory = seriesCategory;
	}
	
	public void addUserE(UserE userE) {
		users.add(userE);
	}
	
	public void addSeries(SeriesE seriesE) {
		seriesCategory.add(seriesE);
	}
	
	
}
