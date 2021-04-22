//package loopAndMore;
import java.util.*;

class EssaiClass
{

  public EssaiClass(int a , long b, String c)
  {
    nb = a ; nbl = b; mot = c;
  }

int nb;
long nbl;
 String mot;

 }

 class Animal
 {
   public String nom ;
   public int nb_de_pattes ;
   public Animal(String a , int b )
   {
     nom = a ; nb_de_pattes = b;
   }

 }

class Oiseau extends Animal
{
  public Oiseau(String a , int b )
  {
    nom = a ; nb_de_pattes = b;
  }
//super  (nom,nb_de_pattes);
  public void presenter()
  {
    System.out.println("Je suis un " + this.nom + "et j'ai " + this.nb_de_pattes + "pattes" );
  }
}

public  class loop {



public static void  main(String[] args)
{
  //String name = "Andie";
  //System.out.println(name);
  for (int i =0 ; i<20;i++)
  {
      System.out.println("====");
  }
  System.out.println("===================");
  System.out.println("===================");

  //EssaiClass  essai1 = new  EssaiClass(0,1,"hum");
// System.out.println( essai1.nb + essai1.nbl + essai1.mot );
}



}
