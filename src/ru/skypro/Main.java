package ru.skypro;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int numberDepartment =3;
        double indexSalary=0.1;
        double limitSalary=200000;
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Ivan0", "Ivanov", "Ivanovich", 1, 150000);
        employee[1] = new Employee("Ivan1", "Ivanov", "Ivanovich", 2, 160000);
        employee[2] = new Employee("Ivan2", "Ivanov", "Ivanovich", 3, 170000);
        employee[3] = new Employee("Ivan3", "Ivanov", "Ivanovich", 4, 180000);
        employee[4] = new Employee("Ivan4", "Ivanov", "Ivanovich", 5, 190000);
        employee[5] = new Employee("Ivan5", "Ivanov", "Ivanovich", 1, 140000);
        employee[6] = new Employee("Ivan6", "Ivanov", "Ivanovich", 2, 130000);
        employee[7] = new Employee("Ivan7", "Ivanov", "Ivanovich", 3, 120000);
        employee[8] = new Employee("Ivan8", "Ivanov", "Ivanovich", 4, 110000);
        employee[9] = new Employee("Ivan9", "Ivanov", "Ivanovich", 5, 200000);
        System.out.println("Зарплата после индексации составит: ");
        indexingSalary (employee, 0.1);
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].toString() );
        }
        System.out.println("");
        System.out.println("Информация по отделу номер " +numberDepartment +":");
        if (countEmployeeDepartment(employee,numberDepartment)>0) {
            minSalaryDepartment(employee, numberDepartment);
            maxSalaryDepartment(employee, numberDepartment);
            System.out.println("Сумма затрат на зарплату по отделу: " + allSalaryDepartment(employee, numberDepartment));
            System.out.println("Средняя зарплата по отделу: " + averageSalaryDepartment(employee, numberDepartment));
            indexingSalaryDepartment(employee, indexSalary, numberDepartment);
            System.out.println("Список сотрудников отдела:");
            for (int i = 0; i < employee.length; i++) {
                getEmployeeDepartment(employee, i, numberDepartment);
            }
        }
        else {
            System.out.println("В отделе нет сотрудников");
        }
        System.out.println("");

        employeeSalaryMore(employee,limitSalary);
        employeeSalaryLess(employee,limitSalary);
    }

    public static int countEmployeeDepartment(Employee [] employee, int numberDepartment) {
        int countEmployeeDepartment=0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getNumberDepartment() == numberDepartment) {
                countEmployeeDepartment=countEmployeeDepartment+1;
            }
        }
        return countEmployeeDepartment;
    }
    private static void employeeSalaryMore (Employee [] employee, double limitSalary) {
        boolean employeeExists=false;
        System.out.println("Сотрудники с зарплатой больше " +limitSalary+" рублей");
        for (int i=0; i<employee.length; i++) {
          if (employee[i].getSalary()>=limitSalary) {
              employeeExists=true;
              System.out.println(employee[i].getId() + ": " + employee[i].toStringFullName() + " с зарплатой " + employee[i].getSalary() + " рублей");
          }
        }
        if (!employeeExists) {
            System.out.println("Нет сотрудников с зарплатой больше " +limitSalary+" рублей");
        }
    }
    private static void employeeSalaryLess (Employee [] employee, double limitSalary) {
        boolean employeeExists=false;
        System.out.println("Сотрудники с зарплатой меньше или равно " +limitSalary+" рублей");
        for (int i=0; i<employee.length; i++) {
            if (employee[i].getSalary()<limitSalary) {
                employeeExists=true;
                System.out.println(employee[i].getId() + ": " + employee[i].toStringFullName() + " с зарплатой " + employee[i].getSalary() + " рублей");
            }
        }
        if (!employeeExists) {
            System.out.println("Нет сотрудников с зарплатой меньше или равно " +limitSalary+" рублей");
        }
    }
    private static void indexingSalary (Employee [] employee, double indexSalary) {

        for (int i=0; i<employee.length; i++) {
            employee[i].setSalary(employee[i].getSalary()+employee[i].getSalary()*indexSalary);
        }
    }
    public static void minSalaryDepartment(Employee [] employee, int numberDepartment) {
        double minSalary=0;
        int y = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getNumberDepartment() == numberDepartment) {
               if (minSalary>0) {
                   if (employee[i].getSalary() < minSalary) {
                       minSalary = employee[i].getSalary();
                       y = i;
                   }
               } else {minSalary=employee[i].getSalary();}

            }
        }
        System.out.println("Минимальная зарплата по отделу номер " + numberDepartment +" у сотрудника " + employee[y].toStringFullName() +" "+ employee[y].getSalary()+ " рублей");
    }
    public static void maxSalaryDepartment(Employee [] employee, int numberDepartment) {
        double maxSalary = 0;
        int y = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getNumberDepartment() == numberDepartment) {
                if (employee[i].getSalary() > maxSalary) {
                    maxSalary = employee[i].getSalary();
                    y = i;
                }
            }
        }
        System.out.println("Максимальная зарплата по отделу номер " + numberDepartment +" у сотрудника " + employee[y].toStringFullName() +" "+ employee[y].getSalary() +" рублей");
    }
    public static double allSalaryDepartment (Employee [] employee, int numberDepartment) {
        double allSalaryDepartment = 0;
        for (int i = 0; i < employee.length; i++) {
             if (employee[i].getNumberDepartment() == numberDepartment) {
                 allSalaryDepartment += employee[i].getSalary();
            }
        }
        return allSalaryDepartment;
    }

    public static double averageSalaryDepartment(Employee [] employee, int numberDepartment) {
        int count=countEmployeeDepartment(employee,numberDepartment);
        double averageSalaryDepartment =0;
        if (count>0) {
           averageSalaryDepartment = allSalaryDepartment(employee, numberDepartment) / count;
        }
        return averageSalaryDepartment;
    }
    private static void indexingSalaryDepartment (Employee [] employee, double indexSalary, int numberDepartment) {

        for (int i=0; i<employee.length; i++) {
            if (employee[i].getNumberDepartment() == numberDepartment) {
                employee[i].setSalary(employee[i].getSalary() + employee[i].getSalary() * indexSalary);
            }
        }
    }

    private static void getEmployeeDepartment (Employee [] employee, int i, int numberDepartment) {
        if (employee[i].getNumberDepartment() == numberDepartment) {
            String employeeInfo = employee[i].getId() + ": " + employee[i].getLastName() + " " + employee[i].getName() + " " + employee[i].getMiddleName() + ": " + employee[i].getSalary();
            System.out.println(employeeInfo);
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
