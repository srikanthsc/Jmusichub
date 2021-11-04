package musichub.business;

public class AbstractOeuvre {

private int id;

private String titre;

private int duree;

public AbstractOeuvre (int id, String titre, int duree) {
    this.id = id;
    this.titre = titre;
    this.duree = duree;
}

public int getId () {
    return id;
}

public String getTitre () {
    return titre;
}

public void setTitre (String titre) {
    this.titre = titre;
}

public int getDuree () {
    return duree;
}

public void setDuree (int duree) {
    this.duree = duree;
}

}