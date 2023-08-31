package rpg01;

public class Portion extends Item {
	public Portion(int number) {
		super(number);
		name = "ポーション";
	}

	public void use(Enemy[] enemies, Ally ally) {
		System.out.println(ally.name + "はポーションを飲んだ");
		GameMaster.waitTime(1);
		ally.getHeal(200);
		GameMaster.waitTime(1);
		stock -= 1;
		System.out.println("ポーションの残数：" + stock);
	}
}
