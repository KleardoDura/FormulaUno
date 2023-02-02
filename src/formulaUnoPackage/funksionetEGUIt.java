package formulaUnoPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;



public class funksionetEGUIt   {
	
	public static void TabelaEShoferave (int check){
		//0 ne rend zbrites
		//1 ne rend rrites
		//2 rendit ne baze te pikeve
	   JTable table;
	   JPanel panel=new JPanel();
		JFrame frame = new JFrame();
		frame.setTitle("Formula Uno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Mbyllet programi kur shtypim x siper
		//frame.setDefaultCloseOperation(Jframe.DO_NOTHING_ON_CLOSE);// Nuk hiqet kur shtyp x siper
		frame.setResizable(false);
		frame.setSize(750,550);
		frame.setVisible(true);
		frame.setLayout(null);
		//frame.getContentPane().setBackground(Color.green);
	   frame.setLocationRelativeTo(null);
	   String columnNames[]= {"Emri","Mbiemri","Kombesia","Skuadra","Nr i garave","I","II","III","Piket"};
	   ShoferiFormula1[] shoferat=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()];
	  
	   
	   //Kontrollojme kushtet
	   if(check==0) {
		   shoferat=TeDhenatPerShofer.lexoShofer();}
	   else if(check==1) {
		   shoferat=TeDhenatPerShofer.renditShoferatNeRendRrites();
	   }   else if(check==2) {
		   shoferat=TeDhenatPerShofer.renditSipasVenditI();
	   }	   
	   Object data[][]= new Object[shoferat.length][9];		
		for(int i=0;i<TeDhenatPerShofer.numriIShoferave();i++) {
			data[i][0]=shoferat[i].getEmri();
			data[i][1]=shoferat[i].getMbiemri();
			data[i][2]=shoferat[i].getKombesia();
			data[i][3]=shoferat[i].getSkuadra();
			data[i][4]=shoferat[i].getNumriIGarave();
			data[i][5]=shoferat[i].getVendIPare();
			data[i][6]=shoferat[i].getVendIDyte();
			data[i][7]=shoferat[i].getVendITrete();
			data[i][8]=shoferat[i].getPiket();
			
		}
	   
		table=new JTable(data,columnNames);
		JTableHeader header= table.getTableHeader();
		header.setBounds(0,0,750,20);
		frame.add(header);
		
		table.setBounds(0,20,750,250);
		
		
		frame.add(table.getTableHeader(),BorderLayout.CENTER);//BorderLayout.PAGE_START
		frame.add(table,BorderLayout.CENTER);
		if(check==0) {
			JButton renditNeRendRrites =new JButton("Rendit ne rend rrites");
			renditNeRendRrites.setBounds(180,300, 230, 35);
			renditNeRendRrites.setFocusable(false);
			renditNeRendRrites.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					TabelaEShoferave(1)	;
				}		
			});
			frame.add(renditNeRendRrites);
			
			JButton renditSipasVenditTePare =new JButton("Rendit Sipas Vendit Te Pare");
			renditSipasVenditTePare.setBounds(180,340, 230, 35);
			renditSipasVenditTePare.setFocusable(false);
			renditSipasVenditTePare.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					TabelaEShoferave(2)	;	
				}		
			});
			frame.add(renditSipasVenditTePare);
		}
		JButton ktheu =new JButton("Kthehu");
		ktheu.setBounds(180,380, 230, 35);
		ktheu.setFocusable(false);
		
		ktheu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPerGUI();
				frame.setVisible(false);
			}		
		});
		frame.add(ktheu);
	}
	
	public static void gjeneroNjeGareTeRastesishme (boolean mePozFillestare){
		   JTable table;
			JFrame frame = new JFrame();
			frame.setTitle("Formula Uno");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setSize(550,550);
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
		   String columnNames[]= {"Emri","Mbiemri","Skuadra","Pozicioni"};
		   ShoferiFormula1[] shoferat=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()];
		   if(mePozFillestare) {
			   //Nese mePozicioneFillestare eshte true thrrasin funksionin qe gjeneron me pozicione fillestare
			   shoferat=TeDhenatPerGare.gjeneroNjeGareMePozFillestare();}
		   else {
			   shoferat=TeDhenatPerGare.gjeneroNjeGareRandom();
		   }
		   Object data[][]= new Object[shoferat.length][4];		
			for(int i=0;i<TeDhenatPerShofer.numriIShoferave();i++) {
				data[i][0]=shoferat[i].getEmri();
				data[i][1]=shoferat[i].getMbiemri();
				data[i][2]=shoferat[i].getSkuadra();
				data[i][3]=shoferat[i].getPozicioniNeNjeGare();
				
			}
		   
			table=new JTable(data,columnNames);
			JTableHeader header= table.getTableHeader();
			header.setBounds(0,0,550,20);
			frame.add(header);
		   table.setBounds(0,20,550,290);
			frame.add(table.getTableHeader(),BorderLayout.PAGE_START);
			frame.add(table,BorderLayout.CENTER);
			
			JButton ktheu=new JButton("Ktheu"); 
			ktheu.setBounds(180, 310, 80, 25);
			ktheu.setFocusable(false);
			ktheu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new MenuPerGUI();
					frame.setVisible(false);
				}		
			});
			frame.add(ktheu);
		}

	
	public static void kerkoNeGare() {
		JFrame frame = new JFrame();
		JPanel panel=new JPanel();
		JTextField emri;
		JTextField mbiemri;
		JButton kerko =new JButton("Kerko");
		JButton ktheu =new JButton("Kthehu");
		frame.setTitle("Formula Uno");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setSize(550,550);
		
		JLabel label=new JLabel("Vendsoni emrin e shoferit");
		label.setBounds(10,20,175,25);
		frame.add(label);
		
		emri =new JTextField(15);
		emri.setBounds(180,20,150,25);
		frame.add(emri);
	
		JLabel label1=new JLabel("Vendsoni mbiemrin e shoferit");
		label1.setBounds(10,55,175,25);
		frame.add(label1);
		
		
		mbiemri =new JTextField(15);
		mbiemri.setBounds(180,55,150,25);
		frame.add(mbiemri);
		
		kerko.setBounds(180, 90, 80, 25);
		kerko.setFocusable(false);
		kerko.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shfaqShoferinNeGara( emri.getText(), mbiemri.getText());
				frame.setVisible(false);
			}		
		});
		frame.add(kerko);
		
		ktheu.setBounds(180, 120, 80, 25);
		ktheu.setFocusable(false);
		ktheu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuPerGUI();
				frame.setVisible(false);
			}		
		});
		frame.add(ktheu);
		
		frame.setVisible(true);
	}
	
	public static void shfaqShoferinNeGara(String emri,String mbiemri) { 
	   ArrayList <ShoferiNeGare> shoferiNeGare=TeDhenatPerGare.kontrolloShofer(emri,mbiemri); 
	   int nrIGarave=shoferiNeGare.size();
	   if(nrIGarave==0) {
		   JOptionPane.showMessageDialog(null, "Shoferi i cili vendoset nuk ka marre pjese ne asnje gare");
		   new MenuPerGUI();
	   }
	   JTable table; 
	   JFrame frame = new JFrame(); 
	   if(nrIGarave==0) {
		   JOptionPane.showMessageDialog(null, "Shoferi i cili vendoset nuk ka marre pjese ne asnje gare");
		   return; 
	   }
	  frame.setTitle(emri+" "+mbiemri);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setResizable(false); 
	  frame.setSize(550,550);
	  frame.setVisible(true); 
	  frame.setLayout(null); 
	  frame.setLocationRelativeTo(null);
	  String columnNames[]={"Gara","Data","Pozicioni"}; 
	  Object data[][]= new Object[nrIGarave][3]; 
	  for(int i=0;i<nrIGarave;i++) { 
		  data[i][0]=shoferiNeGare.get(i).gara; 
		  data[i][1]=shoferiNeGare.get(i).data; 
		  data[i][2]=shoferiNeGare.get(i).pozicioni; 
		  }
	  table=new JTable(data,columnNames); 
		JTableHeader header= table.getTableHeader();
		header.setBounds(0,0,550,20);
		frame.add(header);
	  table.setBounds(0,20,550,290);
	  frame.add(table.getTableHeader(),BorderLayout.PAGE_START);
	  frame.add(table,BorderLayout.CENTER); 
	
	  JButton ktheu =new JButton("Kthehu");
		ktheu.setBounds(180,320, 100, 35);
		ktheu.setFocusable(false);
		
		ktheu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPerGUI();
				frame.setVisible(false);
			}		
		});
		frame.add(ktheu);
		
	} 
	
	public static void shfaqGarat(int gara) {
		int nrIGarave=TeDhenatPerGare.numriIGarave();
		JTable table;
		JFrame frame = new JFrame();
		frame.setTitle("Gara "+gara+"=>Date:"+TeDhenatPerGare.dataEGares(gara));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(550,550);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		if(nrIGarave==0) {
			JOptionPane.showMessageDialog(null, "Ju nuk keni asnje gare te ruajtur");
			frame.setVisible(false);
			return;
		}
		if(gara>nrIGarave) return;
		String columnNames[]= {"Emri","Mbiemri","Skuadra","Pozicioni"};
		ShoferiFormula1[] shoferat=TeDhenatPerGare.lexoNjeGare(gara);
		Object data[][]= new Object[shoferat.length][4];		
			for(int i=0;i<shoferat.length;i++) {
				data[i][0]=shoferat[i].getEmri();
				data[i][1]=shoferat[i].getMbiemri();
				data[i][2]=shoferat[i].getSkuadra();
				data[i][3]=shoferat[i].getPozicioniNeNjeGare();			
			} 
		
		table=new JTable(data,columnNames); 
		JTableHeader header= table.getTableHeader();
		header.setBounds(0,0,550,20);
		frame.add(header);
		table.setBounds(0,20,550,290);
		frame.add(table.getTableHeader(),BorderLayout.PAGE_START);
		frame.add(table,BorderLayout.CENTER); 
		
		if(gara!=nrIGarave) {
			//Ne momentin qe jemi ne garen e fundit nuk del me butoni next
			 JButton next =new JButton(">>");
			 next.setBounds(180,320, 100, 35);
			 next.setFocusable(false);	
			 next.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
						shfaqGarat(gara+1);	
					}		
				});
			frame.add(next);
		}
		JButton ktheu =new JButton("Kthehu");
		ktheu.setBounds(180,360, 100, 35);
		ktheu.setFocusable(false);
			
		ktheu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MenuPerGUI();
				frame.setVisible(false);
				return;
			}		
		});
		frame.add(ktheu);  
	}
	
}
