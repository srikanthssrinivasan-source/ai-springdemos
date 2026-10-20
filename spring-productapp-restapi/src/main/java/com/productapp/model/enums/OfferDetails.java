package com.productapp.model.enums;

public enum OfferDetails {
	
	NCI("NO COST EMI"), 
	CH("CASH BACK"),
	PO("PARTNER OFFER"),
	BO("BANK OFFER");

	private String offerName;
	//add a parameterised constr

	private OfferDetails(String offerName) {
		this.offerName = offerName;
	}
	//create getter method for this

	public String getOfferName() {
		return offerName;
	}

	

}
