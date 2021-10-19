import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.security.PrivateKey;
import java.sql.*;

//This is the  main class which runs the GUI
public class CURD extends JFrame {

    EntryPanel dataEntry;
    ViewPanel listOfData;
    Button button;
    
    CURD self = this;
    

    public CURD() {
        setVisible(true); //this shows the app when its runned
        setSize(400, 400); //this sets the size of the app when its runned to 500height and 500width
        setTitle("CRUD");// sets the name of app as Sample App
        setLocationRelativeTo(null);// when opened the app appears in the middle of screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when the close button is clicked the application stops running
        setMinimumSize(new Dimension(400, 400));// doesnt let the size of app get smaller 

        dataEntry = new EntryPanel();
        listOfData = new ViewPanel();
        
        add(AppCage());
        
        pack();
        DataAdd();
        UpdateData();
        Delete();
        

    }

    private JPanel AppCage() {  //this sets the layout of app using grid bag constraints
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(dataEntry.panelUI(), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        mainPanel.add(listOfData.panelUI(), gbc);


        return mainPanel;
    }

    

    private void DataAdd(){
        JButton btnSave = dataEntry.getBtnSave();
        DefaultTableModel model = listOfData.getModel();

        btnSave.addActionListener(new ActionListener() { //setting action on save button 
                @Override
                public void actionPerformed(ActionEvent e){
                    String FirstName = dataEntry.getTotalFirstName().getText().trim();
                    String LastName = dataEntry.getTotalLastName().getText();
                    String RegNumber= dataEntry.getTotalRegNumber().getText();
                    Object [] info = {FirstName, LastName, RegNumber}; //To show the entered data on the list of data panel 
                    model.addRow(info);

                }
            });

    }

    private void UpdateData(){
        JTable tables = listOfData.getTable();
        DefaultTableModel model = listOfData.getModel();
        tables.addMouseListener(new MouseListener() { //setting action on update button
                @Override //
                public void mouseClicked(MouseEvent e) { //seting action when the mouse right button is clicked
                    int selectedRow = tables.getSelectedRow(); //selects the clicked row from the list of details
                    dataEntry.getTotalFirstName().setText(model.getValueAt(selectedRow,0).toString());
                    dataEntry.getTotalLastName().setText(model.getValueAt(selectedRow,1).toString());
                    dataEntry.getTotalRegNumber().setText(model.getValueAt(selectedRow,2).toString());
                }

                @Override
                public void mousePressed(MouseEvent e){}

                @Override
                public void mouseReleased(MouseEvent e){}

                @Override
                public void mouseEntered(MouseEvent e){}

                @Override
                public void mouseExited(MouseEvent e){}
              });

                JButton btnupdate = dataEntry.getBtnUpdate();
                btnupdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){

                    int selectedRow = tables.getSelectedRow();
                    
                    String FirstName = dataEntry.getTotalFirstName().getText().trim();
                    String LastName = dataEntry.getTotalLastName().getText();
                    String RegNumber= dataEntry.getTotalRegNumber().getText();
                
                    model.setValueAt(FirstName,selectedRow, 0);
                    model.setValueAt(LastName,selectedRow, 1);
                    model.setValueAt(RegNumber,selectedRow, 2);
                    
                    
                
                }
            });

    }
    
    private void Delete(){
    JButton btnDelete = dataEntry.getBtnDelete();
    DefaultTableModel model = listOfData.getModel();
    btnDelete.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
    String row = JOptionPane.showInputDialog(btnDelete, "Please enter row number to delete?", "Queries", JOptionPane.QUESTION_MESSAGE);
    int confirm = JOptionPane.showConfirmDialog(btnDelete, "Are you sure want to delete row?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        int rowDelete = Integer.parseInt(row);
                        model.removeRow(rowDelete - 1);
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(btnDelete, "You must enter valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        JOptionPane.showMessageDialog(btnDelete, "Provided row doesn't exist. Please enter valid row number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

    }
    
    public static void main(String[] args) {
        new CURD();
    }
}
