package programmers.exhaustivesearch;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class _86491 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
		System.out.println(solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
		System.out.println(solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
	}

	public static int solution(int[][] sizes) {
		int maxLength = 0;
		int maxWidth = 0;

		for (int[] size : sizes) {
			int x = size[0];
			int y = size[1];

			int temp;
			if (x < y) {
				temp = x;
				x = y;
				y = temp;
			}

			if (x > maxLength) {
				maxLength = x;
			}

			if (y > maxWidth) {
				maxWidth = y;
			}
		}

		return maxLength * maxWidth;
	}
}
