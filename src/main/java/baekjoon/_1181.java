package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://www.acmicpc.net/problem/1181
 */
public class _1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1 ≤ N ≤ 20,000
		int N = Integer.parseInt(br.readLine());
		Set<String> words = new HashSet<>();
		for (int i = 0; i < N; i++) {
			words.add(br.readLine());
		}
		br.close();

		List<String> wordList = new ArrayList<>(words);
		Collections.sort(wordList, (o1, o2) -> {
			if (o1.length() < o2.length()) {
				return -1;
			} else if (o1.length() > o2.length()) {
				return 1;
			}

			return o1.compareTo(o2);
		});

		for (String word : wordList) {
			System.out.println(word);
		}
	}
}
