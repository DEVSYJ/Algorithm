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

	@Test
	void _181943() {
		String my_string = "He11oWor1d";
		String overwrite_string = "lloWorl";
		int s = 2;

		String answer = my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());

		assertThat(answer)
				.isEqualTo("HelloWorld");
	}

	@Test
	void _181942() {
		String str1 = "aaaaa";
		String str2 = "bbbbb";

		StringBuilder sb = new StringBuilder();

		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();

		for (int i = 0; i < str1.length(); i++) {
			sb.append(chars1[i]);
			sb.append(chars2[i]);
		}

		assertThat(sb.toString())
				.isEqualTo("ababababab");
	}
}
