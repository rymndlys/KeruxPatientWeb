package com.kerux.security;

public class TestSecurity {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Security.decrypt("M0E51/D2unw4mOhSexTFXyRbO2atjxV1TnXW8spTXxfu7+GwRgXn86sL76hYaOOK"));
		System.out.println(Security.decrypt("Fo/pQuB2C1tNB/V2YoLWMA=="));
		System.out.println(Security.decrypt("ZObe4rdvMhFMUtf3CC/+Q4geanEZkM+gqoLhiF8fRIAkdNjfXlGyPv0RyWwv9FWE"));
		System.out.println(Security.decrypt("aliv/jZ2ur6kYXLP+CeJFQ=="));
		System.out.println(Security.decrypt("U1LDNN09Bdy1JQo6A5pzLA=="));
		System.out.println(Security.encrypt("jdbc:mysql://192.168.1.6/keruxfinal"));
		System.out.println(Security.encrypt("KeruxAdmin"));
		System.out.println(Security.encrypt("admin"));
		System.out.println("---------");
		System.out.println(Security.encrypt("keruxAdmin"));
		System.out.println(Security.encrypt("rootAdmin"));
		System.out.println(Security.encrypt("admin"));
		System.out.println("---------");
		System.out.println(Security.encrypt("jdbc:mysql://10.70.0.114/keruxtest"));
		System.out.println(Security.encrypt("jdbc:mysql://10.70.0.17/keruxdb"));
		System.out.println(Security.encrypt("root"));
		System.out.println(Security.encrypt(""));
		
		System.out.println(Security.encrypt("jdbc:mysql://192.168.1.2/keruxFinal"));
	}

}
