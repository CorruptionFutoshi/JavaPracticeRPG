package rpg01;

import java.util.ArrayList;
import java.util.Arrays;

public class Rudo extends Character {
	public Rudo() {
		name = "ルード";
		health = 9999;
		maxHealth = 9999;
		attack = 30;
	}

	public void talkPrologue(ArrayList<Character> characters) {
		System.out.println("\r\n　自分のパーティーに新しい人が来る。");
		GameMaster.WaitTime(2);
		System.out.println("　そう聞いたとき、多くの者は嬉しさを感じるのではないだろうか。");
		GameMaster.WaitTime(2);
		System.out.println("　少なくとも、俺はそうだった。");
		GameMaster.WaitTime(2);
		System.out.println("　新しい仲間かぁ。男か女か。できれば女性がいいなぁ、とか。");
		GameMaster.WaitTime(2);
		System.out.println("　男としてそう考えるのはおかしくはないのではないだろうか?");
		GameMaster.WaitTime(2);
		System.out.println("　新しい仲間の歓迎会に参加するため、酒場へと来ていた。");
		GameMaster.WaitTime(2);
		System.out.println("　入口で待っていたパーティーリーダー");
		GameMaster.WaitTime(2);
		System.out.println("　――勇者と呼ばれているキグラスが、俺を見てにやりと笑う。");
		GameMaster.WaitTime(2);
		System.out.println("　笑顔の意味はわからなかった。");
		GameMaster.WaitTime(2);
		System.out.println("　彼の隣にはすでにパーティーメンバーが並んでいた。");
		GameMaster.WaitTime(2);
		System.out.println("　迷宮のルールで、一度に入れるパーティーは六人までだ。");
		GameMaster.WaitTime(2);
		System.out.println("　俺を含めて、現在は五人。");
		GameMaster.WaitTime(2);
		System.out.println("　「よぉ、ルード」");
		GameMaster.WaitTime(2);
		System.out.println("　「悪い。遅れたか?」");
		GameMaster.WaitTime(2);
		System.out.println("　「いや、時間通りだ」");
		GameMaster.WaitTime(2);
		System.out.println("　「そうか」");
		GameMaster.WaitTime(2);
		System.out.println("　キグラスの隣に並んだ瞬間、彼の笑みがますます濃くなった。");
		GameMaster.WaitTime(2);
		System.out.println("　何か面白いことでもあったのだろうか。");
		GameMaster.WaitTime(2);
		System.out.println("　彼の笑顔はあまり人に見せていい類のものではない。");
		GameMaster.WaitTime(2);
		System.out.println("　勇者と皆から尊敬される立場なのだから、少しは控えたほうがいいと思う。");
		GameMaster.WaitTime(2);
		System.out.println("　彼に教えようとしたときだった。");
		GameMaster.WaitTime(2);
		System.out.println("　" + characters.get(0).name + "「す、すみません遅くなりました!」");
		GameMaster.WaitTime(2);
		System.out.println("　" + characters.get(1).name + "「き、キグラス様!　お待たせしました!」");
		GameMaster.WaitTime(2);
		System.out.println("　" + characters.get(0).name + "たちがこちらに来ていた。");
		GameMaster.WaitTime(2);
		System.out.println("　二人とも、俺よりもいくつか年下に見える。");
		GameMaster.WaitTime(2);
		System.out.println("　彼らが、新しい仲間だろうか。");
		GameMaster.WaitTime(2);
		System.out.println("　ちょっと待って。");
		GameMaster.WaitTime(2);
		System.out.println("　合計七人になるんだけど……。");
		GameMaster.WaitTime(2);
		System.out.println("　くるりとキグラスが俺の方を向いた。");
		GameMaster.WaitTime(2);
		System.out.println("　その笑みの理由が、今やっとわかった。");
		GameMaster.WaitTime(1);
		System.out.println("");
		GameMaster.WaitTime(1);
		System.out.println("");
		GameMaster.WaitTime(1);
		System.out.println("　「今日は歓迎会と送別会だ。ルード、おまえは今日でクビだ」");
		GameMaster.WaitTime(1);
		System.out.println("");
		GameMaster.WaitTime(1);
		System.out.println("　キグラスは首を切るように腕を動かした。\r\n");
	}

	public void Attack(Enemy[] enemies) {
		System.out.println("\r\n攻撃コマンドを数字で選択してください。");
		GameMaster.WaitTime(1);
		System.out.println("0:通常攻撃 1:生命変換 ");

		int number = 0;

		try {
			number = GameMaster.scanner.nextInt();
		} catch (Exception ex) {
			System.out.println("「:」前の数字を入力してください");
			GameMaster.WaitTime(1);
			Attack(enemies);
		}

		GameMaster.WaitTime(1);

		switch (number) {
		case 0:
			AA(enemies);
			break;
		case 1:
			healthConversion(enemies);
			break;
		}
	}

	private void healthConversion(Enemy[] enemies) {
		System.out.println("これは攻撃スキルだったのか");
		GameMaster.WaitTime(1);
		System.out.println("固有スキル「生命変換」を発動しました。");
		GameMaster.WaitTime(1);

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
			healthConversion(enemies);
		}

		enemy.getDamage(9999 - health);
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.WaitTime(1);
		System.out.println(name + "の体力が" + damage + "減少した！");
		health -= damage;
		GameMaster.WaitTime(2);

		if (health <= 0) {
			System.out.println(name + "の外皮が消えた");
		} else {
			System.out.println(name + "の外皮は9999なのよ");
			GameMaster.WaitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}

	public void getHeal(int heal) {
		System.out.println(name + "の体力が" + heal + "回復した！");
		health += heal;
	}
}
