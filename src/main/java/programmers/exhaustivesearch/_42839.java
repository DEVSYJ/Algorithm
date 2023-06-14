package programmers.exhaustivesearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
courses/30/lessons/42839
 */
public class _42839 {
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

	private static boolean[] primeNumberArray = getPrimeNumberArray();

	public static int solution(String numbers) {
		int answer = 0;

		Set<Integer> possibleNumberSet = getPossibleNumber(numbers);
		for (Integer possibleNumber : possibleNumberSet) {
			if (primeNumberArray[possibleNumber]) {
				answer++;
			}
		}

		return answer;
	}

	private static Set<Integer> getPossibleNumber(String numbers) {
		Set<Integer> numberSet = new HashSet<>();

		char[] numberCharArray = numbers.toCharArray();

		for (int i = 0; i < numbers.length(); i++) {
			makePossibleNumber("", i, numberCharArray.clone(), numbers.length(), numberSet);
		}

		return numberSet;
	}

	private static void makePossibleNumber(String now, int index, char[] checkNumberCharArray, int endLength,
		Set<Integer> possibleNumber) {
		now += checkNumberCharArray[index];
		possibleNumber.add(Integer.parseInt(now));
		checkNumberCharArray[index] = '-';

		for (int i = 0; i < endLength; i++) {
			if (checkNumberCharArray[i] == '-') {
				continue;
			}
			makePossibleNumber(now, i, checkNumberCharArray.clone(), endLength, possibleNumber);
		}
	}

	// public static Set<Integer> getPrimeNumber(int length) {
	// 	Set<Integer> primeNumbers = new HashSet<>();
	//
	// 	boolean isPrimeNumber;
	// 	for (int i = 2; i < Math.pow(10, length); i++) {
	// 		isPrimeNumber = true;
	// 		for (int j = 2; j < i / 2; j++) {
	// 			if (i % j == 0) {
	// 				isPrimeNumber = false;
	// 				break;
	// 			}
	// 		}
	// 		if (isPrimeNumber) {
	// 			primeNumbers.add(i);
	// 		}
	// 	}
	//
	// 	return primeNumbers;
	// }

	public static boolean[] getPrimeNumberArray() {
		boolean[] primeNumberArray = new boolean[10000000];
		// 일단 모든 값을 소수로 초기화
		Arrays.fill(primeNumberArray, true);

		primeNumberArray[0] = false;
		primeNumberArray[1] = false;

		for (int i = 4; i < 9999999; i++) {
			for (int j = 2; j <= Math.sqrt(9999999); j++) {
				if (!primeNumberArray[i]) {
					break;
				}

				if (i != j && i % j == 0) {
					primeNumberArray[i] = false;
					break;
				}
			}
		}
		return primeNumberArray;
	}

	@Test
	public void getPrimeNumberArrayTest() {
		System.out.println(getPrimeNumberArray());
	}

}
