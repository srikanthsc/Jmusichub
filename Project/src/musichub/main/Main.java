package musichub.main;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import musichub.business.IJouable;
import musichub.business.Album;
import musichub.business.Categorie;
import musichub.business.Chanson;
import musichub.business.Genre;
import musichub.business.Langue;
import musichub.business.LivreAudio;
import musichub.business.Playlist;
import musichub.util.XmlReader;
import musichub.util.XmlWriter;

/**
 *  classe basique Main
 */

public class Main { 
    List<Chanson> chansons;
    List<LivreAudio> livresAudio;
    List<Album> albums;
    List<Playlist> playlists;

/**
 *  constructeur du Main
 */
    public Main() throws Exception { 
        XmlReader reader = new XmlReader();

        this.chansons = reader.getChansons();
        this.livresAudio = reader.getLivresAudio();
        this.albums = reader.getAlbums();
        this.playlists = reader.getPlaylists();
    }

/**
 *  méthode newAlbum qui permet de créer un nouvel album. Elle est appelée pour la commande "a".
 */
    private Album newAlbum(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un titre (string) $> ");
        String titre = sc.nextLine();
        System.out.print("Entrez une durée (secondes) $> ");
        int duree = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un artiste (string) $> ");
        String artiste = sc.nextLine();
        System.out.print("Entrez une date (aaaa-mm-jj) $> ");
        String date = sc.nextLine();
        System.out.println();

        Album album = new Album(id, titre, duree, null, artiste, date);
        
        return album;
    }

/**
 *  méthode addChansonToPlaylist qui permet d'ajouter une chanson existante à une playlist. Elle est appelée pour la commande "p".
 */
    private Chanson addChansonToPlaylist(Scanner sc) {
        System.out.println("\nVoici vos chansons actuelles :");
        System.out.println(this.chansons);
        System.out.print("\nQuelle chanson souhaitez-vous ajouter à votre playlist (id de la chanson) ? $> ");
        int idChanson = sc.nextInt();
        sc.nextLine();

        Chanson chanson = null;
        for (int i = 0; i < this.chansons.size(); i++) {
            if (this.chansons.get(i).getId() == idChanson) {
                chanson = this.chansons.get(i);
                System.out.println("\nVoici la chanson selectionnée : ");
                System.out.println(chanson);
            }
        }

        return chanson;
    }
/**
 *  méthode addLivreAudioToPlaylist qui permet d'ajouter un livre audio existant à une playlist. Elle est appelée pour la commande "p".
 */
    private LivreAudio addLivreAudioToPlaylist(Scanner sc) {
        System.out.println("\nVoici vos livres audio actuels :");
        System.out.println(this.livresAudio);
        System.out.print("\nQuelle livre audio souhaitez-vous ajouter à votre playlist (id du livre audio) ? $> ");
        int idLivreAudio = sc.nextInt();
        sc.nextLine();

        LivreAudio livreaudio = null;
        for (int i = 0; i < this.livresAudio.size(); i++) {
            if (this.livresAudio.get(i).getId() == idLivreAudio) {
                livreaudio = this.livresAudio.get(i);
                System.out.println("\nVoici le livre audio selectionné : ");
                System.out.println(livreaudio);
            }
        }

        return livreaudio;
    }

/**
 *  méthode newPlaylist qui permet de créer une nouvelle playlist et d'y ajouter des éléments (chansons ou livres audio) existants. Elle est appelée pour la commande "p".
 */    
    private Playlist newPlaylist(Scanner sc) {
        //Caratéristiques de la playlist
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un nom (string) $> ");
        String nom = sc.nextLine();
        System.out.println();


        //Ajout d'élément à la playlist
        int choix = 1;
        Collection<IJouable> elements = new LinkedList<IJouable> ();
        while (choix == 1 || choix == 2) {
            System.out.println("\nSouhaitez-vous ajouter des elements à votre playlist ?");
            System.out.println("1. Ajouter une chanson");
            System.out.println("2. Ajouter un livre audio");
            System.out.println("3. Ne plus rien ajouter");

            System.out.print("\nVotre choix $> ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("Ajoute une chanson à ta playlist");
                    elements.add(this.addChansonToPlaylist(sc));
                    break;
                case 2:
                    System.out.println("Ajoute un livre audio à ta playlist");
                    elements.add(this.addLivreAudioToPlaylist(sc));
                    break;
                default:
                    System.out.println("Félicitation ! Vous avez terminé d'ajouter des éléments à votre playlist");
                    break;
            }
        }

        //Création de la playlist
        Playlist playlist = new Playlist(id, nom, elements);

        return playlist;
    }

/**
 *  méthode newChanson qui permet de créer une nouvelle chanson. Elle est appelée pour la commande "c".
 */
    private Chanson newChanson(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un titre (string) $> ");
        String titre = sc.nextLine();
        System.out.print("Entrez une durée (secondes) $> ");
        int duree = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un artiste (string) $> ");
        String artiste = sc.nextLine();
        System.out.print("Entrez un contenu (string) $> ");
        String contenu = sc.nextLine();
        System.out.print("Entrez un genre (JAZZ, CLASSIQUE, HIPHOP, ROCK, POP, RAP) $> ");
        Genre genre = Genre.valueOf(sc.nextLine());
        System.out.print("Entrez une date (aaaa-mm-jj) $> ");
        String date = sc.nextLine();
        System.out.println();

        Chanson chanson = new Chanson(id, titre, duree, artiste, contenu, genre, date);

        return chanson;
    }

/**
 *  méthode newLivreAudio qui permet de créer un nouveau livre audio. Elle est appelée pour la commande "l".
 */
    private LivreAudio newLivreAudio(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un titre (string) $> ");
        String titre = sc.nextLine();
        System.out.print("Entrez une durée (secondes) $> ");
        int duree = sc.nextInt();
        sc.nextLine();
        System.out.print("Entrez un auteur (string) $> ");
        String auteur = sc.nextLine();
        System.out.print("Entrez un contenu (string) $> ");
        String contenu = sc.nextLine();
        System.out.print("Entrez une langue (FRANCAIS, ANGLAIS, ITALIEN, ESPAGNOL, ALLEMAND) $> ");
        Langue langue = Langue.valueOf(sc.nextLine());
        System.out.print("Entrez une categorie (JEUNESSE, ROMAN, THEATRE, DISCOURS, DOCUMENTAIRE) $> ");
        Categorie categorie = Categorie.valueOf(sc.nextLine());
        System.out.println();

        LivreAudio livreAudio = new LivreAudio(id, titre, duree, auteur, contenu, langue, categorie);

        return livreAudio;
    }

/**
 *  méthode removePlaylist qui permet de supprimer une playlist. Elle est appelée pour la commande "-".
 */    
    private void removePlaylist(Scanner sc) {
        System.out.print("\nEntrez un id (integer) $> ");
        int id = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getId() == id) {
                  this.playlists.remove(i);  
            }
        }
    }

