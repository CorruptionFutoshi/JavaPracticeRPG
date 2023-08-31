package rpg01;

import java.util.ArrayList;
import java.util.Arrays;

public class Zeus extends Ally {
	public Zeus() {
		name = "ゼウス";
		health = 1000;
		maxHealth = 1000;
		attack = 1000;
	}

	public void talkPrologue(ArrayList<Ally> allies) {
		System.out.println("\r\nホッホホ～イ");
		GameMaster.waitTime(1);
		System.out.println("わしじゃよ💛");
		GameMaster.waitTime(1);
		System.out.println(allies.get(0).name + "「ゼ・ウ・ス！」");
		GameMaster.waitTime(1);
		System.out.println(allies.get(1).name + "「ゼ・ウ・ス！」");
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
			System.out.println("ほっほっほ　ええのう💛");
			GameMaster.waitTime(1);
			System.out.println("…では遠慮なく…");
			GameMaster.waitTime(1);
			System.out.println("どんどんいくぞい💛");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:通常攻撃 1:黄昏流星群！！");

		int number = 0;

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
			meteorJab(enemies);
			break;
		}
	}

	private void meteorJab(Enemy[] enemies) {
		System.out.println("ほぃああああああ💛");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「黄昏流星群！！」を発動しました。");
		GameMaster.waitTime(1);

		var message = "攻撃対象を数字で選択してください。\r\n";

		for (var enemy : enemies) {
			if (enemy.health > 0) {
				message += String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix()
						+ " ";
			}
		}

		System.out.println(message);
		var enemyIndex = 0;
		var enemy = enemies[0];

		try {
			enemyIndex = GameMaster.scanner.nextInt();
			enemy = enemies[enemyIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			meteorJab(enemies);
		}

		enemy.getDamage(attack * 5);
	}
}
