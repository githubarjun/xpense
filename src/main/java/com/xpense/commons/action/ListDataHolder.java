package com.xpense.commons.action;

import java.util.List;

import com.xpense.commons.dto.BaseFieldsDTO;

public class ListDataHolder {
	private String prefix;
	private String action;
	private String actionForward;
	private List<String> propertyNames;
	private List<String> pageHeaders;
	private List<String> sortableHeaders;
	private List<? extends BaseFieldsDTO> dtos;
	List<List<String>> pageData;
	private String count;
	private int headerCount;
	private String hyperlinkColumn;
	private boolean addNewVisible;
	private String module;
	private String instructions;
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionForward() {
		return actionForward;
	}

	public void setActionForward(String actionForward) {
		this.actionForward = actionForward;
	}

	public List<String> getPropertyNames() {
		return propertyNames;
	}

	public void setPropertyNames(List<String> propertyNames) {
		this.propertyNames = propertyNames;
	}

	public List<String> getPageHeaders() {
		return pageHeaders;
	}

	public void setPageHeaders(List<String> pageHeaders) {
		this.pageHeaders = pageHeaders;
	}

	public List<String> getSortableHeaders() {
		return sortableHeaders;
	}

	public void setSortableHeaders(List<String> sortableHeaders) {
		this.sortableHeaders = sortableHeaders;
	}

	public List<? extends BaseFieldsDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<? extends BaseFieldsDTO> dtos) {
		this.dtos = dtos;
	}

	public List<List<String>> getPageData() {
		return pageData;
	}

	public void setPageData(List<List<String>> pageData) {
		this.pageData = pageData;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public int getHeaderCount() {
		return headerCount;
	}

	public void setHeaderCount(int headerCount) {
		this.headerCount = headerCount;
	}

	public String getHyperlinkColumn() {
		return hyperlinkColumn;
	}

	public void setHyperlinkColumn(String hyperlinkColumn) {
		this.hyperlinkColumn = hyperlinkColumn;
	}

	public boolean isAddNewVisible() {
		return addNewVisible;
	}

	public void setAddNewVisible(boolean addNewVisible) {
		this.addNewVisible = addNewVisible;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
}