/**
 *  méthode addChansonToAlbum qui permet d'ajouter une chanson existante à un album. Elle est appelée pour la commande "+".
 */        
    private void addChansonToAlbum(Scanner sc) {
        System.out.print("\nA quel album souhaitez-vous ajouter une chanson (id de l'album) ? $> ");
        int idAlbum = sc.nextInt();
        sc.nextLine();

        int indexAlbum = 0;
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getId() == idAlbum) {
                indexAlbum = i;
                System.out.println("\nVoici l'album selectionné : ");
                System.out.println(this.albums.get(i));
            }
        }

        System.out.println("\nVoici vos chansons actuelles :");
        System.out.println(this.chansons);
        System.out.print("\nQuelle chanson souhaitez-vous ajouter à l'album (id de la chanson) ? $> ");
        int idChanson = sc.nextInt();
        sc.nextLine();

        Chanson chanson = null;
        for (int i = 0; i < this.chansons.size(); i++) {
            if (this.chansons.get(i).getId() == idChanson) {
                chanson = this.chansons.get(i);
                System.out.println("\nVoici la chanson selectionnée : ");
                System.out.println(chanson);
            }
        }
        this.albums.get(indexAlbum).addChanson(chanson);
        
        System.out.println("\nVoici votre album mis à jour");
        System.out.println(this.albums.get(indexAlbum));
    }

 /**
 *  méthode commandsHandling qui de gérer les différentes commandes prises en charge par l'application.
 */   
    private boolean commandsHandlding(Scanner sc, String cmd) throws Exception {
        boolean again = true;

        switch (cmd) {
            case "albums":
                System.out.println(this.albums);
                break;
            case "chansons":
                System.out.println(this.chansons);
                break;
            case "livres audio":
                System.out.println(this.livresAudio);
                break;
            case "playlists":
                System.out.println(this.playlists);
                break;
            case "c":
                System.out.println("\nAjout d'une nouvelle chanson :");
                Chanson chanson = this.newChanson(sc);
                this.chansons.add(chanson);
                System.out.println(chanson);
                System.out.println("La chanson a bien été ajoutée.");
                break;
            case "a":
                System.out.println("\nAjout d'un nouvel album :");
                Album album = this.newAlbum(sc);
                this.albums.add(album);
                System.out.println(album);
                System.out.println("L'album a bien été ajoutée.");
                System.out.println("Pour ajouter des chansons existantes à cet album, utilisez la commande '+'");
                break;
            case "+":
                System.out.println("\nVoici vos albums actuels :");
                System.out.println(this.albums);
                this.addChansonToAlbum(sc);
                System.out.println("\nLa chanson a bien été ajoutée.");
                break;
            case "l":
                System.out.println("\nAjout d'un nouveau livre audio :");
                LivreAudio livreAudio = this.newLivreAudio(sc);
                this.livresAudio.add(livreAudio);
                System.out.println(livreAudio);
                System.out.println("Le livre audio a bien été ajouté.");
                break;
            case "p":
                System.out.println("\nCréation d'une nouvelle playlist:");
                Playlist playlist = this.newPlaylist(sc);
                this.playlists.add(playlist);
                System.out.println(playlist);
                System.out.println("La playlist a bien été créée.");
                break;
            case "-":
                System.out.println("\nVoici vos playlists actuelles :");
                System.out.println(this.playlists);
                System.out.print("Quelle playlist souhaitez-vous supprimer (id) ? $>");
                this.removePlaylist(sc);
                System.out.println("\nLa playlist a bien été supprimée.");
                break;
            case "s":
                XmlWriter writer = new XmlWriter();
                writer.save(this.chansons, this.livresAudio, this.albums, this.playlists);
                System.out.println("Les fichiers XML ont été mis à jour.");
                break;
            case "h": 
                this.menu();
                break;
            case "q": 
                again = false;
                break;
            default:
                System.out.println("\nCette commande n'est pas prise en charge");
                this.menu();
                break;
        }
        return again;
    }

 /**
 *  méthode menu qui gère l'affichage du menu de l'application et les différentes commandes disponibles.
 */ 
    private void menu() {
        System.out.println("\nVoici la liste des commandes disponibles : \n");
        System.out.println("--------- AFFICHAGE ---------");
        System.out.println("albums       : lister les albums ");
        System.out.println("chansons     : lister les chansons ");
        System.out.println("livres audio : lister les livres audio ");
        System.out.println("playlists    : lister les playlists ");
        System.out.println("\n--------- AJOUT / SUPPRESSION ---------");
        System.out.println("c   :   Ajouter une nouvelle chanson ");
        System.out.println("a   :   Ajouter un nouvel album ");
        System.out.println("+   :   Ajouter une chanson existante à un album");
        System.out.println("l   :   Ajouter un nouveau livre audio");
        System.out.println("p   :   Créer une nouvelle playlist à partir de chansons et livres audio existants");
        System.out.println("-   :   Supprimer une playlist");
        System.out.println("s   :   Sauvegarder les playlists, albums, hansons et livres audios dans leurs fichiers xml respectifs");
        System.out.println("\n--------- AUTRES ---------");
        System.out.println("h   :   Afficher le détail des commandes");
        System.out.println("q   :   Quitter le programme");
    }

 /**
 *  méthode run qui gère le fonctionnement de l'application en prenant en charge les commandes rentrées par l'utilisateur.
 */     
    private void run() throws Exception {
        Scanner sc = new Scanner(System.in);

        boolean again = true;
        String cmd = null;

        this.menu();
        while (again) {
            System.out.print("\nEntrez une commande $> ");
            cmd = sc.nextLine();
            again = this.commandsHandlding(sc, cmd);
        }
        sc.close();
    }

 /**
 *  méthode principale main gère le fonctionnement global de l'application.
 */ 
    public static void main(String[] args) {

        System.out.println("\nBienvenue dans JMUSICHUB");

        try {
            Main application = new Main();
            application.run();
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("\nMerci d'avoir utilisé nos services.");
        System.out.println("A bientot !\n");
    }

}
