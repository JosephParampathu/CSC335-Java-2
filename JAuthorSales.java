/**
 * Name: Joseph Parampathu
 * Date: 12/12/2021
 * Assignment: Unit 14 Case Problem 2
 *
 * Dataset Download Link: https://corgis-edu.github.io/corgis/csv/publishers/
 * Purpose (Class Description): A class called JAUthorSales that launches a window to allow the user to add values to the author sales dataset.
 */
 import javax.swing.*;

 import java.awt.*;
 import java.awt.event.*;
 import java.util.ArrayList;
 import javax.swing.event.ListSelectionListener;
 import javax.swing.event.*;

 public class JAuthorSales extends JFrame implements ActionListener, ListSelectionListener
 {
   final int WIDTH = 875;
   final int HEIGHT = 700;

   JLabel mainLabel = new JLabel("<html>Author Sales Information<br>  Sales Rank   |   Total Reviews   | Daily Average Units Sold | Daily Average Gross Sales |  Publisher Name</html>", SwingConstants.CENTER);

   ArrayList<BookSales> listOfBookData = BookSalesDemo.openDataFile("publishers.csv");
   String[] bookInfo = new String[listOfBookData.size()];
   final DefaultListModel<String> listModel = new DefaultListModel<>();

   JButton addButton = new JButton("ADD");
   JLabel addLabel = new JLabel("<html>Add a New Entry?<br>  Sales Rank   |   Total Reviews   | Daily Average Units Sold | Daily Average Gross Sales |  Publisher Name</html>");
   JTextField salePriceField = new JTextField(12);
   JTextField totalReviewsField = new JTextField(12);
   JTextField avgUnitsSoldField = new JTextField(12);
   JTextField avgGrossSalesField = new JTextField(12);
   JTextField publisherField = new JTextField(12);
   JPanel addPanel = new JPanel();

   JButton deleteButton = new JButton("DELETE SELECTION");
   JList<String> bookInfoList = new JList<String>(listModel);


   //Constructor class for the window sets the window title, format, and adds all the components of the window
   public JAuthorSales()
   {
     super("Author Sales Dataset");
     setSize(WIDTH, HEIGHT);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new FlowLayout());

     setupAddPanel();
     addBookDataToList();

     for (String eachItem : bookInfo)
     {
       listModel.addElement(eachItem);
     }

     deleteButton.setEnabled(false);
     bookInfoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     bookInfoList.setLayoutOrientation(JList.VERTICAL);
     bookInfoList.setVisibleRowCount(-1);

     JScrollPane scrollPane = new JScrollPane(bookInfoList);
     scrollPane.setPreferredSize(new Dimension(500,500));
     add(mainLabel);
     add(scrollPane);
     add(deleteButton);
     add(addLabel);
     add(addPanel);

     addButton.addActionListener(this);
     deleteButton.addActionListener(this);
     bookInfoList.addListSelectionListener(this);
   }

   //This is a helper method that adds the book data to the JList
   public void addBookDataToList()
   {
     int i = 0;

     for (BookSales eachBook : listOfBookData)
     {
       bookInfo[i] = (eachBook.getSalePrice() + "     |     " + eachBook.getTotalReviews() + "     |     " + eachBook.getDailyAverageUnitsSold() + "     |     " + eachBook.getDailyAverageGrossSales() + "     |     " + eachBook.getPublisherName());
       i++;
     }
   }

   //This method sets the panel with the fields to add a new entry
   public void setupAddPanel()
   {
     addPanel.add(salePriceField);
     addPanel.add(totalReviewsField);
     addPanel.add(avgUnitsSoldField);
     addPanel.add(avgGrossSalesField);
     addPanel.add(publisherField);
     addPanel.add(addButton);
   }

   //This method overrides the abstract method to add items to the list based on valid user input
   @Override
   public void actionPerformed(ActionEvent e)
   {
     Object source = e.getSource();

     if(source == addButton)
     {
       if(!salePriceField.getText().equals("") && !totalReviewsField.getText().equals("") && !avgUnitsSoldField.getText().equals("") && !avgGrossSalesField.getText().equals("") && !publisherField.getText().equals(""))
       {
         try
         {
           int i = bookInfo.length;
           Double.parseDouble(salePriceField.getText());
           Integer.parseInt(totalReviewsField.getText());
           Integer.parseInt(avgUnitsSoldField.getText());
           Integer.parseInt(avgGrossSalesField.getText());

           listModel.addElement(salePriceField.getText() + "     |     " + totalReviewsField.getText() + "     |     " + avgUnitsSoldField.getText() + "     |     " + avgGrossSalesField.getText() + "     |     " + publisherField.getText());
           salePriceField.setText("");
           totalReviewsField.setText("");
           avgUnitsSoldField.setText("");
           avgGrossSalesField.setText("");
           publisherField.setText("");
         }
         catch (Exception inputError)
         {
           JOptionPane.showMessageDialog(null, "Fill out numbers where needed.");
         }
       }
       else
       {
         JOptionPane.showMessageDialog(null, "Fill out all the boxes.");
       }
     }

     //Delete button
     if(source == deleteButton)
     {
       int index = bookInfoList.getSelectedIndex();
       listModel.remove(index);
     }
   }

   //This method enables or disables the delete button based on whether an item in the list has been selected
   @Override
   public void valueChanged(ListSelectionEvent event)
   {
     if (event.getValueIsAdjusting() == false)
     {
       if(bookInfoList.getSelectedIndex() == -1)
       {
         deleteButton.setEnabled(false);
       }
       else
       {
         deleteButton.setEnabled(true);
       }
     }
   }

 }
