package programmers;

import java.util.Arrays;

public class courses30_lessons42747 {
	static int[] answer1 = {3, 0, 6, 1, 5};
	static int[] answer2 = {6, 5, 5, 5, 3, 2, 1, 0};

	public static void main(String[] args) {
		System.out.println(solution(answer1));
		System.out.println(solution(answer2));
	}

	public static int solution(int[] citations) {
		Arrays.sort(citations);

		int max = citations[citations.length - 1];

		for (int h = max; h >= 0; h--) {
			int up = 0;
			int down = 0;

			for (int citation:citations) {
				if (citation >= h) {
					up++;
				}
				if (citation <= h) {
					down++;
				}
			}

			if (up >= h && down <= h) {
				return h;
			}
		}

		return 0;
	}
}
