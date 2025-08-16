import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MetierProduitImpl metier = new MetierProduitImpl();

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par ID");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par ID");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = sc.nextInt();
            sc.nextLine(); // vider buffer

            switch (choix) {
                case 1:
                    if (metier.getAll().isEmpty()) {
                        System.out.println("La liste est vide.");
                    } else {
                        metier.getAll().forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'ID du produit : ");
                    long idRecherche = sc.nextLong();
                    Produit p = metier.findById(idRecherche);
                    if (p != null) System.out.println(p);
                    else System.out.println("Produit introuvable !");
                    break;

                case 3:
                    System.out.print("ID : ");
                    long id = sc.nextLong(); sc.nextLine();
                    System.out.print("Nom : ");
                    String nom = sc.nextLine();
                    System.out.print("Marque : ");
                    String marque = sc.nextLine();
                    System.out.print("Prix : ");
                    double prix = sc.nextDouble(); sc.nextLine();
                    System.out.print("Description : ");
                    String desc = sc.nextLine();
                    System.out.print("Stock : ");
                    int stock = sc.nextInt();

                    metier.add(new Produit(id, nom, marque, prix, desc, stock));
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSupp = sc.nextLong();
                    metier.delete(idSupp);
                    System.out.println("Produit supprimé (si trouvé).");
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    return;

                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
