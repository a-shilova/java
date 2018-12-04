public class Cat extends Animals {

	public boolean satiety;

	public Cat(double runDistance, double jumpHeight, double swimDistance) {
		super(runDistance, jumpHeight, swimDistance);
	}

	public Cat(String name, int appetite) {
		super(name, appetite);
		satiety = false;
	}

	@Override
	public void swim(double distance) {
		System.out.println("swim: false");
	}

	public void eat(Plate plate) {
		satiety = plate.decreaseFood(appetite);
	}
}
