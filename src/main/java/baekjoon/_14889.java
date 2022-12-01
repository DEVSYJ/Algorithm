package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/14889
public class _14889 {
	private static int[][] S;
	private static int N;
	private static int teamPersonnel;
	private static List<Integer> allPersonList = new ArrayList<>();
	private static int smallestAbility;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			allPersonList.add(i + 1);
			S[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		br.close();

		/*
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(S[i][j] + " ");
			}
			System.out.println();
		}
		*/

		teamPersonnel = N / 2;
		smallestAbility = N * 100;
		checkTeam(new ArrayList<>(), false, 1);
		checkTeam(new ArrayList<>(), true, 1);

		System.out.println(smallestAbility);
	}

	private static void checkTeam(List<Integer> team1, boolean isAddTeam, int checkCount) {
		if (checkCount == N) {
			return;
		}

		if (isAddTeam) {
			team1.add(checkCount + 1);
		}

		if(team1.size() == teamPersonnel) {
			calculateSmallestAbility(team1);
			return;
		}

		checkTeam(new ArrayList<>(team1), false, checkCount + 1);
		checkTeam(new ArrayList<>(team1), true, checkCount + 1);
	}

	private static void calculateSmallestAbility(List<Integer> team1) {
		List<Integer> team2 = new ArrayList<>(allPersonList);
		team2.removeAll(team1);

		int team1Ability = 0;
		int team2Ability = 0;
		for (int i = 0; i < teamPersonnel; i++) {
			for (int j = i + 1; j < teamPersonnel; j++) {
				team1Ability = team1Ability + S[team1.get(i) - 1][team1.get(j) - 1] + S[team1.get(j) - 1][team1.get(i) - 1];
				team2Ability = team2Ability + S[team2.get(i) - 1][team2.get(j) - 1] + S[team2.get(j) - 1][team2.get(i) - 1];
			}
		}

		int diffAbility = Math.abs(team1Ability - team2Ability);
		smallestAbility = Math.min(diffAbility, smallestAbility);
	}
}
