package com.xpense.report.form;

import java.util.List;

import com.xpense.commons.form.BaseForm;
import com.xpense.master.dto.UserGroupDTO;
import com.xpense.transaction.dto.UserGroupEventDTO;

public class SpendingReportForm extends BaseForm{

	private List<UserGroupDTO> groupDTOs;
	private String group;
	private SpendingReportData reportData = new SpendingReportData();
	
	public List<UserGroupDTO> getGroupDTOs() {
		return groupDTOs;
	}

	public void setGroupDTOs(List<UserGroupDTO> groupDTOs) {
		this.groupDTOs = groupDTOs;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public SpendingReportData getReportData() {
		return reportData;
	}

	public void setReportData(SpendingReportData reportData) {
		this.reportData = reportData;
	}

	@Override
	public void fillED(String mode) {
	}

}
