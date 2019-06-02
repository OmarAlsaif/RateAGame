package Spark;

/**
 * @author Lukas
 * Klass som hanterar informationen för databas-inlogg
 */
public class DatabaseLogin {
	
	private String jdbUrl = "jdbc:postgresql://pgserver.mah.se/";
	private String username = "ah1681";
	private String password = "oc2bpr6g";

	public String getJdbUrl() {
		return jdbUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
