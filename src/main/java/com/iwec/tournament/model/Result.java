package com.iwec.tournament.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "results")
public class Result implements Serializable{

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Player player;

	@Id
	@ManyToOne
	@JoinColumn
	private Event event;

	@Column(name = "seconds")
	private Integer seconds;

	@Column(name = "points")
	private Integer points;

	// @ManyToOne(fetch = FetchType.LAZY)
	// private Player player;

	@Version
	@Column(name = "optlock")
	private Integer version;

	public Result() {
		super();
	}

	public Result(Player player, Event event, Integer seconds, Integer points) {
		super();
		this.player = player;
		this.event = event;
		this.seconds = seconds;
		this.points = points;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Integer getSeconds() {
		return seconds;
	}

	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		result = prime * result + ((seconds == null) ? 0 : seconds.hashCode());
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
		Result other = (Result) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		if (seconds == null) {
			if (other.seconds != null)
				return false;
		} else if (!seconds.equals(other.seconds))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [player=" + player + ", event=" + event + ", seconds=" + seconds + ", points=" + points + "]";
	}

}
