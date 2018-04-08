package tvssa.rest.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SeriesDTO {

	public SeriesDTO() {

	}

	@XmlElement(name = "id")
	private Long id;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "premiere")
	private String premiere;
	@XmlElement(name = "avarageRating")
	private Float avarageRating;
	@XmlElement(name = "runtime")
	private Long runtime;
	@XmlElement(name = "pictureUrl")
	private String pictureUrl;
	@XmlElement(name = "tvMazeUrl")
	private String tvMazeUrl;

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

	public String getPremiere() {
		return premiere;
	}

	public void setPremiere(String premiere) {
		this.premiere = premiere;
	}

	public Float getAvarageRating() {
		return avarageRating;
	}

	public void setAvarageRating(Float avarageRating) {
		this.avarageRating = avarageRating;
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

	public String getTvMazeUrl() {
		return tvMazeUrl;
	}

	public void setTvMazeUrl(String tvMazeUrl) {
		this.tvMazeUrl = tvMazeUrl;
	}

}
