package mysterycode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * http://youtube.com/zarigatongy HackerRank
 * 
 * @author Anish Nath
 * 
 */
public class MysteryCode {

	public static void main(String[] args) {
		int nBit = 3;
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		try {
			nBit = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			System.err.println("Input Must be Valid Integer"); 
			return;
		} catch (IOException e) {
			System.err.println("Input Must be Valid Integer"); 
			return;
		}

		if (nBit > 65 || nBit <= 0) {
			System.out.println("Valid  Range is 1<=N<=65");
			return;
		}
		
		if(nBit ==1)
		{
			System.out.println(1);
			return;		
		}

		List<Integer> result = mysteryCode(nBit);
		List<Integer> subList = result.subList(result.size()-nBit, result.size());

		for (int i : subList) {
			System.out.println(appendZero(nBit, Integer.toBinaryString(i)) + " ");
		}
		System.out.println("");
	}

	/**
	 * 
	 * @param n
	 *            the Nth Mystery Code
	 * @return List of Integer
	 */
	public static List<Integer> mysteryCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0) {
			list.add(0);
			return list;
		} else {
			List<Integer> prev = mysteryCode(n - 1);
			list.addAll(prev);
			for (int i = prev.size() - 1; i >= 0; i--) {
				list.add(prev.get(i) + (int) Math.pow(2.0, n - 1));

			}
			return list;
		}

	}

	/**
	 * 
	 * @param length
	 * @param input
	 * @return String appneded with Zero
	 */
	public static final String appendZero(int length, String input) {
		StringBuilder builder = new StringBuilder();

		// Format the Code
		if (input.length() != length) {
			while (true) {
				if (builder.length() != length - input.length()) {
					builder.append("0");
				}
				if (builder.length() == length - input.length()) {
					builder.append(input);
					break;
				}
			}
		}

		// Keep Adding the Input
		else if (input.length() == length) {
			builder.append(input);
		}

		return builder.toString();

	}

}
