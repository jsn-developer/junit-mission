package level1;

import java.util.ArrayList;
import java.util.List;

public class Grammar {

	/**
	 * 奇数判定
	 * @param num 数値
	 * @return 引数が奇数:true 引数が偶数:false
	 */
	public boolean isOddNumber(int num) {
		return num % 2 == 1;
	}

	/**
	 * 時間をもとに適切な挨拶を返す
	 * @param time 時間
	 * @return 挨拶メッセージ
	 */
	public String greet(int time) {

		// ガード
		if (time > 24) {
			return "不正な数値です";
		}

		// 挨拶メッセージの変数宣言
		String msg;

		// 条件ごとに挨拶を格納
		if (time >= 5 && time < 12) {
			msg = "おはよう";
		} else if (time >= 12 && time < 19) {
			msg = "こんにちは";
		} else {
			msg = "こんばんは";
		}

		return msg;
	}

	/**
	 * メンバーリストを取得する
	 * @return メンバーリスト
	 */
	public List<String> getMember() {
		List<String> list = new ArrayList<>();

		list.add("tarou");
		list.add("hanako");
		list.add("john");
		list.add("mike");
		list.add("mary");

		return list;
	}
}
