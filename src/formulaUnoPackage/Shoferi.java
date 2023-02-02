package formulaUnoPackage;

public abstract class Shoferi {
	//Fushat
	private String emri;
	private String mbiemri;
	private String kombesia;
	private String skuadra;
	private int numriIGarave;
	private int vendIPare;
	private int vendIDyte;
	private int vendITrete;
	private int piket;
	private int pozicioniNeNjeGare;
	
	//CONSTRUCTOR
	public Shoferi(String emri,String mbiemri,String kombesia,String skuadra,int numriIGarave,int vendIPare,int vendIDyte, int vendITrete, int piket) {
		this.emri=emri;
		this.mbiemri=mbiemri;
		this.kombesia=kombesia;
		this.skuadra=skuadra;
		this.numriIGarave=numriIGarave;
		this.vendIPare=vendIPare;
		this.vendIDyte=vendIDyte;
		this.vendITrete=vendITrete;
		this.piket=piket;
		//this.pozicioniNeNjeGare=pozicioniNeNjeGare;
	}
	public Shoferi(String emri,String mbiemri,String skuadra,int piket,int pozicioniNeNjeGare) {
		this.emri=emri;
		this.mbiemri=mbiemri;
		this.skuadra=skuadra;
		this.piket=piket;
		this.pozicioniNeNjeGare=pozicioniNeNjeGare;
	}
	
	public abstract String toString();
	public abstract String toString2();
	
	public String getEmri() {
		return emri;
	}
	public void setEmri(String emri) {
		this.emri = emri;
	}
	public String getMbiemri() {
		return mbiemri;
	}
	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}
	public String getKombesia() {
		return kombesia;
	}
	public void setKombesia(String kombesia) {
		this.kombesia = kombesia;
	}
	public String getSkuadra() {
		return skuadra;
	}
	public void setSkuadra(String skuadra) {
		this.skuadra =skuadra;
	}
	
	public int getNumriIGarave() {
		return numriIGarave;
	}
	public void setNumriIGarave(int numriIGarave) {
		this.numriIGarave = numriIGarave;
	}
	public int getVendIPare() {
		return vendIPare;
	}
	public void setVendIPare(int vendIPare) {
		this.vendIPare = vendIPare;
	}
	public int getVendIDyte() {
		return vendIDyte;
	}
	public void setVendIDyte(int vendIDyte) {
		this.vendIDyte = vendIDyte;
	}
	public int getVendITrete() {
		return vendITrete;
	}
	public void setVendITrete(int vendITrete) {
		this.vendITrete = vendITrete;
	}
	public int getPiket() {
		return piket;
	}
	public void setPiket(int piket) {
		this.piket = piket;
	}
	public int getPozicioniNeNjeGare() {
		return pozicioniNeNjeGare;
	}
	public void setPozicioniNeNjeGare(int pozicioniNeNjeGare) {
		this.pozicioniNeNjeGare =pozicioniNeNjeGare;
	}
	
	
}
