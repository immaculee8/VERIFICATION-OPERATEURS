package net.ista2025.bac2IFI;
/* 1.MUYUMBA ATOWA IMMACULEE
   2.NEEMA BARAKA GENESIS
   3.MULEND IRUNG CLARA
   4.MUKENDI BUTEKA
   5.MUJINGA KALENGA
   6.MWADI MAHONE BERTHE
   7.NGOIE NSENGA RACHEL
   8.MITONGA NGOIE FARAJA
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class OperatorChecker {
    private static final String FILE = "data/operators.txt";

    public static boolean operatorExists(String operatorId) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 1 && parts[0].trim().equals(operatorId)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lecture opérateurs : " + e.getMessage());
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Opérateur 1 existe ? " + operatorExists("1"));
        System.out.println("Opérateur 99 existe ? " + operatorExists("99"));
    }
}



