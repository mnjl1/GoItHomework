package developer_hw_04_01;

import java.io.*;
import java.util.*;

public class DeveloperDAO {

     Map<Integer, Developer> developerMap = new HashMap<>();
     List<Developer> developerList = new ArrayList<>();

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

    public void createNewDeveloper() throws IOException {
        Developer developer = new Developer();
        FileWriter fileWriter = new FileWriter(PATH_TO_DEVELOPERS_LIST, true);

        System.out.println("Enter ID");
        int id = checkInteger();
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
        try {
            BufferedReader bufferedReader =
                    new BufferedReader((new InputStreamReader(new FileInputStream(PATH_TO_DEVELOPERS_LIST))));
            String devLine;
            while ((devLine = bufferedReader.readLine()) != null) {
                Developer developer = new Developer();
                String[] devLineSplit = devLine.split(",\\s");
                int id = Integer.parseInt(devLineSplit[0]);
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
        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println(developerMap);

        //remove developer from collection by ID
        System.out.println("Enter developer ID to remove.");
        int id = checkInteger();

        if (developerMap.containsKey(id)) {
            developerMap.remove(id);
            System.out.println("Developer is deleted.");
        }
        else System.out.println("No developer found");

        //copy from collection to file
        try {
            FileWriter fileWriter = new FileWriter(new File(PATH_TO_DEVELOPERS_LIST));
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //fileWriter.write("");
            for (Map.Entry<Integer, Developer> entry : developerMap.entrySet()) {
                bufferedWriter.write(entry.getKey() +"\t" +entry.getValue());
            }
        }catch (Exception e){
            System.out.println("Cannot record file.");
            System.out.println(e);
        }
        System.out.println(developerMap);
        //clearing collection after recording developers to file
        developerMap.clear();
    }

    public void readDevelopersFile() throws Exception {

        try {
            FileReader fileReader = new FileReader(PATH_TO_DEVELOPERS_LIST);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String devLine;
            while ((devLine = bufferedReader.readLine()) != null) {
                System.out.println(devLine);
            }
            System.out.println();
        }catch (Exception e){
            System.out.println("Can not read file.");
            System.out.println(e);
        }

    }
}
