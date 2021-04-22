class Main {

	static
	int number ;
	static int n ; // n =7;
	static int Length[] = new int[] {2500,3000,1000,1000,1500,700,800};
	static int L = 5000; static int bestK=-1; static int bestX[] = new int[n+1];static int currX []= new int[n+1];
	public static boolean visited[][] = new boolean[n+1][L+1];

	// Variables globales
	public static ArrayList<Integer> bestKN = new ArrayList<Integer>();
	public static ArrayList<int[]> bestXN = new ArrayList<int[]>();
	public static ArrayList<int[]> currXN = new ArrayList<int[]>();
	public static ArrayList<int[]>lengthN = new ArrayList<int[]>();
	public static ArrayList<Integer>LN = new ArrayList<Integer>();

	//un tableau de listes chainees pour garder en memoire les etats deja visités
	//public static ArrayList<Integer> Liste[] = new ArrayList[n +1 ];
	public static ArrayList<ArrayList<Integer>> Liste = new ArrayList<>();




	/*public static boolean Verifier_etat(ArrayList<Integer>L[],int a, int b)
	{
		if(L[a].size() ==0)
		{
			return false ;
		}
		else //rechercher parmi les elements afin
		{
			for(int i =0 ; i <L[a].size();i++)
			{
				if (L[a].get(i) == b) {return true ;}
			}
			return false;
		}

	}*/
			public static boolean Verifier_etat(ArrayList<ArrayList<Integer>>L,int a, int b)
			{
				if(L.get(a).size() ==0)
				{
					return false ;
				}
				else //rechercher parmi les elements afin
				{
					for(int i =0 ; i <L.get(a).size();i++)
					{
						if (L.get(a).get(i) == b) {return true ;}
					}
					return false;
				}

			}


	public static void BackTrackSolve(int currK,int currS)
	{
		if(currK>bestK) {bestK= currK; bestX=currX;}
		if(currK<n)
		{

			//if((currS>= Length[currK]) && !visited[currK+1][currS - Length[currK]])
			if((currS>= Length[currK]) && !Verifier_etat(Liste,currK+1,currS-Length[currK]));
			{
				//System.out.println("hey" + currK);
				currX[currK] = 1;
				int newS = currS-Length[currK];
				BackTrackSolve(currK+1,newS);
				//visited[currK+1][newS] = true;
				//Liste[currK+1].add(newS);
				Liste.get(currK+1).add(newS);
			}
			//determiner l'espace restant du cote droit
			int somme_vehicules_embarques =0;
			for(int i =0 ; i<currK;i++ ) {somme_vehicules_embarques += Length[i];}
			int espace_restant_droite = L- (somme_vehicules_embarques - (L - currS));
			//if(espace_restant_droite >= Length[currK] && !visited[currK+1][currS])
			if(espace_restant_droite >= Length[currK] && !Verifier_etat(Liste,currK+1,currS))
			{
				currX[currK]=0;
				BackTrackSolve(currK+1,currS);
				//visited[currK+1][currS] = true;
				//Liste[currK+1].add(currS);
				Liste.get(currK+1).add(currS);
			}
		}
	}

	public static void Execute()
	{

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		for(int i =0 ; i < n+1 ; i++)
		{
			Liste[i] = new ArrayList<Integer>();
		}
		for(int i =0 ;i < n+1; i++)
		{
			bestX[i] = currX[i] = -1;
		}

		BackTrackSolve(0,L);
		for (int i =0 ;  i < bestK-1; i++)
		{
			System.out.println(bestX[i]);
		}
		*/
		Recuperer_donnees();
	//	Lire();


		//for(int )
		//Recuperer_donnees();

		for(int i =0 ; i < number ; i++) //pour chaque file de vehicules
		{

			//attribuer aux variables globales les variables de la file de vehicules en traitement

			Length = lengthN.get(i);

			L = LN.get(i);


			//bestK = bestKN.get(i);
			//System.out.println("hey");
			//bestX = bestXN.get(i);
			//System.out.println("hey");
			n = Length.length;
			currX = new int[n+1];
			bestX = new int[n+1];
			for(int j =0 ;j < n+1; j++)
			{
				bestX[j] = currX[j] = -1;
			}
			bestK = -1;
			for(int u =0 ; u < n+1 ; u++)
			{
				Liste.add(new ArrayList<Integer>()); //  = new ArrayList<Integer>();
			}
			//Liste = new ArrayList[n+1];
			//Liste = new ArrayList<Integer>[n+1];
			//System.out.println("hey");


			//backtracksolving
			BackTrackSolve(0,L);
			//mettre a jour
			bestXN.add(bestX);
			currXN.add(currX);
			//
			//PrintWriter writer = new PrintWriter(new FileWriter(("output.txt"),true));
		//	writer.println(bestK-1);
			System.out.println(bestK-1);
			for (int k =0 ;  k < bestK-1; k++)
			{
				if (bestX[k] == 1 )
				{
					System.out.println("port");
				//	writer.println("port");
				}
				else
				{
					System.out.println("starboard");
				//	writer.println("starboard");
				}
				//System.out.println(bestX[k]);
			}
			//writer.println();
			System.out.println();
			//
		//	writer.close();
		}

	}

	public static void Recuperer_donnees() throws IOException
	{
		//InputStreamReader isr = new InputStreamReader(System.in);

		Scanner input = new Scanner(System.in);
		/*String e = "";//input.nextLine();
		int a = input.nextInt();

		for(int i =0 ; i < a; i++)
		{
			int b = -1;;
			while(input.hasNextInt() && b !=0)
			{

				b=input.nextInt();
				System.out.println("b ="+b);
			}

		}
		*/
		//number = Integer.parseInt(e);
		number = input.nextInt();

		for(int i =0 ; i < number ; i++) // pour les n files de vehicules
		{
			int a = input.nextInt();
			LN.add(a*100);//lire la longueur du traversier et la convertir en metres
			int jeton= -1;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			while(input.hasNextInt() && jeton !=0)
			{
				jeton = input.nextInt();


				if(jeton == 0 )
				{
					break ;
				}
				else
				{
					temp.add(jeton);
				}


			}


			int t[] = new int[temp.size()];

			for (int j =0 ; j< temp.size();j++) //pour chaque tableau de vehicules associees a une file
			{
				t[j] = temp.get(j); //initialisation

			}
			lengthN.add(t);



		}
		//initialisalisation des variables locales



	}

	public static void Lire() throws IOException
	{

		BufferedReader in = new BufferedReader(new FileReader("input2.txt"));
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		number = Integer.parseInt(line);
		//System.out.println(nombre_de_file);
		int longueur_traversier;
		//creer une liste pour les vehicules
		ArrayList<Integer> liste ; //= new ArrayList<Integer>();
		for(int i =0 ; i< number; i++)
		{
			liste = new ArrayList<Integer>();
			//lire la longueur du traversier
			String jeton = "";
			jeton = in.readLine();
			jeton = in.readLine();

			longueur_traversier = Integer.parseInt(jeton);
			LN.add(longueur_traversier*100);
			int a = -1 ;
			//tant que ce n'est pas 0, enregistrer les reponses
			while( a != 0)
			{
				//lire le jeton
				jeton = in.readLine();
				//le convertir en integer
				a = Integer.parseInt(jeton);
				if(a == 0) { break ;}
				liste.add(a);
			}

			int t[] = new int[liste.size()];

			for (int j =0 ; j< liste.size();j++) //pour chaque tableau de vehicules associees a une file
			{
				t[j] = liste.get(j); //initialisation

			}
			lengthN.add(t);
			/*for(int j =0 ; j < liste.size(); j++)
			{
				System.out.println(liste.get(j));
			}*/
			liste = null;
			//System.out.println("----");
		}

		/*while ((line = in.readLine()) != null)
		{
	      // Afficher le contenu du fichier
			  System.out.println (line);
		}*/
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
