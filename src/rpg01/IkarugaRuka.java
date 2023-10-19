package rpg01;

public class IkarugaRuka extends Ally {
	public IkarugaRuka() {
		name = "カミサマ";
		health = 412;
		maxHealth = 412;
		attack = 283;
		skillName = "神様は死んだ、って";
	}

	public void talkPrologue(Ally[] allies) {
		System.out.println("\r\nチッ……あいつ、何考えてやがる……!");
		GameMaster.waitTime(1);
		System.out.println(allies[1].name + "と" + allies[2].name + "と私でコメティック！？");
		GameMaster.waitTime(1);
		System.out.println("――――っ……。――――――ぁ……………………。病んだ。");
		GameMaster.waitTime(1);
	}

	protected void skill(Enemy[] enemies) {
		System.out.println("最低　最低　最低　なにもかも");
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
			System.out.println("まずいね、このナポリタン……最悪な味がする");
			health = 0;
		} else {
			System.out.println("チッ……クソッ……なんなんだよ……！");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}
}
