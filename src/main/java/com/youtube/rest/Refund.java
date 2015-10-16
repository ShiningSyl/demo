package com.youtube.rest;

public class Refund {
	
	/**Fields
	 * [22]  over paid = f1_48_0_
	 * [23a] refund = f1_50_0_
	 * [23b] routing number = f1_52_0_
	 * [23c] checking/saving "1/2"= c1_4_0_ 
	 * [23d] account number = f1_53_0_
	 * [23e] mail outside US = f1_74_0_
	 * [24]  2015 tax estimate = f1_54_0_
	 * [25]  amount you own = f1_56_0_
	 * [26]  tax penalty = f1_58_0_
	 */
	
	double over_paid;
	double refund;
	String routing_num;
	String checkingOrSaving;
	String account_num;
	String mail_outUS_add;
	String tax_2015;
	double amount_owned;
	double tax_penalty;
	
	/**Constructor*/
	public Refund() {
		super();
	}

	public Refund(double over_paid, double refund, String routing_num, String checkingOrSaving, String account_num,
			String mail_outUS_add, String tax_2015,double amount_owned, double tax_penalty) {
		super();
		this.over_paid = over_paid;
		this.refund = refund;
		this.routing_num = routing_num;
		this.checkingOrSaving = checkingOrSaving;
		this.account_num = account_num;
		this.mail_outUS_add = mail_outUS_add;
		this.tax_2015 = tax_2015;
		this.amount_owned = amount_owned;
		this.tax_penalty = tax_penalty;
	}

	
	/**Methods*/
	public double getOverPaid(double num22, Double tax) {
		if ((num22 - tax) > 0) {
			return num22 - tax;
		} else return 0;
	}
	
	public double getAmountOwned(double num21, Double tax) {
		if ((num21 - tax) < 0) {
			return tax - num21;
		} else return 0;
	}
	
	/**Getter and Setter*/
	public String getTax_2015() {
		return tax_2015;
	}

	public void setTax_2015(String tax_2015) {
		this.tax_2015 = tax_2015;
	}

	public double getOver_paid() {
		return over_paid;
	}

	public void setOver_paid(double over_paid) {
		this.over_paid = over_paid;
	}

	public double getRefund() {
		return refund;
	}

	public void setRefund(double refund) {
		this.refund = refund;
	}

	public String getRouting_num() {
		return routing_num;
	}

	public void setRouting_num(String routing_num) {
		this.routing_num = routing_num;
	}

	public String getCheckingOrSaving() {
		return checkingOrSaving;
	}

	public void setCheckingOrSaving(String checkingOrSaving) {
		this.checkingOrSaving = checkingOrSaving;
	}

	public String getAccount_num() {
		return account_num;
	}

	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}

	public String getMail_outUS_add() {
		return mail_outUS_add;
	}

	public void setMail_outUS_add(String mail_outUS_add) {
		this.mail_outUS_add = mail_outUS_add;
	}

	public double getAmount_owned() {
		return amount_owned;
	}

	public void setAmount_owned(double amount_owned) {
		this.amount_owned = amount_owned;
	}

	public double getTax_penalty() {
		return tax_penalty;
	}

	public void setTax_penalty(double tax_penalty) {
		this.tax_penalty = tax_penalty;
	}

	

	
	
	
	
	

}
