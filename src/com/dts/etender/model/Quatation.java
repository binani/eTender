/**
 * 
 */
package com.dts.etender.model;

/**
 * @author JAVAPROJECTS
 *
 */
public class Quatation {

	private int quatatonID;
	private int tenderID;
	private String suppierName;
	private String dDNo;
	private String BidPostDate;
	private int quantity;
	private String spesification;
	private double pricebid;
	private int itemID;
	private String postingDate;
	private String receiptdate;
	private String tenderName;
	private String itemName;
	
	
	public String getTenderName() {
		return tenderName;
	}
	public void setTenderName(String tenderName) {
		this.tenderName = tenderName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getReceiptdate() {
		return receiptdate;
	}
	public void setReceiptdate(String receiptdate) {
		this.receiptdate = receiptdate;
	}
	public int getQuatatonID() {
		return quatatonID;
	}
	public void setQuatatonID(int quatatonID) {
		this.quatatonID = quatatonID;
	}
	public int getTenderID() {
		return tenderID;
	}
	public void setTenderID(int tenderID) {
		this.tenderID = tenderID;
	}
	public String getSuppierName() {
		return suppierName;
	}
	public void setSuppierName(String suppierName) {
		this.suppierName = suppierName;
	}
	public String getDDNo() {
		return dDNo;
	}
	public void setDDNo(String no) {
		dDNo = no;
	}
	public String getBidPostDate() {
		return BidPostDate;
	}
	public void setBidPostDate(String bidPostDate) {
		BidPostDate = bidPostDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSpesification() {
		return spesification;
	}
	public void setSpesification(String spesification) {
		this.spesification = spesification;
	}
	public double getPricebid() {
		return pricebid;
	}
	public void setPricebid(double pricebid) {
		this.pricebid = pricebid;
	}
}
