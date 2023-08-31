package rpg01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GameMaster {
	private static ArrayList<Character> Party = new ArrayList<Character>();
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("サモナーズリフトへようこそ");
		WaitTime(1);

		Party.add(SelectMainCharacter());
		WaitTime(1);
		System.out.println("メインキャラクターとして、" + Party.get(0).name + "を選択しました。\r\n");
		WaitTime(1);

		var subCharacters = SelectSubCharacters();
		Party.add(subCharacters.get(0));
		Party.add(subCharacters.get(1));
		WaitTime(1);
		System.out.println("サブキャラクターとして、" + Party.get(1).name + "と" + Party.get(2).name + "を選択しました。");
		WaitTime(1);

		var wepon = SelectWepon();
		WaitTime(1);
		Party.get(SelectWeponGetCharacterIndex()).equip(wepon);
		WaitTime(1);

		var item = SelectItem();
		WaitTime(1);
		Party.get(SelectItemGetCharacterIndex()).addBelongingItems(item);
		WaitTime(1);

		System.out.println("\r\n" + Party.get(0).name + "と" + Party.get(1).name + "と" + Party.get(2).name
				+ "の愉快な旅が始まります！");
		WaitTime(2);

		Party.get(0).talkPrologue(new ArrayList<Character>(Arrays.asList(Party.get(1), Party.get(2))));
		WaitTime(1);

		var isWin = IsWinFight();
		WaitTime(2);

		if (isWin) {
			System.out.println("\r\n\r\nV I C T O R Y");
		} else {
			System.out.println("\r\n\r\nD E F E A T");
		}
	}

	private static Character SelectMainCharacter() {
		System.out.println("メインキャラクターを数字で選択してください。");
		var characterList = new Character[] { new Garen(), new Rudo(), new IkarugaRuka(), new Zeus(),
				new NishiKyouya() };

		for (Character character : characterList) {
			WaitTime(1);
			System.out.println(String.valueOf(Arrays.asList(characterList).indexOf(character))
					+ ":" + character.name + " ");
		}

		Character selectedCharacter;

		try {
			var characterIndex = scanner.nextInt();
			selectedCharacter = characterList[characterIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			selectedCharacter = SelectMainCharacter();
		}

		return selectedCharacter;
	}

	private static ArrayList<Character> SelectSubCharacters() {
		System.out.println("1人目のサブキャラクターを数字で選択してください。");
		var characterList = new ArrayList<Character>(
				Arrays.asList(new Garen(), new Rudo(), new IkarugaRuka(), new Zeus(), new NishiKyouya()));

		for (Character character : characterList) {
			if (character.name == Party.get(0).name) {
				characterList.remove(character);
				break;
			}
		}

		for (Character character : characterList) {
			WaitTime(1);
			System.out.println(String.valueOf(characterList.indexOf(character)) + ":" + character.name + " ");
		}

		Character firstSelectedCharacter = new Garen();
		var selectedCharacters = new ArrayList<Character>();

		try {
			var characterIndex = scanner.nextInt();
			firstSelectedCharacter = characterList.get(characterIndex);
			selectedCharacters.add(firstSelectedCharacter);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			selectedCharacters = SelectSubCharacters();
		}

		System.out.println("2人目のサブキャラクターを数字で選択してください。");
		characterList.remove(firstSelectedCharacter);

		for (Character character : characterList) {
			WaitTime(1);
			System.out.println(String.valueOf(characterList.indexOf(character)) + ":" + character.name + " ");
		}

		try {
			var characterIndex = scanner.nextInt();
			selectedCharacters.add(characterList.get(characterIndex));
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			selectedCharacters = SelectSubCharacters();
		}

		return selectedCharacters;
	}

	private static Wepon SelectWepon() {
		System.out.println("\r\n武器が落ちている");
		WaitTime(1);
		System.out.println("拾う武器を数字で選択してください。");

		var weponList = new Wepon[] { new Umeboshi(), new ChainVest(), new Pickaxe() };

		for (Wepon wepon : weponList) {
			WaitTime(1);
			System.out.println(String.valueOf(Arrays.asList(weponList).indexOf(wepon))
					+ ":" + wepon.name + " ");
		}

		Wepon selectedWepon;

		try {
			var weponIndex = scanner.nextInt();
			selectedWepon = weponList[weponIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			selectedWepon = SelectWepon();
		}

		return selectedWepon;
	}

	private static Item SelectItem() {
		System.out.println("\r\nアイテムが落ちている");
		WaitTime(1);
		System.out.println("拾うアイテムを数字で選択してください。");

		var itemList = new Item[] { new Portion(2), new Bomb(1), new SayonaraNoTurugi(1) };

		for (Item item : itemList) {
			WaitTime(1);
			System.out.println(String.valueOf(Arrays.asList(itemList).indexOf(item))
					+ ":" + item.name + "（個数：" + item.getStock() + "） ");
		}

		Item selectedItem;

		try {
			var itemIndex = scanner.nextInt();
			selectedItem = itemList[itemIndex];
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			selectedItem = SelectItem();
		}

		return selectedItem;
	}

	private static int SelectItemGetCharacterIndex() {
		System.out.println("アイテムを持たせるキャラクターを数字で選択してください。");

		for (Character character : Party) {
			WaitTime(1);
			System.out.println(String.valueOf(Party.indexOf(character)) + ":" + character.name + " ");
		}

		int characterIndex;

		try {
			characterIndex = scanner.nextInt();
			Party.get(characterIndex);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			characterIndex = SelectItemGetCharacterIndex();
		}

		return characterIndex;
	}

	private static int SelectWeponGetCharacterIndex() {
		System.out.println("装備させるキャラクターを数字で選択してください。");

		for (Character character : Party) {
			WaitTime(1);
			System.out.println(String.valueOf(Party.indexOf(character))
					+ ":" + character.name + " ");
		}

		int characterIndex;

		try {
			characterIndex = scanner.nextInt();
			Party.get(characterIndex);
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			WaitTime(1);
			characterIndex = SelectWeponGetCharacterIndex();
		}

		return characterIndex;
	}

	private static boolean IsWinFight() {
		var enemies = CreateEnemies();
		System.out.println("");

		for (Enemy enemy : enemies) {
			System.out.println(enemy.getNameWithSuffix() + "が現れた");
			GameMaster.WaitTime(1);
		}

		System.out.println("どうする？");

		while (!IsCharactersAnnihilation(Party)) {
			WaitTime(1);

			for (Character character : Party) {
				if (character.health > 0) {
					character.SelectCommand(Party, enemies);
					WaitTime(1);

					if (IsEnemiesAnnihilation(enemies)) {
						return true;
					}
				}
			}

			for (Enemy enemy : enemies) {
				if (enemy.health > 0) {
					enemy.Action(Party.get(getAttackTargetIndex()));
					WaitTime(1);

					if (IsCharactersAnnihilation(Party)) {
						return false;
					}
				}
			}
		}

		return false;
	}

	private static boolean IsEnemiesAnnihilation(Enemy[] enemies) {
		for (Enemy enemy : enemies) {
			if (enemy.health > 0) {
				break;
			}

			if (Arrays.asList(enemies).indexOf(enemy) == enemies.length - 1) {
				return true;
			}
		}

		return false;
	}

	private static boolean IsCharactersAnnihilation(ArrayList<Character> characters) {
		for (Character character : characters) {
			if (character.health > 0) {
				break;
			}

			if (characters.indexOf(character) == characters.size() - 1) {
				return true;
			}
		}

		return false;
	}

	private static int getAttackTargetIndex() {
		var targetIndex = new java.util.Random().nextInt(Party.size() - 1);

		if (Party.get(targetIndex).health <= 0) {
			targetIndex = getAttackTargetIndex();
		}

		return targetIndex;
	}

	private static Enemy[] CreateEnemies() {
		var suffixes = new String[] { "A", "B", "C" };
		var enemyCount = new java.util.Random().nextInt(3) + 1;
		var enemies = new Enemy[enemyCount];

		for (int i = 0; i < enemyCount; i++) {
			enemies[i] = new Matango(suffixes[i]);
		}

		return enemies;
	}

	static void WaitTime(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
