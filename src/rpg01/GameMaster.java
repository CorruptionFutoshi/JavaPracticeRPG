package rpg01;

import java.util.Arrays;
import java.util.Scanner;

public class GameMaster {
	public static Scanner scanner = new Scanner(System.in);
	private static Ally[] party = new Ally[3];

	public static void main(String[] args) {
		System.out.println("サモナーズリフトへようこそ");
		waitTime(1);

		party = selectParty();

		System.out.println("取得する武器を数字で選択してください。");
		var weapon = selectWeapon();
		waitTime(1);
		System.out.println("装備させるキャラクターを数字で選択してください。");
		party[Arrays.asList(party).indexOf(selectAlly(party))].equip(weapon);
		waitTime(1);

		System.out.println("取得するアイテムを数字で選択してください。");
		var item = selectItem();
		waitTime(1);
		System.out.println("アイテムを持たせるキャラクターを数字で選択してください。");
		party[Arrays.asList(party).indexOf(selectAlly(party))].getItem(item);
		waitTime(1);

		System.out.println("\r\n" + party[0].name + "と" + party[1].name + "と" + party[2].name + "の愉快な旅が始まります！");
		waitTime(2);

		party[0].talkPrologue(party);
		waitTime(1);

		var win = winFight();
		waitTime(2);

		if (win) {
			System.out.println("\r\n\r\nV I C T O R Y");
		} else {
			System.out.println("\r\n\r\nD E F E A T");
		}
	}

	private static Ally[] selectParty() {
		System.out.println("1人目のキャラクターを数字で選択してください。");
		var selectedAllies = new Ally[3];

		var firstOptions = new Ally[] { new Garen(), new Rudo(), new IkarugaRuka(), new Zeus(), new NishiKyouya() };

		Ally firstSelectedAlly = selectAlly(firstOptions);
		selectedAllies[0] = firstSelectedAlly;

		System.out.println("2人目のキャラクターを数字で選択してください。");
		var secondOptions = new Ally[firstOptions.length - 1];

		int index = 0;

		for (var option : firstOptions) {
			if (option.name.equals(firstSelectedAlly.name)) {
				continue;
			}

			secondOptions[index] = option;
			index++;
		}

		Ally secondSelectedAlly = selectAlly(secondOptions);
		selectedAllies[1] = secondSelectedAlly;

		System.out.println("3人目のキャラクターを数字で選択してください。");
		var thirdOptions = new Ally[secondOptions.length - 1];

		index = 0;

		for (var option : secondOptions) {
			if (option.name.equals(secondSelectedAlly.name)) {
				continue;
			}

			thirdOptions[index] = option;
			index++;
		}

		selectedAllies[2] = selectAlly(thirdOptions);
		return selectedAllies;
	}

	public static Ally selectAlly(Ally[] allies) {
		for (var ally : allies) {
			System.out.println(String.valueOf(Arrays.asList(allies).indexOf(ally)) + ":" + ally.name + " ");
		}

		return (Ally) selectEntity(allies);
	}

	public static Object selectEntity(Object[] entities) {
		Object selectedEntity;

		try {
			var selectedNumber = scanner.nextInt();
			selectedEntity = entities[selectedNumber];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedEntity = selectEntity(entities);
		}

		return selectedEntity;
	}

	private static Weapon selectWeapon() {
		var weaponList = new Weapon[] { new Umeboshi(), new ChainVest(), new Pickaxe() };

		for (var weapon : weaponList) {
			System.out.println(String.valueOf(Arrays.asList(weaponList).indexOf(weapon)) + ":" + weapon.name + " ");
		}

		return (Weapon) selectEntity(weaponList);
	}

	private static Item selectItem() {
		var itemList = new Item[] { new Portion(2), new Bomb(1), new SayonaraNoTurugi(1) };

		for (var item : itemList) {
			System.out.println(String.valueOf(Arrays.asList(itemList).indexOf(item)) + ":" + item.name + "（個数："
					+ item.stock + "） ");
		}

		return (Item) selectEntity(itemList);
	}

	private static boolean winFight() {
		var enemies = createEnemies();
		System.out.println("");

		for (var enemy : enemies) {
			System.out.println(enemy.getNameWithSuffix() + "が現れた");
			waitTime(1);
		}

		System.out.println("戦闘開始！");

		while (!isAlliesAnnihilation()) {
			waitTime(1);

			for (var ally : party) {
				if (ally.health > 0) {
					ally.command(party, enemies);
					waitTime(1);

					if (isEnemiesAnnihilation(enemies)) {
						return true;
					}
				}
			}

			for (var enemy : enemies) {
				if (enemy.health > 0) {
					enemy.action(party);
					waitTime(1);

					if (isAlliesAnnihilation()) {
						return false;
					}
				}
			}
		}

		return false;
	}

	private static Enemy[] createEnemies() {
		var suffixes = new String[] { "A", "B", "C" };
		var enemyCount = new java.util.Random().nextInt(3) + 1;
		var enemies = new Enemy[enemyCount];

		for (var i = 0; i < enemyCount; i++) {
			enemies[i] = new Matango(suffixes[i]);
		}

		return enemies;
	}

	private static boolean isAlliesAnnihilation() {
		for (var ally : party) {
			if (ally.health > 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean isEnemiesAnnihilation(Enemy[] enemies) {
		for (var enemy : enemies) {
			if (enemy.health > 0) {
				return false;
			}
		}

		return true;
	}

	public static void waitTime(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
