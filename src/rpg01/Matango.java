package rpg01;

public class Matango extends Enemy {
	public Matango(String alphabet) {
		suffix = alphabet;
		name = "キノコ";
		health = 100;
		attack = 300;
	}

	public void getDamage(int damageBeforeMitigation) {
		if (health <= 0) {
			return;
		}

		var damage = damageBeforeMitigation - deffence;
		System.out.println(getNameWithSuffix() + "に" + damage + "のダメージ！");
		GameMaster.WaitTime(1);
		System.out.println(getNameWithSuffix() + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.WaitTime(2);

		if (health < 1) {
			System.out.println(getNameWithSuffix() + "は消滅した！");
		} else {

			System.out.println(getNameWithSuffix() + "は邪悪な顔つきをしている");
			GameMaster.WaitTime(1);
			System.out.println(getNameWithSuffix() + "の残り体力:" + health);
		}
	}
}
