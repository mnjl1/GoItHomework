package developer_hw_04_01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeveloperDAO {

    public Developer getById(Integer id) {
        Developer developer = new Developer();

        return developer;
    }

    public Collection<Developer> getAllDevelopers(){
        List<Developer> developers = new ArrayList<>();
        //get all developers fron file
     return developers;
    }

    public void save(Developer developer) throws IOException {

        FileWriter fileWriter = new FileWriter("");

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

    public void update(Developer developer) {

    }

    public void delete(Integer id) {

    }

}
