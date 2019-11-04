
import Lab1_SB.Przedmiot;
import Lab1_SB.Sklep;
import Lab1_SB.Cena;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
public class Main {
    
    public static void create(EntityManager dbm, int choicecreat){
        Scanner scan3=new Scanner(System.in);
        switch(choicecreat){
            case(1):
                List<Przedmiot> list1=dbm.createNamedQuery("Przedmiot.findAll").getResultList();
                //int newID=list1.get(list1.size()-1).getIdPrzedmiotu() + 1;
                 int newID;
                 newID = list1.get(list1.size() - 1).getIdPrzedmiotu() + 1;
                String nazwa;
                
                    System.out.print("Podaj nazwe dodawanego przedmiotu: ");
                    nazwa=scan3.nextLine();
                
                if(nazwa.length() < 50 && nazwa.length() > 3){
                Przedmiot przedmiot = new Przedmiot(newID, nazwa);
                dbm.getTransaction().begin();
                dbm.persist(przedmiot);
                dbm.getTransaction().commit();
                System.out.println("Operacja przebiegla pomyslnie");
                }
                else
                    System.out.println("Bledna nazwa!");
                
                break;
            case(2):
                break;
            case(3):
                break;
            default:
                break;
        }
    }
    public static void read(EntityManager dbm, int choicecreat){
        if(choicecreat==1){
            System.out.println("\nTabela Przedmiot");
            List<Przedmiot> l1=dbm.createNamedQuery("Przedmiot.findAll").getResultList();
            for(Przedmiot przedmiot : l1){
                System.out.println(przedmiot.getIdPrzedmiotu() + ". " + przedmiot.getNazwa());
            }
            System.out.println("\n\n******************\n");
        }
        if(choicecreat==2){
            System.out.println("\nTabela Sklep");
            List<Sklep> l2=dbm.createNamedQuery("Sklep.findAll").getResultList();
            for(Sklep sklep : l2){
                System.out.println(sklep.getIdSklepu()+ ". " + sklep.getNazwa());
            }
            System.out.println("\n\n******************\n");
        }
        if(choicecreat==3){
            System.out.println("\nTabela Cena");
            List<Cena> l3 = dbm.createNamedQuery("Cena.findAll").getResultList();
            for (Cena cena : l3){
                System.out.println("ID Ceny:" +" "+ cena.getIdCeny()+"ID_ Pzedmiotu:" +" "+ cena.getIdPrzedmiotu()+"Sklep: "+" "+ cena.getIdSklepu()+"Cena: "+ cena.getCena() );
            }
            System.out.println("\n\n******************\n");
        }
        
    }
    
    public static void delete(EntityManager dbm, int choicecreat){
        Scanner scan4=new Scanner(System.in);
         if(choicecreat==1){
            System.out.println("\nTabela Przedmiot");
            List<Przedmiot> result1 = dbm.createNamedQuery("Przedmiot.findAll").getResultList();
             System.out.println("Podaj id przedmiotu ktory chcesz usunac");
            int id=scan4.nextInt();
            Przedmiot result2 = dbm.find(Przedmiot.class, id);
            dbm.getTransaction().begin();
            dbm.remove(result2);
            dbm.getTransaction().commit();
        }
        if(choicecreat==2){
            System.out.println("\nTabela Sklep");
           
            List<Sklep> result12 = dbm.createNamedQuery("Przedmiot.findAll").getResultList();
             System.out.println("Podaj id Sklepu ktory chcesz usunac");
            int id=scan4.nextInt();
            Sklep result22 = dbm.find(Sklep.class, id);
            dbm.getTransaction().begin();
            dbm.remove(result22);
            dbm.getTransaction().commit();
        }
        if(choicecreat==3){
            System.out.println("\nTabela Cena");
            List<Cena> result13 = dbm.createNamedQuery("Cena.findAll").getResultList();
             System.out.println("Podaj id Ceny ktora chcesz usunac");
            int id=scan4.nextInt();
            Cena result23 = dbm.find(Cena.class, id);
            dbm.getTransaction().begin();
            dbm.remove(result23);
            dbm.getTransaction().commit();
          
        }
    }
    
    private final static String persistenceUnitName = "com.mycompany_Lab1_SB_jar_1.0-SNAPSHOTPU";
    public static boolean stay = true; //if stay==false wyjdzie z petli 
    
    public static void main(String[] args){
        EntityManager dbm = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        while(stay){
            System.out.println("Dostepne akcje:");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update (niedostepny)");
            System.out.println("4. Delete ");
            System.out.print("Twoj wybor: ");
            int choice=scan1.nextInt();
            switch(choice){
                case(1):
                    System.out.println("Wybierz tabele:");
                    System.out.println("1. Przedmiot");
                    System.out.println("2. Sklep");
                    System.out.println("3. Cena");
                    System.out.print("Twoj wybor: ");
                    int choicecreat1 = scan2.nextInt();
                    create(dbm,choicecreat1);
                    break;
                case(2):
                    System.out.println("Wybierz tabele:");
                    System.out.println("1. Przedmiot");
                    System.out.println("2. Sklep");
                    System.out.println("3. Cena");
                    System.out.print("Twoj wybor: ");
                    int choicecreat2 = scan2.nextInt();
                    read(dbm,choicecreat2);
                    break;
                case(3):
                    
                    break;
                case(4):
                    int id;
                   System.out.println("Wybierz tabele z ktorej chcesz usunac rekord:");
                    System.out.println("1. Przedmiot");
                    System.out.println("2. Sklep");
                    System.out.println("3. Cena");
                    System.out.print("Twoj wybor: ");
                     int choicecreat3 = scan2.nextInt();
                    delete(dbm, choicecreat3);
                    break;
                default:
                    stay=false;
                    break;
                
            }
            
            
        }
        
    }
}
