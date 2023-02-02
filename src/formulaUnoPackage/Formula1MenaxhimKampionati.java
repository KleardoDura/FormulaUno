package formulaUnoPackage;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Formula1MenaxhimKampionati implements MenaxhimKampionati{
	
	
	public static void main(String[] args) {
		
		// PRINTON DATEN 
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		System.out.println(dtf.format(now));
		System.out.println("      MIRE SE VINI NE NDERFAQEN FORMUAL UNO MENAXHIM KAMPIONATI");
		System.out.println("________________________________________________________________________");
		
		int m;
		Formula1MenaxhimKampionati fm=new Formula1MenaxhimKampionati();
		while((m=fm.menu())!=0) {
			switch (m){
			case 1: TeDhenatPerShofer.printoShoferat(); break;                    
			case 2: TeDhenatPerShofer.shtoShofer(); break;
			case 3: TeDhenatPerShofer.fshiShofer(); break;
			case 4: TeDhenatPerShofer.ndryshoShofer(); break;
			case 5: TeDhenatPerShofer.printoTeDhenaPerShofer(); break;
			case 6: TeDhenatPerGare.shtoGare(); break;
			case 7: new MenuPerGUI(); break;
			default: System.exit(0);
		  }
		}
		//System.exit(0);
		
			
		//TeDhenatPerGare.gjeneroNjeGareMePozFillestare();
		//System.out.println(TeDhenatPerGare.dataEGares(1));
		/*
		ArrayList <ShoferiNeGare> shoferiNeGare=TeDhenatPerGare.kontrolloShofer("max ","verstappen  ");
		 for(int i=0;i<shoferiNeGare.size();i++) {
			 System.out.println(shoferiNeGare.get(i).toString());
		 }
		*/
	}
	
	public  int menu() {
		Scanner sc=new Scanner(System.in);
		int i=0;
		System.out.println("___________________________________________________");
		System.out.println("1.Shfaqe Tabelen e Shoferave");
		System.out.println("2.Krijo nje shofer te ri");
		System.out.println("3.Fshi nje shofer se bashku me skuadren perkatese");
		System.out.println("4.Ndrysho shoferin per nje skuader");
		System.out.println("5.Shfaq statistikat per nje shofer te zgjedhur");
		System.out.println("6.Shto nje gare");
		System.out.println("7.Nderfaqja grafike");
		System.out.println("0.Mbyll programin");
		System.out.println("___________________________________________________");
		System.out.println("Zgjedhja juaj => ");
		try {
			i=sc.nextInt();
			if(i<0 || i>7) {
				System.out.println("Ju duhet te vendosni nje numer  nga 0-6! ");
				System.exit(0);
			}
		}catch(InputMismatchException e) {
			System.out.println("Ju duhet te vendosni nje numer!! ");
			System.exit(0);
		}
	
		return i;
	}
}
