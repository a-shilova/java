public class Main {

	public static void main(String[] args) {
		Cat cat1 = new Cat(200, 2, 5);
		cat1.run(150);
		cat1.run(300);
		cat1.jump(1);
		cat1.jump(3);
		cat1.swim(1);

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

		Cat eatingCat = new Cat("Vasilisa", 10);
		Plate plate = new Plate(100);
		eatingCat.eat(plate);
		System.out.println(eatingCat.appetite);
		plate.info();

		Cat[] cats = new Cat[6];
		cats[0] = new Cat("Markiz", 20);
		cats[1] = new Cat("Georg", 15);
		cats[2] = new Cat("Boris", 10);
		cats[3] = new Cat("Mark", 5);
		cats[4] = new Cat("Tima", 16);
		cats[5] = new Cat("Kisa", 30);

		for(int i = 0; i < cats.length; i++) {
			Cat cat = cats[i];
			cat.eat(plate);
			System.out.println("Satiety of " + cat.name + ": " + cat.satiety);
			plate.info();
		}
	}
}
