public class Plate {

	private int food;

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public Plate(int food) {
		this.food = food;
	}

	public void info() {
		System.out.println("plate: " + food);
	}

	public boolean decreaseFood(int n) {
		if (food - n >= 0) {
			food -= n;
			return true;
		}
		return false;
	}

	public void increaseFood(int n) {
		food += n;
	}
}
