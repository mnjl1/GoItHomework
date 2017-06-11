package developer_hw_04_01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class DeveloperDAO {
    int number;
    String text;

    public int checkInteger() {
        Scanner scanner = new Scanner(System.in);
        boolean correctInt = false;
        while (!correctInt) {
            try {
                number = Integer.parseInt(scanner.next());
                correctInt = true;

            }catch (Exception e){
                System.out.println("Not integer.");
            }
        }
        scanner.close();
        return number;
    }

    public String checkText() {
        Scanner scanner = new Scanner(System.in);
        boolean correctText = false;
        while (!correctText){
            try {
                text = scanner.nextLine();
                correctText = true;
            }catch (Exception e) {
                System.out.println("Not a string!");
            }
        }
        scanner.close();
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

    public void  creatNewDeveloper() throws IOException {
        Developer developer = new Developer();

        FileWriter fileWriter = new FileWriter("C:\\Users\\Dmytro\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt");

        System.out.println("Enter ID");
        int id = checkInteger();
        developer.setId(id);

        System.out.println("Enter first Name: ");
        String firstName = checkText();
        developer.setFirstName(firstName);


        String newDeveloperToString = "";

        newDeveloperToString += id+ ", " +firstName; //developer.getId()+"/";

        fileWriter.write(newDeveloperToString);
        fileWriter.close();

    }

    public void save() throws IOException {

        FileWriter fileWriter = new FileWriter("Developers.txt");
        Developer developer = new Developer();
        Integer id = developer.getId();
        String firstName = developer.getFirstName();
        String lastName = developer.getLastName();
        String specialty = developer.getSpecialty();
        Integer experience = developer.getExperience();
        Double salary = developer.getSalary();

        String developerToStringRepresentation ="";
        developerToStringRepresentation += id +", " +firstName +", " +lastName +", " +specialty +", " +experience +", " +salary +"/";
        fileWriter.write(developerToStringRepresentation);

    }

    public void update() {



    }

    public void delete(Integer id) {

    }

}
