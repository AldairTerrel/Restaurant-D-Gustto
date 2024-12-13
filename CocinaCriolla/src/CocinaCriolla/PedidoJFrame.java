package CocinaCriolla;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class PedidoJFrame extends javax.swing.JFrame {
    
    //public Object[][] dataBoleta = new Object[10][4];
    private Usuario usuario;    //usuario
    private DefaultTableModel model; //tabla
    private List<Pedido> pedidosList;
    private double precioSeleccionado;
    
    /**
     * Creates new form PedidoJFrame
     */
    
    public PedidoJFrame() {
        initComponents();
        
        Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoPantalla = pantallaSize.width;
        int altoPantalla = pantallaSize.height;
        
        int anchoVentana = getWidth();
        int altoVentana = getHeight();
        
        int posX = (anchoPantalla - anchoVentana) / 2;
        int posY = (altoPantalla - altoVentana) / 2;
        
        setLocation(posX, posY);
        
        getContentPane().setBackground(new java.awt.Color(255, 255, 255)); 
        
        setIconImage(new ImageIcon(getClass().getResource("/icono.png")).getImage());
        
        btnAgregarATabla.setEnabled(false);
        precioSeleccionado = 0.0;

        DefaultTableModel modeloCreado = crearModel();
        this.model = modeloCreado;
        jTable1.setModel(this.model);
        jTable1.setDefaultEditor(Object.class, null);
        
        pedidosList = new ArrayList<>();
        
        cbCombo.removeAllItems();
        cbCombo.addItem("Seleccione");
        cbCombo.addItem("Causa Limeña");
        cbCombo.addItem("Papa Rellena");
        cbCombo.addItem("Aji de Gallina");
        cbCombo.addItem("Ceviche");
        cbCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String comboSeleccionado = (String) cbCombo.getSelectedItem();
                if (comboSeleccionado != null) {
                    switch (comboSeleccionado) {
                        case "Causa Limeña":
                            precioSeleccionado = 10.0;
                            break;
                        case "Papa Rellena":
                            precioSeleccionado = 15.0;
                            break;
                        case "Aji de Gallina":
                            precioSeleccionado = 12.0;
                            break;
                        case "Ceviche":
                            precioSeleccionado = 18.0;
                            break;
                        default:
                            precioSeleccionado = 0.0;
                    }
                    if (precioSeleccionado != 0.0) {
                        lblPrecio.setText("S/."+precioSeleccionado);
                        btnAgregarATabla.setEnabled(true);
                    } else {
                        lblPrecio.setText("-");
                        btnAgregarATabla.setEnabled(false);
                    }
                }
                if (comboSeleccionado.equals("Causa Limeña")) {
                    ImageIcon CausaLim = new ImageIcon(getClass().getResource("/imagenes/PLATO1.png"));
                    ImageIcon icono = new ImageIcon(CausaLim.getImage().getScaledInstance(180,120,150));
                    jLabel6.setIcon(icono);
                    jLabel10.setText("Causa Limeña");
                } else 
                {
                    if (comboSeleccionado.equals("Papa Rellena")) {
                    ImageIcon PapaRe = new ImageIcon(getClass().getResource("/imagenes/PLATO2.png"));
                    ImageIcon icono1 = new ImageIcon(PapaRe.getImage().getScaledInstance(185,120,150));
                    jLabel6.setIcon(icono1);
                    jLabel10.setText("Papa Rellena");
                    }
                    else
                    {
                        if (comboSeleccionado.equals("Aji de Gallina")) {
                            ImageIcon AjiGa = new ImageIcon(getClass().getResource("/imagenes/PLATO3.png"));
                            ImageIcon icono2 = new ImageIcon(AjiGa.getImage().getScaledInstance(185,120,150));
                            jLabel6.setIcon(icono2);
                            jLabel10.setText("Aji de Gallina");
                        } else 
                        { 
                            if (comboSeleccionado.equals("Ceviche")) {
                            ImageIcon Cevi = new ImageIcon(getClass().getResource("/imagenes/PLATO4.png"));
                            ImageIcon icono3 = new ImageIcon(Cevi.getImage().getScaledInstance(185,120,150));
                            jLabel6.setIcon(icono3);
                            jLabel10.setText("Ceviche");
                            }
                            else {
                                ImageIcon Logo = new ImageIcon(getClass().getResource("/imagenes/logoincial.png"));
                                ImageIcon iconlogo = new ImageIcon(Logo.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
                                jLabel6.setIcon(iconlogo);
                                jLabel10.setText("Seleccione un Plato");
                            }
                        }
                    }
                }
                
            }
        });
    }
       
    private DefaultTableModel crearModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Precio Total");
        return model;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        lblCliente.setText(usuario.getNombre() + " " + usuario.getApellido());              
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnIrADetalle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        btnAgregarATabla = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 174, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 0, 0));
        jLabel1.setText("BIENVENIDO A COCINA CRIOLLA");

        jTable1.setBackground(new java.awt.Color(255, 204, 102));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnIrADetalle.setBackground(new java.awt.Color(255, 153, 0));
        btnIrADetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnIrADetalle.setText("Ir a Detalle");
        btnIrADetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrADetalleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 0, 0));
        jLabel2.setText("Cliente            :");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCliente.setText("-");
        lblCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnAgregarATabla.setBackground(new java.awt.Color(255, 153, 0));
        btnAgregarATabla.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarATabla.setText("Agregar");
        btnAgregarATabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarATablaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 0, 0));
        jLabel3.setText("Plato Elegido :");

        cbCombo.setBackground(new java.awt.Color(194, 229, 211));
        cbCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComboActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 0, 0));
        jLabel4.setText("Precio :");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPrecio.setText("-");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoincial.png"))); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 150));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(50, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Seleccione un Plato");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequeño.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(btnAgregarATabla)
                .addContainerGap(376, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(268, 268, 268))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIrADetalle)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(jLabel4)
                        .addGap(40, 40, 40)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblCliente))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(lblPrecio)))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarATabla)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIrADetalle)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void btnIrADetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrADetalleActionPerformed
        if (pedidosList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay pedidos para procesar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Supongamos que estos valores son fijos por ahora.
    int mesaId = 1; 
    int clienteId = 1; 
    int metodoPagoId = 1; 
    int empleadoId = 1; 

    // Mensajes de depuración
    System.out.println("MesaId: " + mesaId);
    System.out.println("ClienteId: " + clienteId);
    System.out.println("MetodoPagoId: " + metodoPagoId);
    System.out.println("EmpleadoId: " + empleadoId);

    // Insertar Pedido
    int pedidoId = ConexionSQL.insertarPedido(mesaId, clienteId, metodoPagoId, empleadoId);
    if (pedidoId > 0) {
        System.out.println("Pedido insertado con ID: " + pedidoId);

        for (Pedido pedido : pedidosList) {
            int productoId = ConexionSQL.obtenerIdProductoPorNombre(pedido.getNombre());
            if (productoId > 0) {
                System.out.println("ProductoId: " + productoId + " para el producto: " + pedido.getNombre());
                boolean detalleInsertado = ConexionSQL.insertarDetallePedido(pedidoId, productoId, pedido.getCantidad());
                if (!detalleInsertado) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el detalle del pedido en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    System.out.println("Detalle insertado: PedidoId = " + pedidoId + ", ProductoId = " + productoId + ", Cantidad = " + pedido.getCantidad());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado en la base de datos: " + pedido.getNombre(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Redirigir al siguiente formulario
        ComprobanteCliente detalleJF = new ComprobanteCliente();
        detalleJF.setUsuario(usuario);
        detalleJF.setPedidos(pedidosList);
        detalleJF.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Error al guardar el pedido en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnIrADetalleActionPerformed

    private Pedido createOnePedido(String number) {
        Pedido pedido = new Pedido();
        pedido.setNombre("Jin " + number);
        pedido.setCantidad(Integer.parseInt(number));
        pedido.setPrecioUnitario(Double.parseDouble(number + ".25"));
        return pedido;
    }
    
    private void volverARellenarTabla() {
        model.setRowCount(0);
        for (Pedido pedido : pedidosList) {
            Object[] fila = new Object[4];
            fila[0] = pedido.getNombre();
            fila[1] = pedido.getCantidad();
            fila[2] = pedido.getPrecioUnitario();
            fila[3] = pedido.getPrecioUnitario() * pedido.getCantidad();
            model.addRow(fila);
        }
    }
    
    public void agregarPedidoListaYValidar(Pedido pedido) {
        boolean pedidoExiste = false;
        for (Pedido pedidoDeLista : pedidosList) {
            if (pedido.getNombre().equals(pedidoDeLista.getNombre())) {
                pedidoExiste = true;
                pedidoDeLista.setCantidad(pedidoDeLista.getCantidad() + pedido.getCantidad());
            }
        }
        if (pedidoExiste == true) {
            System.out.println("El pedido ya existe");
            volverARellenarTabla();
        } else {
            System.out.println("El pedido NO existe");
            pedidosList.add(pedido);
            agregarPedidoATabla(pedido);
        }

    }
    
    public void agregarPedidoATabla(Pedido pedido) {
        Object[] fila = new Object[4];
        fila[0] = pedido.getNombre();
        fila[1] = pedido.getCantidad();
        fila[2] = pedido.getPrecioUnitario();
        fila[3] = pedido.getPrecioUnitario() * pedido.getCantidad();
        model.addRow(fila);
    }
    
    private void btnAgregarATablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarATablaActionPerformed
        if (precioSeleccionado != 0.0) {
        Pedido pedido = new Pedido();
        pedido.setNombre(cbCombo.getSelectedItem().toString());
        pedido.setCantidad(1); // Fijar cantidad en 1 como predeterminado
        pedido.setPrecioUnitario(precioSeleccionado);

        // Agregar a la lista y tabla local
        agregarPedidoListaYValidar(pedido);

        // Obtener IDs ficticios para los valores que no están claros
        int mesaId = 1; // Puedes reemplazar con lógica dinámica
        int clienteId = 1;
        int metodoPagoId = 1;
        int empleadoId = 1;

        // Insertar en base de datos
        int pedidoId = ConexionSQL.insertarPedido(mesaId, clienteId, metodoPagoId, empleadoId);
        if (pedidoId > 0) {
            int productoId = ConexionSQL.obtenerIdProductoPorNombre(pedido.getNombre());
            if (productoId > 0) {
                boolean detalleInsertado = ConexionSQL.insertarDetallePedido(pedidoId, productoId, pedido.getCantidad());
                if (!detalleInsertado) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el detalle del pedido en la base de datos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error: Producto no encontrado en la base de datos.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el pedido en la base de datos.");
        }

        cbCombo.setSelectedIndex(0);
    }
    }//GEN-LAST:event_btnAgregarATablaActionPerformed

    private void cbComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbComboActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarATabla;
    private javax.swing.JButton btnIrADetalle;
    private javax.swing.JComboBox<String> cbCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblPrecio;
    // End of variables declaration//GEN-END:variables
}
