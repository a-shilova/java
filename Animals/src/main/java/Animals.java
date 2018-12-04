public class Animals {

	private double maxRunDistance;
	private double maxJumpHeight;
	private double maxSwimDistance;
	protected String name;
	protected int appetite;

	public Animals(String name, int appetite) {
		this.name = name;
		this.appetite = appetite;
	}

	public Animals(double runDistance, double jumpHeight, double swimDistance) {
		this.maxSwimDistance = swimDistance;
		this.maxJumpHeight = jumpHeight;
		this.maxRunDistance = runDistance;
	}

	public void run(double distance) {
		System.out.println("run: " + Boolean.toString(distance <= this.maxRunDistance));
	}

	public void jump(double height) {
		System.out.println("jump: "  + Boolean.toString(height <= this.maxJumpHeight));
	}

	public void swim(double distance) {
		System.out.println("swim: " + Boolean.toString(distance <= this.maxSwimDistance));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAppetite() {
		return appetite;
	}

	public void setAppetite(int appetite) {
		this.appetite = appetite;
	}
}
