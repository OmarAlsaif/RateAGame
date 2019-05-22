package Spark;

public class DatabaseLogin {
	
	private String jdbUrl = "jdbc:postgresql://localhost:5432/postgres";
	private String username = "postgres";
	private String password = "password";
	
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
