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
		GameMaster.waitTime(1);
		health -= damage;
		System.out.println(getNameWithSuffix() + "の体力が" + damage + "減少した！");
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println(getNameWithSuffix() + "は消滅した！");
			health = 0;
		} else {
			System.out.println(getNameWithSuffix() + "はまだやれる顔つきをしている");
			GameMaster.waitTime(1);
			System.out.println(getNameWithSuffix() + "の残り体力:" + health);
		}
	}
}
