package sys;

public class DatabaseLogin {
	
	String jdbUrl = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "password";
	
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
