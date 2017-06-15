package developer_hw_04_01;

import java.io.*;
import java.util.*;


public class DeveloperDAO {
    Developer developer = new Developer();
     Map<Integer, Developer> developerMap = new TreeMap<>();

    int number;
    String text;
    Scanner scanner = new Scanner(System.in);

    public static final String PATH_TO_DEVELOPERS_LIST = "C:\\Documents and Settings\\Manager\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt";

    //method for inserting any integer
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

        FileWriter fileWriter = new FileWriter(PATH_TO_DEVELOPERS_LIST, true);

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

        String newDeveloperToString = "";

        newDeveloperToString += id+ ", " +firstName +", " +lastName +", " +specialty +", " +experience +", " +salary +"\n";

        fileWriter.write(newDeveloperToString);
        fileWriter.close();

    }
//remove developer from file
    public void removeDeveloper() throws Exception {

        //copy developers from file to collection
        FileReader fileReader = new FileReader(PATH_TO_DEVELOPERS_LIST);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int id;
        String devLine;
        while ((devLine = bufferedReader.readLine()) !=null && devLine.isEmpty()) {
            String[] devLineSplit = devLine.split(",\\s");
           id = Integer.parseInt(devLineSplit[0]);
           developer.setId(id);
           developer.setFirstName(devLineSplit[1]);
           developer.setLastName(devLineSplit[2]);
           developer.setSpecialty(devLineSplit[3]);
           int experience = Integer.parseInt(devLineSplit[4]);
           developer.setExperience(experience);
           double salary = Double.parseDouble(devLineSplit[5]);
           developer.setSalary(salary);

           developerMap.put(id, developer);

        }
        System.out.println(developerMap);
         //

//        System.out.println("Enter developer ID to remove.");
//        int id = checkInteger();

        //remove developer from collection by ID
//        if (developerMap.containsKey(id)) {
//            developerMap.remove(id);
//        }
//        else System.out.println("No developer found");
//
//        //copy from collection to file
//        FileWriter fileWriter = new FileWriter(PATH_TO_DEVELOPERS_LIST);
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//        fileWriter.write("");
//        for (Map.Entry<Integer, Developer> entry: developerMap.entrySet()){
//            bufferedWriter.write(entry.getKey() +"\t" +entry.getValue());
//        }
//        bufferedWriter.flush();
//        bufferedWriter.close();
//        fileWriter.close();

        //developerMap.clear();

    }

/*candidate to be deleted

    public void update() throws IOException {
        FileWriter fileWriter = new FileWriter(PATH_TO_DEVELOPERS_LIST);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();

        FileWriter fileWriter1 = new FileWriter(PATH_TO_DEVELOPERS_LIST, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter1);

        for (Map.Entry<Integer, Developer> entry: developerMap.entrySet()){
              bufferedWriter.write(entry.getKey() +"\t" +entry.getValue());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
    */

    public void readDevelopersFile() throws Exception {
        FileReader fileReader = new FileReader(PATH_TO_DEVELOPERS_LIST);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String devLine;
        while ((devLine = bufferedReader.readLine()) !=null) {
            System.out.println(devLine);
        }
        System.out.println();
        bufferedReader.close();
        fileReader.close();
    }
}
