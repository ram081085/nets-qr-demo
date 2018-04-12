package com.nets.demo.qr.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JsonNpxData {

	@JsonProperty("E103")
	private String posId;
	
	@JsonProperty("E107")
	private String edcBatchNumber;

	@JsonProperty("E201")
	private String sourceAmount;
	
	@JsonProperty("E202")
	private String sourceCurrency;

	@JsonProperty("E204")
	private String targetCurrencyReq;

	@JsonProperty("E601")
	private String cardType;
	
	@JsonProperty("F101")
	private String transactionId;
	
	@JsonProperty("F102")
	private String transactionType;
	
	@JsonProperty("F103")
	private String transactionStatus;

	@JsonProperty("F104")
	private String transactionTimestamp;
	
	@JsonProperty("F111")
	private String originalSourceAmount;

	@JsonProperty("F112")
	private String sourceCurrencyResponse;

	@JsonProperty("F113")
	private String originalTargetAmount;
	
	@JsonProperty("F114")
	private String targetCurrency;

	@JsonProperty("F116")
	private String targetCurrencyLongText;
	
	
	@JsonProperty("F117")
	private String conversionRate;
	
	@JsonProperty("F121")
	private String sourceAmountRes;
	
	@JsonProperty("F122")
	private String targetAmount;

	@JsonProperty("F200")
	private String courencyGroups;

	@JsonProperty("F201")
	private String targetCurrencyRes;

	@JsonProperty("F202")
	private String targetCurrencyText;
	
	@JsonProperty("F203")
	private String targetCurrencyIso;

	@JsonProperty("F204")
	private String exchangeRate;
	
	@JsonProperty("F209")
	private String receiptHeader1;
	
	@JsonProperty("F210")
	private String receiptHeader2;

	@JsonProperty("F211")
	private String receiptHeader3;

	@JsonProperty("F212")
	private String receiptHeader4;

	@JsonProperty("F213")
	private String expressPayIndicator;
	
	@JsonProperty("F214")
	private String expressPayMessage;

	@JsonProperty("F215")
	private String acquirerId;

	@JsonProperty("F216")
	private String terminalAcquirerId;
	
	@JsonProperty("F217")
	private String paymentTypeId;

	@JsonProperty("F218")
	private String sofDetails;

	@JsonProperty("F998")
	private String uposErrorMessage;

	@JsonProperty("F999")
	private String uposErrorCode;

	public String getPosId() {
		return posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	public String getEdcBatchNumber() {
		return edcBatchNumber;
	}

	public void setEdcBatchNumber(String edcBatchNumber) {
		this.edcBatchNumber = edcBatchNumber;
	}

	public String getSourceAmount() {
		return sourceAmount;
	}

	public void setSourceAmount(String sourceAmount) {
		this.sourceAmount = sourceAmount;
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getTargetCurrencyReq() {
		return targetCurrencyReq;
	}

	public void setTargetCurrencyReq(String targetCurrencyReq) {
		this.targetCurrencyReq = targetCurrencyReq;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	
	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}
	
	public String getOriginalSourceAmount() {
		return originalSourceAmount;
	}

	public void setOriginalSourceAmount(String originalSourceAmount) {
		this.originalSourceAmount = originalSourceAmount;
	}
	
	
	public String getSourceCurrencyResponse() {
		return sourceCurrencyResponse;
	}

	public void setSourceCurrencyResponse(String sourceCurrencyResponse) {
		this.sourceCurrencyResponse = sourceCurrencyResponse;
	}
	
	public String getOriginalTargetAmount() {
		return originalTargetAmount;
	}

	public void setOriginalTargetAmount(String originalTargetAmount) {
		this.originalTargetAmount = originalTargetAmount;
	}
	
	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}
	
	public String getTargetCurrencyLongText() {
		return targetCurrencyLongText;
	}

	public void setTargetCurrencyLongText(String targetCurrencyLongText) {
		this.targetCurrencyLongText = targetCurrencyLongText;
	}
	
	
	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	public String getSourceAmountRes() {
		return sourceAmountRes;
	}

	public void setSourceAmountRes(String sourceAmountRes) {
		this.sourceAmountRes = sourceAmountRes;
	}
	
	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}


	public String getCourencyGroups() {
		return courencyGroups;
	}

	public void setCourencyGroups(String courencyGroups) {
		this.courencyGroups = courencyGroups;
	}

	public String getTargetCurrencyRes() {
		return targetCurrencyRes;
	}

	public void setTargetCurrencyRes(String targetCurrencyRes) {
		this.targetCurrencyRes = targetCurrencyRes;
	}

	public String getTargetCurrencyText() {
		return targetCurrencyText;
	}

	public void setTargetCurrencyText(String targetCurrencyText) {
		this.targetCurrencyText = targetCurrencyText;
	}

	public String getTargetCurrencyIso() {
		return targetCurrencyIso;
	}

	public void setTargetCurrencyIso(String targetCurrencyIso) {
		this.targetCurrencyIso = targetCurrencyIso;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getReceiptHeader1() {
		return receiptHeader1;
	}

	public void setReceiptHeader1(String receiptHeader1) {
		this.receiptHeader1 = receiptHeader1;
	}

	public String getReceiptHeader2() {
		return receiptHeader2;
	}

	public void setReceiptHeader2(String receiptHeader2) {
		this.receiptHeader2 = receiptHeader2;
	}

	public String getReceiptHeader3() {
		return receiptHeader3;
	}

	public void setReceiptHeader3(String receiptHeader3) {
		this.receiptHeader3 = receiptHeader3;
	}

	public String getReceiptHeader4() {
		return receiptHeader4;
	}

	public void setReceiptHeader4(String receiptHeader4) {
		this.receiptHeader4 = receiptHeader4;
	}

	public String getExpressPayIndicator() {
		return expressPayIndicator;
	}

	public void setExpressPayIndicator(String expressPayIndicator) {
		this.expressPayIndicator = expressPayIndicator;
	}

	public String getExpressPayMessage() {
		return expressPayMessage;
	}

	public void setExpressPayMessage(String expressPayMessage) {
		this.expressPayMessage = expressPayMessage;
	}

	public String getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(String acquirerId) {
		this.acquirerId = acquirerId;
	}

	public String getTerminalAcquirerId() {
		return terminalAcquirerId;
	}

	public void setTerminalAcquirerId(String terminalAcquirerId) {
		this.terminalAcquirerId = terminalAcquirerId;
	}

	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getSofDetails() {
		return sofDetails;
	}

	public void setSofDetails(String sofDetails) {
		this.sofDetails = sofDetails;
	}

	public String getUposErrorMessage() {
		return uposErrorMessage;
	}

	public void setUposErrorMessage(String uposErrorMessage) {
		this.uposErrorMessage = uposErrorMessage;
	}

	public String getUposErrorCode() {
		return uposErrorCode;
	}

	public void setUposErrorCode(String uposErrorCode) {
		this.uposErrorCode = uposErrorCode;
	}

	

}
