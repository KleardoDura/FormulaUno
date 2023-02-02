package formulaUnoPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import formulaUnoPackage.funksionetEGUIt.TabelaEShoferave;

//import kontrolliIDyerve.Dalja;
//import kontrolliIDyerve.Hyrja;

public class MenuPerGUI extends JFrame implements ActionListener {

	JButton shfaqTablenEShoferave;
	JButton gjeneroNjeGareTeRastesishme;
	JButton gjeneroNjeGareMePozFillestare,ktheu;
	JButton shfaqGarat;
	JButton kerkoNeGara;
	JPanel panel = new JPanel();
	JTextField userText;

	MenuPerGUI() {
		this.setLayout(null);
		this.setTitle("Menu per nderfaqen grafike");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Mbyllet programi kur shtypim x siper
		this.setResizable(false);
		this.setSize(400, 450);
		this.setLocationRelativeTo(null); // e vendos ne qender te ekranit guin

		JLabel label = new JLabel("JU LUTEM ZGJIDHNI VEPRIMIN QE DO TE KRYENI");
		label.setBounds(40, 20, 350, 25);
		this.add(label);

		shfaqTablenEShoferave = new JButton("Shfaq Tablen E Shoferave");
		shfaqTablenEShoferave.setBounds(55, 70, 225, 30);
		shfaqTablenEShoferave.setFocusable(false);
		shfaqTablenEShoferave.addActionListener(this);
		this.add(shfaqTablenEShoferave);

		gjeneroNjeGareTeRastesishme = new JButton("Gjenero Nje Gare Te Rastesishme");
		gjeneroNjeGareTeRastesishme.setBounds(55, 105, 225, 30);
		gjeneroNjeGareTeRastesishme.setFocusable(false);
		gjeneroNjeGareTeRastesishme.addActionListener(this);
		this.add(gjeneroNjeGareTeRastesishme);

		gjeneroNjeGareMePozFillestare = new JButton("Gjenero Nje Gare Me Poz Fillestare");
		gjeneroNjeGareMePozFillestare.setBounds(55, 140, 225, 30);
		gjeneroNjeGareMePozFillestare.setFocusable(false);
		gjeneroNjeGareMePozFillestare.addActionListener(this);
		this.add(gjeneroNjeGareMePozFillestare);

		shfaqGarat = new JButton("Shfaq Garat");
		shfaqGarat.setBounds(55, 175, 225, 30);
		shfaqGarat.setFocusable(false);
		shfaqGarat.addActionListener(this);
		this.add(shfaqGarat);

		kerkoNeGara = new JButton("Kerko ne gara per nje shofer");
		kerkoNeGara.setBounds(55, 210, 225, 30);
		kerkoNeGara.setFocusable(false);
		kerkoNeGara.addActionListener(this);
		this.add(kerkoNeGara);

		ktheu = new JButton("Dil");
		ktheu.setBounds(55, 245, 225, 30);
		ktheu.setFocusable(false);
		ktheu.addActionListener(this);
		this.add(ktheu);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		  if(e.getSource()==shfaqTablenEShoferave) {
			  funksionetEGUIt
			  .TabelaEShoferave(0);    this.setVisible(false);}
		  else if(e.getSource()==gjeneroNjeGareTeRastesishme) {
			  funksionetEGUIt.gjeneroNjeGareTeRastesishme(false);    this.setVisible(false);  }
		  else if(e.getSource()==gjeneroNjeGareMePozFillestare) {//Pozicionet fillestare =true
			  funksionetEGUIt.gjeneroNjeGareTeRastesishme(true);    this.setVisible(false); }
		  else if(e.getSource()==kerkoNeGara) {
			  funksionetEGUIt.kerkoNeGare();    this.setVisible(false);  }
		  else if(e.getSource()==shfaqGarat) {
			  funksionetEGUIt.shfaqGarat(1);    this.setVisible(false);  }
		  else if(e.getSource()==ktheu) {
			      this.setVisible(false);  
			 System.exit(0);
		  }

}
}