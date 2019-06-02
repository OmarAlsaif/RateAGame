package Spark;

/**
 * @author Lukas Rosberg
 * Klass som skapar objekt med information som behövs till html-sidor
 * Flera olika konstruktorer 
 */

public class Game {
	int GameID;
	String GameTitle;
	String GameInfo;
	String ReleaseDate;
	String Publishers;
	String Genre;
	String GameModes;
	String PlayerPerspective;
	String LinkOfficialSite;
	String LinkTrailer;
	String LinkPoster;
	String LinkCover;
	String LinkPicture2;
	String LinkPicture3;
	String LinkPicture1;
	double rating = 0;
	
	public int getGameID() {
		return GameID;
	}
	
	public double getRating() {
		return rating;
	}
	public void setGameID(int gameID) {
		GameID = gameID;
	}
	public String getGameTitle() {
		return GameTitle;
	}
	public void setGameTitle(String gameTitle) {
		GameTitle = gameTitle;
	}
	public String getGameInfo() {
		return GameInfo;
	}
	public void setGameInfo(String gameInfo) {
		GameInfo = gameInfo;
	}
	public String getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}
	public String getPublishers() {
		return Publishers;
	}
	public void setPublishers(String publishers) {
		Publishers = publishers;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getGameModes() {
		return GameModes;
	}
	public void setGameModes(String gameModes) {
		GameModes = gameModes;
	}
	public String getPlayerPerspective() {
		return PlayerPerspective;
	}
	public void setPlayerPerspective(String playerPerspective) {
		PlayerPerspective = playerPerspective;
	}
	public String getLinkOfficialSite() {
		return LinkOfficialSite;
	}
	public void setLinkOfficialSite(String linkOfficialSite) {
		LinkOfficialSite = linkOfficialSite;
	}
	public String getLinkTrailer() {
		return LinkTrailer;
	}
	public void setLinkTrailer(String linkTrailer) {
		LinkTrailer = linkTrailer;
	}
	public String getLinkPoster() {
		return LinkPoster;
	}
	public void setLinkPoster(String linkPoster) {
		LinkPoster = linkPoster;
	}
	public String getLinkPicture1() {
		return LinkPicture1;
	}
	public void setLinkPicture1(String linkPicture1) {
		LinkPicture1 = linkPicture1;
	}
	public String getLinkPicture2() {
		return LinkPicture2;
	}
	public void setLinkPicture2(String linkPicture2) {
		LinkPicture2 = linkPicture2;
	}
	public String getLinkPicture3() {
		return LinkPicture3;
	}
	
	public String getLinkCover() {
		return LinkCover;
	}
	public void setLinkPicture3(String linkPicture3) {
		LinkPicture3 = linkPicture3;
	}

	public Game(int gameID, String gameTitle, String gameInfo, String releaseDate, String publishers, String genre,
			String gameModes, String playerPerspective, String linkOfficialSite, String linkTrailer, String linkPoster,
			String linkCover, String linkPicture1, String linkPicture2, String linkPicture3) {
		GameID = gameID;
		GameTitle = gameTitle;
		GameInfo = gameInfo;
		ReleaseDate = releaseDate;
		Publishers = publishers;
		Genre = genre;
		GameModes = gameModes;
		PlayerPerspective = playerPerspective;
		LinkOfficialSite = linkOfficialSite;
		LinkTrailer = linkTrailer;
		LinkPoster = linkPoster;
		LinkCover = linkCover;
		LinkPicture1 = linkPicture1;
		LinkPicture2 = linkPicture2;
		LinkPicture3 = linkPicture3;
	}
	
	//en andra konstruktor som skickar ett objekt som används av top10.html
	//typkonverterar float rating för att visa rating med två decimaltecken (typen Double går inte att använda i databasen, endast float)
	public Game(float rating, int GameID, String GameTitle, String GameInfo, String LinkCover) {
		this.rating += (double)rating;
		this.GameID = GameID;
		this.GameTitle = GameTitle;
		this.GameInfo = GameInfo;
		this.LinkCover = LinkCover;
	}

	
	//konstruktor för att skicka ett objekt till index.html
	public Game(int gameID, String linkCover, String gameTitle) {
		this.GameID = gameID;
		this.LinkCover = linkCover;
		this.GameTitle = gameTitle;
	}
    

}