import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewPanel extends JPanel implements AppCage {
    private DefaultTableModel model; //makes the table modle 
    private JTable table;

    public ViewPanel() {
        model = new DefaultTableModel();
        String[] headers = {"FirstName", "LastName", "IDNumber"}; //gives the heading to table serially
        model.setColumnIdentifiers(headers);
        table = new JTable(model);

    }

    @Override
    public JPanel panelUI() {
        table.setShowGrid(true);
        JScrollPane scrollable = new JScrollPane(table);//to set scroll in List of data
        add(scrollable); 
        return this;
    }

    public DefaultTableModel getModel() {
        return (DefaultTableModel) getTable().getModel();
    }

    public JTable getTable() {
        return table;
    }
}
