package programmers;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */
public class courses30_lessons60057 {

	/**
	 * @return parseUnit 기준으로 압축된 문자열 길이
	 */
	private static int compressionWord(String fullString, int parseUnit) {
		String standardStr;
		String compareStr;
		int compressionCount = 1;
		StringBuilder sb = new StringBuilder();

		standardStr = fullString.substring(0, parseUnit);
		for (int i = parseUnit; i < fullString.length();) {
			int parseStartIndex = i;
			int parseEndIndex = i += parseUnit;
			if(parseEndIndex > fullString.length()) {
				parseEndIndex = fullString.length();
			}

			compareStr = fullString.substring(parseStartIndex, parseEndIndex);

			if (standardStr.equals(compareStr)) {
				compressionCount++;
			} else {
				if (compressionCount != 1) {
					sb.append(compressionCount);
				}
				sb.append(standardStr);
				compressionCount = 1;
				standardStr = compareStr;
			}
		}
		if (compressionCount != 1) {
			sb.append(compressionCount);
		}
		sb.append(standardStr);

		// System.out.println(sb);
		return sb.length();
	}



	public static int solution(String s) {
		int shortestLength = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			int length = compressionWord(s, i);

			// System.out.println(length);

			if (length < shortestLength) {
				shortestLength = length;
			}
		}
		return shortestLength;
	}

	public static void main(String[] args) {
		String s1 = "aabbaccc";
		System.out.println(solution(s1));

		String s2 = "ababcdcdababcdcd";
		System.out.println(solution(s2));

		String s3 = "abcabcdede";
		System.out.println(solution(s3));

		String s4 = "abcabcabcabcdededededede";
		System.out.println(solution(s4));

		String s5 = "xababcdcdababcdcd";
		System.out.println(solution(s5));
	}

}
