
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class bookstoreTabbedView extends JFrame {

    private JPanel searchPanel = new JPanel();
    private JPanel addPanel = new JPanel();
    private JPanel updatePanel = new JPanel();
    private JPanel deletePanel = new JPanel();

    private JTabbedPane tabbedView = new JTabbedPane();

    //search panel elements
    private JLabel enterBookId = new JLabel("Please Enter Book ID");
    private JTextField bookID = new JTextField(20);
    private JLabel title = new JLabel("Title");
    private JTextField displayTitle = new JTextField(40);
    private JLabel author = new JLabel("Author");
    private JTextField displayAuthor = new JTextField(70);
    private JLabel qty = new JLabel("Quantity");
    private JTextField displayQty = new JTextField(70);
    private JButton searchButton = new JButton("Search");

    //create add panel elements
    private JLabel enterBookName = new JLabel("Please Enter Book Title");
    private JLabel enterBookAuthor = new JLabel("Please Enter Book Author");
    private JLabel enterBookQty = new JLabel("Please Enter Book Qty");
    private JTextField bookName = new JTextField(50);
    private JTextField bookAuthor = new JTextField(50);
    private JTextField bookQty = new JTextField(50);
    private JLabel displayAddBookResults = new JLabel("Book Entered:");
    private JTextField addResults = new JTextField(50);
    private JButton addPanelSubmitButton = new JButton("Submit");

    //create update panel elements
    private JLabel enterIdToUpdate = new JLabel("Enter Book ID:");
    private JTextField enterId = new JTextField(70);
    private JButton submitId = new JButton("Get Book");
    private JButton updateBook = new JButton("Update");
    private JLabel updateTitle = new JLabel("Title");
    private JTextField displayUpdateTitle = new JTextField(40);
    private JLabel updateAuthor = new JLabel("Author");
    private JTextField displayUpdateAuthor = new JTextField(70);
    private JLabel updateQty = new JLabel("Quantity");
    private JTextField displayUpdateQty = new JTextField(70);
    private JTextField updateMsg = new JTextField(70);

    //delete panel elements
    private JLabel enterIdToDelete = new JLabel("Enter Book Id");
    private JTextField deleteId = new JTextField(50);
    private JLabel bookDetails = new JLabel("Details");
    private JTextField bookToDelete = new JTextField(50);
    private JButton getBookToDelete = new JButton("Get Book");
    private JButton deleteBook = new JButton("Delete");
    private JTextField deleteMsg = new JTextField(70);

    //constructor
    bookstoreTabbedView() {
        super("Bookstore Database");

        searchPanel.setLayout(new GridLayout(0, 2, 2, 2));
        searchPanel.add(enterBookId);
        searchPanel.add(bookID);
        searchPanel.add(title);
        searchPanel.add(displayTitle);
        searchPanel.add(author);
        searchPanel.add(displayAuthor);
        searchPanel.add(qty);
        searchPanel.add(displayQty);
        searchPanel.add(searchButton);

        addPanel.setLayout(new GridLayout(0, 2, 2, 2));
        addPanel.add(enterBookName);
        addPanel.add(bookName);
        addPanel.add(enterBookAuthor);
        addPanel.add(bookAuthor);
        addPanel.add(enterBookQty);
        addPanel.add(bookQty);
        addPanel.add(displayAddBookResults);
        addPanel.add(addResults);
        addPanel.add(addPanelSubmitButton);

        updatePanel.setLayout(new GridLayout(0, 2, 2, 2));
        updatePanel.add(enterIdToUpdate);
        updatePanel.add(enterId);
        updatePanel.add(updateTitle);
        updatePanel.add(displayUpdateTitle);
        updatePanel.add(updateAuthor);
        updatePanel.add(displayUpdateAuthor);
        updatePanel.add(updateQty);
        updatePanel.add(displayUpdateQty);
        updatePanel.add(submitId);
        updatePanel.add(updateBook);
        updatePanel.add(updateMsg);

        deletePanel.setLayout(new GridLayout(0, 2, 2, 2));
        deletePanel.add(enterIdToDelete);
        deletePanel.add(deleteId);
        deletePanel.add(bookDetails);
        deletePanel.add(bookToDelete);
        deletePanel.add(getBookToDelete);
        deletePanel.add(deleteBook);
        deletePanel.add(deleteMsg);

        tabbedView.add("Search", searchPanel);
        tabbedView.add("Add", addPanel);
        tabbedView.add("Update", updatePanel);
        tabbedView.add("Delete", deletePanel);

        this.add(tabbedView);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setResizable(false);

        tabbedView.setVisible(true);

    }

    //search methods
    public int getBookId() {
        return Integer.parseInt(bookID.getText());
    }

    public String getBookTitle() {
        return displayTitle.getText();
    }

    public void setId(String Id) {
        bookID.setText(Id);
    }

    public void setTitle(String Title) {
        displayTitle.setText(Title);
    }

    public void setAuthor(String Author) {
        displayAuthor.setText(Author);
    }

    public void setQty(String Qty) {
        displayQty.setText(Qty);
    }

    //add methods
    public String getBookName() {
        return bookName.getText();
    }

    public String getBookAuthor() {
        return bookAuthor.getText();
    }

    public int getBookQty() {
        return Integer.parseInt(bookQty.getText());
    }

    public void setAddResult(String Result) {
        addResults.setText(Result);
    }

    //update methods
    public String getUpdateBookName() {
        return displayUpdateTitle.getText();
    }

    public String getUpdateBookauthor() {
        return displayUpdateAuthor.getText();
    }

    public int getUpdateBookQty() {
        return Integer.parseInt(displayUpdateQty.getText());
    }

    public void setUpdateTitle(String Title) {
        displayUpdateTitle.setText(Title);
    }

    public void setUpdateAuthor(String Author) {
        displayUpdateAuthor.setText(Author);
    }

    public void setUpdateQty(String Qty) {
        displayUpdateQty.setText(Qty);
    }

    public void setUpdateMsg(String Title) {
        updateMsg.setText(Title);
    }

    public int getBookIdUpdate() {
        return Integer.parseInt(enterId.getText());
    }

    //delete methods
    public int getDeleteBookId() {
        return Integer.parseInt(deleteId.getText());
    }

    public void setDeleteResult(String Result) {
        bookToDelete.setText(Result);
    }

    public void setDeleteMsg(String Title) {
        deleteMsg.setText(Title);
    }

    //search button
    //add action listener for search button
    void addSearchIdListener(ActionListener listenForSearchButton) {

        searchButton.addActionListener(listenForSearchButton);
    }

    //add button
    //add action listener for add book button
    void addAddBookListener(ActionListener listenForAddPanelSubmitButton) {

        addPanelSubmitButton.addActionListener(listenForAddPanelSubmitButton);
    }

    //update button listeners
    void submitUpdateListener(ActionListener listenForSubmitUpdateButton) {

        submitId.addActionListener(listenForSubmitUpdateButton);
    }

    void updateListener(ActionListener listenForUpdateBookButton) {

        updateBook.addActionListener(listenForUpdateBookButton);
    }

    //delete listeners
    void deleteIdListener(ActionListener listenForDeleteIdButton) {

        getBookToDelete.addActionListener(listenForDeleteIdButton);
    }

    void addDeleteListener(ActionListener listenForDeleteButton) {

        deleteBook.addActionListener(listenForDeleteButton);
    }

    //create error msg for unwanted clicks
    void displayErrorMsg(String errorMessage) {

        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
