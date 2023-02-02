package formulaUnoPackage;

public class ShoferiFormula1 extends Shoferi {
	//Constructor qe perdoret per tabelen e shoferave
	public ShoferiFormula1(String emri, String mbiemri, String kombesia,String skuadra ,int numriIGarave, int vendIPare, int vendIDyte,
			int vendITrete, int piket) {
		super(emri, mbiemri, kombesia,skuadra,numriIGarave, vendIPare, vendIDyte, vendITrete, piket);
		// TODO Auto-generated constructor stub
	}
	//Constructor qe perdoret per garat
	public ShoferiFormula1(String emri,String mbiemri,String skuadra,int piket,int pozicioniNeNjeGare) {
		super(emri,mbiemri,skuadra,piket,pozicioniNeNjeGare);
	}
	public String toString() {
		return this.getEmri()+"-"+this.getMbiemri()+"-"+this.getSkuadra()+"-"+this.getPiket();
	}
	public String toString2() {
		return this.getEmri()+"-"+this.getMbiemri()+"-"+this.getSkuadra()+"-"+this.getPozicioniNeNjeGare();
	}
}
