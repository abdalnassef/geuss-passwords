/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AGA
 */
public class Password {
static char Litter[];
    public Password(char L[]) {
        Litter=L;
    }
      
     
       static void findPwd(char[] pw, int pos,com.mysql.jdbc.Statement stmt,String user) throws ClassNotFoundException, SQLException {
            if (pos < 0) {
//        System.out.println(new String(pw));
               String sql = "select q from pass where name ='"+user+"' and pass ='"+new String(pw)+"'";
               ResultSet result=stmt.executeQuery(sql);
                System.out.println(new String(pw));
              
         while(result.next()){
//             System.out.println(result.getString("pass")+" + "+new String(pw));
//           if(new String(pw).equals(result.getString("pass"))){
               System.out.println("Found Account pass and Q of it : "+result.getString("q"));System.exit(-1);
               
               break;
//           }
            }
        return;
    }
    for (int index=0 ; index <= Litter.length-1 ; index++){
        pw[pos] = Litter[index];
        findPwd(pw, pos-1,stmt,user);}
    
    
       
           
}
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/t","root","root");
            com.mysql.jdbc.Statement stmt=(com.mysql.jdbc.Statement) connection.createStatement();
      
        char xx[]=new char[26];
        int index=0;
        for(int x=0;x<=27;x++){
         xx[index]=(char)('a'+x);
        if(xx[index++]=='z')break;
        }
        
        new Password(xx);
        
        Scanner in=new Scanner(System.in);
        int Length = 0 ;
        String user = null ;
        try{
         System.out.print("Enter user of password want to hack : " );
         user=in.nextLine(); 
         System.out.print("Enter Length of password want to hack : " );
         Length=in.nextInt();
         
//            Length=7;
        }catch(Exception e){
            System.out.println("Not Number");System.exit(-1);}
        
        char[] pw ;
        // change in 0 to length-1 (index of pw)
//        for(int x=0;x<Length;x++){

        int x=Length;
        pw=new char[x];
                findPwd(pw, x-1,stmt,user);
//    }
//        
        
        
        
    }
    
}
