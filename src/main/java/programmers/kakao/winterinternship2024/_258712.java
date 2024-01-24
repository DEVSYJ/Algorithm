package programmers.kakao.winterinternship2024;

import java.util.HashMap;
import java.util.Map;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
public class _258712 {
	public static void main(String[] args) {
		int result = solution(new String[] {"muzi", "ryan", "frodo", "neo"},
			new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan",
				"neo muzi"});
		System.out.println(result);
	}

	public static int solution(String[] friends, String[] gifts) {
		// key : sender name
		// value : {sender name} info
		Map<String, Friend> friendMap = new HashMap<>();
		for (String friend : friends) {
			friendMap.put(friend, new Friend(friend));
		}

		// 이번달 상태 셋팅
		for (String giftHistory : gifts) {
			String[] gh = giftHistory.split(" ");
			String senderName = gh[0];
			String receiverName = gh[1];

			Friend sender = friendMap.get(senderName);
			Friend receiver = friendMap.get(receiverName);

			sender.giftIndex++;
			receiver.giftIndex--;

			int giveCount = 1;
			Map<String, Integer> giveCountMap = sender.giveCountMap;
			if (giveCountMap.containsKey(receiverName)) {
				giveCount += giveCountMap.get(receiverName);
			}
			giveCountMap.put(receiverName, giveCount);
			friendMap.put(senderName, sender);
		}

		// 다음달 예측
		int maxGiftReceiveCount = 0;
		for (int i = 0; i < friends.length; i++) {
			for (int j = i + 1; j < friends.length; j++) {
				String aName = friends[i];
				String bName = friends[j];

				Friend a = friendMap.get(aName);
				Friend b = friendMap.get(bName);

				if (a.getGiveCount(bName) > b.getGiveCount(aName)) {
					a.expectedReceiveGiftCount++;
				} else if (a.getGiveCount(bName) < b.getGiveCount(aName)) {
					b.expectedReceiveGiftCount++;
				} else {
					if (a.giftIndex > b.giftIndex) {
						a.expectedReceiveGiftCount++;
					} else if (a.giftIndex < b.giftIndex) {
						b.expectedReceiveGiftCount++;
					}
				}

				maxGiftReceiveCount = Math.max(maxGiftReceiveCount, Math.max(a.expectedReceiveGiftCount, b.expectedReceiveGiftCount));
			}
		}

		return maxGiftReceiveCount;
	}

	public static class Friend {
		public String name;
		/**
		 * 선물 지수 : 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
		 */
		public int giftIndex = 0;
		/**
		 * key : receiver name<br>
		 * value : {name}이 {receiver name}에게 선물을 준 횟수
		 */
		public Map<String, Integer> giveCountMap = new HashMap<>();
		public int expectedReceiveGiftCount = 0;

		public Friend(String name) {
			this.name = name;
		}

		public Integer getGiveCount(String key) {
			if (giveCountMap.containsKey(key)) {
				return giveCountMap.get(key);
			}
			return 0;
		}
	}
}
