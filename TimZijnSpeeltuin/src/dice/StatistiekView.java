package dice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/*
 * Deze view laat de statistieken van de worpen zien
 */
public class StatistiekView extends JPanel implements ActionListener{
	private JTextField totaalVeld = new JTextField(6);
	private JTextField aantalEenVeld = new JTextField();
	private JTextField aantalTweeVeld = new JTextField();
	private JTextField aantalDrieVeld = new JTextField();
	private JTextField aantalVierVeld = new JTextField();
	private JTextField aantalVijfVeld = new JTextField();
	private JTextField aantalZesVeld = new JTextField();
	DobbelsteenModel d;
	
	private int totalCount = 0;
	private int countOne = 0;
	private int countTwo = 0;
	private int countThree = 0;
	private int countFour = 0;
	private int countFive = 0;
	private int countSix = 0;

	public StatistiekView()
	{
		this.setLayout(new GridLayout(7,1));
		this.add(totaalVeld);
		this.add(aantalEenVeld);
		this.add(aantalTweeVeld);
		this.add(aantalDrieVeld);
		this.add(aantalVierVeld);
		this.add(aantalVijfVeld);
		this.add(aantalZesVeld);
	}
	public void actionPerformed(ActionEvent e)
	{
		d = (DobbelsteenModel) e.getSource();
		int number = d.getWaarde();
		
		totalCount++;
		totaalVeld.setText(totalCount+" worpen");
		
		switch(number) {
			case 1 :	countOne++;
						aantalEenVeld.setText("1: "+countOne+" keer");
						break;
			case 2 : 	countTwo++;
						aantalTweeVeld.setText("2: "+countTwo+" keer");
						break;
			case 3 : 	countThree++;
						aantalDrieVeld.setText("3: "+countThree+" keer");
						break;
			case 4 : 	countFour++;
						aantalVierVeld.setText("4: "+countFour+" keer");
						break;
			case 5 : 	countFive++;
						aantalVijfVeld.setText("5: "+countFive+" keer");
						break;
			case 6 : 	countSix++;
						aantalZesVeld.setText("6: "+countSix+" keer");
						break;
		} 
	}
	public Dimension getPrefferedSize()
	{
		return new Dimension(50,50);
	}
}
