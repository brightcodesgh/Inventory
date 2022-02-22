import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PharmacyInventory {

    public static void main(String[]args){

        DecimalFormat f = new DecimalFormat("$0,000.00");
        DecimalFormat f1 = new DecimalFormat("$00.00");
        JTextArea area = new JTextArea(10,10);

        int prodID[] = {100, 102, 104, 106, 109, 110, 103, 140, 124, 111};
        String prodName[] = {"Panadol", "Nasal Spray", "Panadol", "Anexxi", "Flufy", "Amine", "Tonic", "Gebidol", "Steriods", "Alumm"};
        int prodQty[] = {100, 200, 300, 440, 712, 820, 915, 110, 132, 112};
        double prodPrice[] = {5.54, 600.00, 20.00, 50.00, 145.00, 235.00, 110.54, 10.32, 523.47, 50.43};
        int prodsold[] = new int [10];
        int prodoldQty[] = {100, 200, 300, 440, 712, 820, 915, 110, 132, 112};
        int UserInputID, UserInputQty, Checkout;
      
        double total = 0.0;
        double Subtotal = 0.0;
        double paymentinput;
        double changeDue = 0.0;
        String output = "ID\tName\tQuantity\tPrice\tCart Total";
          


        System.out.println("              ::: ERMY PHARMARCY :::                 ");
        System.out.println("   :: PHARMARCY PRODUCT PROGRAM version 1.0 ::     ");
        System.out.println("=================================================");
        System.out.printf("%-10s%-15s%-10s%10s\n","ID","Name","Quantity","Price");
        for(int i = 0; i < prodID.length; i++){
            System.out.printf("%-10d%-15s%-10d%8.2f\n",prodID[i],prodName[i],prodQty[i],prodPrice[i]);
            
        }
        System.out.println("=================================================");
        
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Enter Product ID:");
            UserInputID = scan.nextInt();
            System.out.println("Enter Product Quantity:");
            UserInputQty = scan.nextInt();
           

            for(int index = 0; index < prodID.length; index++){
                if(UserInputID == prodID[index] && UserInputQty < prodQty[index]){
                    total = UserInputQty * prodPrice[index];
                    Subtotal += total;
                    prodQty[index] -= UserInputQty;
                    output += "\n" +prodID[index] +"\t" + prodName[index] + "\t" + prodQty[index] + "\t" + prodPrice[index] + "\t" +total;
                    break;
                }
            }

            System.out.println("1. ADD TO CART \n0. END ");
            Checkout = scan.nextInt();


        }while(Checkout != 0);
        System.out.println("========================");

        System.out.println("Total = "+ f.format(Subtotal));

        Scanner input = new Scanner(System.in);
        System.out.println("PAYMENT:");
        paymentinput = input.nextDouble();


        while(paymentinput < Subtotal){
            System.out.println("Insufficient Amount");
            System.out.println("\nTotal = "+ f.format(Subtotal)+ "\nPAYMENT: ");
            paymentinput = input.nextDouble();
        }

        changeDue =  paymentinput - Subtotal;

        area.setText("\t\tERMY PHARMARCY\n\t\tOFFICIAL RECIEPT\n"+
        "===========================================\n"
        + output+"\n" 
        +"\n\t\tTOTAL: " + f.format(Subtotal)+"\n" + 
        "\t\tPAYMENT: "+ f.format(paymentinput)+"\n"
        +"\t\tCHANGE: " + f1.format(changeDue)
        +"\n===========================================\n"
        +"\n\tTHANK YOU FOR SHOPPING WITH US\n\t\tERMY|DANN PHARMACY");

        area.setFont(new Font("Tahoma", Font.BOLD, 16));
        area.setBackground(Color.WHITE);
        area.setEditable(false);

        JOptionPane.showMessageDialog(null, area, "OFFICIAL RECEIPT", JOptionPane.PLAIN_MESSAGE);



        System.out.println("              ::: ERMY PHARMARCY :::                 ");
        System.out.println("   :: PHARMARCY PRODUCT PROGRAM version 1.0 ::     ");
        System.out.println("=================================================");
        System.out.println("                :: NEW INVENTORY::          ");
        System.out.printf("%-10s%-15s%-10s%-10s%10s\n","ID","Name","Quantity","SoldQty", "OldQty");
       
        for(int i = 0; i < prodID.length; i++){
            prodsold[i] = prodoldQty[i] - prodQty[i];
            System.out.printf("%-10s%-15s%-10s%-10s%10s\n",prodID[i],prodName[i],prodQty[i],prodsold[i], prodoldQty[i]);
        }
           
               
        System.out.println("=================================================\n");
        System.out.println("         ::Thank you for shoping with us ::  ");

        scan.close();
        input.close();

       

    }
    
}
