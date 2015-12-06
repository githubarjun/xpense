package com.xpense.report.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SettlementReportData implements Serializable{

	private static final long serialVersionUID = -1741134167274434762L;

	private Map<String,String> headers = new LinkedHashMap<String, String>();
	
	private List<List<String>> dataDtls = new ArrayList<List<String>>();
	
	Map<String,Double> summary = new LinkedHashMap<String, Double>();
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public List<List<String>> getDataDtls() {
		return dataDtls;
	}
	public void setDataDtls(List<List<String>> dataDtls) {
		this.dataDtls = dataDtls;
	}
	public Map<String, Double> getSummary() {
		return summary;
	}
	public void setSummary(Map<String, Double> summary) {
		this.summary = summary;
	}
	
}
