import javax.swing.*;
import java.awt.*;

public class EntryPanel extends JPanel implements AppCage {
    private GridBagConstraints gbc;
    private JTextField FirstName; //setting text writing for Name
    private JTextField LastName;
    private JTextField RegNumber;
    private JButton btnSave, btnUpdate, btnDelete;

    public EntryPanel() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        FirstName = new JTextField(20);
        FirstName.setToolTipText("Please enter your first name"); //shows message please enter your name when clicked on the box
        LastName = new JTextField(20);
        RegNumber = new JTextField(20);
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
    }

    public JPanel panelUI() {
        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); //giving initial grid to the layout
        gbc.ipadx = 5;
        gbc.ipady = 5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("First Name"),gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(FirstName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(new JLabel("Last Name"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(LastName,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(new JLabel("Reg Number"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(RegNumber,gbc);
        
       gbc.fill = GridBagConstraints.HORIZONTAL; //to put the buttons horizontally 
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;

        add(btnSave,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;

        add(btnUpdate,gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(btnDelete,gbc);


        return this;
    }

    public JTextField getTotalFirstName(){
        return FirstName; 
    }

    public JTextField getTotalLastName(){
        return LastName; 
    }

    public JTextField getTotalRegNumber(){
        return RegNumber; 
    }

    
    public JButton getBtnSave (){
        return btnSave;   //returns the btnSave to access publicly for covid class
    }

    public JButton getBtnUpdate (){
        return btnUpdate; 
    }

    public JButton getBtnDelete(){
        return btnDelete;
    }
}
