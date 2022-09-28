package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2941
 */
public class _2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(countCroatiaAlphabet(str));
		br.close();
	}

	private static int countCroatiaAlphabet(String str) {
		int result = 0;
		char[] charArr = str.toCharArray();

		for (int i = 0; i < charArr.length; i++) {
			int checkBit = isPossibleCroatiaAlphabet(i, charArr);
			i += checkBit;
			result += 1;
		}

		return result;
	}

	/**
	 *
	 * @param startIndex
	 * @param charArr
	 * @return 안맞을 경우 0, 맞을 경우 확인한 만큼의 size
	 */
	private static int isPossibleCroatiaAlphabet(int startIndex, char[] charArr) {
		char startChar = charArr[startIndex];
		if (startIndex == charArr.length - 1) {
			return 0;
		}

		char nextChar = charArr[startIndex + 1];

		if (startChar == 'c') {
			if (nextChar == '=') return 1;
			if (nextChar == '-') return 1;
		}

		if (startChar == 'd') {
			if (nextChar == 'z') {
				if (startIndex + 1 == charArr.length - 1) {
					return 0;
				}
				char thirdChar = charArr[startIndex + 2];
				if (thirdChar == '=') return 2;
			}
			if (nextChar == '-') return 1;
		}

		if (startChar == 'l') {
			if (nextChar == 'j') return 1;
		}

		if (startChar == 'n') {
			if (nextChar == 'j') return 1;
		}

		if (startChar == 's') {
			if (nextChar == '=') return 1;
		}

		if (startChar == 'z') {
			if (nextChar == '=') return 1;
		}

		return 0;
	}
}
