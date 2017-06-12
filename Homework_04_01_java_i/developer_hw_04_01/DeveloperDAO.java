package developer_hw_04_01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class DeveloperDAO {
    Collection<Developer> developersList = new ArrayList<>();

    int number;
    String text;
    Scanner scanner = new Scanner(System.in);

    public int checkInteger() {
        boolean correctInt = false;
        while (!correctInt) {
            try {
                number = Integer.parseInt(scanner.next());
                correctInt = true;

            }catch (Exception e){
                System.out.println("Not integer.");
            }
        }

        return number;
    }

    public String checkText() {

        boolean correctText = false;
        while (!correctText){
            try {
                text = scanner.nextLine();
                correctText = true;
            }catch (Exception e) {
                System.out.println("Not a string!");
            }
        }

        return text;
    }


    public Developer getById(Integer id) {
        Developer developer = new Developer();
        developer.getId();
        return developer;
    }

    public Collection<Developer> getAllDevelopers(){
        List<Developer> developers = new ArrayList<>();

        //get all developers from file
     return developers;
    }

    //my code

    public void createNewDeveloper() throws IOException {
        Developer developer = new Developer();
        FileWriter fileWriter = new FileWriter("C:\\Documents and Settings\\Manager\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt");

        System.out.println("Enter ID");
        int id = checkInteger();
        scanner.nextLine();
        developer.setId(id);

        System.out.println("Enter first Name: ");
        String firstName = scanner.nextLine();
        developer.setFirstName(firstName);

        System.out.println("Enter last Name: ");
        String lastName = scanner.nextLine();
        developer.setLastName(lastName);


        System.out.println("Enter specialty: ");
        String specialty = scanner.nextLine();
        developer.setSpecialty(specialty);

        System.out.println("Enter experience: ");
        int experience = checkInteger();
        developer.setSpecialty(specialty);

        System.out.println("Enter salary:  ");
        double salary = scanner.nextDouble();
        developer.setSalary(salary);

        developersList.add(developer);
        System.out.println(developersList);

        String newDeveloperToString = "";

        newDeveloperToString += id+ ", " +firstName +", " +lastName +", " +specialty +", " +experience +", " +salary +"\n";

        fileWriter.write(newDeveloperToString);
        fileWriter.close();
    }

    public void update() {



    }

    public void delete(Integer id) {

    }



}
