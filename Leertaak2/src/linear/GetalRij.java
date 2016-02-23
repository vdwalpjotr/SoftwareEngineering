package linear;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GetalRij {
	private int[] getallen;
	
	public GetalRij( int aantal, int max ){
		// Belangrijke aanname: aantal < max, anders kunnen de getallen niet uniek zijn.
		getallen = new int[aantal];
		vulArrayMetUniekeWaarden( aantal, max );
	}

	private void vulArrayMetUniekeWaarden(int aantal, int max) {
		// Vul een hulplijst met getallen 0, ..., max
		ArrayList hulpLijst = new ArrayList( max );
		for ( int i=0; i<max; i++){
			hulpLijst.add( i );
		}
		
		// Stop 'aantal' random waarden in getallen
		Random r = new Random();
		for ( int i=0; i<aantal; i++){
			// Het omzetten van Integer naar int gaat sinds Java 1.5 automatisch (unboxing).
			int getal = (Integer) (hulpLijst.remove( r.nextInt( hulpLijst.size())));
			getallen[i] = getal;
		}
	}
	
	public boolean zitErinA( int zoekWaarde ){
		int counter = 0;
		boolean zitInArray= false;
		long tijd = System.currentTimeMillis();
		while(counter< getallen.length){
			if(getallen[counter] == zoekWaarde){
				zitInArray = true;
			}
			counter++;
		}
		tijd = System.currentTimeMillis() - tijd;
		System.out.println("A: "+tijd);
		return zitInArray;
	}

	public boolean zitErinB( int zoekWaarde ){
		int counter = 0;
		long tijd = System.currentTimeMillis();
		while(counter< getallen.length){
			if(getallen[counter] == zoekWaarde){
				tijd = System.currentTimeMillis() - tijd;
				System.out.println("B gevonden"+tijd);
				return true;
			}
			counter++;
		}
		tijd = System.currentTimeMillis() - tijd;
		System.out.println("B niet gevonden : "+tijd);
		return false;
	}

	public boolean zitErinC( int zoekWaarde ){
		this.sorteer();
		int counter = 0;
		long tijd = System.currentTimeMillis();
		while(counter< getallen.length){
			if(getallen[counter] == zoekWaarde){
				tijd = System.currentTimeMillis() - tijd;
				System.out.println("B gevonden"+tijd);
				return true;
			}
			counter++;
		}
		tijd = System.currentTimeMillis() - tijd;
		System.out.println("B niet gevonden : "+tijd);
		return false;
	}

	public boolean zitErinD( int zoekWaarde ){
		this.sorteer();
		int low = 0;
		int high = getallen.length -1;
		while (high >= low){
			int mid = (low+high)/2;
			if(zoekWaarde < getallen[mid]){
				high = mid-1;
			}else if(zoekWaarde == getallen[mid]){
				return true;
			}else{
				low  = mid +1;
			}
		}
		return false;
	}
	
	public void sorteer(){
		Arrays.sort( getallen);
	}
	
	public void print(){
		for( int i=0; i<getallen.length; i++)
			System.out.println(getallen[i]);
	}
	
	public static void main(String[] args){
		GetalRij test = new GetalRij(1500, 1501);
		test.zitErinA(150);
		test.zitErinB(150);
		test.zitErinC(150);
	}

}
