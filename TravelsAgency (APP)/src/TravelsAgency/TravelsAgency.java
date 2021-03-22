package TravelsAgency;

//PAQUETS IMPORTATS PER AL FUNCIONAMENT DE L'APLICACIO

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

//INICI DEL FUNCIONAMENT DE L'APLICACIO

public class TravelsAgency {
    
    static Scanner teclat = new Scanner (System.in);
    static String opcio;
    static String email;
    
    public static void main (String[] args) {

Scanner teclat = new Scanner(System.in);

boolean sortir=false;
String opcio;


//MENU DE L'APLICACIO

while (!sortir) {
    System.out.println("=========================== MENU PRINCIPAL ===========================");
    System.out.println("|                                                                    |");
    System.out.println("|         _____  ______   ______          _____        _____         |");
    System.out.println("|           |    |     | |      | |    | |      |     |_____         |");
    System.out.println("|           |    |_____| |______| |    | |----  |           |        |");
    System.out.println("|           |    |    |  |      | |____/ |_____ |____  _____|        |");
    System.out.println("|         _____   _____   _____         _____                        |");
    System.out.println("|        |     | |     | |      | :  | |       |  /                  |");
    System.out.println("|        |_____| |  ___  |----  |  : | |       |/                    |");
    System.out.println("|        |     | |_____| |_____ |   :| |_____  |                     |");
    System.out.println("|            ______                                                  |");
    System.out.println("|            _| _~-|___                                              |");
    System.out.println("|    =  = ==(____AA____D                                             |");
    System.out.println("|                |_____|___________________,-~~~~~~~`-.._            |");
    System.out.println("|                /     o O o o o o O O o o o o o o O o  ||_          |");
    System.out.println("|                `~-.__        ___..----..                  )        |");
    System.out.println("|                      `---~~|___________/------------`````          |");
    System.out.println("|                      =  ===(_________D                             |");
    System.out.println("|                                                                    |");
    System.out.println("|                             1. INICI                               |");
    System.out.println("|                             2. PRODUCTES                           |");
    System.out.println("|                             3. OFERTES                             |");
    System.out.println("|                             4. COMANDES                            |");
    System.out.println("|                             5. CLIENTS                             |");
    System.out.println("|                             6. SORTIR                              |");
    System.out.println("|                                                                    |");
    System.out.println("======================================================================");

    opcio=teclat.next();
    
    
    //OCIONS DEL MENU PER CRIDAR CADA METODE

    switch (opcio.charAt(0)){
        
                case '1':
                    System.out.println("Has triat l'opcio 1");
                    break;
                case '2':
                    productes();
                    break;
                case '3':
                    ofertes();
                    break;
                case '4':
                    factures();
                    break;
                case '5':
                    clients();
                    break;
                case '6':
                    System.out.println("Fins una altra.");
                    sortir=true;
                    break;
        
                default:
                    System.out.println("FORMAT ERRONI");
            }
    
        }

    }
    
    //L'OPCIO DE PRODUCTES MOSTRA TOTS ELS PRODUCTES
    
    private static void productes(){
                    
                    System.out.println("Estas accedint a PRODUCTES");
                    try{
                        
                    //FEM LA CONNEXIÓ AMB LA BD    
                
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                    //Class.forName("com.mysql.jdbc.Driver"); 
                    System.out.println("MOSTRANT TOTS ELS PRODUCTES..."); 
                    
                    //COMANDA PER A MOSTRAR TOTS ELS PRODUCTES
                    
                    String query = "SELECT * FROM productes";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    
                    //ESTRUCTURA DE LA TAULA ON ES MOSTRARAN ELS PRODUCTES
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%-20s %-50s %-40s %-25s %-25s", "ID PRODUCTE", "PRODUCTE", "LOCALITZACIÓ", "CONCEPTE", "PREU");
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

                    while (rs.next())
                    {
                      int id_producte = rs.getInt("id_producte");
                      String nom_producte = rs.getString("nom_producte");
                      String localitzacio = rs.getString("localitzacio");
                      String concepte = rs.getNString("concepte");
                      String preu = rs.getString("preu");
                      
                      System.out.format("%-20s %-50s %-40s %-25s %-25s\n", id_producte, nom_producte, localitzacio, concepte, preu + "€");
                    }
                    st.close();
                    
                    }
                    catch (Exception e)
                    {
                    System.err.println("Got an exception! ");
                    e.printStackTrace();
                    }
                   
                    //SORTIM DE L'APARTAT PRODUCTES
                    
                    System.out.println("\nApreta RETURN per sortir....");
                    
                    teclat.nextLine();
    }
    
