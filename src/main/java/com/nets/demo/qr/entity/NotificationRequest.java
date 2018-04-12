package com.nets.demo.qr.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class NotificationRequest implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 185368351848741415L;


	@JsonProperty("retrieval_ref")
	private String retrievalRef;

	@JsonProperty("mti")
	private String mti;

	@JsonProperty("txn_identifier")
	private String searchId;

	@JsonProperty("process_code")
	private String processCode;

	@JsonProperty("amount")
	private String targetAmount;

	@JsonProperty("stan")
	private String stan;

	@JsonProperty("transaction_time")
	private String transactionTime;

	@JsonProperty("transaction_date")
	private String transactionDate;

	@JsonProperty("entry_mode")
	private String entryMode;

	@JsonProperty("condition_code")
	private String conditionCode;

	@JsonProperty("institution_code")
	private String institutionCode;

	@JsonProperty("response_code")
	private String responseCode;

	@JsonProperty("approval_code")
	private String approvalCode;

	@JsonProperty("host_tid")
	private String tid;

	@JsonProperty("host_mid")
	private String mid;

	@JsonProperty("pay_details")
	private String payDetails;

	@JsonProperty("SOF_uri")
	private String sofUri;

	@JsonProperty("user_data")
	private String userData;

	@JsonProperty("sig")
	private String sig;

	@JsonProperty("transmission_time")
	private String transmissionTime;

	@JsonProperty("settlement_date")
	private String settlementDate;

	@JsonProperty("capture_date")
	private String captureDate;


	@JsonProperty("invoice_ref")
	private String invoiceRef;

	@JsonProperty("callback_url")
	private String callbackUrl;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@JsonProperty("payment_type_id")
	private String paymentTypeId;
	
	@JsonProperty("transaction_id")
	private String transactionId;
	
	@JsonProperty("transaction_status")
	private String transactionStatus;


	public NotificationRequest() {
	}

	public String getRetrievalRef() {
		return retrievalRef;
	}

	public void setRetrievalRef(String retrievalRef) {
		this.retrievalRef = retrievalRef;
	}

	public String getMti() {
		return mti;
	}

	public void setMti(String mti) {
		this.mti = mti;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public String getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(String conditionCode) {
		this.conditionCode = conditionCode;
	}

	public String getInstitutionCode() {
		return institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPayDetails() {
		return payDetails;
	}

	public void setPayDetails(String payDetails) {
		this.payDetails = payDetails;
	}

	public String getSofUri() {
		return sofUri;
	}

	public void setSofUri(String sofUri) {
		this.sofUri = sofUri;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransmissionTime() {
		return transmissionTime;
	}

	public void setTransmissionTime(String transmissionTime) {
		this.transmissionTime = transmissionTime;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(String captureDate) {
		this.captureDate = captureDate;
	}


	public String getInvoiceRef() {
		return invoiceRef;
	}

	public void setInvoiceRef(String invoiceRef) {
		this.invoiceRef = invoiceRef;
	}
	
	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

}
