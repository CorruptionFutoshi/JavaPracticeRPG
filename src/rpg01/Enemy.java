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

	public void action(Ally ally) {
		System.out.println("\r\n" + getNameWithSuffix() + "のターン！");
		GameMaster.waitTime(1);
		aa(ally);
	}

	protected void aa(Ally ally) {
		System.out.println(getNameWithSuffix() + "の通常攻撃！");
		GameMaster.waitTime(1);
		System.out.println(getNameWithSuffix() + "は" + ally.name + "にAAをした！");
		GameMaster.waitTime(1);
		ally.getDamage(attack);
	}

	public abstract void getDamage(int damage);
}
