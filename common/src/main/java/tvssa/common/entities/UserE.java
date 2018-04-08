package tvssa.common.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//import tvssa.common.entities.AbstractEntity;

@Entity(name = "User")
@Table(name = "USER")
@NamedQueries({ @NamedQuery(name = UserE.FIND_BY_ID, query = "select u from User u where u.id = :id"),
		@NamedQuery(name = UserE.FIND_BY_USER_NAME, query = "select u from User u where u.userName = :userName"),
		@NamedQuery(name = UserE.FIND_BY_USER_NAME_AND_PASSWORD, query = "select u from User u where u.userName = :userName and u.password = :password")})
public class UserE extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2457892347054681030L;

	public static final String TABLE_NAME= "USER";
	public static final String FIND_BY_ID = "UserE.findById";
	public static final String FIND_BY_USER_NAME = "UserE.findByUserName";
	public static final String FIND_BY_USER_NAME_AND_PASSWORD = "UserE.findByUserNameAndPassword";

	@Id
	@GeneratedValue
	@Column(name = "\"ID\"")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SUR_NAME")
	private String surName;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "BIRTH_YEAR")
	private Long birtYear;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "NATION")
	private String nation;
	
	@Column(name = "PASSWORD")
	private String password;

	@ManyToMany
	@JoinTable(name = "USER_SERIES", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "SERIES_ID", referencedColumnName = "ID"))
	private List<SeriesE> userSeries = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "USER_CATEGORY", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID"))
	private List<CategoryE> userCategories = new ArrayList<>();
	
	public UserE(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<SeriesE> getUserSeries() {
		return userSeries;
	}

	public void setUserSeries(List<SeriesE> userSeries) {
		this.userSeries = userSeries;
	}

	public List<CategoryE> getUserCategories() {
		return userCategories;
	}

	public void setUserCategories(List<CategoryE> userCategories) {
		this.userCategories = userCategories;
	}

	public void addSeries(SeriesE seriesE) {
		userSeries.add(seriesE);
	}
	public void removeSeries(SeriesE seriesE) {
		userSeries.remove(seriesE);
	}

	public void addCategory(CategoryE categoryE) {
		userCategories.add(categoryE);
	}

	public Long getBirtYear() {
		return birtYear;
	}

	public void setBirtYear(Long birtYear) {
		this.birtYear = birtYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
