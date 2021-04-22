
/*
INFO 1102 - Hiver 2020
Devoir2 - Question 2
Nom : Andie Erwan Kiswendsida SAMADOULOUGOU
NI : A00200508
courriel : eas5957@umoncton.ca
*/


#include <iostream>
#include <string>
#include <fstream>
using namespace std;

template <typename unType>
struct unNoeud
{
	unType information;
	unNoeud<unType> *suivant;
	unNoeud() { suivant = NULL; } // initialiser le champ suivant a Null
};


struct unClient
{
	long tempArrivee;
	long dureeTransaction;
	unClient() :tempArrivee(0), dureeTransaction(0) {} // initialisation de client
};

template <typename unType>
class uneFile
{
private:
	unNoeud<unType> *Tete;
	unNoeud <unType> *Queue;
	unNoeud<unType> Guichet;  //creer le noueud bidon que l'on peut appeller Guichet ;)

public:
	uneFile()
	{
		Tete = &Guichet;
		Queue = Tete;
	}

	unNoeud<unType> *premier_noeud()
	{
		return Queue;
	}

	bool estVide()
	{
		return   Tete->suivant == NULL || Queue == Tete;
	}

	bool estPleine()
	{
		return false; // Version bidon (le monceau est énorme par rapport aux besoins de ce programme.)
	}

	void inserer(unType donnee)
	{
		// Pré-condition  : Cette méthode ne peut être appelée qui si la file n'est pas pleine.// Post-condition : La donnée sera mise dans un noeud qui se trouvera à la fin de la file.		//                  L'ordre des autres noeuds ne change pas.		// Réquisitionner un espace pour la nouvelle information.
		unNoeud<unType> *temporaire = new unNoeud<unType>;
		temporaire->information = donnee;
		temporaire->suivant = NULL;
     	// Il faut qu'à la fin, le pointeur Queue  indique le dernier noeud.			// Le dernier noeud a comme particularité que sont champ suivant contient l'adresse NULL.
		Queue->suivant = temporaire;
		Queue = temporaire; Queue->suivant = NULL; temporaire = NULL; delete temporaire;

	}

	void enlever(unType &donnee)
	{
		// Pré-condition  : Cette méthode ne peut être appelée qui si la file n'est pas vide.
		if (estVide())
		{
			cout << "Pas d'enlevement La file est  vide " << endl;
		}
		else
		{
			// Post-condition : La donnée sera récupérée du noeud qui se trouve au début de la file.
			unNoeud <unType> *temporaire = NULL; // = new unNoeud <unType>;
			// on recupere le noeud entier
			temporaire = Tete->suivant;
			// le noeud bidon pointe maintenant au deuxieme noeud
			Tete->suivant = temporaire->suivant;
			// rendre le noeud inutilise au monceau
			delete temporaire;
		}

	}

};

bool estClientArrive(double probabilite)
{
	if (probabilite < 0 || probabilite > 100) { return false; }
	else
	{
		double valeur = 100 * rand() / 32768;
		return valeur < probabilite;
	}
}

long obtenirDureeTransaction(long dureeMinimum, long dureeMaximum)
{
	if ((dureeMinimum > dureeMaximum) || (dureeMaximum > 480 || dureeMinimum < 0)) { return 0; }
	else
	{
		return dureeMinimum + rand() % (dureeMaximum - dureeMinimum + 1);
	}
}


void recuperer_informations(string &fichier, long &duree_max, long &duree_min, double   &probabilite)
{
	cout << endl << endl << "Veuillez entrer le nom du fichier comportant les informations : " << endl;
	cin >> fichier;
	ifstream lire(fichier, ios::in);
	lire >> probabilite;
	lire >> duree_max;
	lire >> duree_min;
	lire.close();

}

void triABulles(long T[], long debut, long fin)
{
	long stock; // une variable ''intermediaire'' pour stocker une des valeurs lors de l'echange
	for (long i = fin; i > debut; i--) // pour balayer l'intervalles le (nombre d'elements-1) fois ---rendu a ce niveau , la premiere valeur est forcement la plus petite
	{
		for (long k = debut + 1; k <= fin; k++) // balayage
		{
			if (T[k - 1] > T[k]) { stock = T[k - 1]; T[k - 1] = T[k]; T[k] = stock; }//
		}
	}
}

