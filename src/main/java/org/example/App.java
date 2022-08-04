package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HashMapImp<String, String> map = new HashMapImp();
        map.put("Anna", "Bay");
        map.put("Mira", "B");

        System.out.println(map.getValue("Mir"));
    }
}
