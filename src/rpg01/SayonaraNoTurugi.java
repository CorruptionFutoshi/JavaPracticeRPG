package rpg01;

import java.util.Arrays;

public class SayonaraNoTurugi extends Item {
	public SayonaraNoTurugi(int number) {
		super(number);
		name = "さよならの剣";
	}

	public void Use(Enemy[] enemies, Character character) {
		System.out.println(character.name + "はさよならの剣をかかげた");
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
			Use(enemies, character);
		}

		System.out.println(character.name + "は" + enemy.getNameWithSuffix() + "をさよならの剣で切りつけた！");
		GameMaster.WaitTime(1);
		enemy.getDamage(9999);
		GameMaster.WaitTime(1);
		stock -= 1;
		System.out.println("さよならの剣の残数：" + stock);
	}
}
