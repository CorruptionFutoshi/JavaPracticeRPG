package rpg01;

import java.util.ArrayList;

public class IkarugaRuka extends Ally {
	public IkarugaRuka() {
		name = "カミサマ";
		health = 412;
		attack = 283;
	}

	public void talkPrologue(ArrayList<Ally> allies) {
		System.out.println("\r\nチッ……あいつ、何考えてやがる……!");
		GameMaster.waitTime(1);
		System.out.println(allies.get(0).name + "と" + allies.get(1).name + "と私でコメティック！？");
		GameMaster.waitTime(1);
		System.out.println("――――っ……。――――――ぁ……………………。病んだ。");
		GameMaster.waitTime(1);
	}

	public void attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:通常攻撃 1:神様は死んだ、って ");

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
			kamisamaHaSindatte(enemies);
			break;
		}
	}

	private void kamisamaHaSindatte(Enemy[] enemies) {
		System.out.println("最低　最低　最低　なにもかも");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「神様は死んだ、って」を発動しました。");
		GameMaster.waitTime(1);

		for (var enemy : enemies) {
			enemy.getDamage(attack * 2);
		}
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println("まずいね、このナポリタン……最悪な味がする");
		} else {
			System.out.println("チッ……クソッ……なんなんだよ……！");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void getHeal(int heal) {
		System.out.println(name + "の体力が" + heal + "回復した！");
		health += heal;
	}
}
