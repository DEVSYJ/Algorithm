package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _14499 {
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line1 = br.readLine();
		String[] line1Part = line1.split(" ");

		int N = Integer.parseInt(line1Part[0]);    // 세로
		int M = Integer.parseInt(line1Part[1]);    // 가로
		int x = Integer.parseInt(line1Part[2]);    // 주사위 x (0 ≤ x ≤ N-1)
		int y = Integer.parseInt(line1Part[3]);    // 주사위 y (0 ≤ y ≤ M-1)
		int K = Integer.parseInt(line1Part[4]);    // 명령 갯수 (1 ≤ K ≤ 1,000)

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		int[] orders = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		br.close();

		Cube cube = new Cube(x, y);
		for (int order : orders) {
			if (!checkMovable(cube, order)) {
				continue;
			}
			cube = cube.rollCube(order);
			System.out.println(cube.upside);
			moveValueIfNonValue(cube);
		}
	}

	private static void moveValueIfNonValue(Cube cube) {
		if (map[cube.x][cube.y] == 0) {
			map[cube.x][cube.y] = cube.downside;
		} else {
			cube.downside = map[cube.x][cube.y];
			map[cube.x][cube.y] = 0;
		}
	}

	private static boolean checkMovable(Cube cube, int order) {
		switch (order) {
			// 동쪽
			case 1:
				if (cube.y >= map[0].length - 1) {
					return false;
				}
				break;
			// 서쪽
			case 2:
				if (cube.y <= 0) {
					return false;
				}
				break;
			// 북쪽
			case 3:
				if (cube.x <= 0) {
					return false;
				}
				break;
			// 남쪽
			case 4:
				if (cube.x >= map.length - 1) {
					return false;
				}
				break;
		}
		return true;
	}

	static class Cube {
		// 주사위 좌표
		int x;
		int y;

		// 주사위에 쓰인 숫자
		int upside = 0;
		int downside = 0;
		int eastside = 0;
		int westside = 0;
		int southside = 0;
		int northside = 0;

		public Cube(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Cube rollCube(int direction) {
			int originUp = this.upside;
			int originDown = this.downside;
			int originEast = this.eastside;
			int originWest = this.westside;
			int originSouth = this.southside;
			int originNorth = this.northside;

			switch (direction) {
				// 동쪽
				case 1:
					// 남, 북 그대로
					upside = originWest;
					westside = originDown;
					downside = originEast;
					eastside = originUp;
					y++;
					break;
				// 서쪽
				case 2:
					// 남, 북 그대로
					upside = originEast;
					westside = originUp;
					downside = originWest;
					eastside = originDown;
					y--;
					break;
				// 북쪽
				case 3:
					// 동, 서 그대로
					upside = originSouth;
					southside = originDown;
					downside = originNorth;
					northside = originUp;
					x--;
					break;
				// 남쪽
				case 4:
					// 동, 서 그대로
					upside = originNorth;
					southside = originUp;
					downside = originSouth;
					northside = originDown;
					x++;
					break;
			}

			return this;
		}
	}
}
