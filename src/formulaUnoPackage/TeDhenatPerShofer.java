package formulaUnoPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class TeDhenatPerShofer {
	static Scanner sc=new Scanner(System.in);
	
	public static int numriIShoferave() {
		File file=new File("shoferat.txt");
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
			System.out.println("Can't read");
			System.exit(0);
		}
		return lines;
	}
	//funskionet lexo ngarkojne nga file ne matrice
	public static ShoferiFormula1[] lexoShofer() {
		int nrIShoferve=numriIShoferave();
		//System.out.println(nrIShoferve);
		ShoferiFormula1 shoferat[]=new ShoferiFormula1[nrIShoferve];
		
		try {
			int i=0;
			File file=new File("shoferat.txt");
			Scanner sc =new Scanner(file);
			while(sc.hasNextLine()){
				String arr[]=sc.nextLine().split(" ");
				shoferat[i]=new ShoferiFormula1(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4]),Integer.parseInt(arr[5]),Integer.parseInt(arr[6]),Integer.parseInt(arr[7]),Integer.parseInt(arr[8])); 
				i++;
			}
			//Rendisim Tabelen
			for(int y=0;y<nrIShoferve-1;y++) {
				for(int j=y+1;j<nrIShoferve;j++) {
					if(shoferat[y].getPiket()<shoferat[j].getPiket()) {
						ShoferiFormula1 shoferiTemp =shoferat[y];
						shoferat[y]=shoferat[j];
						shoferat[j]=shoferiTemp;
					}
				
				 if(shoferat[y].getPiket()==shoferat[j].getPiket()  && shoferat[y].getVendIPare()< shoferat[j].getVendIPare())
					 {
						ShoferiFormula1 shoferiTemp =shoferat[y];
						shoferat[y]=shoferat[j];
						shoferat[j]=shoferiTemp;
					}
					
					
				}
			}
		
			sc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Fiel doesn not exist");
			System.exit(0);
		}
		catch(NumberFormatException nfe) {
			System.out.println("Gabim ne formatin e File");
			System.out.println("Piket,numri i garave dhe pozicionet duhet te jene numer"); 
			System.exit(0);
		}
	    return shoferat;
	  
	}
	
	public static  ShoferiFormula1[] renditShoferatNeRendRrites() {
		 ShoferiFormula1[] shoferat=TeDhenatPerShofer.lexoShofer();
		 for(int y=0;y<shoferat.length-1;y++) {
				for(int j=y+1;j<shoferat.length;j++) {
					if(shoferat[y].getPiket()>shoferat[j].getPiket()) {
						ShoferiFormula1 shoferiTemp =shoferat[y];
						shoferat[y]=shoferat[j];
						shoferat[j]=shoferiTemp;
					}}}
		 
		 return shoferat;
	}
	
	public static  ShoferiFormula1[] renditSipasVenditI() {
		 ShoferiFormula1[] shoferat=TeDhenatPerShofer.lexoShofer();	
		 for(int y=0;y<shoferat.length-1;y++) {
				for(int j=y+1;j<shoferat.length;j++) {
					if(shoferat[y].getVendIPare()<shoferat[j].getVendIPare()) {
						ShoferiFormula1 shoferiTemp =shoferat[y];
						shoferat[y]=shoferat[j];
						shoferat[j]=shoferiTemp;
					}}}
		 
		 return shoferat;
	}
	
	public static  void printoShoferat() {
		ShoferiFormula1[] shoferat=new ShoferiFormula1[numriIShoferave()];
		System.out.println("                                Tabela E Shoferave");
		shoferat=lexoShofer();
		String leftAlignFormat= "| %-11s | %-11s | %-6s | %-17s | %-3d | %-2d | %-2d | %-2d | %-3d |%n";
		System.out.format("___________________________________________________________________________________%n");
		System.out.format("|Emri         |Mbiemri      |Kombesia|Skuadra      |Nr i garave|  I | II |III|Piket|%n");
		System.out.format("___________________________________________________________________________________%n");
		for(int i=0;i<numriIShoferave();i++) {
			System.out.format(leftAlignFormat, shoferat[i].getEmri(),shoferat[i].getMbiemri(),shoferat[i].getKombesia(),shoferat[i].getSkuadra(),shoferat[i].getNumriIGarave(),shoferat[i].getVendIPare(),shoferat[i].getVendIDyte(),shoferat[i].getVendITrete(),shoferat[i].getPiket());
		}
		System.out.format("___________________________________________________________________________________%n");
		System.out.println("Numri total i shofereve: "+numriIShoferave());
		return;
		
	}

	
	
	//Save Tabelen e Shoferave
	public static void ruajShoferet(ShoferiFormula1 shoferat[]) {
		
		int nrIShoferave=shoferat.length;
		//int nrIShofereve=Shoferi.numriIShoferave()+1;
		try {
			File file=new File("shoferat.txt"); //Nese nuk ekziston e krijon
			FileWriter fileWriter=new FileWriter(file);
			PrintWriter printWriter= new PrintWriter(fileWriter);
			for(int i=0;i<nrIShoferave;i++) {
				printWriter.println(shoferat[i].getEmri()+" "+shoferat[i].getMbiemri()+" "+shoferat[i].getKombesia()+" "+shoferat[i].getSkuadra()+" "+shoferat[i].getNumriIGarave()+" "+shoferat[i].getVendIPare()+" "+shoferat[i].getVendIDyte()+" "+shoferat[i].getVendITrete()+" "+shoferat[i].getPiket());
			}
			printWriter.close();//Importnt
			
		}
		catch(Exception fnfe){
			System.out.println("File not found");System.exit(0);
		}
		
	  return;
	}
	
	public static void printoTeDhenaPerShofer() {
		System.out.println("Ju lutem vendosni emrin dhe mbiemrin e shoferit:");
		String emri=sc.next();
		String mbiemri=sc.next();
		int indeksiIShoferit=kontrolloShofer(emri,mbiemri);
		if(indeksiIShoferit==-1) {
			System.out.println("Ky shofer nuk ndodhet ne list");
		}else {
			int i=indeksiIShoferit;
			ShoferiFormula1[] shoferat= lexoShofer();
			String leftAlignFormat= "| %-11s | %-11s | %-6s | %-17s | %-3d | %-2d | %-2d | %-2d | %-3d |%n";
			System.out.format("___________________________________________________________________________________%n");
			System.out.format("|Emri         |Mbiemri      |Kombesia|Skuadra      |Nr i garave|  I | II |III|Piket|%n");
			System.out.format("___________________________________________________________________________________%n");
				System.out.format(leftAlignFormat, shoferat[i].getEmri(),shoferat[i].getMbiemri(),shoferat[i].getKombesia(),shoferat[i].getSkuadra(),shoferat[i].getNumriIGarave(),shoferat[i].getVendIPare(),shoferat[i].getVendIDyte(),shoferat[i].getVendITrete(),shoferat[i].getPiket());
			System.out.format("___________________________________________________________________________________%n");
		}
		
	}

	public static void shtoShofer() {
		int y=1;
		ShoferiFormula1 shoferIShtuar = null;
		System.out.println("Vendos emrin ,mbiemrin dhe kombesine:");
		String emri=sc.next();
		String mbiemri=sc.next();
		String kombesia=sc.next();
		
		do {
			System.out.println("Vendos skuadren:");
			String skuadra=sc.next();
			if(kontrolloSkuadren(skuadra)!=-1) {
				System.out.println("Kjo skuader e ka nje shofer");
			 	System.out.println("Ju lutem shtoni shoferin per nje skuader tjeter");
	
			}else {
				shoferIShtuar=new ShoferiFormula1(emri,mbiemri,kombesia,skuadra,0,0,0,0,0);
				y=0;
			}
		
		}while(y==1);
		
		File file=new File("shoferat.txt");
		if(!file.exists()) {
			System.out.println("Ky ishte shoferi i pare i shtuar");
			ShoferiFormula1 shoferat[]=new ShoferiFormula1[1];
			shoferat[0]=shoferIShtuar;
			ruajShoferet(shoferat);
			return;
		}
		ShoferiFormula1 shoferat[]=lexoShofer();
		ShoferiFormula1 shoferatEPerditsuar[]= new ShoferiFormula1[shoferat.length+1];
		for(int i=0;i<shoferatEPerditsuar.length-1;i++) {
			shoferatEPerditsuar[i]=shoferat[i];
		}
		shoferatEPerditsuar[shoferatEPerditsuar.length-1]=shoferIShtuar;
		System.out.println("Shoferi i shtua me sukses");
		ruajShoferet(shoferatEPerditsuar);
	}
	
	//kthen indeksin e skuaderes ne tabelen e shoferave (nese nuk e gjen kthen -1)
	public static int kontrolloSkuadren(String skuadra) {
		ShoferiFormula1 shoferat[]=lexoShofer();
		for(int i=0;i<numriIShoferave();i++){
			if(skuadra.equalsIgnoreCase(shoferat[i].getSkuadra()))return i;
		}
		return -1; 
	}      

	//kthen indeksin e shoferit ne tabelen e shoferave (nese nuk e gjen kthen -1)
	public static int kontrolloShofer(String emri,String mbiemri) {
		ShoferiFormula1 shoferat[]=lexoShofer();
		for(int i=0;i<numriIShoferave();i++){
			if(emri.equalsIgnoreCase(shoferat[i].getEmri()) && mbiemri.equalsIgnoreCase(shoferat[i].getMbiemri())) return i;
		}
		return -1;
	}
	
	public static void fshiShofer() {
		System.out.println("Ju lutem vendosni emrin dhe mbiemrin e shoferit:");
		String emri=sc.next();
		String mbiemri=sc.next();
		int indeksiIShoferit=kontrolloShofer(emri,mbiemri);
		if(indeksiIShoferit==-1) {
			System.out.println("Ky shofer nuk ndodhet ne list");
		}else {
			ShoferiFormula1[] shoferat= lexoShofer();
			ShoferiFormula1[] shoferatEPerditsuar=new ShoferiFormula1[shoferat.length-1];
			
			for(int i=indeksiIShoferit;i<shoferat.length-1 ;i++ ) {
				shoferat[i]=shoferat[i+1];
			}
			for(int i=0;i<shoferat.length-1 ;i++ ) {
				shoferatEPerditsuar[i]=shoferat[i];
			}
			System.out.println("Shoferi u fshi me sukses");
			ruajShoferet(shoferatEPerditsuar);
		}
	}

	public static void ndryshoShofer() {
		int y=1;
		int indeksiISkuadres;
		System.out.println("Vendos skuadren:");
		do {
			String skuadra=sc.next();
			indeksiISkuadres=kontrolloSkuadren(skuadra);
			
			if(indeksiISkuadres==-1) {
				System.out.println("Kjo skuader nuk ndodhet ne list");
				System.out.println("Ju lutem vendosni perseri skuadren:");
			}else {
				y=0;
				System.out.println("Vendos emrin,mbiemrin dhe kombesin e shoferit te ri:");
				String emri=sc.next();
				String mbiemri=sc.next();
				String kombesia=sc.next();
				ShoferiFormula1[] shoferat= lexoShofer();
				ShoferiFormula1[] shoferatEPerditsuar= new ShoferiFormula1[shoferat.length];
				for(int i=0;i<shoferat.length;i++) {
					if(i==indeksiISkuadres) {
						shoferatEPerditsuar[i]=new ShoferiFormula1(emri,mbiemri,kombesia,shoferat[i].getSkuadra(),0,0,0,0,0);
					}else {
						shoferatEPerditsuar[i]=shoferat[i];
					}
				}
				System.out.println("Shoferi u modifikua me sukses");
				ruajShoferet(shoferatEPerditsuar);
			}
			
		}while(y==1);
		
	}
}