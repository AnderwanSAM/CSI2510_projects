
/** CSI2510 Fall 2017 Laboratory 1: Algorithm Runtimes
 *
 * ==========================================================================
 * (C)opyright:
 *
 *    Lachlan Plant
 *    SITE, University of Ottawa
 *    800 King Edward Ave.
 *    Ottawa, ON, K1N 6N5
 *    Canada.
 *    http://www.site.uottawa.ca
 *
 *    Creator: lplant (Lachlan Plant)
 *    Email:   lplan053@uottawa.ca
 * ==========================================================================
 * $Log: Lab00.java,v $
 * Revision 1.0  2015/09/14 01:20:40  lplantRevision 1.1  2015/09/19 11:21:00  Lucia Moura
 */
import java.util.*;
import java.lang.*;

public class AlgAnalysis {

	/**
	 * Tests runtimes of Arrays.sort()
	 * Runs experiments to find the average time taken to sort arrays of n elements
	 * prints results directly
	 *
	 * @param  maxSize size of largest array to be tested
	 * @param  count number of arrays tested.
	 */
	public static void arraySortRuntime( int count, int maxSize ) {
		// add your code here (part 1)
		// add your code here (part 1)
		int count_cur = 1;
		// creer une liste pour se souvenir des valeurs de n qui seront generees
		List<Integer> n_generated = new ArrayList<Integer>();
		// Creer des variables pour contenir les informations sur les temps d'execution
		double []keep_track_RunTime = new double[maxSize];
		 Random r = new Random();
		// count fois faire :

		while (count_cur != count) {

		 //generer la taille du tableau
		 int taille_tableau = r.nextInt(maxSize);
		 n_generated.add(taille_tableau);
		 // generer un tableau
		 int [] tableau_test = new int[taille_tableau];
			tableau_test  = genArray(taille_tableau);
		 //afficher le numero du tableau tester //
		// System.out.println("Nous testons le " +  count_cur + " ieme  tableau");
		 //afficher la taille du tableau
		 //System.out.println("la taille de ce tableau est " +  taille_tableau);
		 //  10 fois faire :
		 double heure_debut =0;
		 double heure_fin =0;
		 double temps_execution = 0 ;
		 for (int i =0 ; i< 10; i++)
		 {
			 //melanger le tableau
			 randomizeArray(tableau_test);
			 //heure au debut
				heure_debut = nanoToSeconds(System.nanoTime());
			 //ordonner le tableau
			 java.util.Arrays.sort(tableau_test);
			 //heure a la fin
			 heure_fin = nanoToSeconds(System.nanoTime());
			 // calculer le temps d'execution
			 temps_execution = heure_fin - heure_debut;
			 //determiner s'il s'agit du temps d'execution maximum T(n) // mettre a jour le temops d'execution maximum le cas echeant

			 if(temps_execution > keep_track_RunTime[taille_tableau])
			 {
					keep_track_RunTime[taille_tableau] =  temps_execution;
				}

		 }
			count_cur++;
		}

		//afficher pour cette taille du tableau : n, T (n), T (n) / (n * n), T (n) / (n log(n))
		for (int i =0; i< n_generated.size(); i++)
		{
			System.out.println();	System.out.println();	System.out.println("================================================================================");
			System.out.println("n = " + n_generated.get(i));
			System.out.println(" T("+n_generated.get(i) + ")  = " + keep_track_RunTime[n_generated.get(i)] );
			System.out.println(" T ( " + n_generated.get(i) + ")/  " + (n_generated.get(i) * n_generated.get(i)) + " = " + (keep_track_RunTime[n_generated.get(i)] / (n_generated.get(i)*n_generated.get(i))) );
      System.out.println("T( " + n_generated.get(i) + ") / ( " + n_generated.get(i) + " log  ( " + n_generated.get(i) + ")  = " + (keep_track_RunTime[n_generated.get(i)] / (n_generated.get(i) * Math.log(n_generated.get(i)  ))));
      System.out.println("===============================================================================================");
      System.out.println();	System.out.println();

		}



	} /* arraySortRuntime */


