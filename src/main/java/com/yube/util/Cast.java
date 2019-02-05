package com.yube.util;

public class Cast {
	public static double strTOdoub(String value) {
		try {
			return Double.valueOf(value.replace(",", "."));
		} catch (Exception e) {
			System.out.println("hata : " + e.getMessage());
			return 0;
		}
	}

	public static double doubTOrate(double firstValue, double secondValue) {
		try {
			return ((firstValue / secondValue) - 1) * 100;
		} catch (Exception e) {
			System.out.println("hata : " + e.getMessage());
			return 0;
		}
	}
}
