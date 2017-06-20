package developer_hw_04_01;

import java.io.*;
import java.util.*;

public class DeveloperDAO {


     Map<Integer, Developer> developerMap = new TreeMap<>();

    int number;

    Scanner scanner = new Scanner(System.in);

    //public static final String PATH_TO_DEVELOPERS_LIST = "C:\\Users\\Dmytro\\IdeaProjects\\GoItHomework\\Homework_04_01_java_i\\Developers.txt";
    //public static final String PATH_TO_DEVELOPERS_LIST = "Developers.txt";
    File devFile = new File("Developers.txt");


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
        try(FileWriter fileWriter = new FileWriter(devFile, true)) {

            final String LINE_SEPARATOR = System.getProperty("line.separator");

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

            newDeveloperToString += id + ", " + firstName + ", " + lastName + ", "
                    + specialty + ", " + experience + ", " + salary;

            fileWriter.write(newDeveloperToString);
            fileWriter.write(LINE_SEPARATOR);
            fileWriter.close();
        }catch (IOException e){
            System.out.println("Can not create developer.");
            System.out.println(e);
        }

    }
//remove developer from file
    public void removeDeveloper() throws Exception {
        //copy developers from file to collection
        try(BufferedReader bufferedReader =
                    new BufferedReader((new InputStreamReader(new FileInputStream(devFile))))) {

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
        try(FileWriter fileWriter = new FileWriter(devFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            final String LINE_SEPARATOR = System.getProperty("line.separator");

            for (Map.Entry<Integer, Developer> entry : developerMap.entrySet()) {

                Object value = entry.getValue();
                bufferedWriter.write(value.toString());
                bufferedWriter.write(LINE_SEPARATOR);
                bufferedWriter.flush();

                //bufferedWriter.newLine();
            }

        }catch (Exception e){
            System.out.println("Cannot record file.");
            System.out.println(e);
        }

        //clearing collection after writing developers to file
        developerMap.clear();
    }

    public void readDevelopersFile() throws Exception {

        try(FileReader fileReader = new FileReader(devFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {

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
