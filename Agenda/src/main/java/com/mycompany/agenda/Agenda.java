
package com.mycompany.agenda;

// Archivo: Agenda.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Agenda extends JFrame {
    // Modelo de datos
    private final ArrayList<Paciente> pacientes = new ArrayList<>();
    private final DefaultListModel<String> listModel = new DefaultListModel<>();

    // Componentes UI
    private final JTextField tfApellido = new JTextField(20);
    private final JTextField tfNombre = new JTextField(20);
    private final JTextField tfTelefono = new JTextField(15);
    private final JTextField tfDireccion = new JTextField(30);
    private final JButton btnAgregar = new JButton("Agregar");
    private final JLabel lblUltimoAgregado = new JLabel("Ningún paciente agregado todavía.");
    private final JList<String> listaPacientes = new JList<>(listModel);

    public Agenda() {
        super("Agenda Electrónica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setResizable(false);

        // Panel formulario
        JPanel pnlFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0; c.gridy = 0;
        pnlFormulario.add(new JLabel("Apellido:"), c);
        c.gridx = 1;
        pnlFormulario.add(tfApellido, c);

        c.gridx = 0; c.gridy = 1;
        pnlFormulario.add(new JLabel("Nombre:"), c);
        c.gridx = 1;
        pnlFormulario.add(tfNombre, c);

        c.gridx = 0; c.gridy = 2;
        pnlFormulario.add(new JLabel("Teléfono:"), c);
        c.gridx = 1;
        pnlFormulario.add(tfTelefono, c);

        c.gridx = 0; c.gridy = 3;
        pnlFormulario.add(new JLabel("Dirección:"), c);
        c.gridx = 1;
        pnlFormulario.add(tfDireccion, c);

        c.gridx = 1; c.gridy = 4;
        c.anchor = GridBagConstraints.EAST;
        pnlFormulario.add(btnAgregar, c);

        // Panel lista + label
        JPanel pnlLista = new JPanel(new BorderLayout(6, 6));
        pnlLista.setBorder(BorderFactory.createTitledBorder("Pacientes"));
        listaPacientes.setVisibleRowCount(10);
        listaPacientes.setFixedCellWidth(380);
        JScrollPane scroll = new JScrollPane(listaPacientes);
        pnlLista.add(scroll, BorderLayout.CENTER);
        pnlLista.add(lblUltimoAgregado, BorderLayout.SOUTH);

        add(pnlFormulario, BorderLayout.NORTH);
        add(pnlLista, BorderLayout.CENTER);

        // Eventos
        btnAgregar.addActionListener(e -> agregarPaciente());
        // Enter en cualquiera de los textfields agrega el paciente
        Action addAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPaciente();
            }
        };
        tfApellido.addActionListener(addAction);
        tfNombre.addActionListener(addAction);
        tfTelefono.addActionListener(addAction);
        tfDireccion.addActionListener(addAction);

        pack();
        setLocationRelativeTo(null); // centra la ventana
    }

    private void agregarPaciente() {
        String apellido = tfApellido.getText().trim();
        String nombre   = tfNombre.getText().trim();
        String telefono = tfTelefono.getText().trim();
        String direccion= tfDireccion.getText().trim();

        // Validación simple: campos obligatorios
        if (apellido.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor completá todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Paciente p = new Paciente(apellido, nombre, telefono, direccion);
        pacientes.add(p);
        listModel.addElement(p.toString()); // muestra en la JList

        // Muestra en el label el paciente agregado (según tu pedido)
        lblUltimoAgregado.setText("Paciente agregado: " + nombre + " " + apellido);

        // Limpia los campos para un nuevo registro
        tfApellido.setText("");
        tfNombre.setText("");
        tfTelefono.setText("");
        tfDireccion.setText("");

        tfApellido.requestFocus();
    }

    public static void main(String[] args) {
        // usar el look and feel del sistema (opcional)
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new Agenda().setVisible(true);
        });
    }
}

// Clase auxiliar para representar un paciente
class Paciente {
    private final String apellido;
    private final String nombre;
    private final String telefono;
    private final String direccion;

    public Paciente(String apellido, String nombre, String telefono, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getApellido() { return apellido; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        // formato en la lista: Apellido, Nombre - Tel: XXXX - Dir: ...
        return apellido + ", " + nombre + " - Tel: " + telefono + " - Dir: " + direccion;
    }
}
