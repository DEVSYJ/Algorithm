package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class courses30_lessons17681 {
	// 지도 한 변의 크기
	static int n = 5;
	static int[] arr1 = {9, 20, 28, 18, 11};
	static int[] arr2 = {30, 1, 21, 17, 28};
	// 출력	["#####","# # #", "### #", "# ##", "#####"]

	public static void main(String[] args) {
		String[] result = solution(n, arr1, arr2);
		System.out.println(result);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[][] stringMap = combineMap(n, toMap(n, arr1), toMap(n, arr2));

		return flatMap(n, stringMap);
	}

	private static String[][] toMap(int n, int[] arr) {
		String[][] result = new String[n][n];

		for (int i = 0; i < n; i++) {
			int oneLine = arr[i];
			for (int j = 0; j < n; j++) {
				int denominator = (int)Math.pow(2, ((n - 1) - j));
				result[i][j] = oneLine / denominator == 1 ? "#" : " ";
				oneLine %= (Math.pow(2, ((n - 1) - j)));
			}
		}

		return result;
	}

	private static String[][] combineMap(int n, String[][] arr1, String[][] arr2) {
		String[][] result = arr1.clone();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr2[i][j].equals("#")) {
					result[i][j] = "#";
				}
			}
		}

		return result;
	}

	private static String[] flatMap(int n, String[][] map) {
		String[] result = new String[n];

		for (int i = 0; i < n; i++) {
			String[] oneLine = map[i];
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < n; j++) {
				temp.append(oneLine[j]);
			}
			result[i] = temp.toString();
		}

		return result;
	}

}
