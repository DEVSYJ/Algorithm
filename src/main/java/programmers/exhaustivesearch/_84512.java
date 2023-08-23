package programmers.exhaustivesearch;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
public class _84512 {

	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}

	private static final String[] alphabets = new String[] {"A", "E", "I", "O", "U"};

	// DFS.
	public static int solution(String word) {
		index = 0;
		dfs(new StringBuilder(), word,  false);
		return answer;
	}

	private static int index;
	private static int answer;

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
}
