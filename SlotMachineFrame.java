package start.Java;

//importing for later use
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Joey
 * @balance: this shows the standard base currency amount
 * @mbar, mnufile, miLoad, miSave, miPrint, miRestart, miExit: all are used to locate and navigate through the menu
 * @btnMax, btnMid, btnMin: sets up the button layout on the slot machine
 */
public class SlotMachineFrame extends JFrame {
	private TilePanel tpan;
	private double balance = 5; //currency
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar(); //option menu
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		JMenuItem miRestart = new JMenuItem("Restart");
		JMenuItem miExit = new JMenuItem("Exit");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read."); //if an error occurs
					}
				}
			}
		});
		/**
		 * @param jfc: selects file
		 */
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		miRestart.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				balance = 5;
				
			}
		});
		/**
		 * @param: miload, save, print, restart, exit, file: menu options given to user
		 */
		mnuFile.add(miLoad); //menu actions
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vegas Baby .\nCode at <insert github address here>");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	/**
	 * @panSouth: allows border for slot machine to be set, includes buttons at south part of border
	 * @half: value is split
	 * @lblbalance: shows what currency is labeled
	 */
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine"); //name/title
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		btnMid = new JButton("Mid");
		btnMin = new JButton("Min");
		panSouth.add(btnMax); //where buttons are located
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.5s",balance));
		panSouth.add(txtBalance);
		btnMax.addActionListener(new ActionListener() {	//max button will bet entire amount
			public void actionPerformed(ActionEvent e) {
				if(balance != 0) {
				tpan.bSpin();
				TileChecker a = new TileChecker();
				balance *= a.max_pattern(tpan.getTiles());
				txtBalance.setText(String.format("%.5s",balance));
			}
			}
		});
		btnMid.addActionListener(new ActionListener() {	//mid button is given actions for bet being half of amount
			public void actionPerformed(ActionEvent e) {
				if(balance != 0) {
				tpan.bSpin();
				TileChecker a = new TileChecker();
				balance /= 2;
				double half = balance;
				half *= a.mid_pattern(tpan.getTiles());
				balance += half;
				txtBalance.setText(String.format("%.5s",balance));
			}
			}
		});
		btnMin.addActionListener(new ActionListener() {	 //min button is given actions which bet lowest amount
			public void actionPerformed(ActionEvent e) {
				if(balance != 0) {
				tpan.bSpin();
				TileChecker a = new TileChecker();
				balance -= 1;
				double half = 1;
				half *= a.min_pattern(tpan.getTiles());
				balance += half;
				txtBalance.setText(String.format("%.5s",balance));
			}
			}
		});
		
		setupMenu();
	}
	public void spin() {
		tpan.spin();
	}
	public SlotMachineFrame() {
		setupLook();
	}
}
