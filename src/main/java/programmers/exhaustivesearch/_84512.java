package programmers.exhaustivesearch;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class _84512 {

	private static final String[] alphabets = new String[] {"A", "E", "I", "O", "U"};

	private static int index;
	private static int answer;

	public static void main(String[] args) {
		// System.out.println(solution("AAAAE"));
		// System.out.println(solution("AAAE"));
		// System.out.println(solution("I"));
		// System.out.println(solution("EIO"));
		System.out.println(solution2("AAAAE"));
		System.out.println(solution2("AAAE"));
		System.out.println(solution2("I"));
		System.out.println(solution2("EIO"));
	}

	// DFS.
	/*
	테스트 1 〉	통과 (1.16ms, 72.5MB)
	테스트 2 〉	통과 (1.16ms, 74.6MB)
	테스트 3 〉	통과 (1.17ms, 81.6MB)
	테스트 4 〉	통과 (1.14ms, 83.9MB)
	테스트 5 〉	통과 (1.42ms, 84.7MB)
	테스트 6 〉	통과 (1.18ms, 76MB)
	테스트 7 〉	통과 (1.60ms, 75.6MB)
	테스트 8 〉	통과 (1.27ms, 78.8MB)
	테스트 9 〉	통과 (1.23ms, 78.8MB)
	테스트 10 〉	통과 (1.14ms, 71.7MB)
	테스트 11 〉	통과 (1.13ms, 77.4MB)
	테스트 12 〉	통과 (1.86ms, 72.2MB)
	테스트 13 〉	통과 (1.12ms, 72.3MB)
	테스트 14 〉	통과 (1.10ms, 73.3MB)
	테스트 15 〉	통과 (1.19ms, 78.5MB)
	테스트 16 〉	통과 (1.33ms, 75.1MB)
	테스트 17 〉	통과 (1.36ms, 75.5MB)
	테스트 18 〉	통과 (1.28ms, 75MB)
	테스트 19 〉	통과 (1.68ms, 81.7MB)
	테스트 20 〉	통과 (1.23ms, 75MB)
	테스트 21 〉	통과 (4.48ms, 84.6MB)
	테스트 22 〉	통과 (1.46ms, 75.6MB)
	테스트 23 〉	통과 (1.34ms, 75.3MB)
	테스트 24 〉	통과 (1.24ms, 78.4MB)
	테스트 25 〉	통과 (2.01ms, 76.2MB)
	테스트 26 〉	통과 (1.83ms, 79.8MB)
	테스트 27 〉	통과 (3.47ms, 77.9MB)
	테스트 28 〉	통과 (1.74ms, 73.7MB)
	테스트 29 〉	통과 (1.36ms, 78.7MB)
	테스트 30 〉	통과 (1.22ms, 71.9MB)
	테스트 31 〉	통과 (1.27ms, 72.7MB)
	테스트 32 〉	통과 (1.53ms, 81.9MB)
	테스트 33 〉	통과 (3.59ms, 71.3MB)
	테스트 34 〉	통과 (1.45ms, 77.6MB)
	테스트 35 〉	통과 (1.43ms, 79.2MB)
	테스트 36 〉	통과 (1.12ms, 75.7MB)
	테스트 37 〉	통과 (1.77ms, 76.7MB)
	테스트 38 〉	통과 (1.34ms, 73.8MB)
	테스트 39 〉	통과 (1.97ms, 74.3MB)
	테스트 40 〉	통과 (1.47ms, 78.1MB)
	 */
	public static int solution(String word) {
		index = 0;
		dfs(new StringBuilder(), word,  false);
		return answer;
	}

	private static void dfs(StringBuilder search, String word, boolean isSearched) {
		// System.out.println(search + " - " + index);

		if (search.toString().equals(word)) {
			answer = index;
			isSearched = true;
			return;
		}
		if (search.length() >= 5) {
			return;
		}

		for (String alphabet : alphabets) {
			if (isSearched) {
				break;
			}
			search.append(alphabet);
			index++;
			dfs(search, word, false);
			search.deleteCharAt(search.length() - 1);
		}
	}


	/*
	테스트 1 〉	통과 (0.02ms, 78.4MB)
	테스트 2 〉	통과 (0.02ms, 76.7MB)
	테스트 3 〉	통과 (0.02ms, 78.7MB)
	테스트 4 〉	통과 (0.02ms, 67.1MB)
	테스트 5 〉	통과 (0.01ms, 71.6MB)
	테스트 6 〉	통과 (0.02ms, 72.9MB)
	테스트 7 〉	통과 (0.02ms, 78.7MB)
	테스트 8 〉	통과 (0.02ms, 73.9MB)
	테스트 9 〉	통과 (0.02ms, 74.7MB)
	테스트 10 〉	통과 (0.02ms, 72.1MB)
	테스트 11 〉	통과 (0.04ms, 77.6MB)
	테스트 12 〉	통과 (0.03ms, 76.9MB)
	테스트 13 〉	통과 (0.02ms, 93.4MB)
	테스트 14 〉	통과 (0.02ms, 74.6MB)
	테스트 15 〉	통과 (0.03ms, 85.9MB)
	테스트 16 〉	통과 (0.02ms, 88.3MB)
	테스트 17 〉	통과 (0.02ms, 82.3MB)
	테스트 18 〉	통과 (0.02ms, 83.7MB)
	테스트 19 〉	통과 (0.02ms, 79MB)
	테스트 20 〉	통과 (0.02ms, 80.3MB)
	테스트 21 〉	통과 (0.02ms, 73.3MB)
	테스트 22 〉	통과 (0.02ms, 65.2MB)
	테스트 23 〉	통과 (0.02ms, 71.3MB)
	테스트 24 〉	통과 (0.02ms, 68.3MB)
	테스트 25 〉	통과 (0.03ms, 77.2MB)
	테스트 26 〉	통과 (0.02ms, 81.4MB)
	테스트 27 〉	통과 (0.02ms, 77.2MB)
	테스트 28 〉	통과 (0.04ms, 80.3MB)
	테스트 29 〉	통과 (0.02ms, 79.3MB)
	테스트 30 〉	통과 (0.02ms, 79MB)
	테스트 31 〉	통과 (0.02ms, 70.9MB)
	테스트 32 〉	통과 (0.02ms, 67.8MB)
	테스트 33 〉	통과 (0.02ms, 76.9MB)
	테스트 34 〉	통과 (0.01ms, 89MB)
	테스트 35 〉	통과 (0.02ms, 85.9MB)
	테스트 36 〉	통과 (0.02ms, 78.6MB)
	테스트 37 〉	통과 (0.02ms, 83.7MB)
	테스트 38 〉	통과 (0.02ms, 75.3MB)
	테스트 39 〉	통과 (0.02ms, 67.7MB)
	테스트 40 〉	통과 (0.02ms, 73.5MB)
	 */
	public static int solution2(String word) {
		index = 0;
		return dictionary.get(word);
	}
	private static Map<String, Integer> dictionary = makeDictionary();

	private static Map<String, Integer> makeDictionary() {
		Map<String, Integer> dictionary = new HashMap<>();
		addWord(dictionary, new StringBuilder());
		return dictionary;
	}

	private static void addWord(Map<String, Integer> dictionary, StringBuilder word) {
		// System.out.println(word + " - " + index);
		if (word.length() >= 5) {
			return;
		}

		for (String alphabet : alphabets) {
			word.append(alphabet);
			index++;
			dictionary.put(word.toString(), index);
			addWord(dictionary, word);
			word.deleteCharAt(word.length() - 1);
		}
	}
}
