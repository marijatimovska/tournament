package com.iwec.tournament.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "max_points")
	private Integer maxPoints;

	@OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Result> results;

	@Version
	@Column(name = "optlock")
	private Integer version;

	public Event() {
		super();
	}

	public Event(String title, Integer maxPoints) {
		super();
		this.title = title;
		this.maxPoints = maxPoints;
	}

	public Event(Integer id, String title, Integer maxPoints) {
		super();
		this.id = id;
		this.title = title;
		this.maxPoints = maxPoints;
	}

	public Event(String title, Integer maxPoints, List<Result> results) {
		super();
		this.title = title;
		this.maxPoints = maxPoints;
		this.results = results;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", maxPoints=" + maxPoints + ", results=" + results + "]";
	}

}
