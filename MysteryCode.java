package mysterycode;

import java.util.ArrayList;
import java.util.List;

/**
 * http://youtube.com/zarigatongy
 * HackerRank
 * @author Anish Nath
 * 
 */
public class MysteryCode {

	public static void main(String[] args) {
		int nBit = 3;

		if (args != null && args.length > 0) {
			try {
				nBit = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Error in Input Valid  Range is 1<=N<=65 ");
				System.exit(0);
			}
		}
		if (nBit > 65 || nBit <= 0) {
			System.out.println("Valid  Range is 1<=N<=65");
			System.exit(0);
		}

		List<Integer> result = mysteryCode(nBit);

		for (int i : result) {
			System.out.print(appendZero(nBit, Integer.toBinaryString(i)) + " ");
		}
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