	/**
	 * creates an array of size n, then tests the runtime of findDups1 using that array
	 *
	 * @param  n size of array
	 * @return time taken in nano seconds
	 */
	public static long unique1Runtime( int n ) {
		// add your code here (part 2)
		long temps_execution_unique1 =0;
		long heure_debut_unique1 = 0;
		long heure_fin_unique1=0;
		int [] tableau_test_unique1 = new int[n];
		//generer un tableau dont tous les elements sont differents
		tableau_test_unique1 = genArray(n);
		//Enregistrer l'heure de debut
		heure_debut_unique1 =  (long) nanoToSeconds(System.nanoTime());
		// Tester le tableau
	  boolean result = 	Unique1.unique1(tableau_test_unique1);
    // Enregistrer l'heure de fin
		heure_fin_unique1 = (long) nanoToSeconds(System.nanoTime());
		//calculer le temps d'execution
    temps_execution_unique1 = heure_fin_unique1 - heure_debut_unique1;

		return temps_execution_unique1;
	} /* unique1Runtime */


	/**
	 * creates an array of size n, then tests the runtime of findDups2 using that array
	 *
	 * @param  n size of array
	 * @return time taken in nano seconds
	 */
	public static long unique2Runtime( int n ) {
		// add your code here (part 2)
		// add your code here (part 2)
		long temps_execution_unique2 =0;
		long heure_debut_unique2 = 0;
		long heure_fin_unique2=0;
		int [] tableau_test_unique2 = new int[n];
		//generer un tableau dont tous les elements sont differents
		tableau_test_unique2= genArray(n);
		//Enregistrer l'heure de debut
		heure_debut_unique2 =  (long) nanoToSeconds(System.nanoTime());
		// Tester le tableau
		boolean result = 	Unique2.unique2(tableau_test_unique2);
		// Enregistrer l'heure de fin
		heure_fin_unique2 = (long) nanoToSeconds(System.nanoTime());
		//calculer le temps d'execution
		temps_execution_unique2 = heure_fin_unique2 - heure_debut_unique2;

		return temps_execution_unique2;
	} /* unique2Runtime */


	/**
	 * Generates an array of ins of size n
	 * Array contains values array[i]=i
	 *
	 * @param  n size of array
	 * @return ordered array
	 */
	private static int [] genArray( int n ) {
		int []    ret = new int [ n ];

		for( int i = 0; i < ret.length; i++ ) {
			ret [ i ] = i;
		}
		return ret;
	} /* genArray */


	/**
	 * Randomly shuffles an array
	 *
	 * @param  array array of ints to be shuffled
	 * @return      randomized array
	 */
	private static int [] randomizeArray( int [] array ) {
		Random    rng = new Random();

		for( int i = array.length - 1; i > 0; i-- ) {
			//rng.nextInt(N) returns random number between 0 and N-1 inclusive
			int    randomPosition = rng.nextInt ( i );
			int    temp           = array [ i ];

			array [ i ]              = array [ randomPosition ];
			array [ randomPosition ] = temp;
		}

		return array;
	} /* randomizeArray */


	/**
	 * Convert time in nanoseconds to seconds
	 *
	 * @param  time time in nanoseconds
	 * @return      time in seconds as a double
	 */
	private static double nanoToSeconds( long time ) {
		return (double) time / 1000000000.0;
	} /* nanoToSeconds */


	/**
	 * Main method
	 * Provides prompts for all experiments
	 */
	public static void main( String [] args ) {
		Scanner    scanner = new Scanner ( System.in );

		while( true ) {
			System.out.println ( "Enter 0 to test Arrays.sort(), 1 for unique, any other number to exit" );

			int    opt1 = scanner.nextInt();

			if( opt1 == 0 ) {
				System.out.println ( "Enter number of arrays to test" );

				int    count = scanner.nextInt();

				System.out.println ( "Enter largest array size" );

				int    n = scanner.nextInt();

				AlgAnalysis.arraySortRuntime ( count, n );
				System.out.println();
			}
			else
			if( opt1 == 1 ) {
				while( true ) {
					System.out.println ( "Enter 1 to test unique1, 2 for unique2, any other number to exit" );

					int    opt2 = scanner.nextInt();

					if( opt2 == 1 ) {
						System.out.println ( "Enter n value" );

						int    n = scanner.nextInt();

						System.out.println ( "Time Elapsed: " + AlgAnalysis.nanoToSeconds ( AlgAnalysis.unique1Runtime ( n ) ) + " secs" );
						System.out.println();
					}
					else
					if( opt2 == 2 ) {
						System.out.println ( "Enter n value" );

						int    n = scanner.nextInt();

						System.out.println ( "Time Elapsed: " + AlgAnalysis.nanoToSeconds ( AlgAnalysis.unique2Runtime ( n ) ) + " secs" );
						System.out.println();
					}
					else {
						System.out.println ( "End of Program!" );
						return;
					}
				}
			}
			else {
				System.out.println ( "End of Program!" );
				return;
			}

		}
	} /* main */


}
