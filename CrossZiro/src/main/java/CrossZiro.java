import java.util.Random;
import java.util.Scanner;

public class CrossZiro {
	private static int SIZE = 3;
	private static int DOTS_TO_WIN = 3;
	private static final char DOT_EMPTY = '•';
	private static final char DOT_X = 'X';
	private static final char DOT_O = 'O';
	private static char[][] map;
	private static Scanner sc = new Scanner(System.in);
	private static Random rand = new Random();
	public static void main(String[] args) {
		initMap();
		printMap();
		while (true) {
			int[] humanDot = humanTurn();
			printMap();
			if (checkWin(DOT_X)) {
				System.out.println("Победил человек");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			int[] aiDot = aiTurn();
			printMap();
			if (checkWin(DOT_O)) {
				System.out.println("Победил Искуственный Интеллект");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
		}
		System.out.println("Игра закончена");
	}

	private static boolean checkWin(char symb) {
		for (int i = 0; i < SIZE; i++ ) {
			int equals = 0;
			boolean isEquals;
			for (int j = 0; j < SIZE; j++) {
				isEquals = symb == map[i][j];
				if (isEquals) {
					equals += 1;
				}
			}
			if (equals == DOTS_TO_WIN) return true;
		}

		for (int i = 0; i < SIZE; i++) {
			int equals = 0;
			boolean isEquals;
			for (int j = 0; j < SIZE; j++) {
				isEquals = symb == map[j][i];
				if (isEquals) {
					equals += 1;
				}
			}
			if (equals == DOTS_TO_WIN) return true;
		}

		for (int i = 0; i < SIZE; i++) {
			int equalsR = 0;
			int equalsL = 0;
			boolean isEquals = false;
			for (int j = 0; j < SIZE; j++) {
				boolean isLeftDiagonal = i == j;
				boolean isRightDiagonal = SIZE - i - 1 == j;
				isEquals = symb == map[j][i];
				if (isEquals && isLeftDiagonal) {
					equalsL += 1;
				}
				if (isEquals && isRightDiagonal) {
					equalsR += 1;
				}
			}
			if (equalsR == DOTS_TO_WIN || equalsL == DOTS_TO_WIN) return true;
		}

		return false;
	}

	private static boolean isMapFull() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == DOT_EMPTY) return false;
			}
		}
		return true;
	}

	private static int[] aiTurn() {
		int x, y;
		do {
			x = rand.nextInt(SIZE);
			y = rand.nextInt(SIZE);
		} while (!isCellValid(x, y));
		System.out.println("Компьютер сделал в точку " + (x + 1) + " " + (y + 1));
		map[y][x] = DOT_O;
		int[] dot = {x, y};
		return dot;
	}

	private static int[] humanTurn() {
		int x, y;
		do {
			System.out.println("Введите координаты в формате X Y");
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
		} while (!isCellValid(x, y));
		map[y][x] = DOT_X;
		int[] dot = {x, y};
		return dot;
	}

	private static boolean isCellValid(int x, int y) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
		if (map[y][x] == DOT_EMPTY) return true;
		return false;
	}

	private static void initMap() {
		map = new char[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				map[i][j] = DOT_EMPTY;
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i <= SIZE; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < SIZE; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < SIZE; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
