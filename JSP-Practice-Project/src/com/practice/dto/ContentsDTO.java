package com.practice.dto;

import java.sql.Timestamp;

public class ContentsDTO {

	private int cId;
	private String cTitle;
	private String cName;
	private String cContent;
	private Timestamp cDate;
	private int cHit;
	private int cGroup;
	private int cStep;
	private int cIndent;
	
	public ContentsDTO() {
	}

	public ContentsDTO(int cId, String cTitle, String cName, String cContent, Timestamp cDate, int cHit, int cGroup,
			int cStep, int cIndent) {
		this.cId = cId;
		this.cTitle = cTitle;
		this.cName = cName;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cHit = cHit;
		this.cGroup = cGroup;
		this.cStep = cStep;
		this.cIndent = cIndent;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public int getcHit() {
		return cHit;
	}

	public void setcHit(int cHit) {
		this.cHit = cHit;
	}

	public int getcGroup() {
		return cGroup;
	}

	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}

	public int getcStep() {
		return cStep;
	}

	public void setcStep(int cStep) {
		this.cStep = cStep;
	}

	public int getcIndent() {
		return cIndent;
	}

	public void setcIndent(int cIndent) {
		this.cIndent = cIndent;
	}
	
}
