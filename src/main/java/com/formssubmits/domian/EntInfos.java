package com.formssubmits.domian;
import java.time.LocalDateTime;

/**
 * 
 * 
 * @ClassName:  EntInfos
 * @Description: entInfos   
 * @author: 龚润忠
 * @date:   2019-12-30 20:45:46
 *
 */
public class EntInfos {

	/**  **/
	private Long entId;
	/**  **/
	private String entName;
	/**  **/
	private String entInfo;
	/**  **/
	private Long orgId;
	/**  **/
	private Long userId;
	
	
	
	public Long getEntId() {
		return entId;
	}
	
	public void setEntId(Long entId) {
		this.entId = entId;
	}
	
	
	public String getEntName() {
		return entName;
	}
	
	public void setEntName(String entName) {
		this.entName = entName;
	}
	
	
	public String getEntInfo() {
		return entInfo;
	}
	
	public void setEntInfo(String entInfo) {
		this.entInfo = entInfo;
	}
	
	
	public Long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
