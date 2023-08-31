package rpg01;

import java.util.ArrayList;

public class Garen extends Character {
	public Garen() {
		name = "ガレン";
		health = 690;
		maxHealth = 690;
		attack = 69;
	}

	public void talkPrologue(ArrayList<Character> characters) {
		System.out.println("\r\n俺の名は" + name);
		GameMaster.WaitTime(1);
		System.out.println(characters.get(0).name + "、それから" + characters.get(1).name + "と共に、今は日課の山歩きをしているところだ");
		GameMaster.WaitTime(1);
		System.out.println(name + "、" + characters.get(0).name + "、" + characters.get(1).name + "、俺「だまっしあ！」");
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.WaitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.WaitTime(2);

		if (health <= 0) {
			System.out.println(name + "は力尽きた");
		} else {
			System.out.println(name + "はタフな男だ。");
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void Attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:通常攻撃 1:ジャッジメント ");

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
			judgement(enemies);
			break;
		}
	}

	private void judgement(Enemy[] enemies) {
		System.out.println("蹴散らしてやる！");
		GameMaster.WaitTime(1);
		System.out.println("固有スキル「ジャッジメント」を発動しました。");
		GameMaster.WaitTime(1);

		for (Enemy enemy : enemies) {
			enemy.getDamage(attack * 2);
		}
	}
}
