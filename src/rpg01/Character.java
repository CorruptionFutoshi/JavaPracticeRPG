package rpg01;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Character {
	protected String name;
	protected int health;
	protected int maxHealth;
	protected int attack;
	protected int deffence = 0;
	protected ArrayList<Item> belongingItems = new ArrayList<Item>();
	protected ArrayList<Wepon> belongingWepons = new ArrayList<Wepon>();

	public abstract void getDamage(int damage);

	public abstract void talkPrologue(ArrayList<Character> characters);

	public void equip(Wepon wepon) {
		belongingWepons.add(wepon);
		System.out.println(name + "は" + wepon.name + "を装備しました。");
		GameMaster.WaitTime(1);
		attack += wepon.bonusAttack;
		health += wepon.bonusHealth;
		maxHealth += wepon.bonusHealth;
		deffence += wepon.bonusDeffence;
		System.out.println("攻撃力が" + wepon.bonusAttack + "上昇しました！");
		System.out.println("体力が" + wepon.bonusHealth + "上昇しました！");
		System.out.println("防御力が" + wepon.bonusDeffence + "上昇しました！");
		belongingWepons.add(wepon);
	}

	public void addBelongingItems(Item item) {
		System.out.println(name + "は" + item.name + "（個数：" + item.getStock() + "）を取得しました。");
		belongingItems.add(item);
	}

	public void getHeal(int heal) {
		if (health + heal >= maxHealth) {
			var healAmount = maxHealth - health;
			System.out.println(name + "の体力が" + healAmount + "回復した！");
			health = maxHealth;
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力：" + health);
			return;
		}

		System.out.println(name + "の体力が" + heal + "回復した！");
		health += heal;
		GameMaster.WaitTime(1);
		System.out.println(name + "の残り体力：" + health);
	}

	protected void AA(Enemy[] enemies) {
		String message = "攻撃対象を数字で選択してください。\r\n";

		for (Enemy enemy : enemies) {
			if (enemy.health > 0) {
				message += String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix()
						+ " ";
			}
		}

		System.out.println(message);
		int enemyIndex = 0;
		Enemy enemy = enemies[0];

		try {
			enemyIndex = GameMaster.scanner.nextInt();
			enemy = enemies[enemyIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			AA(enemies);
		}

		System.out.println(name + "は" + enemy.getNameWithSuffix() + "にAAをした！");
		GameMaster.WaitTime(1);
		enemy.getDamage(attack);
	}

	public void SelectCommand(ArrayList<Character> characters, Enemy[] enemies) {
		System.out.println("\r\n" + name + "のターン！");
		GameMaster.WaitTime(1);
		System.out.println("行うコマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:攻撃");
		GameMaster.WaitTime(1);
		System.out.println("1:逃げる");
		GameMaster.WaitTime(1);
		System.out.println("2:体力確認");
		GameMaster.WaitTime(1);
		System.out.println("3:アイテムを使う");

		int number = 0;

		try {
			number = GameMaster.scanner.nextInt();

		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.WaitTime(1);
			SelectCommand(characters, enemies);
		}

		GameMaster.WaitTime(1);

		switch (number) {
		case 0:
			Attack(enemies);
			break;
		case 1:
			System.out.println(name + "は逃走を試みた！");
			GameMaster.WaitTime(1);
			System.out.println("失敗した！");
			break;
		case 2:
			for (Character character : characters) {
				if (character.health > 0) {
					System.out.println(character.name + "の体力:" + character.health);
					GameMaster.WaitTime(1);
				} else {
					System.out.println(character.name + "の体力:0");
					GameMaster.WaitTime(1);
				}
			}

			for (Enemy enemy : enemies) {
				if (enemy.health > 0) {
					System.out.println(enemy.getNameWithSuffix() + "の体力:" + enemy.health);
					GameMaster.WaitTime(1);
				} else {
					System.out.println(enemy.getNameWithSuffix() + "の体力:0");
					GameMaster.WaitTime(1);
				}
			}

			SelectCommand(characters, enemies);
			break;
		case 3:
			if (belongingItems.size() == 0) {
				System.out.println("使えるアイテムがありません。");
				SelectCommand(characters, enemies);
				return;
			}

			for (Item item : belongingItems) {
				if (item.getStock() > 0) {
					break;
				}

				if (belongingItems.indexOf(item) == belongingItems.size() - 1) {
					System.out.println("使えるアイテムがありません。");
					SelectCommand(characters, enemies);
					return;
				}
			}

			useItem(enemies, this);
			break;
		}
	}

	public abstract void Attack(Enemy[] enemies);

	public void useItem(Enemy[] enemies, Character character) {
		System.out.println("使いたいアイテムを数字で選択してください。");

		for (Item item : belongingItems) {
			if (item.getStock() > 0) {
				GameMaster.WaitTime(1);
				System.out.println(String.valueOf(belongingItems.indexOf(item)) + ":" + item.name + "（残数："
						+ item.getStock() + "）");
			}
		}

		try {
			var itemIndex = GameMaster.scanner.nextInt();
			belongingItems.get(itemIndex).Use(enemies, character);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			useItem(enemies, character);
		}
	}
}
