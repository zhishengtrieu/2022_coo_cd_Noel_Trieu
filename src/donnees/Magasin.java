package donnees;

import java.util.ArrayList;

/**
 * La classe Magasin represente un magasin qui vend des CDs.</p>
 * <p>
 * cette classe est caracterisee par un ensemble de CDs correspondant aux CDS
 * vendus dans ce magasin.
 */
public class Magasin {

    /**
     * la liste des CDs disponibles en magasin
     */
    private ArrayList<CD> listeCds;

    /**
     * construit un magasin par defaut qui ne contient pas de CD
     */
    public Magasin() {
        listeCds = new ArrayList<CD>();
    }

    /**
     * ajoute un cd au magasin
     *
     * @param cdAAjouter le cd a ajouter
     */
    public void ajouteCd(CD cdAAjouter) {
        listeCds.add(cdAAjouter);
    }

    @Override
    /**
     * affiche le contenu du magasin
     */
    public String toString() {
        String chaineResultat = "";
        //parcours des Cds
        for (int i = 0; i < listeCds.size(); i++) {
            chaineResultat += listeCds.get(i);
        }
        chaineResultat += "nb Cds: " + listeCds.size();
        return (chaineResultat);

    }

    /**
     * @return le nombre de Cds du magasin
     */
    public int getNombreCds() {
        return listeCds.size();
    }


    /**
     * permet d'acceder à un CD
     *
     * @return le cd a l'indice i ou null si indice est non valide
     */
    public CD getCd(int i) {
        CD res = null;
        if ((i >= 0) && (i < this.listeCds.size()))
            res = this.listeCds.get(i);
        return (res);
    }

    public void trierAriste() {
        ArrayList<CD> listeTrie = new ArrayList<CD>();
        CD cdTrie;
        while (listeCds.size() > 0) {
            cdTrie = listeCds.get(0);
            for (int j = 1; j < listeCds.size(); j++) {
                if (cdTrie.compareArtiste(listeCds.get(j)) > 0) {
                    cdTrie = listeCds.get(j);
                }
            }
            listeTrie.add(cdTrie);
            listeCds.remove(cdTrie);
        }
        listeCds = listeTrie;
    }

    public void trierAlbum() {
        ArrayList<CD> listeTrie = new ArrayList<CD>();
        CD cdTrie;
        while (listeCds.size() > 0) {
            cdTrie = listeCds.get(0);
            for (int j = 1; j < listeCds.size(); j++) {
                if (cdTrie.compareNom(listeCds.get(j)) > 0) {
                    cdTrie = listeCds.get(j);
                }
            }
            listeTrie.add(cdTrie);
            listeCds.remove(cdTrie);
        }
        listeCds = listeTrie;
    }

    public void trier(ComparateurCd comparateur) {
        ArrayList<CD> listeTrie = new ArrayList<CD>();
        CD cdTrie;
        while (listeCds.size() > 0) {
            cdTrie = listeCds.get(0);
            for (int j = 1; j < listeCds.size(); j++) {
                if (comparateur.etreAvant(listeCds.get(j), cdTrie)) {
                    cdTrie = listeCds.get(j);
                }
            }
            listeTrie.add(cdTrie);
            listeCds.remove(cdTrie);
        }
        listeCds = listeTrie;
    }

    public ArrayList<CD> selectionParArtiste(String artiste) {
        ArrayList<CD> list = new ArrayList<CD>();
        Selecteur selecteur = new SelecteurArtiste(artiste);
        for (CD cd : listeCds) {
            if (selecteur.garderCd(cd)) {
                list.add(cd);
            }
        }
        return list;
    }

}
