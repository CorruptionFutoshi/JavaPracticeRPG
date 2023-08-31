package rpg01;

import java.util.ArrayList;

public class NishiKyouya extends Ally {
	public NishiKyouya() {
		name = "西恭弥";
		health = 500;
		maxHealth = 500;
		attack = 100;
	}

	public void talkPrologue(ArrayList<Ally> allies) {
		System.out.println("\r\n……フーアムアイ？");
		GameMaster.waitTime(1);
		System.out.println("……フーアムアイ！！！");
		GameMaster.waitTime(2);
		System.out.println(allies.get(0).name + "、" + allies.get(1).name + "「God of…… BlackField!!!」");
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println("ドサッ");
			GameMaster.waitTime(1);
			System.out.println("やられたのか…");
			GameMaster.waitTime(1);
			System.out.println("だが…");
			GameMaster.waitTime(1);
			System.out.println("背後から？");
			GameMaster.waitTime(1);
			System.out.println("狙撃…？");
			GameMaster.waitTime(1);
			System.out.println("誰かが");
			GameMaster.waitTime(1);
			System.out.println("裏切っ…");
		} else {
			System.out.println("くぅっ");
			GameMaster.waitTime(1);
			System.out.println("ヤロウ…");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:通常攻撃 1:スミセン！！オレを誰だと思ってやがる！！ ");

		var number = 0;

		try {
			number = GameMaster.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.waitTime(1);
			attack(enemies);
		}

		GameMaster.waitTime(1);

		switch (number) {
		case 0:
			aa(enemies);
			break;
		case 1:
			konomamaTukkiru();
			break;
		}
	}

	private void konomamaTukkiru() {
		System.out.println("もう少し耐えてくれ。");
		GameMaster.waitTime(1);
		System.out.println("敵の本部はもう目の前だ");
		GameMaster.waitTime(1);
		System.out.println("ガチャ");
		GameMaster.waitTime(1);
		System.out.println("このまま突っ切る！！");
		GameMaster.waitTime(3);
		System.out.println("バァン");
		GameMaster.waitTime(1);
		System.out.println("ぐはっ");
		GameMaster.waitTime(1);
		System.out.println("何だ…？");
		GameMaster.waitTime(1);

		getDamage(9999);
	}
}
