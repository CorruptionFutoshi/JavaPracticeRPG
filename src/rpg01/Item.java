package rpg01;

public abstract class Item {
	protected String name;
	protected int stock;

	public Item(int number) {
		stock = number;
	}

	public void add(int number) {
		stock += number;
	}

	public int getStock() {
		return stock;
	}

	public abstract void use(Enemy[] enemies, Ally ally);
}
