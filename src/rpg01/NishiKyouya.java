package rpg01;

import java.util.ArrayList;

public class NishiKyouya extends Character {
	public NishiKyouya() {
		name = "西恭弥";
		health = 500;
		maxHealth = 500;
		attack = 100;
	}

	public void talkPrologue(ArrayList<Character> characters) {
		System.out.println("\r\n……フーアムアイ？");
		GameMaster.WaitTime(1);
		System.out.println("……フーアムアイ！！！");
		GameMaster.WaitTime(2);
		System.out.println(characters.get(0).name + "、" + characters.get(1).name + "「God of…… BlackField!!!」");
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.WaitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.WaitTime(2);

		if (health <= 0) {
			System.out.println("ドサッ");
			GameMaster.WaitTime(1);
			System.out.println("やられたのか…");
			GameMaster.WaitTime(1);
			System.out.println("だが…");
			GameMaster.WaitTime(1);
			System.out.println("背後から？");
			GameMaster.WaitTime(1);
			System.out.println("狙撃…？");
			GameMaster.WaitTime(1);
			System.out.println("誰かが");
			GameMaster.WaitTime(1);
			System.out.println("裏切っ…");
		} else {
			System.out.println("くぅっ");
			GameMaster.WaitTime(1);
			System.out.println("ヤロウ…");
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void Attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:通常攻撃 1:スミセン！！オレを誰だと思ってやがる！！ ");

		int number = 0;

		try {
			number = GameMaster.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.WaitTime(1);
			Attack(enemies);
		}

		GameMaster.WaitTime(1);

		switch (number) {
		case 0:
			AA(enemies);
			break;
		case 1:
			konomamaTukkiru();
			break;
		}
	}

	private void konomamaTukkiru() {
		System.out.println("もう少し耐えてくれ。");
		GameMaster.WaitTime(1);
		System.out.println("敵の本部はもう目の前だ");
		GameMaster.WaitTime(1);
		System.out.println("ガチャ");
		GameMaster.WaitTime(1);
		System.out.println("このまま突っ切る！！");
		GameMaster.WaitTime(3);
		System.out.println("バァン");
		GameMaster.WaitTime(1);
		System.out.println("ぐはっ");
		GameMaster.WaitTime(1);
		System.out.println("何だ…？");
		GameMaster.WaitTime(1);

		getDamage(9999);
	}
}
