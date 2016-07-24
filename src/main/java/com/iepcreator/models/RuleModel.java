package com.iepcreator.models;

public class RuleModel {

	private int ruleId;
	private int subjectId;
	private String subject;
	private int subjectNo;
	private int preSubjectId;
	private String preSubject;
	private int preSubjectNo;
	
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}
	public int getPreSubjectId() {
		return preSubjectId;
	}
	public void setPreSubjectId(int preSubjectId) {
		this.preSubjectId = preSubjectId;
	}
	public String getPreSubject() {
		return preSubject;
	}
	public void setPreSubject(String preSubject) {
		this.preSubject = preSubject;
	}
	public int getPreSubjectNo() {
		return preSubjectNo;
	}
	public void setPreSubjectNo(int preSubjectNo) {
		this.preSubjectNo = preSubjectNo;
	}

}
