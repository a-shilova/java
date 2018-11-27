public class Cat extends Animals {

	public Cat(double runDistance, double jumpHeight, double swimDistance) {
		super(runDistance, jumpHeight, swimDistance);
	}

	@Override
	public void swim(double distance) {
		System.out.println("swim: false");
	}
}
