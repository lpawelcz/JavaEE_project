package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Result")
public class Result {

	public Result(float points, float prcntgOfUnderstanding) {
		this.points = points;
		this.prcntgOfUnderstanding = prcntgOfUnderstanding;
	}
	public Result() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "resultID")
	private int resultID;
	
	@JoinColumn(name = "points")
	private float points;
	
	@JoinColumn(name = "prcntgOfUnderstanding")
	private float prcntgOfUnderstanding;
	
	public int getResultID() {
		return resultID;
	}
	public void setResultID(int resultID) {
		this.resultID = resultID;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public float getPrcntgOfUnderstanding() {
		return prcntgOfUnderstanding;
	}
	public void setPrcntgOfUnderstanding(float prcntgOfUnderstanding) {
		this.prcntgOfUnderstanding = prcntgOfUnderstanding;
	}

	@Override
	public String toString() {
		return "Result [resultID=" + resultID + ", points=" + points + ", prcntgOfUnderstanding="
				+ prcntgOfUnderstanding + "]";
	}


}
