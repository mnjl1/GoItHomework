package developer_hw_04_01;

import java.io.IOException;

public class DeveloperController {
     DeveloperDAO developerDAO = new DeveloperDAO();

public void  getDeveloperDAO() throws IOException {

         developerDAO.createNewDeveloper();
    }

    public void  getDevelopersList() {
        developerDAO.getAllDevelopers();
    }

    public void getDeveloperToRemoveFromList() {
        developerDAO.removeDeveloper();
    }

    public void updateFile() throws IOException {
        developerDAO.update();
    }

}


