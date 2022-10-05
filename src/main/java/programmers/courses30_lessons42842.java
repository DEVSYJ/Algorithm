package programmers;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class courses30_lessons42842 {
	public static void main(String[] args) {
		System.out.println(solution(10, 2));
	}

	public static int[] solution(int brown, int yellow) {
		// 가로 길이는 3 ~ 2499 (2499 * 3)
		for (int isRow = 3; isRow < 2500; isRow++) {
			//  세로 길이는 3 ~ 1249 (5000 / 4 - 1)
			for (int isColumn = 0; isColumn < 1250; isColumn++) {
				if (isRow < isColumn) {
					continue;
				}

				if (((isRow - 2) * (isColumn - 2) == yellow) &&
					((2 * (isRow - 1)) + (2 * (isColumn - 1)) == brown)) {

					System.out.println(isRow);
					System.out.println(isColumn);

					return new int[] {isRow, isColumn};
				}
			}
		}

		return new int[] {0, 0};
	}
}
