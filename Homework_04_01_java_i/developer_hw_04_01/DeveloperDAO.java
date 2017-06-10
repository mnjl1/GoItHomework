package developer_hw_04_01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class DeveloperDAO {


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
        FileWriter fileWriter = new FileWriter("Developers.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();
        developer.setId(id);

        String newDeveloperToString = "";

        newDeveloperToString = developer.getId()+"/";

        fileWriter.write(newDeveloperToString);

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
