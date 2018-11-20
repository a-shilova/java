public class Main {

	public static void main(String[] args) {
		Cat cat = new Cat(200, 2, 5);
		cat.run(150);
		cat.run(300);
		cat.jump(1);
		cat.jump(3);
		cat.swim(1);

		Dog dog = new Dog(400, 1, 10);
		dog.run(10);
		dog.run(400);
		dog.jump(5);
		dog.jump(0.5);
		dog.swim(10);
		dog.swim(11);

		Dog dog1 = new Dog(600, 1, 11);
		dog1.run(10);
		dog1.run(500);
		dog1.jump(5);
		dog1.jump(0.5);
		dog1.swim(10);
		dog1.swim(11);
	}
}
