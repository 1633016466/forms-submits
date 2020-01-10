package com.formssubmits.domian;
import java.time.LocalDateTime;

/**
 * 
 * 
 * @ClassName:  OrgInfos
 * @Description: orgInfos   
 * @author: 龚润忠
 * @date:   2019-12-30 20:46:15
 *
 */
public class OrgInfos {

	/**  **/
	private Long orgId;
	/**  **/
	private String orgName;
	/**  **/
	private Long entId;
	/**  **/
	private Long userId;
	
	
	
	public Long getOrgId() {
		return orgId;
	}
	
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	
	public String getOrgName() {
		return orgName;
	}
	
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	public Long getEntId() {
		return entId;
	}
	
	public void setEntId(Long entId) {
		this.entId = entId;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
