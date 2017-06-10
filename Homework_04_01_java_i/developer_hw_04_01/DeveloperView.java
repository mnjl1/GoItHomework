package developer_hw_04_01;

/**
 * Created by Manager on 10.06.17.
 */
public class DeveloperView {
    private DeveloperController controller;

    public void starMenu() {
        System.out.println("Hello!");
    }

    void getById(Integer id) {
       Developer developer = controller.getById(id);
        System.out.println(developer);
    }

}
