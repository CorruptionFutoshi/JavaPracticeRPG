package rpg01;

public class Bomb extends Item {
	public Bomb(int number) {
		super(number);
		name="爆弾";
	}

	public void Use(Enemy[] enemies, Character character) {
		System.out.println(character.name + "は爆弾を投げた");
		GameMaster.WaitTime(1);
		character.getDamage(200);

		for (Enemy enemy : enemies) {
			enemy.getDamage(400);
		}
		
		GameMaster.WaitTime(1);
		stock -= 1;
		System.out.println("爆弾の残数：" + stock);
	}
}
