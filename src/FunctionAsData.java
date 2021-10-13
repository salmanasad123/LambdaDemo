import javax.xml.crypto.Data;
import java.util.function.Function;

public class FunctionAsData {

    static class Person {
        String name;
        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    static class DataLoader {

        public final NoArgFunction<Person> loadPerson;

        public DataLoader(boolean isDevelopment) {

            this.loadPerson = isDevelopment ? this::loadPersonFake : this::loadPersonReal;

        }

        public Person loadPersonReal() {
            System.out.println("Loading person ...");
            return new Person("Real Person", 30);
        }

        public Person loadPersonFake() {
            System.out.println("Loading fake person");

            return new Person("Fake person", 100);
        }
    }

    public static void main(String[] args) {
        final boolean isDevelopment = true;
        DataLoader dataLoader = new DataLoader(isDevelopment);
        System.out.println(dataLoader.loadPerson.apply());

    }
}
