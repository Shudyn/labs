import java.util.Scanner;

public class ThirdTask {
  private Scanner scanner;

  public ThirdTask(Scanner sc) {
    this.scanner = sc;
    this.ask();
  }

  private void ask() {
    int result;
    System.out.println("Введите любое число:");
    int number = this.scanner.nextInt();

    if (number > 0) {
      result = number + 1;
    }
    else {
      result = number;
    }

    System.out.println("Результат: " + result);
  }
}
