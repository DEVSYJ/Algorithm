package programmers.greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
/*
이 문제가 그리디... 를 사용한다는 것은
순간에 최적의 선택을 하면 답이 나온다는 거지만, 그거에 대한 확신이 없다.

 */
public class _42885 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 10, 5, 3, 20}, 100));
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);

		Deque<Integer> deque = new LinkedList<>();
		for (int person : people) {
			deque.add(person);
		}

		int boatCount = 0;
		while (!deque.isEmpty()) {
			int heaviest = deque.pollLast();
			int lightest = 0;
			if (!deque.isEmpty()) {
				lightest = deque.peekFirst();
			}

			if (heaviest + lightest <= limit) {
				deque.pollFirst();
			}

			boatCount++;
		}

		return boatCount;
	}

	public static int kingBatNunSolution1(int[] people, int limit) {
		Arrays.sort(people);

		boolean[] boarding = new boolean[people.length];

		int boatCount = 0;
		int boardingCount = 0;

		while (boardingCount != people.length) {
			int currentBoardingWeight = 0;
			int currentBoardingCount = 0;
			for (int i = people.length - 1; i >= 0; i--) {
				if (currentBoardingCount == 2) {
					break;
				}
				if (boarding[i]) {
					continue;
				}
				if (currentBoardingWeight + people[i] <= limit) {
					currentBoardingWeight += people[i];
					boarding[i] = true;
					boardingCount++;
					currentBoardingCount++;
				}
			}
			boatCount++;
		}

		return boatCount;
	}
}
