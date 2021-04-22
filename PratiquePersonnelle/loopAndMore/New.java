import java.util.*;


class Book
{
  public Book(String a)
  {
    title = a;
  }
  private String title ;
  public void  Hello(){ System.out.println(title);}
}

public class New
{

 public static void main(String[] args) {
Book mybook = new Book("OKK");
mybook.Hello();
}


}
