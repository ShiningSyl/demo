package com.youtube.rest;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	
    	@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
        Person_Info yan = (Person_Info) context.getBean("person_info"); 
        Income_and_Tax it = (Income_and_Tax) context.getBean("incometax");
        Refund rf = (Refund) context.getBean("refund");
 
    	try {
    	      PdfReader reader = new PdfReader("test.pdf");
    	      /** filling in the personal information*/
    	      PdfStamper stamp1 = new PdfStamper(reader, new FileOutputStream("FormFillPDF.pdf"));
    	      AcroFields form1 = stamp1.getAcroFields();
    	      //Personal info=============================================
    	      form1.setField("f1_01_0_", yan.first_name);
    	      form1.setField("f1_02_0_", yan.last_name);
    	      form1.setField("f1_03_0_", yan.identifying_num);
    	      form1.setField("f1_04_0_", yan.home_address);
    	      form1.setField("f1_05_0_", yan.city_state_zip);
    	      form1.setField("TextField1", yan.foreign_country);
    	      form1.setField("f1_73_0_", yan.foreign_prov);
    	      form1.setField("f1_301_0_", yan.foreign_zip);
    	      form1.setField("c1_2_0_[0]", yan.isSingle); //System.out.println(single);
    	      form1.setField("c1_2_0_[1]", yan.isSingle); //System.out.println(single);
    	      //Income and Tax============================================
    	      form1.setField("f1_10_0_", it.wage + "");
    	      form1.setField("f1_12_0_", it.taxable_refunds + "");
    	      form1.setField("f1_14_0_", it.scholarship + "");   	      
    	      form1.setField("f1_16_0_", it.treaty + "");
    	      form1.setField("f1_17_0_", it.treaty_type);
    	      double num7 = round(it.getSumOf345(it.wage, it.taxable_refunds, it.scholarship), 2);
    	      form1.setField("f1_18_0_", num7 + "");
    	      double num10 = round(it.getSumOf789(num7, 0, 0), 2);
    	      form1.setField("f1_24_0_", num10 + "");
    	      form1.setField("f1_26_0_", it.itemized_deduction + "");
    	      double num12 = round(it.getSumOf10and11(num10, it.itemized_deduction), 2);
    	      form1.setField("f1_28_0_", num12 + "");
    	      form1.setField("f1_30_0_", it.exemption + "");
    	      it.taxable_income = round(it.getTaxableIncome(num12, it.exemption),2);    	      
    	      form1.setField("f1_32_0_", it.taxable_income + "");
    	      it.tax = (double) CalculateTax.getTax(it.taxable_income);    	      
    	      form1.setField("f1_34_0_", it.tax + "");
    	      form1.setField("f1_38_0_", it.tax + "");
    	      form1.setField("f1_40_0_", it.federal_withheld_W2 + "");
    	      form1.setField("f1_100_0_", it.federal_withheld_1042S + "");
    	      form1.setField("f1_42_0_", it.return_of_2013 + "");
    	      form1.setField("f1_44_0_", it.credit_1040C + "");
    	      double num21 = it.getTotalPayments(it.federal_withheld_W2, it.federal_withheld_1042S, 
    	    		  it.return_of_2013, it.credit_1040C);
    	      form1.setField("f1_46_0_", num21 + "");
    	      //Refund====================================================
    	      double num22 = round(rf.getOverPaid(num21,it.tax), 2);
    	      form1.setField("f1_48_0_", num22 + "");
    	      double num23 = num22;
    	      form1.setField("f1_50_0_", num23 + "");
    	      form1.setField("f1_52_0_", rf.routing_num + "");
    	      form1.setField("c1_4_0_", rf.checkingOrSaving);
    	      form1.setField("f1_53_0_", rf.account_num + "");
    	      form1.setField("f1_74_0_", rf.mail_outUS_add);
    	      form1.setField("f1_52_0_", rf.routing_num + "");
    	      form1.setField("f1_54_0_", rf.tax_2015);
    	      double num25 = round(rf.getAmountOwned(num21,it.tax), 2);
    	      form1.setField("f1_56_0_", num25 + "");
    	      form1.setField("f1_58_0_", rf.tax_penalty + "");
    	      
    	      stamp1.close();
    	} catch (Exception de) {
    	      de.printStackTrace();
    	}
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

