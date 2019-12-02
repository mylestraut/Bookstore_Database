
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bookstoreController {

    private bookstoreModel theModel;
    private bookstoreTabbedView tabbedView;

    public bookstoreController(bookstoreModel theModel, bookstoreTabbedView tabbedView) {

        this.theModel = theModel;
        this.tabbedView = tabbedView;

        this.tabbedView.addSearchIdListener(new searchIdListener());
        this.tabbedView.addAddBookListener(new addBookListener());
        this.tabbedView.submitUpdateListener(new submitUpdateListener());
        this.tabbedView.updateListener(new updateBookListener());
        this.tabbedView.deleteIdListener(new getDeleteIdListener());
        this.tabbedView.addDeleteListener(new deleteListener());

    }

    class searchIdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = 0;

            try {

                id = tabbedView.getBookId();

                theModel.SelectBookId(id);

                tabbedView.setTitle(theModel.getTitle());
                tabbedView.setAuthor(theModel.getAuthor());
                tabbedView.setQty(theModel.getQty());
            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

    class addBookListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = 0;

            try {

                theModel.generateId();
                id = theModel.getId();
                String Title = tabbedView.getBookName();
                String Author = tabbedView.getBookAuthor();
                int Qty = tabbedView.getBookQty();

                theModel.addBook(id, Title, Author, Qty);
                theModel.SelectBookTitle(Title);
                tabbedView.setAddResult(theModel.getResult());
            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

    class submitUpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = 0;

            try {

                id = tabbedView.getBookIdUpdate();

                theModel.SelectBookId(id);

                tabbedView.setUpdateTitle(theModel.getTitle());
                tabbedView.setUpdateAuthor(theModel.getAuthor());
                tabbedView.setUpdateQty(theModel.getQty());
            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

    class updateBookListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int Id = 0;
            try {

                Id = tabbedView.getBookIdUpdate();
                String Title = tabbedView.getUpdateBookName();
                String Author = tabbedView.getUpdateBookauthor();
                int Qty = tabbedView.getUpdateBookQty();

                theModel.updateBook(Id, Title, Author, Qty);
                tabbedView.setUpdateMsg("Book Updated");
            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

    class getDeleteIdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int Id = 0;
            try {

                Id = tabbedView.getDeleteBookId();
                theModel.SelectBookId(Id);

                tabbedView.setDeleteResult(theModel.getResult());

            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

    class deleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int Id = 0;
            try {

                Id = tabbedView.getDeleteBookId();
                theModel.SelectBookId(Id);

                theModel.deleteBook(Id);
                tabbedView.setDeleteMsg("Book Deleted");
            } catch (SQLException ex) {
                Logger.getLogger(bookstoreController.class.getName()).log(Level.SEVERE, null, ex);
                tabbedView.displayErrorMsg("No Connection");
            }
        }

    }

}
