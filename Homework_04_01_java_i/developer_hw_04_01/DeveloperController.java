package developer_hw_04_01;

import java.io.IOException;

public class DeveloperController {
    private DeveloperDAO developerDAO;

    public Developer getById(Integer id){

        return developerDAO.getById(id);

    }

    public Developer saveNewDeveloper() throws IOException {

        return null;

    }
}
