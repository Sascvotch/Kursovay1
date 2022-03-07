package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Ivan0", "Ivanov", "Ivanovich", "1", 150000);
        employee[1] = new Employee("Ivan1", "Ivanov", "Ivanovich", "2", 160000);
        employee[2] = new Employee("Ivan2", "Ivanov", "Ivanovich", "3", 170000);
        employee[3] = new Employee("Ivan3", "Ivanov", "Ivanovich", "4", 180000);
        employee[4] = new Employee("Ivan4", "Ivanov", "Ivanovich", "5", 190000);
        employee[5] = new Employee("Ivan5", "Ivanov", "Ivanovich", "1", 140000);
        employee[6] = new Employee("Ivan6", "Ivanov", "Ivanovich", "2", 130000);
        employee[7] = new Employee("Ivan7", "Ivanov", "Ivanovich", "3", 120000);
        employee[8] = new Employee("Ivan8", "Ivanov", "Ivanovich", "4", 110000);
        employee[9] = new Employee("Ivan9", "Ivanov", "Ivanovich", "5", 200000);

        printAllEmployee(employee);
        System.out.println("Сумма затрат на зарплату в месяц: " +allSalary(employee));
        maxSalary(employee);
        minSalary(employee);
        System.out.println("Средняя зарплата: " +averageSalary(employee));

        for (int i=0; i< employee.length;i++) {
            getFullName(employee, i);
        }
    }

    private static void getFullName(Employee [] employee, int i) {
        String fullName = employee[i].getLastName() + " " +employee[i].getName() + " " +employee[i].getMiddleName();
        System.out.println(fullName) ;
    }

    public static void printAllEmployee(Employee [] employee) {
        System.out.println(Arrays.toString(employee));

    }

   public static double allSalary(Employee [] employee) {
          double allSalary = 0;
          for (int i = 0; i < employee.length; i++) {
               allSalary +=employee[i].getSalary();
          }
          return allSalary;
    }
    public static double averageSalary(Employee [] employee) {
        double averageSalary= allSalary(employee)/10;
        return averageSalary;
    }
    public static void minSalary(Employee [] employee) {
        double minSalary = employee[0].getSalary();
        int y = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() < minSalary) {
                minSalary = employee[i].getSalary();
                y = i;
            }
        }
        System.out.println("Минимальная зарплата у сотрудника " + employee[y].toString() + " рублей");
    }
    public static void maxSalary(Employee [] employee) {
        double maxSalary = employee[0].getSalary();
        int y = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i].getSalary() > maxSalary) {
                maxSalary = employee[i].getSalary();
                y = i;
            }
        }
        System.out.println("Максимальная зарплата у сотрудника " + employee[y] + " рублей");
    }


}
