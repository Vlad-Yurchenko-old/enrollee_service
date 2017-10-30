package domain.entityImpl;

import domain.Entity;

// баллы за экзамен
public class ExamScope extends Entity{

	private int scope; //балл
	private int enrolleeID;
	private int subjectID;
	
	public int getScope() {
		return scope;
	}
	public void setScope(int scope) {
		this.scope = scope;
	}
	public int getEnrolleeID() {
		return enrolleeID;
	}
	public void setEnrolleeID(int enrolleeID) {
		this.enrolleeID = enrolleeID;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	
}
