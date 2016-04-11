package contactListGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import contactList.Casual;
import contactList.Database;
import contactList.Functions;
import contactList.Interactions;
import contactList.Personal;
import contactList.Professional;
import contactList.Relative;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class MainFrame extends JApplet {

	private JFrame frame;
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel panel_3_1 = new JPanel();
	JPanel panel_3_2 = new JPanel();
	JPanel panel_3_3 = new JPanel();
	JPanel panel_3_4 = new JPanel();
	CardLayout CL = new CardLayout();
	int ridx = 0;
	int prfidx = 0;
	int pidx = 0;
	int cidx = 0;
	
	//PANEL 1 COMPONENTS
	Timer tm;
	String[] list = {"/logo4.png",
			         "/logo6.png",
			         "/logo7.png",
			         "/relativeFaded.png"
			         };
	int x = 0;
	JLabel labelBkg;
	static Relative relative;
	public static JButton btnViewFullList;
	public static JButton btnSearchContact;
	public static JButton btnRelative;
	public static JButton btnProf;
	public static JButton btnPersonal;
	public static JButton btnCasual;
	
	// PANEL 2 COMPONENTS
	static JList list_1=new JList(),
			  list_2=new JList(),
			  list_3=new JList(),
			  list_4=new JList();
		private JTextField searchField = new JTextField();
		static JButton btnView_1, btnView_2, btnView_3, btnView_4;
		static JLabel lblEnterName = new JLabel();
		private JLabel label;
		private JLabel label_1 = new JLabel();
	// PANEL 3_1 COMPONENTS
		 JLabel labelP1;
		 JTextField textFieldP1;
		 JTextField textField_1P1;
		 JTextField textField_2P1;
		 JTextField textField_3P1;
		 JTextField textField_4P1;
		 JButton btnSaveAndExitP1;
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		 JLabel BckgdP1;
		 JButton btnExitWoSavingP1;
	
	// PANEL 3_2 COMPONENTS
		 	private JLabel labelP2;
			private JTextField textFieldP2;
			private JTextField textField_1P2;
			private JTextField textField_2P2;
			private JButton btnSaveAndExitP2;
			private JLabel BckgdP2;
			private JButton btnExitWoSavingP2;
			private JTextArea textArea_1P2, textArea_2P2;
			
	// PANEL 3_3 COMPONENTS
			private JLabel labelP3;
			private JTextField textFieldP3;
			private JTextField textField_1P3;
			private JTextField textField_2P3;
			private JButton btnSaveAndExitP3;
			private JLabel BckgdP3;
			private JLabel lblContextP3;
			private JLabel lblDateAcquaintedP3;
			private JTextField textField_3P3;
			private JLabel lblSpecificEventsP3;
			private JTextArea textArea_1P3;
			private JTextArea textArea_2P3;
	
			// PANEL 3_4 COMPONENTS
			private JLabel labelP4;
			private JTextField textField;
			private JTextField textField_1;
			private JTextField textField_2;
			private JTextField textField_3;
			private JButton btnSaveAndExit;
			private JLabel Bckgd;
			private JLabel lblContext;
			private JLabel lblDateAcquainted;
			private JLabel lblSpecificEvents;
			private JTextArea textArea_1;
			private JTextArea textArea_2;
			private JTextArea textArea_3;
	/**
	 * Launch the application.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		///*
		Interactions.reconstruct();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});//*/
	//	Interactions.reconstruct();
	//	Interactions.save();
	}

	public void init(){

		MainFrame window = new MainFrame();
		try {
			Interactions.reconstruct();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setContentPane(window.frame.getContentPane());
		setSize(622,452);
	}
	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 602, 452);
		frame.setTitle("Contact List");
		//frame.setResizable(false);
		ImageIcon img = new ImageIcon("src\\logo.png");
		frame.setIconImage(img.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CL = new CardLayout();
		frame.getContentPane().setLayout(CL);
		JPanel contentPane = (JPanel)frame.getContentPane();
		
		//JPanel panel_1 = new JPanel();
		contentPane.add(panel_1,"1");
		contentPane.add(panel_2,"2");
		contentPane.add(panel_3_1,"3.1");
		contentPane.add(panel_3_2,"3.2");
		contentPane.add(panel_3_3,"3.3");
		contentPane.add(panel_3_4,"3.4");
		
		
		/****************************************** PANEL 1 ***********************************************/
		panel_1.setLayout(null);
		JLabel lblNewLabel = new JLabel();
		Image img1 = new ImageIcon(this.getClass().getResource("/logo2.png")).getImage();
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		btnSearchContact = new JButton("Search a Contact");
		btnSearchContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setBounds(100, 100, 646, 489);
				CL.show(contentPane,"2");
				lblEnterName.setVisible(true);
				searchField.setVisible(true);
				label_1.setVisible(true);
				setData();
				
				searchField.getDocument().addDocumentListener(new DocumentListener() {
					  public void changedUpdate(DocumentEvent e) {
					    warn();
					  }
					  public void removeUpdate(DocumentEvent e) {
					    warn();
					  }
					  public void insertUpdate(DocumentEvent e) {
					    warn();
					  }

					  public void warn() {
						  String txt = searchField.getText();
						  if(txt=="")
						  {
							  String[] temp = {};
							  list_1.setListData(temp);
							  list_2.setListData(temp);
							  list_3.setListData(temp);
							  list_4.setListData(temp);
							  
						  }
						  ArrayList <String> rNames = new ArrayList<String>();
							for(int i = 0; i<Database.relative.size(); i++)
							{
								if(Database.relative.get(i).name==null) Database.relative.remove(i);
								else if(Database.relative.get(i).name.toLowerCase().contains(txt.toLowerCase()))
								rNames.add(Database.relative.get(i).name);
							}
							list_1.setListData(rNames.toArray());
						  
							ArrayList <String> prfNames = new ArrayList<String>();
							for(int i = 0; i<Database.professional.size(); i++)
							{
								if(Database.professional.get(i).name==null) Database.professional.remove(i);
								else if(Database.professional.get(i).name.toLowerCase().contains(txt.toLowerCase()))
								prfNames.add(Database.professional.get(i).name);
							}
							list_2.setListData(prfNames.toArray());
						  
							
							ArrayList <String> prNames = new ArrayList<String>();
							for(int i = 0; i<Database.personal.size(); i++)
							{
								if(Database.personal.get(i).name==null) Database.personal.remove(i);
								else if(Database.personal.get(i).name.toLowerCase().contains(txt.toLowerCase()))
								prNames.add(Database.personal.get(i).name);
							}
							list_3.setListData(prNames.toArray());
							
							ArrayList <String> cNames = new ArrayList<String>();
							for(int i = 0; i<Database.casual.size(); i++)
							{
								if(Database.casual.get(i).name==null) Database.casual.remove(i);
								else if(Database.casual.get(i).name.toLowerCase().contains(txt.toLowerCase()))
								cNames.add(Database.casual.get(i).name);
							}
							list_4.setListData(cNames.toArray());
					  }
					});
				
				
				
			}
		});
		btnSearchContact.setBounds(447, 116, 139, 31);
		panel_1.add(btnSearchContact);
		
		btnCasual = new JButton("New Casual Acq.");
		btnCasual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Casual casual = new Casual();
				Database.casual.add(casual);
				frame.setBounds(100, 100, 535, 462);
				cidx = Database.casual.size()-1;
				viewCasual(cidx);
				CL.show(contentPane, "3.4");
			}
		});
		btnCasual.setBounds(447, 283, 139, 31);
		panel_1.add(btnCasual);
		
		btnPersonal = new JButton("New Personal Frnd\r\n");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Personal personal = new Personal();
				Database.personal.add(personal);
				pidx = Database.personal.size()-1;
				viewPersonal(pidx);
				frame.setBounds(100, 100, 535, 452);
				CL.show(contentPane, "3.3");
			}
		});
		btnPersonal.setHorizontalAlignment(SwingConstants.LEADING);
		btnPersonal.setBounds(447, 243, 139, 31);
		panel_1.add(btnPersonal);
		
		btnProf = new JButton("New Prof. Friend\r\n");
		btnProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Professional professional = new Professional();
				Database.professional.add(professional);
				prfidx = Database.professional.size()-1;
				viewProf(prfidx);
				frame.setBounds(100, 100, 535, 333);
				CL.show(contentPane, "3.2");
			}
		});
		btnProf.setBounds(447, 201, 139, 31);
		panel_1.add(btnProf);
		btnExit.setBounds(447, 325, 139, 31);
		panel_1.add(btnExit);
		
		btnViewFullList = new JButton("View Full List\r\n");
		btnViewFullList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//	CList list = new CList(1);
			//	list.setVisible(true);
				frame.setBounds(100, 100, 646, 489);
				CL.show(contentPane, "2");
				setData();
				lblEnterName.setVisible(false);
				searchField.setVisible(false);
				label_1.setVisible(false);
			}
		});
		btnViewFullList.setBounds(447, 74, 139, 31);
		panel_1.add(btnViewFullList);
		
		
		btnRelative = new JButton("New Relative");
		btnRelative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relative relative = new Relative();
				Database.relative.add(relative);
				ridx = Database.relative.size()-1;
				frame.setBounds(100, 100, 535, 333);
				viewRelative(ridx,contentPane,0);
				CL.show(contentPane, "3.1");
			}
		});

		btnRelative.setBounds(447, 158, 139, 31);
		panel_1.add(btnRelative);
		
		
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(40, 127, 123, 148);
		panel_1.add(lblNewLabel);
	//	SetImageSize(lblNewLabel,"/logo2.png");
		
		labelBkg = new JLabel();
		labelBkg.setBounds(0, 0, 586, 419);
		panel_1.add(labelBkg);
		
		SetImageSize(labelBkg,"/logo7.png");
		
		
		/************************************ PANEL 2 **********************************************/
		panel_2.setLayout(null);
		list_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list_1.setBackground(new Color(100, 149, 237));
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(8, 92, 133, 300);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)list_1.getCellRenderer();  
		
		
		//JList list_2 = new JList();
		list_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setBackground(new Color(100, 149, 237));
		list_2.setBounds(164, 92, 133, 300);
		renderer =  (DefaultListCellRenderer)list_2.getCellRenderer();  
		
		
		//JList list_3 = new JList();
		list_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_3.setBackground(new Color(100, 149, 237));
		list_3.setBounds(325, 92, 133, 300);
		renderer =  (DefaultListCellRenderer)list_3.getCellRenderer();  
		
