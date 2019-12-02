
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bookstoreModel {

    private String QueryResult;
    private String bookTitle;
    private String bookAuthor;
    private int bookQty;
    private int bookId;

    private int maxId;

    //generate new id numbers for books
    public void generateId() throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {

            maxId = 0;

            String Id = "select id from books";
            ResultSet idResult = stmt.executeQuery(Id);
            while (idResult.next()) {
                maxId = idResult.getInt("id");
            }
            maxId++;
        }
    }

    public int getId() {
        return maxId;
    }

    //select book via id from db
    public void SelectBookId(int id) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {
            QueryResult = "";
            bookTitle = "";
            bookAuthor = "";
            bookQty = 0;
            String Select = "select * from books where id =" + id;
            ResultSet result = stmt.executeQuery(Select);
            while (result.next()) {
                QueryResult = result.getString("title") + ", "
                        + result.getString("author") + ", "
                        + result.getInt("qty");

                bookTitle = result.getString("title");
                bookAuthor = result.getString("author");
                bookQty = result.getInt("qty");
            }

        }
    }

    public String getTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return bookAuthor;
    }

    public String getQty() {
        return bookQty + "";
    }

    public String getBookId() {
        return bookId + "";
    }

    //select book via title from db
    public void SelectBookTitle(String title) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {
            QueryResult = "";
            String Select = "select * from books where title = " + "'" + title + "'";
            ResultSet result = stmt.executeQuery(Select);
            while (result.next()) {
                QueryResult = result.getInt("id") + "," + result.getString("title") + ", "
                        + result.getString("author") + ", "
                        + result.getInt("qty");

                bookId = result.getInt("id");
            }
        }
    }

    public String getResult() {
        return QueryResult;
    }

    public void addBook(int Id, String Title, String Author, int Qty) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {

            String insert = "insert into books values (" + Id + "," + "'" + Title + "'" + "," + "'" + Author + "'" + "," + Qty + ")";
            int countinsert = stmt.executeUpdate(insert);
        }
    }

    //update book method
    public void updateBook(int Id, String Title, String Author, int Qty) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {

            String updateTitle = "update books set title = " + "'" + Title + "'" + " where id = " + Id;
            int countinsert = stmt.executeUpdate(updateTitle);
            String updateAuthor = "update books set author = " + "'" + Author + "'" + " where id = " + Id;
            countinsert = stmt.executeUpdate(updateAuthor);
            String updateQty = "update books set qty = " + "'" + Qty + "'" + " where id = " + Id;
            countinsert = stmt.executeUpdate(updateQty);
        }
    }

    public void deleteBook(int Id) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name?useSSL=false", "username", "Password");
                Statement stmt = conn.createStatement();) {

            String DeleteBook = "delete from books where id = " + Id;
            int CountUpdated = stmt.executeUpdate(DeleteBook);
        }
    }

}
