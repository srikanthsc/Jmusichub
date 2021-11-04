package musichub.business;

public class Chanson extends AbstractOeuvre implements IJouable, Comparable<Chanson>  {
    
    private String artiste;

    private String contenu;

    private Genre genre;

    private String date;
  
    public Chanson (int id, String titre, int duree, String artiste, String contenu, Genre genre, String date) {
        super(id, titre, duree);
        this.artiste = artiste;
        this.contenu = contenu;
        this.genre = genre;
        this.date = date;
    }
    
    public String getArtiste () {
        return artiste;
    }

    public void setArtiste (String artiste) {
        this.artiste = artiste;
    }

    public String getContenu () {
        return contenu;
    }

    public void setContenu (String contenu) {
        this.contenu = contenu;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public Genre getGenre () {
        return genre;
    }

    public void setGenre (Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Chanson :\n"
        + "id = " + this.getId() + "\n"
        + "titre = " + this.getTitre() + "\n"
        + "duree = " + this.getDuree() + "\n"
        + "artiste = " + this.getArtiste() + "\n"
        + "contenu = " + this.getContenu() + "\n"
        + "genre = " + this.getGenre() + "\n"
        + "date = " + this.getDate() + "\n";
        }

    @Override
    public int compareTo(Chanson chanson) {
        return this.getGenre().compareTo(chanson.getGenre()); //comparer String = ordre alphabétique
    //si on met return chanson.getGenre().compareTo(this.getGenre())->on a l'inverse du tri 
    }    

}