//	JList list_4 = new JList();
		list_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		list_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_4.setBackground(new Color(100, 149, 237));
		list_4.setBounds(486, 92, 133, 300);
		renderer =  (DefaultListCellRenderer)list_4.getCellRenderer();  
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_1.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_1.getModel().getElementAt(i);
				i = find_name(1,name);
				Database.relative.remove(i);
				Interactions.save();
				update_lists(1);
			}
		});
		
		JButton btnDelete_2 = new JButton("Delete");
		btnDelete_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_2.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_2.getModel().getElementAt(i);
				i = find_name(2,name);
				Database.professional.remove(i);
				Interactions.save();
				update_lists(2);
			}
		});
		
		
		JButton btnDelete_3 = new JButton("Delete");
		btnDelete_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_3.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_3.getModel().getElementAt(i);
				i = find_name(3,name);
				Database.personal.remove(i);
				Interactions.save();
				update_lists(3);
			}
		});
		
		JButton btnDelete_4 = new JButton("Delete");
		btnDelete_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_4.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_4.getModel().getElementAt(i);
				i = find_name(4,name);
				Database.casual.remove(i);
				Interactions.save();
				update_lists(4);
			}
		});
		
		btnView_2 = new JButton("View/Edit\r\n");
		btnView_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_2.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_2.getModel().getElementAt(i);
				prfidx = find_name(2,name);
		//		ViewProfessional vp = new ViewProfessional(i);
		//		vp.setVisible(true);
				viewProf(prfidx);
				frame.setBounds(100, 100, 535, 333);
				CL.show(contentPane, "3.2");
			}
		});
		
		btnView_3 = new JButton("View/Edit");
		btnView_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_3.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_3.getModel().getElementAt(i);
				pidx = find_name(3,name);
				viewPersonal(pidx);
				frame.setBounds(100, 100, 535, 452);
				CL.show(contentPane, "3.3");
			}
		});
		
		btnView_4 = new JButton("View/Edit");
		btnView_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = list_4.getSelectedIndex();
				if(i==-1) return;
				String name = (String)list_4.getModel().getElementAt(i);
				cidx = find_name(4,name);
				viewCasual(cidx);
				frame.setBounds(100, 100, 535, 462);
				CL.show(contentPane, "3.4");
			}
		});
		
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.btnViewFullList.setEnabled(true);
				MainFrame.btnSearchContact.setEnabled(true);
				MainFrame.btnRelative.setEnabled(true);
				MainFrame.btnPersonal.setEnabled(true);
				MainFrame.btnProf.setEnabled(true);
				MainFrame.btnCasual.setEnabled(true);
				CL.show(contentPane, "1");
				frame.setBounds(100, 100, 602, 452);
			}
		});
		
		label_1.setBounds(344, 12, 25, 20);
		panel_2.add(label_1);
		SetImageSize(label_1,"/search.png");
		
		
		btnGoBack.setBounds(509, 11, 89, 23);
		panel_2.add(btnGoBack);
		
		searchField = new JTextField();
		searchField.setBounds(137, 12, 203, 20);
		panel_2.add(searchField);
		searchField.setColumns(10);
		
		lblEnterName.setText("Enter Name :");
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEnterName.setBounds(52, 8, 89, 27);
		panel_2.add(lblEnterName);
		btnView_4.setBounds(513, 396, 89, 23);
		panel_2.add(btnView_4);
		btnView_3.setBounds(350, 396, 89, 23);
		panel_2.add(btnView_3);
		btnView_2.setBounds(188, 396, 89, 23);
		panel_2.add(btnView_2);
		
		
		btnView_1 = new JButton("View/Edit");
		btnView_1.setBounds(30, 396, 89, 23);
		panel_2.add(btnView_1);
		btnView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int i = list_1.getSelectedIndex();
			if(i==-1) return;
			String name = (String)list_1.getModel().getElementAt(i);
			ridx = i = find_name(1,name);
	//		ViewRelative vr = new ViewRelative(i);
	//		vr.setVisible(true);
			viewRelative(i,contentPane,1);
			frame.setBounds(100, 100, 535, 333);
			CL.show(contentPane,"3.1");
			}
		});
		btnDelete_4.setBounds(513, 424, 89, 23);
		panel_2.add(btnDelete_4);
		btnDelete_3.setBounds(350, 424, 89, 23);
		panel_2.add(btnDelete_3);
		btnDelete_2.setBounds(188, 424, 89, 23);
		panel_2.add(btnDelete_2);
		btnDelete_1.setBounds(30, 424, 89, 23);
		panel_2.add(btnDelete_1);
		panel_2.add(list_4);
		panel_2.add(list_3);
		panel_2.add(list_2);
		panel_2.add(list_1);
	
	
	
		JLabel menu = new JLabel("");
		menu.setBounds(-6, 392, 644, 60);
		panel_2.add(menu);
		SetImageSize(menu,"/button.png");
		
		JLabel lblRelatives = new JLabel("Relatives");
		lblRelatives.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatives.setBackground(SystemColor.activeCaption);
		lblRelatives.setOpaque(true);
		lblRelatives.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblRelatives.setBounds(38, 53, 79, 30);
		panel_2.add(lblRelatives);
		
		JLabel lblProfessionalFriends = new JLabel("Professional Friends\r\n");
		lblProfessionalFriends.setOpaque(true);
		lblProfessionalFriends.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblProfessionalFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfessionalFriends.setBackground(SystemColor.activeCaption);
		lblProfessionalFriends.setBounds(167, 53, 127, 30);
		panel_2.add(lblProfessionalFriends);
		
		JLabel lblPersonalFriends = new JLabel("Personal Friends\r\n");
		lblPersonalFriends.setOpaque(true);
		lblPersonalFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalFriends.setBackground(SystemColor.activeCaption);
		lblPersonalFriends.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblPersonalFriends.setBounds(335, 53, 107, 30);
		panel_2.add(lblPersonalFriends);
		
		JLabel lblCasualFriends = new JLabel("Casual Friends\r\n");
		lblCasualFriends.setOpaque(true);
		lblCasualFriends.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasualFriends.setBackground(SystemColor.activeCaption);
		lblCasualFriends.setBounds(504, 53, 94, 30);
		lblCasualFriends.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.add(lblCasualFriends);
		
		JLabel Bkgd = new JLabel("");
		Bkgd.setBounds(0, 0, 630, 430);
		panel_2.add(Bkgd);
		SetImageSize(Bkgd,"/logo6.png");
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		
		/************************************* PANEL 3_1 *******************************************/
		{
			 panel_3_1.setLayout(null);
			 label = new JLabel("");
				label.setBounds(45, 70, 113, 105);
				panel_3_1.add(label);
				SetImageSize(label,"/logo8.png");
				
				JLabel lblName = new JLabel("NAME");
				lblName.setHorizontalAlignment(SwingConstants.CENTER);
				lblName.setBounds(188, 54, 105, 22);
				panel_3_1.add(lblName);
				
				
				JLabel lblAddress = new JLabel("MOBILE NO.");
				lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
				lblAddress.setBounds(188, 87, 105, 22);
				panel_3_1.add(lblAddress);
				
				JLabel lblEmail = new JLabel("EMAIL\r\n");
				lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmail.setBounds(188, 120, 105, 22);
				panel_3_1.add(lblEmail);
				
				JLabel lblBirthDay = new JLabel("BIRTH DAY");
				lblBirthDay.setHorizontalAlignment(SwingConstants.CENTER);
				lblBirthDay.setBounds(188, 153, 105, 22);
				panel_3_1.add(lblBirthDay);
				
				JLabel lblLastMeeting = new JLabel("LAST MEETING\r\n");
				lblLastMeeting.setHorizontalAlignment(SwingConstants.CENTER);
				lblLastMeeting.setBounds(188, 186, 105, 22);
				panel_3_1.add(lblLastMeeting);
				
				textFieldP1 = new JTextField();
				textFieldP1.setBounds(303, 55, 189, 20);
				panel_3_1.add(textFieldP1);
				textFieldP1.setColumns(10);
				
				
				textField_1P1 = new JTextField();
				textField_1P1.setColumns(10);
				textField_1P1.setBounds(303, 88, 189, 20);
				panel_3_1.add(textField_1P1);
				
				
				textField_2P1 = new JTextField();
				textField_2P1.setColumns(10);
				textField_2P1.setBounds(303, 121, 189, 20);
				panel_3_1.add(textField_2P1);
				
				
				textField_3P1 = new JTextField();
				textField_3P1.setColumns(10);
				textField_3P1.setBounds(303, 155, 189, 20);
				panel_3_1.add(textField_3P1);
				
				
				
				textField_4P1 = new JTextField();
				textField_4P1.setColumns(10);
				textField_4P1.setBounds(303, 187, 189, 20);
				panel_3_1.add(textField_4P1);
				
				
				
				btnSaveAndExitP1 = new JButton("Save and Exit");
				btnSaveAndExitP1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean dateValid = false;
						try {
							dateValid = Functions.checkDateFormat(textField_3P1.getText());
						} catch (ParseException e2) {
							System.out.println("Exception! Error parsing date");
						}
						boolean date2Valid = false;
						try {
							date2Valid = Functions.checkDateFormat(textField_4P1.getText());
						} catch (ParseException e2) {
							System.out.println("Exception! Error parsing date");
						}
						
						if(textFieldP1.getText().equals("")||textField_1P1.getText().equals("")||textField_2P1.getText().equals("")
							||textField_3P1.getText().equals("")||textField_4P1.getText().equals("")
						  )
						{
							JOptionPane.showMessageDialog(null, "No Field should be left empty!");
						}
						else if((!dateValid)||(!date2Valid))
						{
							JOptionPane.showMessageDialog(null, "Invalid Date / Date Format");
						}
						else if(!(Functions.check_eAddress(textField_2P1.getText())))
						{
							JOptionPane.showMessageDialog(null, "Invalid Email Address");
						}
						else
						{
							Database.relative.get(ridx).name = textFieldP1.getText();
							Database.relative.get(ridx).mNumber=textField_1P1.getText();
							Database.relative.get(ridx).eAddress=textField_2P1.getText();	
							try {
								Database.relative.get(ridx).setBirthDay(textField_3P1.getText());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							try {
								Database.relative.get(ridx).setLastMeeting(textField_4P1.getText());
							} catch (ParseException e) {
								e.printStackTrace();
							}	
							Interactions.save();
							update_lists(1);
						/*	if(from==0)
								CL.show(contentPane, "1");
							else
							{
								CL.show(contentPane, "2");
								frame.setBounds(100, 100, 646, 489);
							}*/
							frame.setBounds(100, 100, 602, 452);
							CL.show(contentPane, "1");
						}
					}
				});
				btnSaveAndExitP1.setBounds(238, 231, 113, 23);
				panel_3_1.add(btnSaveAndExitP1);
				
				
				btnExitWoSavingP1 = new JButton("Exit w/o Saving");
				btnExitWoSavingP1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						frame.setBounds(100, 100, 602, 452);
						if(Database.relative.get(ridx).name==null)
						Database.relative.remove(ridx);
						/*if()
							{
								CL.show(contentPane, "1");
							}
						else
							{
								CL.show(contentPane, "2");
								frame.setBounds(100, 100, 646, 489);
							}*/
						CL.show(contentPane, "1");
					}
				});
				btnExitWoSavingP1.setBounds(379, 231, 130, 23);
				panel_3_1.add(btnExitWoSavingP1);
		}
				
				/************************************ PANEL 3_2 ***************************************/
		{
				panel_3_2.setLayout(null);
				btnExitWoSavingP2 = new JButton("Exit w/o Saving\r\n");
				btnExitWoSavingP2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(Database.professional.get(prfidx).name==null)
							Database.professional.remove(prfidx);
							CL.show(contentPane, "1");
							frame.setBounds(100, 100, 602, 452);
					}
				});
				btnExitWoSavingP2.setBounds(389, 239, 120, 23);
				panel_3_2.add(btnExitWoSavingP2);
				
				JLabel lblInterests = new JLabel("INTERESTS");
				lblInterests.setBounds(230, 147, 63, 14);
				panel_3_2.add(lblInterests);
				
				textArea_1P2 = new JTextArea();
				textArea_1P2.setLineWrap(true);
				textArea_1P2.setBounds(303, 126, 189, 90);
				panel_3_2.add(textArea_1P2);
				
				label = new JLabel("");
				label.setBounds(20, 57, 113, 105);
				panel_3_2.add(label);
				SetImageSize(label,"/logo8.png");
				
				JLabel lblNameP2 = new JLabel("NAME");
				lblNameP2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNameP2.setBounds(188, 24, 105, 22);
				panel_3_2.add(lblNameP2);
				
				JLabel lblAddressP2 = new JLabel("MOBILE NO.");
				lblAddressP2.setHorizontalAlignment(SwingConstants.CENTER);
				lblAddressP2.setBounds(188, 57, 105, 22);
				panel_3_2.add(lblAddressP2);
				
				JLabel lblEmailP2 = new JLabel("EMAIL\r\n");
				lblEmailP2.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmailP2.setBounds(188, 90, 105, 22);
				panel_3_2.add(lblEmailP2);
				
				JLabel lblLastMeeting = new JLabel("COMMON PROFESSIONAL\r\n");
				lblLastMeeting.setHorizontalAlignment(SwingConstants.CENTER);
				lblLastMeeting.setBounds(150, 126, 143, 22);
				panel_3_2.add(lblLastMeeting);
				
				textFieldP2 = new JTextField();
				textFieldP2.setBounds(303, 25, 189, 20);
				panel_3_2.add(textFieldP2);
				textFieldP2.setColumns(10);
				
				
				textField_1P2 = new JTextField();
				textField_1P2.setColumns(10);
				textField_1P2.setBounds(303, 58, 189, 20);
				panel_3_2.add(textField_1P2);
				
				
				textField_2P2 = new JTextField();
				textField_2P2.setColumns(10);
				textField_2P2.setBounds(303, 91, 189, 20);
				panel_3_2.add(textField_2P2);
			
				
				btnSaveAndExitP2 = new JButton("Save and Exit");
				btnSaveAndExitP2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(textFieldP2.getText().equals("")||textField_1P2.getText().equals("")||textField_2P2.getText().equals("")||textArea_1P2.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "No Field should be left empty!");
						}
						else if(!(Functions.check_eAddress(textField_2P2.getText())))
						{
							JOptionPane.showMessageDialog(null, "Invalid Email Address");
						}
						else
						{
							Database.professional.get(prfidx).name = textFieldP2.getText();
							Database.professional.get(prfidx).mNumber=textField_1P2.getText();
							Database.professional.get(prfidx).eAddress=textField_2P2.getText();	
							Database.professional.get(prfidx).commonInterest=textArea_1P2.getText();
							Interactions.save();
							update_lists(2);
							CL.show(contentPane, "1");
							frame.setBounds(100, 100, 602, 452);
						}
					}
				});
				btnSaveAndExitP2.setBounds(255, 239, 113, 23);
				panel_3_2.add(btnSaveAndExitP2);
			
		}
		
		/**************************************** PANEL 3_3 ************************************************/
		{
			panel_3_3.setLayout(null);
			textArea_1P3 = new JTextArea();
			textArea_1P3.setLineWrap(true);
			textArea_1P3.setBounds(303, 126, 189, 90);
			panel_3_3.add(textArea_1P3);
			
			
			textArea_2P3 = new JTextArea();
			textArea_2P3.setLineWrap(true);
			textArea_2P3.setText((String) null);
			textArea_2P3.setBounds(303, 266, 189, 90);
			panel_3_3.add(textArea_2P3);
			
			
			textFieldP3 = new JTextField();
			textFieldP3.setBounds(303, 25, 189, 20);
			panel_3_3.add(textFieldP3);
			textFieldP3.setColumns(10);
			
			
			textField_1P3 = new JTextField();
			textField_1P3.setColumns(10);
			textField_1P3.setBounds(303, 58, 189, 20);
			panel_3_3.add(textField_1P3);
			
			
			textField_2P3 = new JTextField();
			textField_2P3.setColumns(10);
			textField_2P3.setBounds(303, 91, 189, 20);
			panel_3_3.add(textField_2P3);
			
			
			textField_3P3 = new JTextField();
			textField_3P3.setText((String) null);
			textField_3P3.setColumns(10);
			textField_3P3.setBounds(303, 235, 189, 20);
			panel_3_3.add(textField_3P3);
			
			lblDateAcquaintedP3 = new JLabel("DATE MET\r\n");
			lblDateAcquaintedP3.setHorizontalAlignment(SwingConstants.CENTER);
			lblDateAcquaintedP3.setBounds(188, 234, 105, 22);
			panel_3_3.add(lblDateAcquaintedP3);
			
			JLabel lblContext = new JLabel("CONTEXT");
			lblContext.setHorizontalAlignment(SwingConstants.CENTER);
			lblContext.setBounds(188, 123, 105, 22);
			panel_3_3.add(lblContext);
			
			JLabel lblName = new JLabel("NAME");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(188, 24, 105, 22);
			panel_3_3.add(lblName);
			
			JLabel lblAddress = new JLabel("MOBILE NO.");
			lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddress.setBounds(188, 57, 105, 22);
			panel_3_3.add(lblAddress);
			
			JLabel lblEmail = new JLabel("EMAIL\r\n");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setBounds(188, 90, 105, 22);
			panel_3_3.add(lblEmail);
			
			label = new JLabel("");
			label.setBounds(38, 104, 129, 126);
			panel_3_3.add(label);
			SetImageSize(label,"/logo8.png");
			
			btnSaveAndExitP3 = new JButton("Save and Exit");
			btnSaveAndExitP3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean dateValid = false;
					try {
						dateValid = Functions.checkDateFormat(textField_3P3.getText());
					} catch (ParseException e2) {
						System.out.println("Exception! Error parsing date");
					}
					if(textFieldP3.getText().equals("")||textField_1P3.getText().equals("")||textField_2P3.getText().equals("")||textField_3P3.getText().equals("")||textArea_1P3.getText().equals("")||textArea_2P3.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "No Field should be left empty!");
					}
					else if(!dateValid)
					{
						JOptionPane.showMessageDialog(null, "Invalid Date / Date Format");
					}
					else if(!(Functions.check_eAddress(textField_2P3.getText())))
					{
						JOptionPane.showMessageDialog(null, "Invalid Email Address");
					}
					else
					{
						Database.personal.get(pidx).name = textFieldP3.getText();
						Database.personal.get(pidx).mNumber=textField_1P3.getText();
						Database.personal.get(pidx).eAddress=textField_2P3.getText();	
						try {
							Database.personal.get(pidx).dateAcq=formatter.parse(textField_3P3.getText());
						} catch (ParseException e) {
							System.out.println("Exception! Error parsing date.");
						}
						Database.personal.get(pidx).context=textArea_1P3.getText();
						Database.personal.get(pidx).specificEvent=textArea_2P3.getText();
						Interactions.save();
						update_lists(3);
						frame.setBounds(100, 100, 602, 452);
						CL.show(contentPane, "1");
					}
				}
			});
			btnSaveAndExitP3.setBounds(267, 379, 113, 23);
			panel_3_3.add(btnSaveAndExitP3);
			
			BckgdP3 = new JLabel("");
			BckgdP3.setBounds(0, 0, 519, 294);
			panel_3_3.add(BckgdP3);
			
			lblSpecificEventsP3 = new JLabel("SPECIFIC EVENTS\r\n");
			lblSpecificEventsP3.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpecificEventsP3.setBounds(188, 272, 105, 22);
			panel_3_3.add(lblSpecificEventsP3);
			
			JButton btnExitWoSavingP3 = new JButton("Exit w/o Saving");
			btnExitWoSavingP3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Database.personal.get(pidx).name==null)
						Database.personal.remove(pidx);
						MainFrame.btnViewFullList.setEnabled(true);
						MainFrame.btnRelative.setEnabled(true);
						MainFrame.btnPersonal.setEnabled(true);
						MainFrame.btnProf.setEnabled(true);
						MainFrame.btnCasual.setEnabled(true);
						MainFrame.btnSearchContact.setEnabled(true);
						frame.setBounds(100, 100, 602, 452);
						CL.show(contentPane, "1");
				}
			});
			btnExitWoSavingP3.setBounds(390, 379, 119, 23);
			panel_3_3.add(btnExitWoSavingP3);
			
			
		}
		
		/******************************************** PANEL 3.4 ***********************************************/
		{
			panel_3_4.setLayout(null);
			lblSpecificEvents = new JLabel("CIRCUMSTANCES");
			lblSpecificEvents.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpecificEvents.setBounds(340, 240, 105, 22);
			panel_3_4.add(lblSpecificEvents);

			lblDateAcquainted = new JLabel("DATE MET\r\n");
			lblDateAcquainted.setHorizontalAlignment(SwingConstants.CENTER);
			lblDateAcquainted.setBounds(188, 107, 105, 22);
			panel_3_4.add(lblDateAcquainted);
			
			lblContext = new JLabel("MEETING PLACE");
			lblContext.setHorizontalAlignment(SwingConstants.CENTER);
			lblContext.setBounds(188, 140, 105, 22);
			panel_3_4.add(lblContext);
			
			JLabel lblName = new JLabel("NAME");
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(188, 14, 105, 22);
			panel_3_4.add(lblName);
			
			JLabel lblAddress = new JLabel("MOBILE NO.");
			lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
			lblAddress.setBounds(188, 45, 105, 22);
			panel_3_4.add(lblAddress);
			
			JLabel lblEmail = new JLabel("EMAIL\r\n");
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setBounds(188, 76, 105, 22);
			panel_3_4.add(lblEmail);
			
			label = new JLabel("");
			label.setBounds(38, 46, 129, 126);
			panel_3_4.add(label);
			SetImageSize(label,"/logo8.png");
			
			JLabel lblUsefulInfo = new JLabel("OTHER USEFUL INFO");
			lblUsefulInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsefulInfo.setBounds(38, 240, 189, 22);
			panel_3_4.add(lblUsefulInfo);
			
			
			
			textField = new JTextField();
			textField.setBounds(303, 15, 189, 20);
			textField.setColumns(10);
			
			panel_3_4.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(303, 46, 189, 20);
			panel_3_4.add(textField_1);
			
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(303, 77, 189, 20);
			panel_3_4.add(textField_2);
			
			
			textField_3 = new JTextField();
			textField_3.setText((String) null);
			textField_3.setColumns(10);
			textField_3.setBounds(303, 108, 189, 20);
			panel_3_4.add(textField_3);
			
			textArea_1 = new JTextArea();
			textArea_1.setLineWrap(true);
			textArea_1.setBounds(303, 139, 189, 90);
			panel_3_4.add(textArea_1);
			
			
			textArea_2 = new JTextArea();
			textArea_2.setLineWrap(true);
			textArea_2.setText((String) null);
			textArea_2.setBounds(303, 262, 189, 90);
			panel_3_4.add(textArea_2);
			
			
			textArea_3 = new JTextArea();
			textArea_3.setLineWrap(true);
			textArea_3.setColumns(2);
			textArea_3.setBounds(38, 262, 189, 90);
			panel_3_4.add(textArea_3);
			
			
			
			btnSaveAndExit = new JButton("Save and Exit");
			btnSaveAndExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean dateValid = false;
					try {
						dateValid = Functions.checkDateFormat(textField_3.getText());
					} catch (ParseException e2) {
						System.out.println("Exception! Error parsing date");
					}
					if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")
							||textField_3.getText().equals("")||textArea_1.getText().equals("")
							||textArea_2.getText().equals("")||textArea_3.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "No Field should be left empty!");
					}
					else if(!dateValid)
					{
						JOptionPane.showMessageDialog(null, "Invalid Date / Date Format");
					}
					else if(!(Functions.check_eAddress(textField_2.getText())))
					{
						JOptionPane.showMessageDialog(null, "Invalid Email Address");
					}
					else
					{
						Database.casual.get(cidx).name = textField.getText();
						Database.casual.get(cidx).mNumber=textField_1.getText();
						Database.casual.get(cidx).eAddress=textField_2.getText();	
						try {
							Database.casual.get(cidx).dateAcq=formatter.parse(textField_3.getText());
						} catch (ParseException e) {
							System.out.println("Exception! Error parsing date.");
						}
						Database.casual.get(cidx).meetPlace=textArea_1.getText();
						Database.casual.get(cidx).circumstance=textArea_2.getText();
						Database.casual.get(cidx).usefulInfo=textArea_3.getText();
						Interactions.save();
						update_lists(4);
						MainFrame.btnViewFullList.setEnabled(true);
						MainFrame.btnRelative.setEnabled(true);
						MainFrame.btnPersonal.setEnabled(true);
						MainFrame.btnProf.setEnabled(true);
						MainFrame.btnCasual.setEnabled(true);
						MainFrame.btnSearchContact.setEnabled(true);
						frame.setBounds(100, 100, 602, 452);
						CL.show(contentPane, "1");
					}
				}
			});
			btnSaveAndExit.setBounds(256, 378, 113, 23);
			panel_3_4.add(btnSaveAndExit);
			
			Bckgd = new JLabel("");
			Bckgd.setBounds(0, 0, 519, 294);
			panel_3_4.add(Bckgd);
			
			JButton btnExitWoSaving = new JButton("Exit w/o Saving");
			btnExitWoSaving.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Database.casual.get(cidx).name==null)
						Database.casual.remove(cidx);
						MainFrame.btnViewFullList.setEnabled(true);
						MainFrame.btnRelative.setEnabled(true);
						MainFrame.btnPersonal.setEnabled(true);
						MainFrame.btnProf.setEnabled(true);
						MainFrame.btnCasual.setEnabled(true);
						MainFrame.btnSearchContact.setEnabled(true);
						frame.setBounds(100, 100, 602, 452);
						CL.show(contentPane, "1");
				}
			});
			btnExitWoSaving.setBounds(390, 378, 119, 23);
			panel_3_4.add(btnExitWoSaving);
			
			
			
		}
		
		
		
	}
	
	public void SetImageSize(JLabel label,String imgName)
	{ 
		ImageIcon icon = new ImageIcon(this.getClass().getResource(imgName)); 
		Image img = icon.getImage(); 
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
		ImageIcon newImc = new ImageIcon(newImg); 
		label.setIcon(newImc); 
	}
	public static void update_lists(int i)
	{
		if(i==1)
		{
			ArrayList<String> rNames = new ArrayList <String>();
			for(int j=0;j<Database.relative.size();j++)
			{
				if(Database.relative.get(j).name==null) Database.relative.remove(j);
				else rNames.add(Database.relative.get(j).name);
			}
			list_1.setListData(rNames.toArray());
		}
		if(i==2)
		{
			ArrayList<String> rNames = new ArrayList <String>();
			for(int j=0;j<Database.professional.size();j++)
			{
				rNames.add(Database.professional.get(j).name);
			}
			list_2.setListData(rNames.toArray());
		}
		if(i==3)
		{
			ArrayList<String> rNames = new ArrayList <String>();
			for(int j=0;j<Database.personal.size();j++)
			{
				rNames.add(Database.personal.get(j).name);
			}
			list_3.setListData(rNames.toArray());
		}
		if(i==4)
		{
			ArrayList<String> rNames = new ArrayList <String>();
			for(int j=0;j<Database.casual.size();j++)
			{
				rNames.add(Database.casual.get(j).name);
			}
			list_4.setListData(rNames.toArray());
		}
	}
	
	public static void setData()
	{
		String[] rNames = new String[Database.relative.size()];
		for(int i = 0; i<Database.relative.size(); i++)
		{
			if(Database.relative.get(i).name==null) Database.relative.remove(i);
			else
			rNames[i]=Database.relative.get(i).name;
		}
		list_1.setListData(rNames);
		
		String[] profNames = new String[Database.professional.size()];
		for(int i = 0; i<Database.professional.size(); i++)
		{
			profNames[i]=Database.professional.get(i).name;
		}
		list_2.setListData(profNames);
		
		String[] personalNames = new String[Database.personal.size()];
		for(int i = 0; i<Database.personal.size(); i++)
		{
			personalNames[i]=Database.personal.get(i).name;
		}
		list_3.setListData(personalNames);
		
		String[] casualNames = new String[Database.casual.size()];
		for(int i = 0; i<Database.casual.size(); i++)
		{
			casualNames[i]=Database.casual.get(i).name;
		}
		list_4.setListData(casualNames);
		
	}
	
	public static int find_name(int i, String name)
	{
		if(i==1)
		{
			for(int j=0;j<Database.relative.size();j++)
			{
				if(Database.relative.get(j).name.equals(name))return j;
			}
		}
		else if(i==2)
		{
			for(int j=0;j<Database.professional.size();j++)
			{
				if(Database.professional.get(j).name.equals(name))return j;
			}
		}
		else if(i==3)
		{
			for(int j=0;j<Database.personal.size();j++)
			{
				if(Database.personal.get(j).name.equals(name))return j;
			}
		}
		else
		{
			for(int j=0;j<Database.casual.size();j++)
			{
				if(Database.casual.get(j).name.equals(name))return j;
			}
		}
		return -1;
	}
	void viewRelative(int index, JPanel contentPane, int from)
	{
		textFieldP1.setText(Database.relative.get(index).name);
		textField_1P1.setText(Database.relative.get(index).mNumber);
		textField_2P1.setText(Database.relative.get(index).eAddress);
		if(Database.relative.get(index).birthDay!=null)
		textField_3P1.setText(formatter.format(Database.relative.get(index).getBirthDay()));
		else textField_3P1.setText("");
		if(Database.relative.get(index).lastMeeting!=null)
		textField_4P1.setText(formatter.format(Database.relative.get(index).getLastMeeting()));
		else textField_4P1.setText("");
	}
	void viewProf(int index)
	{
		textArea_1P2.setText(Database.professional.get(prfidx).commonInterest);
		textFieldP2.setText(Database.professional.get(prfidx).name);
		textField_1P2.setText(Database.professional.get(prfidx).mNumber);
		textField_2P2.setText(Database.professional.get(prfidx).eAddress);
	}
	void viewPersonal(int i)
	{
		textArea_1P3.setText(Database.personal.get(i).context);
		textArea_2P3.setText(Database.personal.get(i).specificEvent);
		textFieldP3.setText(Database.personal.get(i).name);
		textField_1P3.setText(Database.personal.get(i).mNumber);
		textField_2P3.setText(Database.personal.get(i).eAddress);
		if(Database.personal.get(i).name!=null)
		textField_3P3.setText(formatter.format(Database.personal.get(i).dateAcq));
		else textField_3P3.setText("");
	}
	void viewCasual(int i)
	{
		textField.setText(Database.casual.get(i).name);
		textField_1.setText(Database.casual.get(i).mNumber);
		textField_2.setText(Database.casual.get(i).eAddress);
		if(Database.casual.get(i).name!=null)
		textField_3.setText(formatter.format(Database.casual.get(i).dateAcq));
		else textField_3.setText("");
		textArea_1.setText(Database.casual.get(i).meetPlace);
		textArea_3.setText(Database.casual.get(i).usefulInfo);
		textArea_2.setText(Database.casual.get(i).circumstance);

	}
}
