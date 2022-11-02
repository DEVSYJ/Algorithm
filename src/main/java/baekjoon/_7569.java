package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/7569
public class _7569 {
	private static int greenTomatoCount = 0;
	private static int M;
	private static int N;
	private static int H;
	private static String[][][] tomatos;
	private static Queue<RedTomato> dq = new LinkedList();
	private static final int[] nArr = {0, 0, -1, 1, 0, 0};
	private static final int[] mArr = {0, 0, 0, 0, -1, 1};
	private static final int[] hArr = {1, -1, 0, 0, 0, 0};

	private static int checkRedDate(int day, int redTomatoCount) {
		if (greenTomatoCount <= 0) {
			return day;
		}

		RedTomato redTomato;
		for (int oneRedTomato = 0; oneRedTomato < redTomatoCount; oneRedTomato++) {
			redTomato = dq.poll();
			for (int i = 0; i < 6; i++) {
				int checkH = redTomato.h + hArr[i];
				int checkN = redTomato.n + nArr[i];
				int checkM = redTomato.m + mArr[i];

				if (checkH < 0 || checkH >= H) {
					continue;
				}
				if (checkN < 0 || checkN >= N) {
					continue;
				}
				if (checkM < 0 || checkM >= M) {
					continue;
				}

				if (tomatos[checkH][checkN][checkM].equals("0")) {
					tomatos[checkH][checkN][checkM] = "1";
					dq.add(new RedTomato(redTomato.h + hArr[i], redTomato.n + nArr[i], redTomato.m + mArr[i]));
					greenTomatoCount--;
				}
			}
		}

		if (dq.size() == 0) {
			return -1;
		}

		return checkRedDate(day + 1, dq.size());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");

		M = Integer.parseInt(firstLine[0]);
		N = Integer.parseInt(firstLine[1]);
		H = Integer.parseInt(firstLine[2]);

		tomatos = new String[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				tomatos[i][j] = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					if (tomatos[i][j][k].equals("1")) {
						dq.add(new RedTomato(i, j, k));
					} else if (tomatos[i][j][k].equals("0")) {
						greenTomatoCount++;
					}
				}
			}
		}

		br.close();

		System.out.println(checkRedDate(0, dq.size()));
	}

	private static class RedTomato {
		int h;
		int n;
		int m;

		public RedTomato(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}

		@Override
		public String toString() {
			return "RedTomato{" +
				"h=" + h +
				", n=" + n +
				", m=" + m +
				'}';
		}
	}
}
