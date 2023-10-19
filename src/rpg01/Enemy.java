package rpg01;

public abstract class Enemy {
	protected String name;
	protected int health;
	protected int attack;
	protected int deffence = 0;
	protected String suffix;

	public String getNameWithSuffix() {
		return name + suffix;
	}

	public void action(Ally[] allies) {
		System.out.println("\r\n" + getNameWithSuffix() + "のターン！");
		GameMaster.waitTime(1);
		aa(getTarget(allies));
	}

	protected void aa(Ally ally) {
		System.out.println(getNameWithSuffix() + "の通常攻撃！");
		GameMaster.waitTime(1);
		System.out.println(getNameWithSuffix() + "は" + ally.name + "にAAをした！");
		GameMaster.waitTime(1);
		ally.getDamage(attack);
	}

	private Ally getTarget(Ally[] allies) {
		var targetIndex = new java.util.Random().nextInt(allies.length - 1);

		if (allies[targetIndex].health <= 0) {
			return getTarget(allies);
		}

		return allies[targetIndex];
	}

	public abstract void getDamage(int damage);
}
