package rpg01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameMaster {
	private static ArrayList<Ally> party = new ArrayList<Ally>();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("サモナーズリフトへようこそ");
		waitTime(1);

		party.add(selectMainAlly());
		waitTime(1);
		System.out.println("メインキャラクターとして、" + party.get(0).name + "を選択しました。\r\n");
		waitTime(1);

		var subAllies = selectSubAllies();
		party.add(subAllies.get(0));
		party.add(subAllies.get(1));
		waitTime(1);
		System.out.println("サブキャラクターとして、" + party.get(1).name + "と" + party.get(2).name + "を選択しました。");
		waitTime(1);

		var wepon = selectWepon();
		waitTime(1);
		party.get(selectWeponGetAllyIndex()).equip(wepon);
		waitTime(1);

		var item = selectItem();
		waitTime(1);
		party.get(selectItemGetAllyIndex()).addBelongingItems(item);
		waitTime(1);

		System.out.println("\r\n" + party.get(0).name + "と" + party.get(1).name + "と" + party.get(2).name
				+ "の愉快な旅が始まります！");
		waitTime(2);

		party.get(0).talkPrologue(new ArrayList<Ally>(Arrays.asList(party.get(1), party.get(2))));
		waitTime(1);

		var isWin = isWinFight();
		waitTime(2);

		if (isWin) {
			System.out.println("\r\n\r\nV I C T O R Y");
		} else {
			System.out.println("\r\n\r\nD E F E A T");
		}
	}

	private static Ally selectMainAlly() {
		System.out.println("メインキャラクターを数字で選択してください。");
		var allies = new Ally[] { new Garen(), new Rudo(), new IkarugaRuka(), new Zeus(),
				new NishiKyouya() };

		for (var ally : allies) {
			waitTime(1);
			System.out.println(String.valueOf(Arrays.asList(allies).indexOf(ally))
					+ ":" + ally.name + " ");
		}

		Ally selectedAlly;

		try {
			var allyIndex = scanner.nextInt();
			selectedAlly = allies[allyIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedAlly = selectMainAlly();
		}

		return selectedAlly;
	}

	private static ArrayList<Ally> selectSubAllies() {
		System.out.println("1人目のサブキャラクターを数字で選択してください。");
		var allies = new ArrayList<Ally>(
				Arrays.asList(new Garen(), new Rudo(), new IkarugaRuka(), new Zeus(), new NishiKyouya()));

		for (var ally : allies) {
			if (ally.name == party.get(0).name) {
				allies.remove(ally);
				break;
			}
		}

		for (var ally : allies) {
			waitTime(1);
			System.out.println(String.valueOf(allies.indexOf(ally)) + ":" + ally.name + " ");
		}

		Ally firstSelectedAlly = new Garen();
		var selectedAllies = new ArrayList<Ally>();

		try {
			var allyIndex = scanner.nextInt();
			firstSelectedAlly = allies.get(allyIndex);
			selectedAllies.add(firstSelectedAlly);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedAllies = selectSubAllies();
		}

		System.out.println("2人目のサブキャラクターを数字で選択してください。");
		allies.remove(firstSelectedAlly);

		for (var ally : allies) {
			waitTime(1);
			System.out.println(String.valueOf(allies.indexOf(ally)) + ":" + ally.name + " ");
		}

		try {
			var allyIndex = scanner.nextInt();
			selectedAllies.add(allies.get(allyIndex));
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedAllies = selectSubAllies();
		}

		return selectedAllies;
	}

	private static Wepon selectWepon() {
		System.out.println("\r\n武器が落ちている");
		waitTime(1);
		System.out.println("拾う武器を数字で選択してください。");

		var weponList = new Wepon[] { new Umeboshi(), new ChainVest(), new Pickaxe() };

		for (var wepon : weponList) {
			waitTime(1);
			System.out.println(String.valueOf(Arrays.asList(weponList).indexOf(wepon))
					+ ":" + wepon.name + " ");
		}

		Wepon selectedWepon;

		try {
			var weponIndex = scanner.nextInt();
			selectedWepon = weponList[weponIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedWepon = selectWepon();
		}

		return selectedWepon;
	}

	private static Item selectItem() {
		System.out.println("\r\nアイテムが落ちている");
		waitTime(1);
		System.out.println("拾うアイテムを数字で選択してください。");

		var itemList = new Item[] { new Portion(2), new Bomb(1), new SayonaraNoTurugi(1) };

		for (var item : itemList) {
			waitTime(1);
			System.out.println(String.valueOf(Arrays.asList(itemList).indexOf(item))
					+ ":" + item.name + "（個数：" + item.getStock() + "） ");
		}

		Item selectedItem;

		try {
			var itemIndex = scanner.nextInt();
			selectedItem = itemList[itemIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			selectedItem = selectItem();
		}

		return selectedItem;
	}

	private static int selectItemGetAllyIndex() {
		System.out.println("アイテムを持たせるキャラクターを数字で選択してください。");

		for (var ally : party) {
			waitTime(1);
			System.out.println(String.valueOf(party.indexOf(ally)) + ":" + ally.name + " ");
		}

		int allyIndex;

		try {
			allyIndex = scanner.nextInt();
			party.get(allyIndex);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			allyIndex = selectItemGetAllyIndex();
		}

		return allyIndex;
	}

	private static int selectWeponGetAllyIndex() {
		System.out.println("装備させるキャラクターを数字で選択してください。");

		for (var ally : party) {
			waitTime(1);
			System.out.println(String.valueOf(party.indexOf(ally))
					+ ":" + ally.name + " ");
		}

		int allyIndex;

		try {
			allyIndex = scanner.nextInt();
			party.get(allyIndex);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			waitTime(1);
			allyIndex = selectWeponGetAllyIndex();
		}

		return allyIndex;
	}

	private static boolean isWinFight() {
		var enemies = createEnemies();
		System.out.println("");

		for (var enemy : enemies) {
			System.out.println(enemy.getNameWithSuffix() + "が現れた");
			GameMaster.waitTime(1);
		}

		System.out.println("どうする？");

		while (!isAlliesAnnihilation(party)) {
			waitTime(1);

			for (var ally : party) {
				if (ally.health > 0) {
					ally.selectCommand(party, enemies);
					waitTime(1);

					if (isEnemiesAnnihilation(enemies)) {
						return true;
					}
				}
			}

			for (var enemy : enemies) {
				if (enemy.health > 0) {
					enemy.action(party.get(getAttackTargetIndex()));
					waitTime(1);

					if (isAlliesAnnihilation(party)) {
						return false;
					}
				}
			}
		}

		return false;
	}

	private static boolean isEnemiesAnnihilation(Enemy[] enemies) {
		for (var enemy : enemies) {
			if (enemy.health > 0) {
				break;
			}

			if (Arrays.asList(enemies).indexOf(enemy) == enemies.length - 1) {
				return true;
			}
		}

		return false;
	}

	private static boolean isAlliesAnnihilation(ArrayList<Ally> allies) {
		for (var ally : allies) {
			if (ally.health > 0) {
				break;
			}

			if (allies.indexOf(ally) == allies.size() - 1) {
				return true;
			}
		}

		return false;
	}

	private static int getAttackTargetIndex() {
		var targetIndex = new java.util.Random().nextInt(party.size() - 1);

		if (party.get(targetIndex).health <= 0) {
			targetIndex = getAttackTargetIndex();
		}

		return targetIndex;
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

	static void waitTime(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
