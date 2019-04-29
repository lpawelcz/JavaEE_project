package database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Result")
public class Result {

	public Result(float result, float prcntgOfUnderstanding) {
		this.result = result;
		this.prcntgOfUnderstanding = prcntgOfUnderstanding;
	}
	public Result() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "resultID")
	private int resultID;
	
	@Column(name = "result")
	private float result;
	
	@Column(name = "prcntgOfUnderstanding")
	private float prcntgOfUnderstanding;
	
	public int getResultID() {
		return resultID;
	}
	public void setResultID(int resultID) {
		this.resultID = resultID;
	}
	public float getResult() {
		return result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	public float getPrcntgOfUnderstanding() {
		return prcntgOfUnderstanding;
	}
	public void setPrcntgOfUnderstanding(float prcntgOfUnderstanding) {
		this.prcntgOfUnderstanding = prcntgOfUnderstanding;
	}

	@Override
	public String toString() {
		return "Result [resultID=" + resultID + ", result=" + result + ", prcntgOfUnderstanding="
				+ prcntgOfUnderstanding + "]";
	}


}
