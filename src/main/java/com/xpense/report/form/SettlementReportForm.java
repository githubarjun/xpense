package com.xpense.report.form;

import java.util.List;

import com.xpense.commons.form.BaseForm;
import com.xpense.master.dto.UserGroupDTO;

public class SettlementReportForm extends BaseForm{

	private static final long serialVersionUID = 4177178781722249131L;
	private List<UserGroupDTO> groupDTOs;
	private String group;
	private SettlementReportData reportData = new SettlementReportData();
	
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

	public SettlementReportData getReportData() {
		return reportData;
	}

	public void setReportData(SettlementReportData reportData) {
		this.reportData = reportData;
	}

	@Override
	public void fillED(String mode) {
	}

	
	
}
