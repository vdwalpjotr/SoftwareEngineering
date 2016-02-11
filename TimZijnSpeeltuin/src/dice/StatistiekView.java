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
	private JLabel totaalVeld = new JLabel();
	private JLabel aantalEenVeld = new JLabel();
	private JLabel aantalTweeVeld = new JLabel();
	private JLabel aantalDrieVeld = new JLabel();
	private JLabel aantalVierVeld = new JLabel();
	private JLabel aantalVijfVeld = new JLabel();
	private JLabel aantalZesVeld = new JLabel();
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
		
		totaalVeld.setText(d.getAantalWorpen()+" worpen");
		
		int[] worpen = d.getTotaalAantalHit();
		
		aantalEenVeld.setText("1: "+worpen[0]+" keer");
		aantalTweeVeld.setText("2: "+worpen[1]+" keer");
		aantalDrieVeld.setText("3: "+worpen[2]+" keer");
		aantalVierVeld.setText("4: "+worpen[3]+" keer");
		aantalVijfVeld.setText("5: "+worpen[4]+" keer");
		aantalZesVeld.setText("6: "+worpen[5]+" keer");

	}
	public Dimension getPrefferedSize()
	{
		return new Dimension(50,50);
	}
}
