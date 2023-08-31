package rpg01;

import java.util.Arrays;

public class SayonaraNoTurugi extends Item {
	public SayonaraNoTurugi(int number) {
		super(number);
		name = "さよならの剣";
	}

	public void use(Enemy[] enemies, Ally ally) {
		System.out.println(ally.name + "はさよならの剣をかかげた");
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
			use(enemies, ally);
		}

		System.out.println(ally.name + "は" + enemy.getNameWithSuffix() + "をさよならの剣で切りつけた！");
		GameMaster.waitTime(1);
		enemy.getDamage(9999);
		GameMaster.waitTime(1);
		stock -= 1;
		System.out.println("さよならの剣の残数：" + stock);
	}
}
