package reignier.guillaume.homecinema;

import org.json.JSONArray;

public class FilmMoment {
    private String titre, titre_ori, affiche, web, distributeur, participants, realisateur, synopsis, annee, duree, date_sortie,
            info, genre, categorie, releaseNumber, pays, share_url;
    private int id, genreid, categorieid;
    private boolean is_visible, is_vente, is_avp, is_alaune, isLastWeek;
    private JSONArray medias, videos;

    public FilmMoment() {
    }

    public FilmMoment(String titre, String titre_ori, String affiche, String web, String distributeur, String participants,
                      String realisateur, String synopsis, String annee, String duree, String date_sortie, String info, String genre,
                      String categorie, String releaseNumber, String pays, String share_url, int id, int genreid, int categorieid,
                      boolean is_visible, boolean is_vente, boolean is_avp, boolean is_alaune, boolean isLastWeek,
                      JSONArray medias, JSONArray videos ) {
        this.titre = titre; this.titre_ori = titre_ori; this.affiche = affiche; this.web = web; this.distributeur = distributeur;
        this.participants = participants; this.realisateur = realisateur; this.synopsis = synopsis; this.annee = annee;
        this.duree = duree; this.date_sortie = date_sortie; this.info = info; this.genre = genre; this.categorie = categorie;
        this.releaseNumber = releaseNumber; this.pays = pays; this.share_url = share_url; this.id = id; this.genreid = genreid;
        this.categorieid = categorieid; this.is_visible = is_visible; this.is_vente = is_vente; this.is_avp = is_avp;
        this.is_alaune = is_alaune; this.isLastWeek = isLastWeek; this.medias = medias; this.videos = videos;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre_ori() {
        return titre_ori;
    }

    public void setTitre_ori(String titre_ori) {
        this.titre_ori = titre_ori;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getDistributeur() {
        return distributeur;
    }

    public void setDistributeur(String distributeur) {
        this.distributeur = distributeur;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(String releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public int getCategorieid() {
        return categorieid;
    }

    public void setCategorieid(int categorieid) {
        this.categorieid = categorieid;
    }

    public boolean is_visible() {
        return is_visible;
    }

    public void setIs_visible(boolean is_visible) {
        this.is_visible = is_visible;
    }

    public boolean is_vente() {
        return is_vente;
    }

    public void setIs_vente(boolean is_vente) {
        this.is_vente = is_vente;
    }

    public boolean is_avp() {
        return is_avp;
    }

    public void setIs_avp(boolean is_avp) {
        this.is_avp = is_avp;
    }

    public boolean is_alaune() {
        return is_alaune;
    }

    public void setIs_alaune(boolean is_alaune) {
        this.is_alaune = is_alaune;
    }

    public boolean isLastWeek() {
        return isLastWeek;
    }

    public void setIsLastWeek(boolean isLastWeek) {
        this.isLastWeek = isLastWeek;
    }

    public JSONArray getMedias() {
        return medias;
    }

    public void setMedias(JSONArray medias) {
        this.medias = medias;
    }

    public JSONArray getVideos() {
        return videos;
    }

    public void setVideos(JSONArray videos) {
        this.videos = videos;
    }
}