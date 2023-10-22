package rpg01;

public class Garen extends Ally {
	public Garen() {
		name = "ガレン";
		health = 690;
		maxHealth = 690;
		attack = 69;
		skillName = "ジャッジメント";
	}

	public void talkPrologue(Ally[] allies) {
		System.out.println("\r\n俺の名は" + name);
		GameMaster.waitTime(1);
		System.out.println(allies[1].name + "、それから" + allies[2].name + "と共に、今は日課の山歩きをしているところだ");
		GameMaster.waitTime(1);
		System.out.println(name + "、" + allies[1].name + "、" + allies[2].name + "、俺「だまっしあ！」");
		System.out.println(name + "、" + allies[1].name + "、" + allies[2].name + "「って、なんで俺くんが！？改めまして、ありがとうございました！」");
	}

	protected void skill(Enemy[] enemies) {
		System.out.println("蹴散らしてやる！");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「" + skillName + "」を発動しました。");
		GameMaster.waitTime(1);

		for (var enemy : enemies) {
			enemy.getDamage(attack * 2);
		}
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		health -= damage;
		System.out.println(name + "の体力が" + damage + "減少した！");
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println(name + "は力尽きた");
			health = 0;
		} else {
			System.out.println(name + "はタフな男だ。");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}
}
