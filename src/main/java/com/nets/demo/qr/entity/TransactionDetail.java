package com.nets.demo.qr.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TransactionDetail implements Serializable {

	private static final long serialVersionUID = -1512270040084536951L;

	@JsonProperty("amount")
	private String targetAmount;
	
	@JsonProperty("currency")
	private String targetCurrency;
	
	@JsonProperty("approval_code")
	private String approvalCode;
	
	@JsonProperty("response_code")
	private String responseCode;
	
	@JsonProperty("transaction_date")
	private String transactionDate;
	
	@JsonProperty("transaction_time")
	private String transactionTime;
	
	@JsonProperty("stan")
	private String stan;
	
	@JsonProperty("retrieval_ref")
	private String retrievalRefNo;
	
	@JsonProperty("payment_type")
	private String paymentType;

	public TransactionDetail(){
		
	}
	
	public String getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getRetrievalRefNo() {
		return retrievalRefNo;
	}

	public void setRetrievalRefNo(String retrievalRefNo) {
		this.retrievalRefNo = retrievalRefNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
