package com.cyt.authority.model;
/**
 * @author Chenyt7
 * @date  2021/5/20
 **/
public class SysRole extends BaseModel {
    private String name;
    private String remark;
    private Byte delFlag;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Byte getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Byte delFlag) {
		this.delFlag = delFlag;
	}
}