package formulaUnoPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.lang.Exception;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;


public class TeDhenatPerGare {

	public ShoferiFormula1 shoferat[];
	
	public static int numriIGarave() {
		int ln=0;
		try {
			File file=new File("garat/");
			String ls[]=file.list();
			ln=ls.length;
		}catch(NullPointerException e) {
			System.out.println("Direcory not found");System.exit(0);
		}
		return ln;
	}
	
	
	public static int numriIShoferaveNeNjeGare(int nrIGares) {
		File file=new File("garat/gara_"+nrIGares+".txt");
		int lines=0;
		try(LineNumberReader lnr= new LineNumberReader(new FileReader(file))){
			while(lnr.readLine()!=null) {
				lines=lnr.getLineNumber();
			}
		}
		catch(FileNotFoundException e){
			//e.printStackTrace();
			System.out.println("File not found");
			System.exit(0);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Cant read");
			System.exit(0);
		}
		return lines;
	}
	
	public static String dataEGares(int nrIGares) {
		File my_file=new File("garat/gara_"+nrIGares+".txt");
		Path path=my_file.toPath();
		
		 BasicFileAttributes file_att=null ;
		try {
			file_att = Files.readAttributes(
			            path, BasicFileAttributes.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File nuk u gjet"); System.exit(0);
		}
		        // creating simple date format object to make the
		        // output more readable
		        SimpleDateFormat sd
		            = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");   
		        // converting time to milliseconds then specifying
		        // the format in which we want the output
		           return  sd.format(file_att.creationTime().toMillis());
	}
	
	public static ShoferiFormula1[] lexoNjeGare(int nrIGares) {
		if(numriIGarave()==0) {
			System.out.println("Nuk kemi te ruajtur asnje gare");
			System.exit(0);
		}
		if(nrIGares>numriIGarave() || nrIGares<=0 ) {
			System.out.println("Nuk mund te lexojme garen :"+nrIGares+" Sepse Numri i gares duhet te bej pjese ne segmentin 1-"+numriIGarave());
			System.exit(0);		}
		
		int nrIShoferve=numriIShoferaveNeNjeGare(nrIGares);
		//System.out.println("Numri i shoferave pjesmarres ne kete gare:"+nrIShoferve);
		ShoferiFormula1 shoferat[]=new ShoferiFormula1[nrIShoferve];
		try {
			int i=0;
			File file=new File("garat/gara_"+nrIGares+".txt");
			Scanner sc =new Scanner(file);
			while(sc.hasNextLine()){
				
				String arr[]=sc.nextLine().split(" ");
				//Ngarkojme shoferat nga file i gares ne vektorin e objekteve
				//Perdorim Constructorin per Garen
				shoferat[i]=new ShoferiFormula1(arr[0],arr[1],arr[2],0,Integer.parseInt(arr[3])); 
				i++;
			}
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Fiel doesn not exist");
			System.exit(0);
		}
		catch(NumberFormatException nfe) {
			System.out.println("Mosha duhet te jete nje numer"); 
			System.exit(0);
		}
	    return shoferat;
		
	
	}
	
	public static void printoNjeGare (int nrIGares) {
		ShoferiFormula1 shoferat[]=lexoNjeGare(nrIGares);
		for(int i=0;i<shoferat.length;i++) {
			System.out.println(shoferat[i].toString2());
		}
	}
	
	
	public static void ruajGaren(ShoferiFormula1 shoferat[]) {
		
		int nrIShoferave=shoferat.length;
		try {
			File file=new File("garat/gara_"+(numriIGarave()+1)+".txt"); //e krijon
			FileWriter fileWriter=new FileWriter(file);
			PrintWriter printWriter= new PrintWriter(fileWriter);
			
			for(int i=0;i<nrIShoferave;i++) {
				printWriter.println(shoferat[i].getEmri()+" "+shoferat[i].getMbiemri()+" "+shoferat[i].getSkuadra()+" "+shoferat[i].getPozicioniNeNjeGare());
			}
			printWriter.close();// e rendesishme ta mbyllim
			
		}
		
		catch(IOException ioe){
			//ioe.printStackTrace();
			System.out.println("File not found2");System.exit(0);
		}
		
	  return;}

	public static void updateTabelesSeShoferave(ShoferiFormula1 shoferat[]) {
		ShoferiFormula1 [] tabelaEShoferave=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()];
		tabelaEShoferave=TeDhenatPerShofer.lexoShofer();
		for(int i=0;i<tabelaEShoferave.length;i++) {
		//Shtojme tek Tablea e Shoferit rezultatet e reja
			tabelaEShoferave[i].setPiket(tabelaEShoferave[i].getPiket()+shoferat[i].getPiket());
			//Nese tek shoferat[] pozicioni eshte !=0 dmth qe garuesi ka merr pjese pra garat e tij ikrementohen me 1
			if(shoferat[i].getPozicioniNeNjeGare()!=0) {
				tabelaEShoferave[i].setNumriIGarave(tabelaEShoferave[i].getNumriIGarave()+1);
			}
			//Nese eshte ne vend te pare te dyte ose te tret ikremento pozicionin perkates
			if(shoferat[i].getPozicioniNeNjeGare()==1) {
				tabelaEShoferave[i].setVendIPare(tabelaEShoferave[i].getVendIPare()+1);
			}
			if(shoferat[i].getPozicioniNeNjeGare()==2) {
				tabelaEShoferave[i].setVendIDyte(tabelaEShoferave[i].getVendIDyte()+1);
			}
			if(shoferat[i].getPozicioniNeNjeGare()==3) {
				tabelaEShoferave[i].setVendITrete(tabelaEShoferave[i].getVendITrete()+1);
			}
			
			
		}
		TeDhenatPerShofer.ruajShoferet(tabelaEShoferave);
	}
	
