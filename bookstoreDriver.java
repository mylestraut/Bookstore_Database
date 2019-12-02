
import java.sql.SQLException;

public class bookstoreDriver {

    public static void main(String[] args) throws SQLException {

        bookstoreModel theModel = new bookstoreModel();
        bookstoreTabbedView tabbedView = new bookstoreTabbedView();

        bookstoreController theController = new bookstoreController(theModel, tabbedView);

        tabbedView.setVisible(true);

    }
}
