package linear;

public class Easy {
	int checkNumber=0;
	boolean truth= false;
	public Easy(){}
	
	public boolean zitErInA(int getal){
		//Tussen 0 en 2 mil, dus exc 0 en 2 mil
		long start = System.currentTimeMillis();
		checkNumber = 0;
		while(checkNumber < 2000000){
			checkNumber++;
			if(getal == checkNumber){
				truth = true;
			}
		}
		start = System.currentTimeMillis() - start;
		System.out.println("A:  "+start);
		return truth;
	}
	
	public boolean zitErInB(int getal){
		long start = System.currentTimeMillis();
		checkNumber=0;
		while(checkNumber < 2000000 ){
			checkNumber++;
			if(getal == checkNumber){
				start = System.currentTimeMillis() - start;
				System.out.println("B:  "+start);
				return true;
			}
		}
		start = System.currentTimeMillis() - start;
		System.out.println("C:  "+start);
		return false;
	}
	public static void main(String[] args){
		Easy easy = new Easy();
		easy.zitErInA(1230000);
		easy.zitErInB(120000);

	}
}

