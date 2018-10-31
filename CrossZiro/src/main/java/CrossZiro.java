import java.util.Random;
import java.util.Scanner;

public class CrossZiro {
	private static int SIZE;
	private static int DOTS_TO_WIN;
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
			humanTurn();
			printMap();
			if (checkWin(DOT_X)) {
				System.out.println("Вы победили!");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			aiTurn();
			printMap();
			if (checkWin(DOT_O)) {
				System.out.println("Победил Компьютер");
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
			int equalsVertical = 0;
			int equalsGorizontal = 0;
			int equalsR = 0;
			int equalsL = 0;

			for (int j = 0; j < SIZE; j++) {
				boolean isEqualsVertical = symb == map[i][j];
				if (isEqualsVertical) equalsVertical += 1;

				boolean equalsGorizontal = symb == map[j][i];
				if (equalsGorizontal) equalsGorizontal += 1;

				boolean isLeftDiagonal = i == j;
				boolean isRightDiagonal = SIZE - i - 1 == j;
				if (isEqualsVertical && isLeftDiagonal) equalsL += 1;
				if (isEqualsVertical && isRightDiagonal) equalsR += 1;
			}

			if (isEqualsVertical == DOTS_TO_WIN) return true;
			if (isEqualsGorizontal == DOTS_TO_WIN) return true;
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

	private static aiTurn() {
		int x, y;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (map[i][j] == DOT_O) {
					if (i - 1 >= 0) {
						char up = map[i - 1][j];
						if (up == DOT_EMPTY) {
							x = j;
							y = i - 1;
							break;
						}

						if (j - 1 >= 0) {
							char leftUpD = map[i - 1][j - 1];
							if (leftUpD == DOT_EMPTY) {
								x = j - 1;
								y = i - 1;
								break;
							}
						}

						if (j + 1 < SIZE) {
							char rightUpD = map[i - 1][j + 1];
							if (rightUpD == DOT_EMPTY) {
								x = j + 1;
								y = i - 1;
								break;
							}
						}
					}

					if (i + 1 < SIZE) {
						char down = map[i + 1][j];
						if (down == DOT_EMPTY) {
							x = j;
							y = i + 1;
							break;
						}

						if (j - 1 >= 0) {
							char leftDownD = map[i + 1][j - 1];
							if (leftDownD == DOT_EMPTY) {
								x = j - 1;
								y = i + 1;
								break;
							}
						}

						if (j + 1 < SIZE) {
							char rightDownD = map[i + 1][j + 1];
							if (rightDownD == DOT_EMPTY) {
								x = j + 1;
								y = i + 1;
								break;
							}
						}
					}

					if (j - 1 >= 0) {
						char left = map[i][j - 1];
						if (left == DOT_EMPTY) {
							x = j - 1;
							y = i;
							break;
						}
					}

					if (j + 1 < SIZE) {
						char right = map[i][j + 1];
						if (right == DOT_EMPTY) {
							x = j + 1;
							y = i;
							break;
						}
					}
				}
			}
		}
		System.out.println("Компьютер сделал ход в точку " + (x + 1) + " " + (y + 1));
		map[y][x] = DOT_O;
	}

	private static humanTurn() {
		int x, y;
		do {
			System.out.println("Введите координаты в формате X Y");
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
		} while (!isCellValid(x, y));
		map[y][x] = DOT_X;
	}

	private static boolean isCellValid(int x, int y) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
		if (map[y][x] == DOT_EMPTY) return true;
		return false;
	}

	private static void initMap() {
		System.out.println("Введите размер поля (число от 3 до 5)");
		SIZE = sc.nextInt();
		if (SIZE < 3 || SIZE > 5) {
			System.out.println("Неверный размер поля");
			initMap();
		} else {
			map = new char[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = DOT_EMPTY;
				}
			}
			if (SIZE == 3) DOTS_TO_WIN = 3;
			if (SIZE > 3) DOTS_TO_WIN = 4;
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
