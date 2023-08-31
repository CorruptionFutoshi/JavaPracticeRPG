package rpg01;

public abstract class Enemy {
	protected String name;
	protected int health;
	protected int attack;
	protected int deffence;
	protected String suffix;

	public String getNameWithSuffix() {
		return name + suffix;
	}

	public void Action(Character character) {
		System.out.println("\r\n" + getNameWithSuffix() + "のターン！");
		GameMaster.WaitTime(1);
		AA(character);
	}

	protected void AA(Character character) {
		System.out.println(getNameWithSuffix() + "の通常攻撃！");
		GameMaster.WaitTime(1);
		System.out.println(getNameWithSuffix() + "は" + character.name + "にAAをした！");
		GameMaster.WaitTime(1);
		character.getDamage(attack);
	}

	public abstract void getDamage(int damage);
}
