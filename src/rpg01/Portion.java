package rpg01;

public class Portion extends Item {
	public Portion(int number) {
		super(number);
		name = "ポーション";
	}

	public void Use(Enemy[] enemies, Character character) {
		System.out.println(character.name + "はポーションを飲んだ");
		GameMaster.WaitTime(1);
		character.getHeal(200);
		GameMaster.WaitTime(1);
		stock -= 1;
		System.out.println("ポーションの残数：" + stock);
	}
}
