public class Employee {
	private String fio;
	private Position position;
	private String email;
	private String phone;
	private int salary;
	private int age;

	public enum Position {
		DIRECTOR("Директор"),
		DEVELOPER("Разработчик"),
		TESTER("Тестировщик"),
		ACCOUNTANT("Бухгалтер");

		private String position;

		Position(String position) {
			this.position = position;
		};

		public String getPosition() {
			return position;
		}

	}

	public Employee(String fio, Position position, String email, String phone, int salary, int age) {
		this.fio = fio;
		this.position = position;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getFio() {
		return fio;
	}

	public Position getPosition() {
		return position;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void printToConsole() {
		System.out.println("ФИО: " + fio);
		System.out.println("Должность: " + position.getPosition());
		System.out.println("Email: " + email);
		System.out.println("Tелефон: " + phone);
		System.out.println("Зарплата: " + salary);
		System.out.println("Возраст: " + age);
		System.out.println();
	}
}
