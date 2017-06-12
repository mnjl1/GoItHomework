package developer_hw_04_01;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Manager on 10.06.17.
 */
public class DeveloperView {
    private DeveloperController controller = new DeveloperController();


    public void starMenu() {

        System.out.println("Hello!");
        System.out.println("Make your choice:");
        while (true) {
            System.out.println("1. Insert new developer.");
            System.out.println("2. Find developer by ID.");
            System.out.println("3. Print.");
            System.out.println("4. Exit APP");


            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            boolean correctChoice = false;
            while (!correctChoice) {
                try {
                    choice = Integer.parseInt(scanner.next());
                    correctChoice = true;
                } catch (Exception e) {
                    System.out.println("Not integer.");
                    System.out.println(e);
                }
            }
            switch (choice) {
                case 1: {
                    DeveloperView developerView = new DeveloperView();
                    try {
                        developerView.controller.getDeveloperDAO();
                    } catch (Exception e) {
                        System.out.println("Something wrong with file.");
                        System.out.println(e);
                    }
                }
            }
        }
    }
}
