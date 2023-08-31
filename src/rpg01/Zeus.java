package rpg01;

import java.util.ArrayList;
import java.util.Arrays;

public class Zeus extends Character {
	public Zeus() {
		name = "ゼウス";
		health = 1000;
		maxHealth = 1000;
		attack = 1000;
	}

	public void talkPrologue(ArrayList<Character> characters) {
		System.out.println("\r\nホッホホ～イ");
		GameMaster.WaitTime(1);
		System.out.println("わしじゃよ💛");
		GameMaster.WaitTime(1);
		System.out.println(characters.get(0).name + "「ゼ・ウ・ス！」");
		GameMaster.WaitTime(1);
		System.out.println(characters.get(1).name + "「ゼ・ウ・ス！」");
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
			System.out.println("ほっほっほ　ええのう💛");
			GameMaster.WaitTime(1);
			System.out.println("…では遠慮なく…");
			GameMaster.WaitTime(1);
			System.out.println("どんどんいくぞい💛");
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void Attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:通常攻撃 1:黄昏流星群！！");

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
			meteorJab(enemies);
			break;
		}
	}

	private void meteorJab(Enemy[] enemies) {
		System.out.println("ほぃああああああ💛");
		GameMaster.WaitTime(1);
		System.out.println("固有スキル「黄昏流星群！！」を発動しました。");
		GameMaster.WaitTime(1);

		String message = "攻撃対象を数字で選択してください。\r\n";

		for (Enemy enemy : enemies) {
			if (enemy.health > 0) {
				message += String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix()
						+ " ";
			}
		}

		System.out.println(message);
		int enemyIndex = 0;
		Enemy enemy = enemies[0];

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
