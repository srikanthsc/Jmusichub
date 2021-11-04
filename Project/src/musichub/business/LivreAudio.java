package musichub.business;

public class LivreAudio extends AbstractOeuvre implements IJouable, Comparable<LivreAudio> {
    
    private String auteur;

    private String contenu;

    private Langue langue;

    private Categorie categorie;

    public LivreAudio (int id, String titre, int duree, String auteur, String contenu, Langue langue, Categorie categorie) {
        super(id, titre, duree);
        this.auteur = auteur;
        this.contenu = contenu;
        this.langue = langue;
        this.categorie = categorie;
    }

    public String getAuteur () {
        return auteur;
    }

    public void setAuteur (String auteur) {
        this.auteur = auteur;
    }  

    public String getContenu () {
        return contenu;
    }

    public void setContenu (String contenu) {
        this.contenu = contenu;
    }

    public Langue getLangue () {
        return langue;
    }

    public void setLangue (Langue langue) {
        this.langue = langue;
    }

    public Categorie getCategorie () {
        return categorie;
    }

    public void setCategorie (Categorie categorie) {
        this.categorie = categorie;
    } 

    @Override
    public String toString() {
        return "---------\n"
        + "LivreAudio :\n"
        + "id = " + this.getId() + "\n"
        + "titre = " + this.getTitre() + "\n"
        + "duree = " + this.getDuree() + "\n"
        + "auteur = " + this.getAuteur() + "\n"
        + "contenu = " + this.getContenu() + "\n"
        + "langue = " + this.getLangue() + "\n"
        + "categorie = " + this.getCategorie() + "\n";
        }
        
    @Override
    public int compareTo(LivreAudio livreaudio) {
        return this.getAuteur().compareTo(livreaudio.getAuteur());
    }
}
