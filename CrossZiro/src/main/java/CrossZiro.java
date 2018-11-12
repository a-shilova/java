import java.util.Scanner;

public class CrossZiro {
	private static int size;
	private static int dotsToWin;
	private static final char DOT_EMPTY = '•';
	private static final char DOT_X = 'X';
	private static final char DOT_O = 'O';
	private static char[][] map;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		initMap();
		printMap();
		while (true) {
			int[] humanTurnCord = humanTurn();
			printMap();
			if (checkWin(humanTurnCord)) {
				System.out.println("Вы победили!");
				break;
			}
			if (isMapFull()) {
				System.out.println("Ничья");
				break;
			}
			int[] aiTurnCord = aiTurn(humanTurnCord);
			printMap();
			if (checkWin(aiTurnCord)) {
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

	private static boolean checkWin(int[] turn) {
		int i = turn[1];
		int j = turn[0];
		char symb = map[i][j];

		boolean isWinInGorizontal = checkGorizontal(i, j, symb);
		boolean isWinInVertical = checkVertical(i, j, symb);
		boolean isWinToLeftDiagonal = checkLeftDiagonal(i, j, symb);
		boolean isWinToRightDiagonal = checkRightDiagonal(i, j, symb);

		return isWinInGorizontal || isWinInVertical || isWinToLeftDiagonal || isWinToRightDiagonal;
	}

	private static boolean checkGorizontal(int y, int x, char symb) {
		int count = 0;

		for (int i = x; i >= 0; i--) {
			if (map[y][i] == symb) count++;
			else break;
		}

		for (int i = x; i < size; i++) {
			if (map[y][i] == symb) count++;
			else break;
		}

		return count - 1 == dotsToWin;
	}

	private static boolean checkVertical(int y, int x, char symb) {
		int count = 0;

		for (int i = y; i >= 0; i--) {
			if (map[i][x] == symb) count++;
			else break;
		}

		for (int i = y; i < size; i++) {
			if (map[i][x] == symb) count++;
			else break;
		}

		return count - 1 == dotsToWin;
	}

	private static boolean checkRightDiagonal(int y, int x, char symb) {
		int count = 0;

		for (int i = y, j = x; i < size && j >= 0; i++, j--) {
			if (map[i][j] == symb) count++;
			else break;
		}

		for (int i = y, j = x; i >= 0 && j < size; i--, j++) {
			if (map[i][j] == symb) count++;
			else break;
		}

		return count - 1 == dotsToWin;
	}

	private static boolean checkLeftDiagonal(int y, int x, char symb) {
		int count = 0;

		for (int i = y, j = x; i < size && j < size; i++, j++) {
			if (map[i][j] == symb) count++;
			else break;
		}

		for (int i = y, j = x; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == symb) count++;
			else break;
		}

		return count - 1 == dotsToWin;
	}

	private static boolean isMapFull() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] == DOT_EMPTY) return false;
			}
		}
		return true;
	}

	private static int[] aiTurn(int[] humanTurn) {
		int x = -1;
		int y = -1;
		int i = humanTurn[0];
		int j = humanTurn[1];
		boolean isDone = false;

		if (isCellValid(i - 1, j)) {
			y = j;
			x = i - 1;
			isDone = true;
		}

		if (!isDone && isCellValid(i - 1, j - 1)) {
			y = j - 1;
			x = i - 1;
			isDone = true;
		}

		if (!isDone && isCellValid( i - 1, j + 1)) {
			y = j + 1;
			x = i - 1;
			isDone = true;
		}

		if (!isDone && isCellValid(i + 1, j)) {
			y = j;
			x = i + 1;
			isDone = true;
		}

		if (!isDone && isCellValid(i + 1, j - 1)) {
			y = j - 1;
			x = i + 1;
			isDone = true;
		}

		if (!isDone && isCellValid( i + 1, j + 1)) {
			y = j + 1;
			x = i + 1;
			isDone = true;
		}

		if (!isDone && isCellValid( i, j - 1)) {
			y = j - 1;
			x = i;
			isDone = true;
		}

		if (!isDone && isCellValid(i, j + 1)) {
			y = j + 1;
			x = i;
		}

		System.out.println("Компьютер сделал ход в точку " + (x + 1) + " " + (y + 1));
		map[y][x] = DOT_O;
		return new int[]{x, y};
	}

	private static int[] humanTurn() {
		int x, y;

		do {
			System.out.println("Введите координаты в формате X Y");
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
		} while (!isCellValid(x, y));
		map[y][x] = DOT_X;

		return new int[]{x, y};
	}

	private static boolean isCellValid(int x, int y) {
		boolean isInSize = x >= 0 && x < size && y >= 0 && y < size;
		if (isInSize) return map[y][x] == DOT_EMPTY;

		return false;
	}

	private static void initMap() {
		System.out.println("Введите размер поля (число от 3 до 5)");
		size = sc.nextInt();
		if (size < 3 || size > 5) {
			System.out.println("Неверный размер поля");
			initMap();
		} else {
			map = new char[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j] = DOT_EMPTY;
				}
			}
			if (size == 3) dotsToWin = 3;
			if (size > 3) dotsToWin = 4;
		}
	}

	private static void printMap() {
		for (int i = 0; i <= size; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < size; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
