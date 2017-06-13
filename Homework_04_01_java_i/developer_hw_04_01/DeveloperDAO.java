package developer_hw_04_01;

import java.io.*;
import java.util.*;

public class DeveloperDAO {
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

    public void getAllDevelopers(){
        for (Map.Entry<Integer, Developer> entry: developerMap.entrySet()) {
            System.out.println("ID: " +entry.getKey() +". " +" Developer: " +entry.getValue());
        }
    }

    public void createNewDeveloper() throws IOException {
        Developer developer = new Developer();
        FileWriter fileWriter = new FileWriter("C:\\Users\\Dmytro\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt", true);

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


        developerMap.put(id, developer);
        System.out.println(developerMap);

        String newDeveloperToString = "";

        newDeveloperToString += id+ ", " +firstName +", " +lastName +", " +specialty +", " +experience +", " +salary +"\n" ;

        fileWriter.write(newDeveloperToString);
        fileWriter.close();

    }

    public void removeDeveloper() {
        System.out.println("Enter developer ID to remove.");
        int id = checkInteger();

        if (developerMap.containsKey(id)) {
            developerMap.remove(id);
        }
        else System.out.println("No developer found");



    }

    //updating text file after editing/removing developer
    public void update() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\Dmytro\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        fileWriter.write("");
        for (Map.Entry<Integer, Developer> entry: developerMap.entrySet()){
              bufferedWriter.write(entry.getKey() +"\t" +entry.getValue());

        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();


    }




}
