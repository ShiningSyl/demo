package com.youtube.rest;

public class Income_and_Tax {
	
	/**Fields
	 * [3]	Wage = f1_10_0_ 				所有W-2表中 单元[1]项标示的收入之和
	 * [4] 	Taxable Refund = f1_12_0_ 		州税与地方税的退税总和，查看1099-G，没无该表则跳过此项
	 * [5]  Scholarship = f1_14_0_ 			所有1042-S 表中Line 2项标示的收入之和
	 * [6-1] treaty = f1_16_0_				填入5000
	 * [6-2] treaty type  = f1_17_0_		Treaty C
	 * [7]  sum 3,4,5 = f1_18_0_			单元[3]+[4]+[5]之和
	 * [8]  Scholarship exc= f1_20_0_		此项不适用，填入0
	 * [9]  Student loan intr deduction		此项不适用，填入0
	 * [10] adjst gross income= f1_24_0_	单元[7]-[8]-[9]之差,为[7]
	 * [11] itemized deduct = f1_26_0_		W-2上单元[17]与[19]数字之和
	 * [12] 10-11 = f1_28_0_				单元[10]-[11]之差1
	 * [13] exemption = f1_30_0_			2014年为3950
	 * [14] taxable income = f1_32_0_		单元[12]-[13]的差，如为负数，填入0
	 * [15] tax = f1_34_0_					套用taxing table得出税款
	 * [16] SS and MT						此项不适用，不做填入
	 * [17] is 15 = f1_38_0_				单元[15]+[16]之和，等于[15]
	 * [18a] Federal wh w2 = f1_40_0_		W-2表中单元[2]中数字之和
	 * [18b] Federal wh 1042S = f1_100_0_	1042-S表中单元[3]中数字之和
	 * [19] last year return = f1_42_0_		2013年未退的税款
	 * [20] 1040c = f1_44_0_				如收到1040-C表，则填入此项
	 * [21] total payments = f1_46_0_		单元[18a]+[18b]+[19]+[20]之和
	 */
	
	Double wage;
	Double taxable_refunds;
	Double scholarship;
	Double treaty;
	String treaty_type;
	Double sumof_3_4_5;
	Double scholarship_exclude;
	Double sumof_7_8_9;
	Double itemized_deduction;
	Double sumof_10_11;
	Double exemption;
	Double taxable_income;
	Double tax;
	Double isTax;
	Double federal_withheld_W2;
	Double federal_withheld_1042S;
	Double return_of_2013;
	Double credit_1040C;
	Double total_payments;
	
	/**Constructor*/
	public Income_and_Tax() {
		super();
	}

	public Income_and_Tax(Double wage, Double taxable_refunds, Double scholarship, Double treaty, String treaty_type,
			Double sumof_3_4_5, Double scholarship_exclude, Double sumof_7_8_9, Double itemized_deduction,
			Double sumof_10_11, Double exemption, Double taxable_income, Double tax, Double isTax,
			Double federal_withheld_W2, Double federal_withheld_1042S, Double return_of_2013, Double credit_1040c,
			Double total_payments) {
		super();
		this.wage = wage;
		this.taxable_refunds = taxable_refunds;
		this.scholarship = scholarship;
		this.treaty = treaty;
		this.treaty_type = treaty_type;
		this.sumof_3_4_5 = sumof_3_4_5;
		this.scholarship_exclude = scholarship_exclude;
		this.sumof_7_8_9 = sumof_7_8_9;
		this.itemized_deduction = itemized_deduction;
		this.sumof_10_11 = sumof_10_11;
		this.exemption = exemption;
		this.taxable_income = taxable_income;
		this.tax = tax;
		this.isTax = isTax;
		this.federal_withheld_W2 = federal_withheld_W2;
		this.federal_withheld_1042S = federal_withheld_1042S;
		this.return_of_2013 = return_of_2013;
		this.credit_1040C = credit_1040c;
		this.total_payments = total_payments;
	}
	
	
	/**Methods*/
	public double getSumOf345 (double wage, double taxable_refunds, double scholarship) {		
		sumof_3_4_5 = wage + taxable_refunds + scholarship;
		return sumof_3_4_5;		
	}
	
