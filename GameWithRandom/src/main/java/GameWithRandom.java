import java.util.Scanner;

public class GameWithRandom {

	public static void main(String[] args) {
		System.out.println("Добро пожаловать в игру!");

		gaming();
	}

	private static void gaming() {
		int a = 0;
		int b = 9;
		int randomNumber = a + (int) (Math.random() * b);

		System.out.println("Загадано число от 0 до 9");
		System.out.println("Постарайтесь угадать :)");

		final int totalTry = 3;
		int trying = 1;
		boolean isEqual = false;
		Scanner in = new Scanner(System.in);

		while (totalTry >= trying) {
			System.out.println("Введите число: ");
			int number = in.nextInt();

			isEqual = number == randomNumber;
			if (isEqual) {
				System.out.println("Ура! Вы угадали!");
				gameAgain(in);
			} else {
				System.out.println("Упс.. Вы не угадали!");
				if (number > randomNumber) {
					System.out.println("Загаданное число меньше");
				} else {
					System.out.println("Загаданное число больше");
				}
			}

			trying++;
		}
		gameAgain(in);
	}

	private static void gameAgain(Scanner in) {
		System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

		final int YES = 1;
		int answer = in.nextInt();
		if (answer == YES) {
			gaming();
		}
	}
}
