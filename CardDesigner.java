import javax.swing.*;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;


public class CardDesigner extends JFrame implements ActionListener {
	
	// declare menus and accompanying items
		private JMenuBar mainBar = new JMenuBar();
		private JMenu file = new JMenu("File");
			private JMenuItem exit = new JMenuItem("Exit");
		
		private JMenu select = new JMenu("Select");
			private JMenuItem home = new JMenuItem("Home");
			private JMenuItem congrats = new JMenuItem("Congratulations Card");
			private JMenuItem bDayCard = new JMenuItem("Birthday Card");
		
		private JMenu colors = new JMenu("Colors");
			private JMenuItem white = new JMenuItem("White");
		
			private JMenu bright = new JMenu("Bright");
				private JMenuItem pink = new JMenuItem("Pink");
				private JMenuItem yellow = new JMenuItem("Yellow");
			
			private JMenu dark = new JMenu("Dark");
				private JMenuItem black = new JMenuItem("Black");
				private JMenuItem gray = new JMenuItem("Gray");
		
		private JMenu font = new JMenu("Font");
			private JMenuItem arial = new JMenuItem("Arial");
			private JMenuItem lucida = new JMenuItem("Lucida Handwriting");
			private JMenuItem inkFree = new JMenuItem("Ink Free");
		
	// panels
	private JPanel panel = new JPanel();
	private JPanel homePanel = new JPanel();	
	private JPanel congratsPanel = new JPanel();
	private JPanel bDayPanel = new JPanel();
	
	// panel items
	private JLabel heading = new JLabel("Card Designer Application");
	private JTextField nameField = new JTextField("Please Enter the Recipient's Name", 20);
	private String name;
	private JLabel getStarted = new JLabel("Then Get Started By Making Selections From the Menu");
	private JLabel congratsMsg = new JLabel();
	private JLabel bDayMsg = new JLabel();
	private JTextField msgField = new JTextField("enter your message here");
	private String text;
	
	
	public CardDesigner()
	{
		super("Pimp My JFrame");

		
		// home panel
		homePanel.setLayout(new FlowLayout());
		heading.setFont(new Font("Arial", Font.BOLD, 20));
		homePanel.add(heading);
		nameField.setFont(new Font("Arial", Font.ITALIC, 20));
		homePanel.add(nameField);
		homePanel.add(getStarted);
		
		// congrats panel
		congratsPanel.setLayout(new BorderLayout());
		congratsPanel.add(congratsMsg);
		
		// bday panel
		bDayPanel.setLayout(new BorderLayout());
		bDayPanel.add(bDayMsg);
		
		// add panels
		panel = new JPanel(new CardLayout());
		panel.add(homePanel, "Home");
		panel.add(congratsPanel, "Congrats");
		panel.add(bDayPanel, "BDAY");
		getContentPane().add(panel);
		
		
		exit.addActionListener(this);
		pink.addActionListener(this);
		yellow.addActionListener(this);
		black.addActionListener(this);
		gray.addActionListener(this);
		white.addActionListener(this);
		select.addActionListener(this);
		home.addActionListener(this);
		congrats.addActionListener(this);
		bDayCard.addActionListener(this);
		inkFree.addActionListener(this);
		arial.addActionListener(this);
		lucida.addActionListener(this);

		
		setJMenuBar(mainBar);
		mainBar.add(file);
		file.add(exit);
		
		mainBar.add(select);
		select.add(home);	
		select.add(congrats);
		select.add(bDayCard);
	
		// add menu items
		mainBar.add(colors);
		colors.add(bright);
		colors.add(dark);
		colors.add(white);
		bright.add(pink);
		bright.add(yellow);
		dark.add(black);
		dark.add(gray);
		
		mainBar.add(font);
		
		font.add(arial);
		font.add(lucida);
		font.add(inkFree);
		

		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object source = e.getSource(); 	// alternatively, e.getSoure() method can be stated in if-statements (see first if-statement) without needing to create an object
		
		if (e.getSource() == exit)
		{
			System.exit(0);
		}
		
		if(source == home)
		{
			homePanel.setLayout(new FlowLayout());
			CardLayout cardLayout = (CardLayout) panel.getLayout();
			cardLayout.show(panel, "Home");
		}
		
		if (source == congrats)
		{
			name = nameField.getText();
			congratsMsg.setText("Congratulations, " + name + "!");;
			congratsPanel.add(msgField, BorderLayout.SOUTH);

			CardLayout cardLayout = (CardLayout) panel.getLayout();
			cardLayout.show(panel, "Congrats");
		}
		
		if (source == bDayCard)
		{
			name = nameField.getText();
			bDayMsg.setText("Happy Birthday, " + name + "!");
			bDayPanel.add(msgField, BorderLayout.SOUTH);
			CardLayout cardLayout = (CardLayout) panel.getLayout();
			cardLayout.show(panel, "BDAY");
		}
		
		if(source == inkFree)
		{
			text = msgField.getText();
			msgField.setFont(new Font("Ink Free", Font.ITALIC, 12));
			msgField.setText(text);
		}
		
		if(source == lucida)
		{
			text = msgField.getText();
			msgField.setFont(new Font("Lucida Handwriting", Font.ITALIC, 12));
			msgField.setText(text);
		}
		
		if(source == arial)
		{
			text = msgField.getText();
			msgField.setFont(new Font("Arial", Font.ITALIC, 12));
			msgField.setText(text);
		}
		
		if (source == pink)
		{
			homePanel.setBackground(Color.PINK);
			congratsPanel.setBackground(Color.PINK);
			bDayPanel.setBackground(Color.PINK);
		}
		
		if(source == yellow)
		{
			homePanel.setBackground(Color.YELLOW);
			congratsPanel.setBackground(Color.YELLOW);
			bDayPanel.setBackground(Color.YELLOW);
		}
		if(source == white)
		{
			homePanel.setBackground(Color.WHITE);
			congratsPanel.setBackground(Color.WHITE);
			bDayPanel.setBackground(Color.WHITE);
		}
		if(source == black)
		{
			homePanel.setBackground(Color.BLACK);
			congratsPanel.setBackground(Color.BLACK);
			bDayPanel.setBackground(Color.BLACK);
		}
		if(source == gray)
		{
			homePanel.setBackground(Color.GRAY);
			congratsPanel.setBackground(Color.GRAY);
			bDayPanel.setBackground(Color.GRAY);
		}
	}

}
