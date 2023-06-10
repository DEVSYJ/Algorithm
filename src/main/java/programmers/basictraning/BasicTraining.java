package programmers.basictraning;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicTraining {
	@Test
	// 대소문자 바꿔서 출력하기
	public void _181949() {
		String a = "aBcDeFg";
		char[] strArr = a.toCharArray();

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] >= 64 && strArr[i] <= 90) {			// 대문자
				strArr[i] += 32;
			} else if (strArr[i] >= 97 && strArr[i] <= 122) {	// 소문자
				strArr[i] -= 32;
			}
		}

		System.out.println(strArr);
	}
}
