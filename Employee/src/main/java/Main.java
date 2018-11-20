public class Main {

	public static void main(String[] args) {
		Employee[] employees = new Employee[5];

		employees[0] = new Employee(
			"Иванов Иван Иванович",
			Employee.Position.DIRECTOR,
			"ivanov@company.org",
			"8-909-749-50-79",
			200000,
			50
		);

		employees[1] = new Employee(
			"Петров Петр Петрович",
			Employee.Position.ACCOUNTANT,
			"petrov@company.org",
			"8-924-749-50-79",
			100000,
			40
		);

		employees[2] = new Employee(
			"Разработчиков Иван Петрович",
			Employee.Position.DEVELOPER,
			"razrabotchickov@company.org",
			"8-909-749-50-54",
			150000,
			30
		);

		employees[3] = new Employee(
			"Проверяева Алиса Леонидовна",
			Employee.Position.TESTER,
			"proveriaeva@company.org",
			"8-909-892-54-79",
			60000,
			25
		);

		employees[4] = new Employee(
			"Мастреровой Аркадий Иванович",
			Employee.Position.DEVELOPER,
			"masterovoy@company.org",
			"8-979-789-55-79",
			120000,
			26
		);

		for (Employee employee: employees) {
			if (employee.getAge() > 40) {
				employee.printToConsole();
			}
		}
	}

}
