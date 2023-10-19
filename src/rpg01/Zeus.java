package rpg01;

import java.util.Arrays;

public class Zeus extends Ally {
	public Zeus() {
		name = "ゼウス";
		health = 1000;
		maxHealth = 1000;
		attack = 1000;
		skillName = "黄昏流星群！！";
	}

	public void talkPrologue(Ally[] allies) {
		System.out.println("\r\nホッホホ～イ");
		GameMaster.waitTime(1);
		System.out.println("わしじゃよ💛");
		GameMaster.waitTime(1);
	}
	
	protected void skill(Enemy[] enemies) {
		System.out.println("ほぃああああああ💛");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「" + skillName + "」を発動しました。");
		GameMaster.waitTime(1);

		System.out.println("攻撃対象を数字で選択してください。");

		for (var enemy : enemies) {
			if (enemy.health > 0) {
				System.out.println( String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix() + " ");
			}
		}

		var targetEnemy = (Enemy) GameMaster.selectEntity(enemies);
		targetEnemy.getDamage(attack * 5);
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
			health = 0;
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
}
