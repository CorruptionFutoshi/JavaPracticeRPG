package rpg01;

public class NishiKyouya extends Ally {
	public NishiKyouya() {
		name = "西恭弥";
		health = 500;
		maxHealth = 500;
		attack = 100;
		skillName = "スミセン！！オレを誰だと思ってやがる！！";
	}

	public void talkPrologue(Ally[] allies) {
		System.out.println("\r\n……フーアムアイ？");
		GameMaster.waitTime(1);
		System.out.println("……フーアムアイ！！！");
		GameMaster.waitTime(2);
		System.out.println("God of…… BlackField!!!");
	}

	protected void skill(Enemy[] enemies) {
		System.out.println("もう少し耐えてくれ。");
		GameMaster.waitTime(1);
		System.out.println("敵の本部はもう目の前だ");
		GameMaster.waitTime(1);
		System.out.println("ガチャ");
		GameMaster.waitTime(1);
		System.out.println("このまま突っ切る！！");
		GameMaster.waitTime(3);
		System.out.println("バァン");
		GameMaster.waitTime(1);
		System.out.println("ぐはっ");
		GameMaster.waitTime(1);
		System.out.println("何だ…？");
		GameMaster.waitTime(1);

		getDamage(9999);
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		health -= damage;
		System.out.println(name + "の体力が" + damage + "減少した！");
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println("ドサッ");
			GameMaster.waitTime(1);
			System.out.println("やられたのか…");
			GameMaster.waitTime(1);
			System.out.println("だが…");
			GameMaster.waitTime(1);
			System.out.println("背後から？");
			GameMaster.waitTime(1);
			System.out.println("狙撃…？");
			GameMaster.waitTime(1);
			System.out.println("誰かが");
			GameMaster.waitTime(1);
			System.out.println("裏切っ…");
			health = 0;
		} else {
			System.out.println("くぅっ");
			GameMaster.waitTime(1);
			System.out.println("ヤロウ…");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}
}
