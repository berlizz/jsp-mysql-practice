package com.practice.dto;

public class MembersDTO {

	private int mId;
	private String mUserId;
	private String mPassword;
	private String mDisplayName;
	
	public MembersDTO() {
	}

	public MembersDTO(int mId, String mUserId, String mPassword, String mDisplayName) {
		this.mId = mId;
		this.mUserId = mUserId;
		this.mPassword = mPassword;
		this.mDisplayName = mDisplayName;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmUserId() {
		return mUserId;
	}

	public void setmUserId(String mUserId) {
		this.mUserId = mUserId;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmDisplayName() {
		return mDisplayName;
	}

	public void setmDisplayName(String mDisplayName) {
		this.mDisplayName = mDisplayName;
	}
	
	
	
	
}