/*
 * first name = 	f1_01_0_
 * last name = 		f1_02_0_
 * identifying number = f1_03_0_
 * home address = 	f1_04_0_
 * city state zip code = f1_05_0_
 * foreign country name = TextField1
 * foreign province = f1_73_0_
 * foreign post code = f1_301_0_
 * [1] single is "1" , married is "2" = c1_2_0_
 * 		 
 * ------------------------------------------
 * 
 * Wage[3] = f1_10_0_
 * Taxable Refund[4] = f1_12_0_
 * [5] Scholarship = f1_14_0_
 * [6] treaty = f1_16_0_
 * [6]-2 treaty type  = f1_17_0_
 * [7] sum 3,4,5 = f1_18_0_
 * [8]  Scholarship exclude = f1_20_0_
 * [10]  7-8-9 = f1_24_0_
 * [11] itemized deduction = f1_26_0_
 * [12] 10-11 = f1_28_0_
 * [13] exemption is 3950 = f1_30_0_
 * [14] taxable income 12-13 = f1_32_0_
 * [15] tax = f1_34_0_
 * [17] is 15 = f1_38_0_
 * [18a] Federal withheld w2 = f1_40_0_
 * [18b]Federal withheld 1042-s = f1_100_0_
 * [19] last year retuen = f1_42_0_
 * [20] 1040c = f1_44_0_
 * [21] total payments = f1_46_0_
 * --------------------------------------------
 * [22] over paid = f1_48_0_
 * [23a] refund = f1_50_0_
 * [23b] routing number = f1_52_0_
 * [23c] checking "1" , saving "2"= c1_4_0_ 
 * [23d] account number = f1_53_0_
 * [23e] mail address outside US = f1_74_0_
 * [24] 2015 tax estimate = f1_54_0_
 * [25] amount you own = f1_56_0_
 * [26] tax penalty = f1_58_0_
 * -------------------------------------------------
 * occuption =f1_61_0_
 * protion PIN = f1_130
 * ----------------------------------------------
 * PAGE 2 
 * [A] citizenship = f2_01_0_ 
 * [B] residence = f2_02_0_
 * [C] if green card "1","2"= c2_01_0_
 * [D1] US citizen 1/2= c2_35_0_
 * [D2] green card holder 1/2 = c2_37_0_ 
 * [E] VISA STATUS = f2_19_0_
 * [Fa] VISA TYPE CHANGE 1/2= c2_36_0_
 * [Fb] visa type change = f2_18_0_
 * [G] in 1 = f2_019_0_
 * 		out 1 = f2_22_0_
 * 		in 2 = f2_31_0_
 * 		out 2 = f2_34_0_  
 * 		in 3 = f2_43_0_
 * 		out 3 = f2_46_0_
 * 		in 4 =f2_55_0_
 * 		out 4 = f2_58_0_
 * 		in 5 = f2_25_0_
 * 		out 5 = f2_28_0_
 * 		in 6 = f2_37_0_
 * 		out 6 = f2_40_0_
 * 		in 7 = f2_49_0_
 * 		out 7 = f2_52_0_
 * 		in 8 = f2_61_0_
 * 		out 8 = f2_64_0_
 * [H]2012 = f2_15_0_
 * 	  2013 = f2_16_0_
 *    2014 = f2_17_0_
 * [I]a 1/2 = c2_22_0_
 * [I]b prior year form number = f2_129_0_
 * [J]1 (a) country = f2_127_0_
 *      (b) article 20 = f2_128_0_
 *      (c) prior tax year month = f2_129_0_
 *      (d) amount of exemption 5000 = f2_130_0_
 *      (e) treaty total = f2_143_0_ 
 *    2  1/2 = c2_34_0_	
 *    
 * 			  
 * 
 * 
 * */