int main()
{
	// variables et initialisations
	uneFile <unClient> file;
	unClient client;
	unClient guichet;
	double probabilite = 0, duree_moyenne = 0, duree_moyenne_de_transaction = 0;
	long heure_horloge = 0, duree_max = 0, duree_min = 0, nb_de_clients = 0, plus_court_temps = 0, plus_long_temps = 0, plus_courte_duree_transaction = 0, plus_longue_duree_transaction = 0; string nom_fichier;
	long Attente[1000]; long Transactions[1000]; long somme_attentes = 0; long somme_transactions = 0;
	for (long i = 0; i < 1000; i++) { Attente[i] = Transactions[i] = 0; }
	short enlevement = 0;

	// recuperer les informations
	recuperer_informations(nom_fichier, duree_max, duree_min, probabilite);

	cout << endl << endl << "|||||||||||   Debut  de la simulation  ||||||||||||" << endl;
	// creer le premier client  au complet et l'inserer
	client.dureeTransaction = obtenirDureeTransaction(duree_min, duree_max); client.tempArrivee = 0;
	somme_transactions += client.dureeTransaction;
	file.inserer(client);

	//initialiser le curseur et certaines variables  // le curseur nous permettra de nous  balader dans la file sans toucher les private members
	unNoeud <unClient> * curseur = file.premier_noeud();
	nb_de_clients += 1; long compteur = 0;
	bool ajout = false;

	//client : (0, 0);

	while (heure_horloge <= 480 || (file.estVide() == false))
	{

		// calculer la duree d'attente et prendre la duree de transaction  et ajouter dans les tableaux
		Attente[compteur] = heure_horloge - curseur->information.tempArrivee;
		Transactions[compteur] = curseur->information.dureeTransaction; compteur++;

		guichet = curseur->information;

		somme_transactions += guichet.dureeTransaction;
		somme_attentes += (heure_horloge - guichet.tempArrivee);

		if ( (heure_horloge- guichet.tempArrivee) > duree_max) { duree_max =heure_horloge -  guichet.tempArrivee; }
		else { if ((heure_horloge - guichet.tempArrivee) < duree_min) { duree_min = heure_horloge - guichet.tempArrivee; } }
		if (guichet.dureeTransaction > plus_longue_duree_transaction) { plus_longue_duree_transaction = guichet.dureeTransaction; } else {	if (guichet.dureeTransaction < plus_courte_duree_transaction) { plus_courte_duree_transaction = guichet.dureeTransaction; }		}

		// tant que la duree de transaction n'est pas ecoulee , il y a un client . Alors ,
		while (guichet.dureeTransaction != 0)
		{
			if (heure_horloge > 480) { ajout = estClientArrive(-1); }// si heure > 480 ; probabilite = -1;  // on s'assure qu'aucun client ne sera ajouté puisque la probabilité est negative (ajout = false )
			else { ajout = estClientArrive(probabilite); } // ajout ??
			if (ajout == true) //si on a true, on cree un client  au complet et on l'insere
			{
				client.dureeTransaction = obtenirDureeTransaction(duree_min, duree_max); client.tempArrivee = heure_horloge;
				file.inserer(client); nb_de_clients++; client.dureeTransaction = 0; client.tempArrivee = 0;
			}
		  guichet.dureeTransaction--; heure_horloge++; // reduire le temps de transaction 	du client au guichet 	// incrementer le temps sur l'horloge
		}

		// quand le client a fini , on l'enleve et on augmente le nombre de client 	// prendre l'adresse du noueud suivant pour curseur
		unNoeud<unClient> *temporaire; temporaire = curseur->suivant; // noueud temporaire pour garder l'adresse du noeud suivant ;
		enlevement += 1;
		file.enlever(guichet);
		curseur = temporaire; // on affecte a curseur l'adresse du noueud suivant
		//nb_de_clients++; // on incremente le nombre de client
		if (curseur == NULL) { break; } // si le curseur est a NULL , alors la file est vide; pas la peine de continuer
	}
	// calculer les stats et les afficher

	// ordonner les tableaux
	triABulles(Attente, 0, compteur);
	triABulles(Transactions, 0, compteur);

	// les stats
	duree_max = Attente[compteur]; duree_min = Attente[0]; plus_courte_duree_transaction = Transactions[0]; plus_longue_duree_transaction = Transactions[compteur];
	long somme = 0;
	for (short i = 0; i <= compteur; i++) { somme += Attente[i]; }
	duree_moyenne = somme / nb_de_clients;
	somme = 0;
	for (short i = 0; i <= compteur; i++) { somme += Transactions[i]; }
	duree_moyenne_de_transaction = somme / nb_de_clients;

	// affichage des stats
	cout << endl << endl << "|||||||||||   Fin de la simulation  ||||||||||||" << endl;
	cout << endl << "Voici les statistiques : " << endl;
	cout << endl << "Nombre de clients  : " << nb_de_clients << endl;
	cout << endl << "|||||||||||||||||||||||||||||||||||||||" << endl << " Duree moyenne d'attente : " << duree_moyenne << endl;
	cout << endl << "Plus courte duree d'attente : " << duree_min << endl;
	cout << endl << "Plus grande duree d'attente : " << duree_max << endl;
	cout << endl << "|||||||||||||||||||||||||||||||||||||||" << endl << "Duree moyenne de transaction : " << duree_moyenne_de_transaction << endl;
	cout << endl << "Plus courte duree de transaction : " << plus_courte_duree_transaction << endl;
	cout << endl << "Plus longue  duree de transaction : " << plus_longue_duree_transaction << endl;
	cout << endl << "Heure sur l'horloge : " << heure_horloge << endl;


}
