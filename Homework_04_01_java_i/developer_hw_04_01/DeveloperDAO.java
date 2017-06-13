package developer_hw_04_01;

import java.io.*;
import java.util.*;

public class DeveloperDAO {
    //Collection<Developer> developersList = new ArrayList<>();
    Map<Integer, Developer> developerMap = new TreeMap<>();


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



    public Map<Integer, Developer> getAllDevelopers(){

        return developerMap;
    }

    //my code**********************

    public void createNewDeveloper() throws IOException {
        Developer developer = new Developer();
        FileWriter fileWriter = new FileWriter("C:\\Documents and Settings\\Manager\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt", true);

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

//        developersList.add(developer);
//        System.out.println(developersList);

        developerMap.put(id, developer);
        System.out.println(developerMap);

        String newDeveloperToString = "";

        newDeveloperToString += id+ ", " +firstName +", " +lastName +", " +specialty +", " +experience +", " +salary +"\n" ;

        fileWriter.write(newDeveloperToString);
        fileWriter.close();

    }


}
