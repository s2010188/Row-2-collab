import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class product extends JFrame implements ActionListener {

    public static ArrayList<Product> products = new ArrayList<>();

    static class Product {
        String sku;
        String name;
        double price;

        Product(String sku, String name, double price) {
            this.sku = sku;
            this.name = name;
            this.price = price;
        }
    }

    JTextField skuField = new JTextField(40);
    JTextField nameField = new JTextField(40);
    JTextField priceField = new JTextField(40);
    JButton saveBtn = new JButton("Save");

    DefaultTableModel model = new DefaultTableModel(
            new String[]{"SKU", "Name", "Price"}, 0);
    JTable table = new JTable(model);

    public product() {
        setTitle("Product Screen");
        setSize(600, 600);
        setLayout(new BorderLayout());


        saveBtn.setPreferredSize(new Dimension(100, 30));

        JPanel input = new JPanel(new GridLayout(4, 1, 5, 5));

        JPanel skuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        skuPanel.add(new JLabel("SKU:"));
        skuPanel.add(skuField);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        namePanel.add(new JLabel("Name:"));
        namePanel.add(nameField);

        JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        pricePanel.add(new JLabel("Price:"));
        pricePanel.add(priceField);

        input.add(skuPanel);
        input.add(namePanel);
        input.add(pricePanel);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3,3));
        buttonPanel.add(saveBtn);
        input.add(buttonPanel);

        add(input, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        saveBtn.addActionListener(this);

        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String sku = skuField.getText();
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());


            products.add(new Product(sku, name, price));


            model.addRow(new Object[]{sku, name, price});

            JOptionPane.showMessageDialog(this, "Saved!");

            skuField.setText("");
            nameField.setText("");
            priceField.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input");
        }
    }
}