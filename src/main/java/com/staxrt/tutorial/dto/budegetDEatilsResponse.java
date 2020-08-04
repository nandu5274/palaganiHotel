package com.staxrt.tutorial.dto;

import java.util.ArrayList;

public class budegetDEatilsResponse {

	
	private ArrayList<budgetdetailsDTO> budgetdetailsDTOList = new ArrayList<>();
	
	
	private Long finalAmount;
	private Long lastMnthAdvanceAMount ;
	private Long nextMnthpaidAMount ;
	
	
	
	
	
	public budegetDEatilsResponse() {
		super();
	}
	public ArrayList<budgetdetailsDTO> getBudgetdetailsDTOList() {
		return budgetdetailsDTOList;
	}
	public void setBudgetdetailsDTOList(ArrayList<budgetdetailsDTO> budgetdetailsDTOList) {
		this.budgetdetailsDTOList = budgetdetailsDTOList;
	}
	public Long getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Long finalAmount) {
		this.finalAmount = finalAmount;
	}
	public Long getLastMnthAdvanceAMount() {
		return lastMnthAdvanceAMount;
	}
	public void setLastMnthAdvanceAMount(Long lastMnthAdvanceAMount) {
		this.lastMnthAdvanceAMount = lastMnthAdvanceAMount;
	}
	public Long getNextMnthpaidAMount() {
		return nextMnthpaidAMount;
	}
	public void setNextMnthpaidAMount(Long nextMnthpaidAMount) {
		this.nextMnthpaidAMount = nextMnthpaidAMount;
	}
	
	
	public budegetDEatilsResponse(ArrayList<budgetdetailsDTO> budgetdetailsDTOList, Long finalAmount,
			Long lastMnthAdvanceAMount, Long nextMnthpaidAMount) {
		super();
		this.budgetdetailsDTOList = budgetdetailsDTOList;
		this.finalAmount = finalAmount;
		this.lastMnthAdvanceAMount = lastMnthAdvanceAMount;
		this.nextMnthpaidAMount = nextMnthpaidAMount;
	}
	@Override
	public String toString() {
		return "budegetDEatilsResponse [budgetdetailsDTOList=" + budgetdetailsDTOList + ", finalAmount=" + finalAmount
				+ ", lastMnthAdvanceAMount=" + lastMnthAdvanceAMount + ", nextMnthpaidAMount=" + nextMnthpaidAMount
				+ "]";
	}
	
	
	
	
	
	
}
