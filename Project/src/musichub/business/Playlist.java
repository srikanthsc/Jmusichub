package musichub.business;
import java.util.Collection;

public class Playlist implements Comparable<Playlist>  {

    private int id;

    private String nom;

    private Collection<IJouable> liste;


public Playlist(int id, String nom, Collection<IJouable> liste) {
    this.id = id;
    this.nom = nom;
    this.liste = liste;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNom() {
    return nom;
}

public void setNom(String nom) {
    this.nom = nom;
}

public Collection<IJouable> getListe() {
    return this.liste;
}

public void setListe(Collection<IJouable> liste) {
    this.liste = liste;
}

public void add(IJouable element) {
    this.liste.add(element);
}

@Override
public String toString() {
    return "---------\n"
    + "Playlist :\n"
    + "id = " + this.getId() + "\n"
    + "nom = " + this.getNom() + "\n"
    + "liste = \n" + this.getListe() + "\n\n";
    }

@Override
public int compareTo(Playlist playlist) {
    return this.getNom().compareTo(playlist.getNom());
}

public void addElement(IJouable element) {
    this.liste.add(element);
}

public void removeElement(IJouable element) {
    //TODO: remove element from playslists
}


}
