import java.util.ArrayList;
import java.util.List;

import Interfaces.IMetier;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit p) {
        produits.add(p);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit p : produits) {
            if (p.getId() == id) return p;
        }
        return null; // pas trouvé
    }

    @Override
    public void delete(long id) {
        produits.removeIf(p -> p.getId() == id);
    }
}
