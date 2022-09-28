public class Main {
    public static void main(String[] args){
        System.out.println("Task 1 - Student classes");   
        System.out.println(); 

        Student[] students = {
            new Student( "Ivan", "Ivanov", "1234", 5),
            new Student( "Petr", "Petrov", "1234", 4.5),
            new Aspirant( "Sidor", "Sidorov", "123456", 3),
            new Aspirant( "Nikolay", "Nikolayev", "123456", 5),
        };
        showEachScholarship(students);

        System.out.println(); 
        System.out.println("Task 2 - Animal classes");
        System.out.println();    

        Animal[] animals = {
            new Cat("fish", "house", "Vasya", "black"),
            new Dog("meat", "home", "Baron", "white"),
            new Horse("hay", "stable", "Starry", "brown"),
        };
        sendToVet(animals);

        System.out.println(); 
        System.out.println("Task 3 - Phone classes");
        System.out.println();    

        Phone[] phones = {
            new Phone(5553535, 5, 3),
            new Phone(5553535, 5),
            new Phone(),
        };
        phonesTasks(phones);
        Phone.sendMessage(phones);
    }
    
    public static void showEachScholarship(Student[] students) {
        for (Student student : students) {
            System.out.println(student.firstname + " " + student.lastname + " " + student.averagemark + " " + student.getScholarship());
        }
    }
    public static void sendToVet(Animal[] animals) {
        for (Animal animal : animals) {
            Vet.treatAnimal(animal);
        }
    }
    public static void phonesTasks(Phone[] phones){
        for (Phone phone : phones) {
            phone.receiveCall("caller");
            System.out.println(phone.getNumber());
            phone.receiveCall("caller", phone.number);
        }
    }
}

