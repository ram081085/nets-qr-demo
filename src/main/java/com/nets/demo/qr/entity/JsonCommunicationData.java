package com.nets.demo.qr.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JsonCommunicationData {

	@JsonProperty("type")
	private String communicationType;

	@JsonProperty("category")
	private String communicationCategory;

	@JsonProperty("destination")
	private String communicationDestination;

	@JsonProperty("addon")
	private Map<String, String> addon;

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getCommunicationCategory() {
		return communicationCategory;
	}

	public void setCommunicationCategory(String communicationCategory) {
		this.communicationCategory = communicationCategory;
	}

	public String getCommunicationDestination() {
		return communicationDestination;
	}

	public void setCommunicationDestination(String communicationDestination) {
		this.communicationDestination = communicationDestination;
	}

	public Map<String, String> getAddon() {
		return addon;
	}

	public void setAddon(Map<String, String> addon) {
		this.addon = addon;
	}

}