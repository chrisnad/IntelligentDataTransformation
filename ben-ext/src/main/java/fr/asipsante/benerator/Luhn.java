package fr.asipsante.benerator;

import java.util.concurrent.ThreadLocalRandom;

public class Luhn {
	
	public String genRndNum(int n) {
	    long min = (long) Math.pow(10, n - 1);
	    return String.valueOf(ThreadLocalRandom.current().nextLong(min, min * 10));
	}
	
	public String replaceChar(String str, String oldChars, String newChars) {
	    return str.replace(oldChars, newChars);
	}
	
	public static boolean Check(String ccNumber) {
		int sum = 0;
		boolean alternate = false;
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}
	
	public static int generateCheckDigit(String ccNumber) {
		int sum = 0;
		boolean alternate = true;
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum*9)%10;
	}

	public static String concatCheckDigit(String myNum) {
		return myNum + String.valueOf(generateCheckDigit(myNum));
	}
}