	public double getSumOf789 (double sumof_3_4_5, double scholarship_exclude, double loan_deduction ) {
		return sumof_3_4_5;
	}
	
	public double getSumOf10and11 (double sumof_7_8_9, double itemized_deduction) {
		return sumof_7_8_9 - itemized_deduction;
		
	}
	
	public double getTaxableIncome (double sumof_10_11, double exemption) {
		if ((sumof_10_11 - exemption) > 0) {
			return sumof_10_11 - exemption;
		} else return 0;
	}
	
	public double getSumOf15and16 (double tax, double ssmt) {
		return tax;
	}
	
	public double getTotalPayments (double federal_withheld_W2,double federal_withheld_1042S,
			double return_of_2013, double credit_1040C) {
		return federal_withheld_W2 + federal_withheld_1042S + return_of_2013 + credit_1040C;
	}
	
	
	/**Getter and Setter*/
	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public Double getTaxable_refunds() {
		return taxable_refunds;
	}

	public void setTaxable_refunds(Double taxable_refunds) {
		this.taxable_refunds = taxable_refunds;
	}

	public Double getScholarship() {
		return scholarship;
	}

	public void setScholarship(Double scholarship) {
		this.scholarship = scholarship;
	}

	public Double getTreaty() {
		return treaty;
	}

	public void setTreaty(Double treaty) {
		this.treaty = treaty;
	}

	public String getTreaty_type() {
		return treaty_type;
	}

	public void setTreaty_type(String treaty_type) {
		this.treaty_type = treaty_type;
	}

	public Double getSumof_3_4_5() {
		return sumof_3_4_5;
	}

	public void setSumof_3_4_5(Double sumof_3_4_5) {
		this.sumof_3_4_5 = sumof_3_4_5;
	}

	public Double getScholarship_exclude() {
		return scholarship_exclude;
	}

	public void setScholarship_exclude(Double scholarship_exclude) {
		this.scholarship_exclude = scholarship_exclude;
	}

	public Double getSumof_7_8_9() {
		return sumof_7_8_9;
	}

	public void setSumof_7_8_9(Double sumof_7_8_9) {
		this.sumof_7_8_9 = sumof_7_8_9;
	}

	public Double getItemized_deduction() {
		return itemized_deduction;
	}

	public void setItemized_deduction(Double itemized_deduction) {
		this.itemized_deduction = itemized_deduction;
	}

	public Double getSumof_10_11() {
		return sumof_10_11;
	}

	public void setSumof_10_11(Double sumof_10_11) {
		this.sumof_10_11 = sumof_10_11;
	}

	public Double getExemption() {
		return exemption;
	}

	public void setExemption(Double exemption) {
		this.exemption = exemption;
	}

	public Double getTaxable_income() {
		return taxable_income;
	}

	public void setTaxable_income(Double taxable_income) {
		this.taxable_income = taxable_income;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getIsTax() {
		return isTax;
	}

	public void setIsTax(Double isTax) {
		this.isTax = isTax;
	}

	public Double getFederal_withheld_W2() {
		return federal_withheld_W2;
	}

	public void setFederal_withheld_W2(Double federal_withheld_W2) {
		this.federal_withheld_W2 = federal_withheld_W2;
	}

	public Double getFederal_withheld_1042S() {
		return federal_withheld_1042S;
	}

	public void setFederal_withheld_1042S(Double federal_withheld_1042S) {
		this.federal_withheld_1042S = federal_withheld_1042S;
	}

	public Double getReturn_of_2013() {
		return return_of_2013;
	}

	public void setReturn_of_2013(Double return_of_2013) {
		this.return_of_2013 = return_of_2013;
	}

	public Double getCredit_1040C() {
		return credit_1040C;
	}

	public void setCredit_1040C(Double credit_1040c) {
		credit_1040C = credit_1040c;
	}

	public Double getTotal_payments() {
		return total_payments;
	}

	public void setTotal_payments(Double total_payments) {
		this.total_payments = total_payments;
	}
	
	
	
	
	

}
