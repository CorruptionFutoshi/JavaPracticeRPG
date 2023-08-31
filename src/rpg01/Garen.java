package rpg01;

import java.util.ArrayList;

public class Garen extends Ally {
	public Garen() {
		name = "ガレン";
		health = 690;
		maxHealth = 690;
		attack = 69;
	}

	public void talkPrologue(ArrayList<Ally> allies) {
		System.out.println("\r\n俺の名は" + name);
		GameMaster.waitTime(1);
		System.out.println(allies.get(0).name + "、それから" + allies.get(1).name + "と共に、今は日課の山歩きをしているところだ");
		GameMaster.waitTime(1);
		System.out.println(name + "、" + allies.get(0).name + "、" + allies.get(1).name + "、俺「だまっしあ！」");
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println(name + "は力尽きた");
		} else {
			System.out.println(name + "はタフな男だ。");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:通常攻撃 1:ジャッジメント ");

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
			castJudgement(enemies);
			break;
		}
	}

	private void castJudgement(Enemy[] enemies) {
		System.out.println("蹴散らしてやる！");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「ジャッジメント」を発動しました。");
		GameMaster.waitTime(1);

		for (var enemy : enemies) {
			enemy.getDamage(attack * 2);
		}
	}
}
