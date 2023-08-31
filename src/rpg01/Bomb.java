package rpg01;

public class Bomb extends Item {
	public Bomb(int number) {
		super(number);
		name = "爆弾";
	}

	public void use(Enemy[] enemies, Ally ally) {
		System.out.println(ally.name + "は爆弾を投げた");
		GameMaster.waitTime(1);
		ally.getDamage(200);

		for (Enemy enemy : enemies) {
			enemy.getDamage(400);
		}

		GameMaster.waitTime(1);
		stock -= 1;
		System.out.println("爆弾の残数：" + stock);
	}
}
