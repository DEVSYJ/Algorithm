package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1152
 */
public class _1152 {
	public static int countWord(String str) {
		String[] words = str.split(" ");
		if (words.length != 0 && words[0].equals("")) {
			return words.length - 1;
		}
		return words.length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		System.out.println(countWord(str));
	}
}
