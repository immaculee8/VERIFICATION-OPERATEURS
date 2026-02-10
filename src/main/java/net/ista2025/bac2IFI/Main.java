package net.ista2025.bac2IFI;
/* 
    GROUPE 8
    1.MUYUMBA ATOWA IMMACULEE
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

// Déclaration de la classe OperatorChecker (non publique donc accessible uniquement dans son package)
 class OperatorChecker {

    // Déclaration d'une constante qui contient le chemin relatif du fichier de données
    // private : accessible uniquement dans cette classe
    // static : appartient à la classe elle-même, pas aux instances
    // final : valeur constante qui ne peut pas être modifiée
    private static final String FILE = "data/operators.txt";

    // Méthode publique et statique qui vérifie si un opérateur existe dans le fichier
    // public : accessible depuis d'autres classes
    // static : méthode de classe, peut être appelée sans créer d'instance
    // boolean : type de retour (vrai ou faux)
    // operatorExists : nom de la méthode
    // String operatorId : paramètre d'entrée représentant l'ID de l'opérateur à rechercher
    public static boolean operatorExists(String operatorId) {
        
        // Bloc try-with-resources (Java 7+) garantissant la fermeture automatique du BufferedReader
        // BufferedReader : permet une lecture efficace ligne par ligne
        // FileReader : lit le fichier texte
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            
            // Déclaration d'une variable pour stocker chaque ligne lue du fichier
            String line;

            // Boucle de lecture : lit chaque ligne jusqu'à la fin du fichier (null)
            // br.readLine() : lit une ligne du fichier
            // != null : condition pour continuer tant qu'il y a des lignes à lire
            while ((line = br.readLine()) != null) {
                
                // Commentaire expliquant le format des données dans le fichier
                // Chaque ligne est au format : id;nom;poste
               
                // Découpe la ligne en utilisant le point-virgule comme séparateur
                // parts[0] = id, parts[1] = nom, parts[2] = poste
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



