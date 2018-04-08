package tvssa.common.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Series")
@Table(name = "SERIES")
@NamedQueries({ @NamedQuery(name = SeriesE.FIND_BY_ID, query = "select s from Series s where s.id = :id"),
		@NamedQuery(name = SeriesE.FIND_BY_NAME, query = "select s from Series s where s.name = :name"),
		@NamedQuery(name = SeriesE.FIND_ALL_BY_NAME, query = "select s from Series s where lower(s.name) like :name"),})
public class SeriesE extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 773141014403845378L;
	
	public static final String TABLE_NAME= "SERIES";

	public static final String FIND_BY_ID = "SeriesE.findById";
	public static final String FIND_BY_NAME = "SeriesE.findByName";
	public static final String FIND_ALL_BY_NAME = "SeriesE.findAllByName";

	@GeneratedValue
	@Id
	@Column(name = "\"ID\"")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EPISODE_NUMBER")
	private Long episodeNumber;

	@Column(name = "SEASON_NUMBER")
	private Long seasonNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "PREMIERE")
	private Date premiere;

	@Column(name = "AVARAGE_RATING")
	private Float avarageRating;
	
	@Column(name = "RUNTIME")
	private Long runtime;
	
	@Column(name = "PICTURE_URL")
	private String pictureUrl;

	@Column (name ="TVMAZE_URL")
	private String tvmazeURL;
	
	@ManyToMany(mappedBy = "userSeries")
	private List<UserE> users = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "SERIES_CATEGORY", joinColumns = @JoinColumn(name = "SERIES_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID"))
	private List<CategoryE> seriesCategories = new ArrayList<>();

	public SeriesE(){}
	
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

	public Long getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(Long episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public Long getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(Long seasonNumber) {
		this.seasonNumber = seasonNumber;
	}
	

	public Date getPremiere() {
		return premiere;
	}

	public void setPremiere(Date premiere) {
		this.premiere = premiere;
	}

	public String getTvmazeURL() {
		return tvmazeURL;
	}

	public void setTvmazeURL(String tvmazeURL) {
		this.tvmazeURL = tvmazeURL;
	}

	public Float getAvarageRating() {
		return avarageRating;
	}

	public void setAvarageRating(Float avarageRating) {
		this.avarageRating = avarageRating;
	}

	public List<UserE> getUsers() {
		return users;
	}

	public void setUsers(List<UserE> users) {
		this.users = users;
	}

	public List<CategoryE> getSeriesCategories() {
		return seriesCategories;
	}

	public void setSeriesCategories(List<CategoryE> seriesCategories) {
		this.seriesCategories = seriesCategories;
	}

	public void addUserE(UserE userE) {
		users.add(userE);
	}

	public void addCategoryE(CategoryE categoryE) {
		seriesCategories.add(categoryE);
	}

	public Long getRuntime() {
		return runtime;
	}

	public void setRuntime(Long runtime) {
		this.runtime = runtime;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof SeriesE)) return false;
		return ((SeriesE) obj).id.equals(this.id);
	}
	
	@Override
	public int hashCode(){
	    return Objects.hashCode(this.id);
	}

}
