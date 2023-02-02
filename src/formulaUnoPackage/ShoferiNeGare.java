package formulaUnoPackage;

public class ShoferiNeGare {
	//Ne kete klase do te ruhen te dhenat e shoferit ne nje gare;
	public String gara;
	public String data;
	public int pozicioni;
	ShoferiNeGare(String gara,String data,int pozicioni){
		this.gara=gara; this.pozicioni=pozicioni; this.data=data;
	}
	public String toString() {
		return gara+" "+data+" "+pozicioni;
	}
}