    //FUNCIONAMENT PART OFERTES
    
    private static void ofertes(){
                    
                    System.out.println("Estas accedint a OFERTES");
                    try{
                
                    //CONNEXIÓ A LA BD
                        
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                    //Class.forName("com.mysql.jdbc.Driver"); 
                    System.out.println("MOSTRANT TOTES LES OFERTES...");      
                    
                    //COMANDA PER A MOSTRAR TOTES LES OFERTES QUE OFERIM
                    
                    String query = "SELECT * FROM ofertes";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    
                    //ESTRUCTURA DE LA TAULA ON ES MOSTREN LES OFERTES
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%-20s %-50s", "ID OFERTES", "TIPUS");
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

                    while (rs.next())
                    {
                      int id_oferta = rs.getInt("id_oferta");
                      String tipus = rs.getString("tipus");
                      
                      System.out.format("%-20s %-50s\n", id_oferta, tipus);
                    }
                    st.close();
                    
                    }
                    catch (Exception e)
                    {
                    System.err.println("Got an exception! ");
                    e.printStackTrace();
                    }
                    
                    //SORTIM DE L'APARTAT OFERTES
                    
                    System.out.println("\nApreta RETURN per sortir....");
                    
                    teclat.nextLine();
    }
    
    //FUNCIONAMENT PART DE LES FACTURES
    
