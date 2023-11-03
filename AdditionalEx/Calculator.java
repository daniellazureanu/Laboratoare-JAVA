import java.util.Scanner;

public class AdditionalEx{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		double answer = 0.0, dfnum, dsnum;
		int cont = 0;
		String fnum = "";
		String snum = "";
		char symbol = 0;

		/*PARCURGEREA INPUTULUI NOSTRU*/
		for(int i=0; i<input.length(); i++){
			/***************************************************
			*DACA CARACTERUL ESTE O CIFRA SAU UN PUNCT,		   *
			*ACESTA ESTE ADAUGAT INTR-O VARIABILA DE TIP STRING*
			*FORMAND PRIMUL NUMAR IN ACEAST STRING 			   *
			****************************************************/
			if(Character.isDigit(input.charAt(i)) || input.charAt(i)=='.'){
				fnum+=input.charAt(i);
			}

			/****************************************************************
			*DACA CARACTERUL ESTE UN SEMN DE OPERATIE                       * 
			*SEMNUL DE OPERATIE ESTE STOCAT INTR-O VARIABILA DE TIP CHAR 	*
			*POZITIA IN CARE PARCUREGEREA S-A OPRIT SE STOCHEAZA INTR-UN INT*
			*SI PARCUGEREA INPUTULUI NOSTRU SE OPRESTE 						* 
			*****************************************************************/
			else if(input.charAt(i)=='+' || input.charAt(i)=='-' || input.charAt(i)=='/' || input.charAt(i)=='*'){
				symbol=input.charAt(i);
				cont = i+1;
				break;
			}
		}

		/***********************************************
		*SE INCEPE DIN NOU PARCURGEREA 				   *
		*DIN LOCUL IN CARE S-A OPRIT 				   *
		*SI SE STOCHEAZA RESTUL DE CIFRE INTR-UN STRING*
		*FORMAND AL DOILEA NUMAR					   *
		************************************************/
		for(int i=cont; i<input.length(); i++){
			snum+=input.charAt(i);
		}

		/***************************************
		*STRINGURILE CE CONTIN CELE DOUA NUMERE*
		*SE CONVERTESC IN DOUBLE 			   *	
		****************************************/
		dfnum = Double.parseDouble(fnum);
		dsnum = Double.parseDouble(snum);

		/****************************************
		*SE VERIFICA SEMNUL DE OPERATIE 	    *
		*SI SE APLICA OPERATIA CELOR DOUA NUMERE*
		*****************************************/
		switch(symbol){
			case '+':
				answer=dfnum+dsnum;
				break;
			case '-':
				answer=dfnum-dsnum;
				break;
			case '/':
				answer=dfnum/dsnum;
				break;
			case '*':
				answer=dfnum*dsnum;
				break;
			default:
				System.out.println("Error");
				System.exit(0);
		}

		//DACA RASPUNSUL ESTE INTREG SE VA AFISA RASPUNSUL INTREG
		if(answer==(int)answer){
			System.out.println((int)answer);
		}
		//DACA RASPUNSUL ESTE DOUBLE SE VA AFISA RASPUNSUL CA DOUBLE
		else{
			System.out.println(answer);		
		}
	}	
}