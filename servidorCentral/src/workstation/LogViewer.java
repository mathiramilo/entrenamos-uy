package workstation;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import datatypesWS.LogEntryWS;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logica.ILogger;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class LogViewer extends JInternalFrame {


	private JTable table;
    private ILogger IL;
    
	public LogViewer(ILogger IL) {
		setResizable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.IL = IL;
		setTitle("Registro de acceso al servidorWeb");	
		setClosable(true);
		setBounds(200, 200, 900, 650);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{850, 0};
		gridBagLayout.rowHeights = new int[]{45, 540, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		getContentPane().add(scrollPane, gbc_scrollPane);	
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		iniciarTabla();
	}
	
	public void iniciarTabla() {
		DefaultTableModel tablemodel = new DefaultTableModel();
		tablemodel.addColumn("Date");
		tablemodel.addColumn("IP");
		tablemodel.addColumn("URL");
		tablemodel.addColumn("Browser");
		tablemodel.addColumn("OS");	
		table.setModel(tablemodel);
		table.getColumn("Date").setPreferredWidth(4);		
		table.getColumn("IP").setPreferredWidth(4);
		table.getColumn("URL").setPreferredWidth(200);
		table.getColumn("Browser").setPreferredWidth(20);
		table.getColumn("OS").setPreferredWidth(20);
		
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	tablemodel.setRowCount(0);
        		for(LogEntryWS e: IL.getLogs()) {
        			tablemodel.addRow(new Object[]{e.getDate().adapt().toFechaHora(),e.getIp(),e.getUrl(),e.getBrowser(),e.getSo()});
        		}
    			table.setModel(tablemodel);
    			table.getColumn("Date").setPreferredWidth(4);		
    			table.getColumn("IP").setPreferredWidth(4);
    			table.getColumn("URL").setPreferredWidth(200);
    			table.getColumn("Browser").setPreferredWidth(20);
    			table.getColumn("OS").setPreferredWidth(20);
            }
        };
        Timer timer = new Timer(1000, actionListener);
        timer.start();
	}
}
