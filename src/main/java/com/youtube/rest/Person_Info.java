package com.youtube.rest;

public class Person_Info {
	
	/** Fields
	 * 	first name = 			f1_01_0_
	 * 	last name = 			f1_02_0_
	 * 	identifying number = 	f1_03_0_		SSN号或者ITIN号
	 * 	home address = 			f1_04_0_
	 * 	city state ZIP code = 	f1_05_0_
	 * 	foreign country name = 	TextField1
	 * 	foreign province = 		f1_73_0_
	 * 	foreign post code = 	f1_301_0_
	 * 	[1] single is "1"  = 	c1_2_0_
	 *  [2] married is "2" = 	c1_2_0_
	 * */
	String first_name;
	String last_name;
	String identifying_num;
	String home_address;
	String city_state_zip;
	String foreign_country;
	String foreign_prov;
	String foreign_zip;
	String isSingle;
	//Income_and_Tax incometax = new Income_and_Tax();
	
	/**Constructor */
	public Person_Info() {
		super();
	}

	public Person_Info(String first_name, String last_name, String identifying_num, String home_address,
			String city_state_zip, String foreign_country, String foreign_prov, String foreign_zip, String isSingle) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.identifying_num = identifying_num;
		this.home_address = home_address;
		this.city_state_zip = city_state_zip;
		this.foreign_country = foreign_country;
		this.foreign_prov = foreign_prov;
		this.foreign_zip = foreign_zip;
		this.isSingle = isSingle;
	}
	
	/**Getter and Setter*/
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getIdentifying_num() {
		return identifying_num;
	}

	public void setIdentifying_num(String identifying_num) {
		this.identifying_num = identifying_num;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getCity_state_zip() {
		return city_state_zip;
	}

	public void setCity_state_zip(String city_state_zip) {
		this.city_state_zip = city_state_zip;
	}

	public String getForeign_country() {
		return foreign_country;
	}

	public void setForeign_country(String foreign_country) {
		this.foreign_country = foreign_country;
	}

	public String getForeign_prov() {
		return foreign_prov;
	}

	public void setForeign_prov(String foreign_prov) {
		this.foreign_prov = foreign_prov;
	}

	public String getForeign_zip() {
		return foreign_zip;
	}

	public void setForeign_zip(String foreign_zip) {
		this.foreign_zip = foreign_zip;
	}

	public String getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(String isSingle) {
		this.isSingle = isSingle;
	}


}
