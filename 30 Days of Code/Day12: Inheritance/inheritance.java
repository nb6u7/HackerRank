import java.util.*;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

	// Constructor
    Person(String firstName, String lastName, int identification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

	// Print person data
    public void printPerson() {
        System.out.println("Name: " + lastName + ", " + firstName + 	"\nID: " + idNumber);
    }
}

class Student extends Person {
    private int[] testScores;

    Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }

    public char calculate() {
        int sum = 0;

        for (int i = 0; i < this.testScores.length; i++) {
            sum += this.testScores[i];
        }

        int ave = sum / this.testScores.length;

        if ((90 <= ave) && (ave <= 100)) {
            return 'O';
        } else if ((80 <= ave) && (ave < 90)) {
            return 'E';
        } else if ((70 <= ave) && (ave < 80)) {
            return 'A';
        } else if ((55 <= ave) && (ave < 70)) {
            return 'P';
        } else if ((40 <= ave) && (ave < 55)) {
            return 'D';
        } else {
            return 'T';
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
		    String lastName = scan.next();
		    int id = scan.nextInt();
		    int numScores = scan.nextInt();
        int[] testScores = new int[numScores];
        for(int i = 0; i < numScores; i++) {
            testScores[i] = scan.nextInt();
        }
        scan.close();

        Student s = new Student(firstName, lastName, id, testScores);
        s.printPerson();
        System.out.println("Grade: " + s.calculate() );
    }
}
