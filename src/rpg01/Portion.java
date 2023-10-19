package rpg01;

public class Portion extends Item {
	public Portion(int number) {
		super(number);
		name = "ポーション";
	}

	public void use(Enemy[] enemies, Ally user) {
		System.out.println(user.name + "はポーションを飲んだ");
		GameMaster.waitTime(1);
		user.getHeal(200);
		GameMaster.waitTime(1);
		stock -= 1;
		System.out.println("ポーションの残数：" + stock);
	}
}