	public static void shtoGare() {
		System.out.println("Vendos pozicionin per cdo shofer(nese ai nuk ka marr pjese ne gare ploteso me 0):");
		ShoferiFormula1 shoferat[]=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()];
		ShoferiFormula1 listaEShoferave[]= TeDhenatPerShofer.lexoShofer();
		Scanner sc=new Scanner(System.in);
		int nrShoferavePjesmarres=0;
		int pozicioniArray[]= new int[shoferat.length];
		for(int i=0;i<shoferat.length;i++) {
			pozicioniArray[i]=1;
		}
		
		int piket[]= {25,18,15,12,10,8,6,4,2,1};
		for (int i=0;i<listaEShoferave.length;i++) {
			System.out.println("Pozicioni i "+(listaEShoferave[i].getEmri())+" "+(listaEShoferave[i].getMbiemri())+": ");
			int pozicioni=-8;//=sc.nextInt();
			
			int y=1;
			int z=1;
			do {
				do { 
					try {	
						 pozicioni=sc.nextInt();
					}
					catch(InputMismatchException e) {
						System.out.println("Pozicioni duhet te jete nje numer");
						System.exit(0);
					}	
					
			 	if( pozicioni>listaEShoferave.length) { z=0;
			 	System.out.println("Pozicioni maximal qe mund te vendosni eshte :"+listaEShoferave.length);
			 	System.out.println("Vendosni perseri pozicionin:"); }
			 	
			 	else z=1;
				} while(z==0);
			 	if( pozicioni!=0 && pozicioni<=listaEShoferave.length && pozicioniArray[pozicioni-1]==0  ) {
				System.out.println("Ky pozicion eshte vendosur me siper.Pozicionet e mbetura jane:");
				for(int x=0;x<pozicioniArray.length;x++) {
				if(pozicioniArray[x]==1)  System.out.printf("%d ",x+1);}
				System.out.println("Vendosni perseri pozicionin:"); y=0;
			 	}else y=1;
			 	
			 	
			} while(y==0 );
			
			if(pozicioni>0 && pozicioni<=10) {
				ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),piket[pozicioni-1],pozicioni);
				shoferat[i]=shoferiTemp;
				nrShoferavePjesmarres++;
				pozicioniArray[pozicioni-1]=0;
			}
			if(pozicioni>10) {
				ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),0,pozicioni);
				shoferat[i]=shoferiTemp;
				 nrShoferavePjesmarres++;
				 pozicioniArray[pozicioni-1]=0;
				 }
			if(pozicioni==0) {
				//Mos e Shto Kete shofer 
				ShoferiFormula1 shoferiTemp = new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),0,0);
				shoferat[i]=shoferiTemp;
			}
			
		}
		
		
		//Ben ruajtjen ne file vetem te shoferave pjesmarres
		ShoferiFormula1 shoferatPjesmarres[]=new ShoferiFormula1[nrShoferavePjesmarres];
		int i=0,j=0;
		do {
			if(j==nrShoferavePjesmarres) {break;}
			shoferatPjesmarres[j]=shoferat[i];
			while(shoferat[i].getPozicioniNeNjeGare()==0 && j+1<shoferat.length) {
				shoferatPjesmarres[j]=shoferat[i+1];i++;
			}	
			i++;j++;
		} while(i<shoferat.length);
		
		System.out.println("Gara u shtua me sukses");
		ruajGaren(shoferatPjesmarres);
		updateTabelesSeShoferave(shoferat);
		
	}

	public static int[] gjeneroNumraRandom(int nrIShoferave) {
		//Gjeneron numra Random jo te Dublicuar 
		int i;
		Random r= new Random();
		int a[]=new int [nrIShoferave];
		for( i=0;i<nrIShoferave;i++) a[i]=-1;
		boolean check;
		i=0;	
		while(i<nrIShoferave) {
			int pozicionRandom;
			do {check=false;
				pozicionRandom=r.nextInt(nrIShoferave)+1;
					for(int j=0;j<nrIShoferave;j++) {
						if(a[j]==pozicionRandom) 
							{check=true;break;
							}
					}
				} while(check);		
			a[i]=pozicionRandom;
			i++;
		}
		return a;
	}
	
	public static ShoferiFormula1 [] gjeneroNjeGareRandom() {
			ShoferiFormula1 shoferat[]=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()];
			ShoferiFormula1 listaEShoferave[]= TeDhenatPerShofer.lexoShofer();
			int pozicioniArray[]= gjeneroNumraRandom(TeDhenatPerShofer.numriIShoferave());
			int piket[]= {25,18,15,12,10,8,6,4,2,1};
			for (int i=0;i<listaEShoferave.length;i++) {
				int pozicioni=pozicioniArray[i];
				if(pozicioni>0 && pozicioni<=10) {
					ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),piket[pozicioni-1],pozicioni);
					shoferat[i]=shoferiTemp;
				}
				if(pozicioni>10) {
					ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),0,pozicioni);
					shoferat[i]=shoferiTemp;
					 }
			}
			for(int i=0;i<12;i++)
			System.out.println(shoferat[i].toString2());
			System.out.println("Gara u shtua me sukses");
			ruajGaren(shoferat);
			updateTabelesSeShoferave(shoferat);
			return shoferat;
	}
	
	public static ShoferiFormula1 [] gjeneroNjeGareMePozFillestare() {
		int pozicioniFillestar[]= gjeneroNumraRandom(TeDhenatPerShofer.numriIShoferave());
		int probabilitetiPerTeFituar[]=new int[pozicioniFillestar.length];
		int pozicioniPerfundimtar[]=new int[pozicioniFillestar.length];
		for(int i=0;i< pozicioniFillestar.length ;i++) {
			if(pozicioniFillestar[i]==1) {
				probabilitetiPerTeFituar[i]=40;
			}else if(pozicioniFillestar[i]== 2) {
				probabilitetiPerTeFituar[i]=30;
			}else if(pozicioniFillestar[i]== 3 || pozicioniFillestar[i]== 4 ) {
				probabilitetiPerTeFituar[i]=10;
			}else if(pozicioniFillestar[i]>= 5 && pozicioniFillestar[i]<= 9 ) {
				probabilitetiPerTeFituar[i]=2;
			}else  {
				probabilitetiPerTeFituar[i]=0;
			}			
		}
		
		
		
		int poz3_4=3,poz5_9=5,poz_9=10;
		//Ne vektorin pozicioniPerfundimtar ppf => ppf[0]=4 dmth qe shoferi me indeks 0 ka zene vendin e katert
		for(int i=0;i<probabilitetiPerTeFituar.length;i++) {
			if(probabilitetiPerTeFituar[i]==40) pozicioniPerfundimtar[i]=1;
			else if(probabilitetiPerTeFituar[i]==30) pozicioniPerfundimtar[i]=2;
			else if (probabilitetiPerTeFituar[i]==10) {
				pozicioniPerfundimtar[ i]=poz3_4;poz3_4++;
			}
			else if (probabilitetiPerTeFituar[i]==2) {
				pozicioniPerfundimtar[ i]=poz5_9;poz5_9++;
			}
			else if (probabilitetiPerTeFituar[i]==0) {
				pozicioniPerfundimtar[ i]=poz_9;poz_9++;
			}			
		}
	
		ShoferiFormula1 shoferat[]=new ShoferiFormula1[TeDhenatPerShofer.numriIShoferave()]; //Ketu do te ruajme shoferat me te cilet po punohet
		ShoferiFormula1 listaEShoferave[]= TeDhenatPerShofer.lexoShofer(); //Ketu ruajme listen  e shoferave
		int pozicioniArray[]= pozicioniPerfundimtar;
		int piket[]= {25,18,15,12,10,8,6,4,2,1};
		for (int i=0;i<listaEShoferave.length;i++) {
			int pozicioni=pozicioniArray[i];
			if(pozicioni>0 && pozicioni<=10) {
				ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),piket[pozicioni-1],pozicioni);
				shoferat[i]=shoferiTemp;
			}
			if(pozicioni>10) {
				ShoferiFormula1 shoferiTemp=new ShoferiFormula1(listaEShoferave[i].getEmri(),listaEShoferave[i].getMbiemri(),listaEShoferave[i].getSkuadra(),0,pozicioni);
				shoferat[i]=shoferiTemp;
				 }
		}
		ruajGaren(shoferat);
		updateTabelesSeShoferave(shoferat);
		return shoferat;
		
	}
	
	public static ArrayList <ShoferiNeGare> kontrolloShofer(String emri,String mbiemri) {
		int nrIGarave=numriIGarave();
		ArrayList <ShoferiNeGare> shoferiNeGare=new ArrayList <ShoferiNeGare> ();
		
		for(int i=1;i<=nrIGarave;i++) {
			ShoferiFormula1[]shoferat= lexoNjeGare(i);
			for(int j=0;j<shoferat.length;j++) {
				if(emri.trim().equalsIgnoreCase(shoferat[j].getEmri()) && mbiemri.trim().equalsIgnoreCase(shoferat[j].getMbiemri())) {
					shoferiNeGare.add(new ShoferiNeGare("Gara "+i,dataEGares(i),shoferat[j].getPozicioniNeNjeGare()) );
					break;//Sepse u gjet shofer ne kete gare
				}}}
		return shoferiNeGare;
	}
	
}
