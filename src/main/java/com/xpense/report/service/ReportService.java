package com.xpense.report.service;

import java.util.List;

import com.xpense.transaction.dto.UserGroupEventDTO;


public interface ReportService {

	public List<UserGroupEventDTO> getSpendingReport(String groupCode) throws Exception;

	public List<UserGroupEventDTO> getSettlementReport(String groupCode) throws Exception;
}
