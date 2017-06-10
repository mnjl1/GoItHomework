package developer_hw_04_01;

public class DeveloperController {
    private DeveloperDAO developerDAO;

    public Developer getById(Integer id){
        return developerDAO.getById(id);

    }
}
