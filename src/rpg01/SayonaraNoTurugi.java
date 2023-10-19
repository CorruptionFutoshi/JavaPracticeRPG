package rpg01;

import java.util.Arrays;

public class SayonaraNoTurugi extends Item {
	public SayonaraNoTurugi(int number) {
		super(number);
		name = "さよならの剣";
	}

	public void use(Enemy[] enemies, Ally user) {
		System.out.println(user.name + "はさよならの剣をかかげた");
		GameMaster.waitTime(1);
		System.out.println("攻撃対象を数字で選択してください。");

		for (var enemy : enemies) {
			if (enemy.health > 0) {
				System.out.println( String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix() + " ");
			}
		}

		var targetEnemy = (Enemy) GameMaster.selectEntity(enemies);

		System.out.println(user.name + "は" + targetEnemy.getNameWithSuffix() + "をさよならの剣で切りつけた！");
		GameMaster.waitTime(1);
		targetEnemy.getDamage(999999);
		GameMaster.waitTime(1);
		stock -= 1;
		System.out.println("さよならの剣の残数：" + stock);
	}
}
