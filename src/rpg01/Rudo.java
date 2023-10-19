package rpg01;

import java.util.Arrays;

public class Rudo extends Ally {
	public Rudo() {
		name = "ルード";
		health = 9999;
		maxHealth = 9999;
		attack = 30;
		skillName = "生命変換";
	}

	public void talkPrologue(Ally[] allies) {
		System.out.println("\r\n　自分のパーティーに新しい人が来る。");
		GameMaster.waitTime(2);
		System.out.println("　そう聞いたとき、多くの者は嬉しさを感じるのではないだろうか。");
		GameMaster.waitTime(2);
		System.out.println("　少なくとも、俺はそうだった。");
		GameMaster.waitTime(2);
		System.out.println("　新しい仲間かぁ。男か女か。できれば女性がいいなぁ、とか。");
		GameMaster.waitTime(2);
		System.out.println("　男としてそう考えるのはおかしくはないのではないだろうか?");
		GameMaster.waitTime(2);
		System.out.println("　新しい仲間の歓迎会に参加するため、酒場へと来ていた。");
		GameMaster.waitTime(2);
		System.out.println("　入口で待っていたパーティーリーダー");
		GameMaster.waitTime(2);
		System.out.println("　――勇者と呼ばれているキグラスが、俺を見てにやりと笑う。");
		GameMaster.waitTime(2);
		System.out.println("　笑顔の意味はわからなかった。");
		GameMaster.waitTime(2);
		System.out.println("　彼の隣にはすでにパーティーメンバーが並んでいた。");
		GameMaster.waitTime(2);
		System.out.println("　迷宮のルールで、一度に入れるパーティーは六人までだ。");
		GameMaster.waitTime(2);
		System.out.println("　俺を含めて、現在は五人。");
		GameMaster.waitTime(2);
		System.out.println("　「よぉ、ルード」");
		GameMaster.waitTime(2);
		System.out.println("　「悪い。遅れたか?」");
		GameMaster.waitTime(2);
		System.out.println("　「いや、時間通りだ」");
		GameMaster.waitTime(2);
		System.out.println("　「そうか」");
		GameMaster.waitTime(2);
		System.out.println("　キグラスの隣に並んだ瞬間、彼の笑みがますます濃くなった。");
		GameMaster.waitTime(2);
		System.out.println("　何か面白いことでもあったのだろうか。");
		GameMaster.waitTime(2);
		System.out.println("　彼の笑顔はあまり人に見せていい類のものではない。");
		GameMaster.waitTime(2);
		System.out.println("　勇者と皆から尊敬される立場なのだから、少しは控えたほうがいいと思う。");
		GameMaster.waitTime(2);
		System.out.println("　彼に教えようとしたときだった。");
		GameMaster.waitTime(2);
		System.out.println("　" + allies[1].name + "「す、すみません遅くなりました!」");
		GameMaster.waitTime(2);
		System.out.println("　" + allies[2].name + "「き、キグラス様!　お待たせしました!」");
		GameMaster.waitTime(2);
		System.out.println("　" + allies[1].name + "たちがこちらに来ていた。");
		GameMaster.waitTime(2);
		System.out.println("　二人とも、俺よりもいくつか年下に見える。");
		GameMaster.waitTime(2);
		System.out.println("　彼らが、新しい仲間だろうか。");
		GameMaster.waitTime(2);
		System.out.println("　ちょっと待って。");
		GameMaster.waitTime(2);
		System.out.println("　合計七人になるんだけど……。");
		GameMaster.waitTime(2);
		System.out.println("　くるりとキグラスが俺の方を向いた。");
		GameMaster.waitTime(2);
		System.out.println("　その笑みの理由が、今やっとわかった。");
		GameMaster.waitTime(1);
		System.out.println("");
		GameMaster.waitTime(1);
		System.out.println("");
		GameMaster.waitTime(1);
		System.out.println("　「今日は歓迎会と送別会だ。ルード、おまえは今日でクビだ」");
		GameMaster.waitTime(1);
		System.out.println("");
		GameMaster.waitTime(1);
		System.out.println("　キグラスは首を切るように腕を動かした。\r\n");
	}

	protected void skill(Enemy[] enemies) {
		System.out.println("これは攻撃スキルだったのか");
		GameMaster.waitTime(1);
		System.out.println("固有スキル「" + skillName + "」を発動しました。");
		GameMaster.waitTime(1);

		System.out.println("攻撃対象を数字で選択してください。");

		for (var enemy : enemies) {
			if (enemy.health > 0) {
				System.out.println( String.valueOf(Arrays.asList(enemies).indexOf(enemy)) + ":" + enemy.getNameWithSuffix() + " ");
			}
		}

		var targetEnemy = (Enemy) GameMaster.selectEntity(enemies);
		targetEnemy.getDamage(maxHealth - health);
	}

	public void getDamage(int damageBeforeMitigation) {
		var damage = damageBeforeMitigation - deffence;
		System.out.println(name + "に" + damage + "のダメージ！");
		GameMaster.waitTime(1);
		health -= damage;
		System.out.println(name + "の体力が" + damage + "減少した！");
		GameMaster.waitTime(2);

		if (health <= 0) {
			System.out.println(name + "の外皮が消えた");
			health = 0;
		} else {
			System.out.println(name + "の外皮は9999なのよ");
			GameMaster.waitTime(1);
			System.out.println(name + "の残り体力:" + health);
		}
	}
}