    private static void factures(){
                    System.out.println("Estas accedint a COMANDES");
                    try{
                        
                    //CONNEXIÓ A LA BD
                
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                    //Class.forName("com.mysql.jdbc.Driver"); 
                    System.out.println("MOSTRANT TOTES LES COMANDES..."); 
                    
                    //COMANDA PER A MOSTRAR TOTES LES COMANDES
                    
                    String query = "SELECT * FROM comandes";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    
                    //ESTRUCTURA DE LA TAULA ON ES MOSTREN FACTURES
                    
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%-20s %-25s %-25s %-25s %-25s %-25s", "ID COMANDA", "ID CLIENT", "NOM", "COGNOM", "PARÀMETRES COMANDA", "DATA DE COMANDA");
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------------------------------------------");

                    while (rs.next())
                    {
                      int id_comanda = rs.getInt("id_comanda");
                      String comandes = rs.getString("productes");
                      String data_comanda = rs.getString("data_comanda");
                      String id_client = rs.getString("id_client");
                      String lname = rs.getString("lname");
                      String fname = rs.getString("fname");
                      
                      System.out.format("%-20s %-25s %-25s %-25s %-25s %-25s\n", id_comanda, id_client, lname, fname, data_comanda, comandes);
                      
                      //System.out.println(mem_id);
                      
                    }
                    st.close();
                    
                    }
                    catch (Exception e)
                    {
                      System.err.println("Got an exception! ");
                      e.printStackTrace();
                    }
                    
                    //MENU QUE TROBEM A DINTRE DE L'APARTAT DE FACTURES
                    
                    System.out.println("Apreta D per eliminar comandes....");
                    System.out.println("Apreta F per facturar comandes....");
                    System.out.println("Apreta V per validar DNI....");
                    System.out.println("Apreta W per validar EMAIL....");
                    System.out.println("Apreta E per continuar....");
                    opcio=teclat.next();
                    boolean sortir=false;
                    switch(opcio.charAt(0)){
                        
                        //FUNCIO PER A ELIMINAR COMANDES REALITZADES
                        
                        case 'D':
                            System.out.println("Escriu el ID de comanda a eliminar:");
                            
                            //CONNEXIÓ A LA BD
                            
                            try{
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                                
                                //COMANDA PER A ELIMINAR LA COMANDA

                                String query = "DELETE FROM comandes WHERE id_comanda = ?";
                                PreparedStatement st = conn.prepareStatement(query);
                                opcio = teclat.next();
                                System.out.println("Eliminant comanda: " + opcio);
                                st.setInt(1, Integer.parseInt(opcio));
                                
                                st.executeUpdate();
                            }
                            catch (Exception e)
                            {
                            System.err.println("Got an exception! ");
                            e.printStackTrace();
                            }
                        break;
                        
                        //FUNCIO PER A CREAR LA FACTURA
                        
                        case 'F':
                        System.out.println("Escriu el ID de comanda a facturar:");
                        try{    
                            
                            //CONNEXIÓ A LA BD
                            
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                            int client = teclat.nextInt();
                           
                            //COMANDA PER AGAFAR DE LA BD TOTS ELS CAMPS QUE VOLEM MOSTRAR A LA FACTURA
                            
                            String query = "SELECT * FROM comandes, member, productes WHERE comandes.id_client = member.mem_id AND id_comanda = ? AND productes = id_producte";
                            PreparedStatement st = conn.prepareStatement(query);
                            
                            
                            st.setInt(1, client);
                            
                            ResultSet rs = st.executeQuery();
                            
                            //ESTRUCTURA DE LA FACTURA
                            
                            while (rs.next())
                            {
                              int id_comanda = rs.getInt("id_comanda");
                              int id_client = rs.getInt("id_client");
                              String lname = rs.getString("lname");
                              String fname = rs.getString("fname");
                              String address = rs.getString("address");
                              String iban = rs.getString("iban");
                              int productes = rs.getInt("productes");
                              Date data_comanda = rs.getDate("data_comanda");
                              int mem_id = rs.getInt("mem_id");
                              String nom_producte = rs.getString("nom_producte");
                              String localitzacio = rs.getString("localitzacio");
                              String concepte = rs.getString("concepte");
                              int preu = rs.getInt("preu");
                              
                            java.util.Date fecha = new java.util.Date();
                            System.out.println (fecha);   
                            
                            FileWriter fw = new FileWriter("D:\\factura"+ id_comanda + ".txt",true);
                            BufferedWriter bf = new BufferedWriter(fw);
                            PrintWriter escritor = new PrintWriter(bf);

                            escritor.println("DADES DEL CLIENT");
                            escritor.println("────────────────────────────");
                            escritor.println("");
                            escritor.println("\tID DE CLIENT: " + id_client);
                            escritor.println("\tNOM: " + lname);
                            escritor.println("\tCOGNOM: " + fname);
                            escritor.println("\tEMAIL: " + address);
                            escritor.println("\tIBAN: " + iban);
                            escritor.println("");
                            
                            escritor.println("DADES DE LA COMANDA");
                            escritor.println("────────────────────────────");
                            escritor.println("");
                            escritor.println("\tNÚMERO COMANDA: " + id_comanda);
                            escritor.println("\tDATA DE LA COMANDA: " + data_comanda);
                            escritor.println("");
                            escritor.println("");
                            escritor.println("DETALLS DE LA COMANDA");
                            escritor.println("────────────────────────────");
                            escritor.println("");
                            escritor.println("\t════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
                            escritor.println("\tID DE PRODUCTE\t\tNOM DEL PRODUCTE\t\t\tLOCALITZACIO\t\tCONCEPTE\t\t\tPREU");
                            escritor.println("\t════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
                            escritor.println("\t" + productes + "\t\t\t" + nom_producte + "\t\t\t\t" + localitzacio + "\t\t\t" + concepte + "\t\t\t\t" + preu + "€");
                            escritor.println("");
                            escritor.println("\t════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
                               
                            //FORUMLA PER A APLICAR EL IVA
                            
                            double calculiva, total, sumapreu;
                            sumapreu = preu;
                            double iva = 16;
                            calculiva = (sumapreu * iva) / 100;
                            total = sumapreu + calculiva;
                                                        
                            escritor.println("");
                            escritor.println("\tTOTAL:" + sumapreu + "€");
                            escritor.println("\tIVA:" + calculiva + "€");
                            escritor.println("");
                            escritor.println("\tTOTAL A PAGAR:" + total + "€");

                            escritor.close();
                            }
                            st.close();
                            System.out.println("Finalitzat!");
                            
                        }catch (Exception e){
                            System.out.println(e);
                            e.printStackTrace();
                        }    
                        break;
                        
                        //FUNCIÓ PER A VALIDAR EL DNI
                        
                        case 'V':
                        System.out.println("Has seleccionat validar el DNI, introdueix el DNI");
                        System.out.println("Introdueix el seu DNI");                        
                        String dni=teclat.next();
                        boolean dniCorrecte = true;
                        char lletracalc = 0;
                        
                        if (dni.length()!= 9){
                            System.out.println("El DNI no conte 9 caracters");
                        }else{
                            
                            //MIREM QUE L'ULTIM DIGIT SIGUI UNA LLETRA
                            
                            char ult = dni.charAt(dni.length()-1);
                            
                            if (ult>='a' && ult<='z'){
                                ult-=32;
                            }
                            
                            if (ult>='A' && ult<='Z'){
                                
                                for (int i=0; i<8; i++){
                                    if (dni.charAt(i) <'0' || dni.charAt(i)>'9'){
                                        System.out.println("Les 8 primeres posicions han de ser numeros");
                                        dniCorrecte=false;
                                        break;
                                    }
                                }
                                if (dniCorrecte){
                                    
                                    //VALIDEM FORMULA
                                    
                                    dni = dni.substring(0, dni.length()-1);
                                    
                                    //CONVERTIM STRING A INT
                                    
                                    int dniInt = Integer.parseInt(dni);
                                                                        
                                    int reste = dniInt % 23;

                                    switch (reste){
                                        case 0: lletracalc = 'T'; break;
                                        case 1: lletracalc = 'R'; break;
                                        case 2: lletracalc = 'W'; break;
                                        case 3: lletracalc = 'A'; break;
                                        case 4: lletracalc = 'G'; break;
                                        case 5: lletracalc = 'M'; break;
                                        case 6: lletracalc = 'Y'; break;
                                        case 7: lletracalc = 'F'; break;
                                        case 8: lletracalc = 'P'; break;
                                        case 9: lletracalc = 'D'; break;
                                        case 10: lletracalc = 'X'; break;
                                        case 11: lletracalc = 'B'; break;
                                        case 12: lletracalc = 'N'; break;
                                        case 13: lletracalc = 'J'; break;
                                        case 14: lletracalc = 'Z'; break;
                                        case 15: lletracalc = 'S'; break;
                                        case 16: lletracalc = 'Q'; break;
                                        case 17: lletracalc = 'V'; break;
                                        case 18: lletracalc = 'H'; break;
                                        case 19: lletracalc = 'L'; break;
                                        case 20: lletracalc = 'C'; break;
                                        case 21: lletracalc = 'K'; break;
                                        case 22: lletracalc = 'E'; break;
                                    }
                                    
                                    if (ult != lletracalc){
                                        System.out.println("DNI incorrecte");
                                    }else{
                                        System.out.println("DNI correcte");
                                    }
                                }
                            }else{
                               System.out.println("La ultima posicio ha de ser una lletra");                 
                            }  
                        }
                        break;
                        
                        //VALIDAR EMAIL CRIDANT LA FUNCIÓ
                        
                        case 'W':
                            System.out.println("Escriu email a validar: ");
                            String email = teclat.next();
                            if (emailValidar(email)) {
                                System.out.println("Email correcte");
                            }else{
                                System.out.println("Emal incorrecte");
                            }
                            break;
                            
                        //TORNAR AL MENU PRINCIPAL
                            
                        case 'E':  
                            sortir = true;
                        break;
                    }

                  System.out.println("\nApreta RETURN per sortir....");
                  teclat.nextLine();
    }
    
    //FUNCIONAMENR DE LA PART DELS CLIENTS
    
    private static void clients(){
                    
                    System.out.println("Estas accedint a CLIENTS");
                    try{
                
                    //CONNEXIÓ A LA BD
                        
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelsagency", "root", "");
                    System.out.println("MOSTRANT LES DADES DELS CLIENTS...");                  
                    
                    //COMANDA PER A MOSTRAR ELS CLIENTS
                    
                    String query = "SELECT * FROM member";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    
                    //ESTRUCTURA DE LA TAULA ON ES MOSTREN ELS CLIENTS
                    
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.format("%-10s %-15s %-20s %-20s %-20s %-25s %-25s", "ID CLIENT", "USUARI", "CONTRASENYA", "NOM", "COGNOM", "ADREÇA", "IBAN BANCARI");
                    System.out.println("");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");

                    while (rs.next())
                    {
                      int mem_id = rs.getInt("mem_id");
                      String username = rs.getString("username");
                      String password = rs.getString("password");
                      String lname = rs.getString("lname");
                      String fname = rs.getString("fname");
                      String address = rs.getString("address");
                      String iban = rs.getString("iban");
                      
                      System.out.format("%-10s %-15s %-20s %-20s %-20s %-25s %-25s\n", mem_id, username, password, lname, fname, address, iban);
                    }
                    st.close();
                    
                    }
                    catch (Exception e)
                    {
                    System.err.println("Got an exception! ");
                    e.printStackTrace();
                    }
                    
                    //MENU DE L'APARTAT DE CLIENTS
                    
                    System.out.println("Apreta V per validar DNI....");
                    System.out.println("Apreta W per validar EMAIL....");
                    System.out.println("Apreta E per continuar....");
                    opcio=teclat.next();
                    boolean sortir=false;
                    switch(opcio.charAt(0)){
                        
                        //OPCIO DE VALIDAR DNI
                        
                        case 'V':
                        System.out.println("Has seleccionat validar el DNI, introdueix el DNI");
                        System.out.println("Introdueix el seu DNI");                        
                        String dni=teclat.next();
                        boolean dniCorrecte = true;
                        char lletracalc = 0;
                        
                        if (dni.length()!= 9){
                            System.out.println("El DNI no conte 9 caracters");
                        }else{
                            
                            //MIREM QUE L'ULTIM DIGUIT SIGUI UNA LLETRA
                            
                            char ult = dni.charAt(dni.length()-1);
                            if (ult>='a' && ult<='z'){
                                ult-=32;
                            }
                            if (ult>='A' && ult<='Z'){
                                
                                for (int i=0; i<8; i++){
                                    if (dni.charAt(i) <'0' || dni.charAt(i)>'9'){
                                        System.out.println("Les 8 primeres posicions han de ser numeros");
                                        dniCorrecte=false;
                                        break;
                                    }
                                }
                                if (dniCorrecte){
                                    
                                    //VALIDEM FORMULA
                                    
                                    dni = dni.substring(0, dni.length()-1);
                                    
                                    //CONVERTIM STRING A INT
                                    
                                    int dniInt = Integer.parseInt(dni);
                                                                        
                                    int reste = dniInt % 23;

                                    switch (reste){
                                        case 0: lletracalc = 'T'; break;
                                        case 1: lletracalc = 'R'; break;
                                        case 2: lletracalc = 'W'; break;
                                        case 3: lletracalc = 'A'; break;
                                        case 4: lletracalc = 'G'; break;
                                        case 5: lletracalc = 'M'; break;
                                        case 6: lletracalc = 'Y'; break;
                                        case 7: lletracalc = 'F'; break;
                                        case 8: lletracalc = 'P'; break;
                                        case 9: lletracalc = 'D'; break;
                                        case 10: lletracalc = 'X'; break;
                                        case 11: lletracalc = 'B'; break;
                                        case 12: lletracalc = 'N'; break;
                                        case 13: lletracalc = 'J'; break;
                                        case 14: lletracalc = 'Z'; break;
                                        case 15: lletracalc = 'S'; break;
                                        case 16: lletracalc = 'Q'; break;
                                        case 17: lletracalc = 'V'; break;
                                        case 18: lletracalc = 'H'; break;
                                        case 19: lletracalc = 'L'; break;
                                        case 20: lletracalc = 'C'; break;
                                        case 21: lletracalc = 'K'; break;
                                        case 22: lletracalc = 'E'; break;
                                    }
                                    
                                    if (ult != lletracalc){
                                        System.out.println("DNI incorrecte");
                                    }else{
                                        System.out.println("DNI correcte");
                                    }
                                }
                            }else{
                               System.out.println("La ultima posicio ha de ser una lletra");                 
                            }  
                        }
                        break;
                        
                        //OPCIO VALIDAR EMAIL
                        
                        case 'W':
                            
                            System.out.println("Escriu email a validar: ");
                            String email = teclat.next();
                            if (emailValidar(email)) {
                                System.out.println("Email coorecte");
                            }else{
                                System.out.println("Emal incorrecte");
                            }
                            break;
                            
                            //OPCIO DE RETORNAR AL MENU PRINCIPAL
                            
                        case 'E':  
                            sortir = true;
                        break;
                    }
                    System.out.println("\nApreta RETURN per sortir....");
                    
                    teclat.nextLine();
    }
    
    //FUNCIÓ DE VALIDAR EMAIL
    
    public static boolean emailValidar(String email){
        
        //BUESQUIEM L'@
        
        int posinArroba = email.indexOf('@');
        int posultArroba = email.lastIndexOf('@');
        
        if (posinArroba == -1) {
            return false;
        } else {
            if (posinArroba != posultArroba) {
                return false;
            } 
        }

        //SEPAREM LA PART LOCAL       
        
        String local = email.substring(0, posinArroba);
        String domini = email.substring(posinArroba +1, email.length());

        if (local.length() >= 64 || local.length() == 0) {
            System.out.println("ERROR: longitud de la part local");
            return false;
        }

        //SEPAREM LA PART DE DOMINI
        
        if (domini.length() >= 255 && domini.length() == 0) {
            System.out.println("ERROR: longitud del domini");
            return false;

        }

        //BUSQUEM LA POSICIO DEL PUNT
        
        int pospunt = domini.indexOf('.');
        int ultPunt = domini.lastIndexOf('.');

        if (pospunt == -1) {
            System.out.println("ERROR: del punt");
            return false;
        }

        if (pospunt != ultPunt) {

            return false;

        }

        //SEPAREM LA PART DE L'EXTENCIÓ
        
        String subDomini = domini.substring(0, pospunt);
        String extensio = domini.substring(pospunt +1, domini.length());

        if (extensio.length() < 2) {
            System.out.println("ERROR: longitud de l'extenció incorrecta");
             return false;

        }
        
        System.out.println(".............................");
        System.out.println("Local: " + local);
        System.out.println("Domini: " + domini);
        System.out.println("Posicio de la @: " + email.indexOf('@'));
        System.out.println("Posicio del punt: " + pospunt);
        System.out.println("Extensio: " + extensio);
        System.out.println(".............................");
        
    //CRIDEM LA FUNCIÓ QUE ENS VALIDA ELS CARACTERS QUE COMPONEN L'EMAIL

    if(!validar_Caracters(local)) return false;
    if(!validar_Caracters(subDomini)) return false;
    if(!validar_Caracters(extensio)) return false;

    return true;

    }

    //FUNCIÓ DE VALIDAR CARACTERS
    
    public static boolean validar_Caracters(String str) {
    
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') || (x >='0' && x <= '9') || (x=='-') || (x=='_')) {
            }else{
                return false;
            }
        }
        return true;
    }
}
