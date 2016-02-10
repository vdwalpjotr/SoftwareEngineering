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
	private JTextField totaalVeld = new JTextField(3);
	private JTextField aantalEenVeld = new JTextField(3);
	private JTextField aantalTweeVeld = new JTextField(3);
	private JTextField aantalDrieVeld = new JTextField(3);
	private JTextField aantalVierVeld = new JTextField(3);
	private JTextField aantalVijfVeld = new JTextField(3);
	private JTextField aantalZesVeld = new JTextField(3);
	DobbelsteenModel d;

	public StatistiekView()
	{
		this.setLayout(new GridLayout(6,0));
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
		// nog te coderen: set text per oog en in 
	}
	public Dimension getPrefferedSize()
	{
		return new Dimension(50,50);
	}
}
