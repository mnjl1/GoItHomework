package developer_hw_04_01;

import java.io.IOException;

public class DeveloperController {
     DeveloperDAO developerDAO = new DeveloperDAO();

    public Developer getById(Integer id){

        return developerDAO.getById(id);

    }
public void  getDeveloperDAO() throws IOException {

         developerDAO.creatNewDeveloper();
    }
}
