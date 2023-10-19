package rpg01;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Ally {
	protected String name;
	protected int health;
	protected int maxHealth;
	protected int attack;
	protected int deffence = 0;
	protected String skillName;
	protected ArrayList<Item> items = new ArrayList<Item>();
	protected ArrayList<Weapon> weapons = new ArrayList<Weapon>();

	public void equip(Weapon wepon) {
		weapons.add(wepon);
		System.out.println(name + "は" + wepon.name + "を装備しました。");
		GameMaster.waitTime(1);
		attack += wepon.bonusAttack;
		health += wepon.bonusHealth;
		maxHealth += wepon.bonusHealth;
		deffence += wepon.bonusDeffence;
		System.out.println("攻撃力が" + wepon.bonusAttack + "上昇しました！");
		System.out.println("体力が" + wepon.bonusHealth + "上昇しました！");
		System.out.println("防御力が" + wepon.bonusDeffence + "上昇しました！");
		weapons.add(wepon);
	}

	public void getItem(Item item) {
		System.out.println(name + "は" + item.name + "（個数：" + item.stock + "）を取得しました。");
		items.add(item);
	}

	public abstract void talkPrologue(Ally[] allies);

	public void command(Ally[] allies, Enemy[] enemies) {
		System.out.println("\r\n" + name + "のターン！");
		GameMaster.waitTime(1);
		System.out.println("行うコマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:攻撃\r\n1:逃げる\r\n2:体力確認\r\n3:アイテムを使う");

		var selectedNumber = 0;

		try {
			selectedNumber = GameMaster.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.waitTime(1);
			command(allies, enemies);
		}

		GameMaster.waitTime(1);

		switch (selectedNumber) {
		case 0:
			attack(enemies);
			break;

		case 1:
			System.out.println(name + "は逃走を試みた！");
			GameMaster.waitTime(1);
			System.out.println("失敗した！");
			break;

		case 2:
			for (var ally : allies) {
				System.out.println(ally.name + "の体力:" + ally.health);
				GameMaster.waitTime(1);
			}

			for (var enemy : enemies) {
				System.out.println(enemy.getNameWithSuffix() + "の体力:" + enemy.health);
				GameMaster.waitTime(1);
			}

			command(allies, enemies);
			break;

		case 3:
			if (items.size() == 0) {
				System.out.println("使えるアイテムがありません。");
				command(allies, enemies);
				return;
			}

			for (var item : items) {
				if (item.stock > 0) {
					break;
				}

				if (items.indexOf(item) == items.size() - 1) {
					System.out.println("使えるアイテムがありません。");
					command(allies, enemies);
					return;
				}
			}

			useItem(enemies, this);
			break;
		
		default:
			System.out.println("「:」前の数字を入力してください");
			GameMaster.waitTime(1);
			command(allies,enemies);
		}
	}

	public void attack(Enemy[] enemies) {
		System.out.println("\r\n行うコマンドを数字で選択してください。");
		GameMaster.waitTime(1);
		System.out.println("0:通常攻撃 1:"+ skillName );

		var selectedNumber = 0;

		try {
			selectedNumber = GameMaster.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.waitTime(1);
			attack(enemies);
		}

		GameMaster.waitTime(1);

		switch (selectedNumber) {
		case 0:
			aa(enemies);
			break;
		case 1:
			skill(enemies);
			break;
		}
	}
	
	protected void aa(Enemy[] enemies) {
		System.out.println("攻撃対象を数字で選択してください。");

		for (var enemy : enemies) {
			if (enemy.health > 0) {
				System.out.println( String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix() + " ");
			}
		}

		var targetEnemy = (Enemy) GameMaster.selectEntity(enemies);
		System.out.println(name + "は" + targetEnemy.getNameWithSuffix() + "にAAをした！");
		GameMaster.waitTime(1);
		targetEnemy.getDamage(attack);
	}
	
	protected abstract void skill(Enemy[] enemies);

	public void useItem(Enemy[] enemies, Ally ally) {
		System.out.println("使いたいアイテムを数字で選択してください。");

		for (var item : items) {
			if (item.stock > 0) {
				System.out.println( String.valueOf(items.indexOf(item)) + ":" + item.name + "（残数：" + item.stock + "）");
			}
		}

		var selectedItem = (Item) GameMaster.selectEntity(items.toArray(new Item[items.size()]));
		selectedItem.use(enemies, ally);
	}

	public abstract void getDamage(int damage);

	public void getHeal(int heal) {
		if (health <= 0) {
			System.out.println("既に消えてしまった" + name + "には効果がなかった");
		}

		if (health + heal >= maxHealth) {
			heal = maxHealth - health;
		}

		System.out.println(name + "の体力が" + heal + "回復した！");
		health += heal;
		GameMaster.waitTime(1);
		System.out.println(name + "の残り体力：" + health);
	}
}
