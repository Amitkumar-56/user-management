package in.ashokit.dto;
public class LoginDto {
	   private String email;
	   private String pwd;

	   public String getEmail() {
	      return this.email;
	   }

	   public String getPwd() {
	      return this.pwd;
	   }

	   public void setEmail(final String email) {
	      this.email = email;
	   }

	   public void setPwd(final String pwd) {
	      this.pwd = pwd;
	   }
	}