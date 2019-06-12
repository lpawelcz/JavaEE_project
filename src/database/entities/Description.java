package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Description")
public class Description {
	
	public Description(String topic, String description) {
		this.topic = topic;
		this.description = description;
	}
	public Description() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "descID")
	private int descID;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "description")
	private String description;
	
	public int getDescID() {
		return descID;
	}
	public void setDescID(int descID) {
		this.descID = descID;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Description [descID=" + descID + ", topic=" + topic + ", description=" + description + "]";
	}
	
}
