package base.wolf.model;

import java.util.Date;

/**
 * author lzc
 * 2015年7月4日下午1:47:07
 */
public class BaseModel {
	private String id;
	private String deleted;
	private String modifiedId;
	private Date modiiedTime;
	private String createdId;
	private Date createdTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getModifiedId() {
		return modifiedId;
	}
	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}
	public Date getModiiedTime() {
		return modiiedTime;
	}
	public void setModiiedTime(Date modiiedTime) {
		this.modiiedTime = modiiedTime;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
	
	
}
