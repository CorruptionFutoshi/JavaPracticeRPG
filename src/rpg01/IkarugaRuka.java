package rpg01;

import java.util.ArrayList;

public class IkarugaRuka extends Character {
	public IkarugaRuka() {
		name = "カミサマ";
		health = 412;
		attack = 283;
	}

	public void talkPrologue(ArrayList<Character> characters) {
		System.out.println("\r\nチッ……あいつ、何考えてやがる……!");
		GameMaster.WaitTime(1);
		System.out.println(characters.get(0).name + "と" + characters.get(1).name + "と私でコメティック！？");
		GameMaster.WaitTime(1);
		System.out.println("――――っ……。――――――ぁ……………………。病んだ。");
		GameMaster.WaitTime(1);
	}

	public void Attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:通常攻撃 1:神様は死んだ、って ");

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
			kamisamahasindatte(enemies);
			break;
		}
	}

	private void kamisamahasindatte(Enemy[] enemies) {
		System.out.println("最低　最低　最低　なにもかも");
		GameMaster.WaitTime(1);
		System.out.println("固有スキル「神様は死んだ、って」を発動しました。");
		GameMaster.WaitTime(1);

		for (Enemy enemy : enemies) {
			enemy.getDamage(attack * 2);
		}
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.WaitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.WaitTime(2);

		if (health <= 0) {
			System.out.println("まずいね、このナポリタン……最悪な味がする");
		} else {
			System.out.println("チッ……クソッ……なんなんだよ……！");
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void getHeal(int heal) {
		System.out.println(name + "の体力が" + heal + "回復した！");
		health += heal;
	}
}
