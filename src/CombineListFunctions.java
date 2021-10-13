import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CombineListFunctions {

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        CombineListFunctions.Employee[] employeesArr = {
                new CombineListFunctions.Employee("John", 34, "developer", 80000f),
                new CombineListFunctions.Employee("Hannah", 24, "developer", 95000f),
                new CombineListFunctions.Employee("Bart", 50, "sales executive", 100000f),
                new CombineListFunctions.Employee("Sophie", 49, "construction worker", 40000f),
                new CombineListFunctions.Employee("Darren", 38, "writer", 50000f),
                new CombineListFunctions.Employee("Nancy", 29, "developer", 75000f),
        };
        List<CombineListFunctions.Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        // find salary of all developers
        Float totalDeveloperSalaries = employees.stream()
                .filter((Employee e) -> {
                            return e.jobTitle.equals("developer");
                        }
                )
                .map((Employee e) -> {
                    return e.salary;
                })
                .reduce(0f, (Float acc, Float x) -> {
                    return acc + x;
                });

        System.out.println(totalDeveloperSalaries);

//        Predicate<Employee> findDevelopers = new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.jobTitle.equals("developer");
//            }
//        };

        // find total number of developers
        Long numberOfDevelopers = employees.stream()
                .filter((Employee e) -> {
                    return e.jobTitle.equals("developer");
                })
                .collect(Collectors.counting());

        System.out.println(numberOfDevelopers);
    }
}
