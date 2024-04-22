package in.ashokit.dto;



public class RegisterDto {
	   private String name;
	   private String email;
	   private String phno;
	   private String pwd;
	   private Integer countryId;
	   private Integer stateId;
	   private Integer cityId;

	   public String getName() {
	      return this.name;
	   }

	   public String getEmail() {
	      return this.email;
	   }

	   public String getPhno() {
	      return this.phno;
	   }

	   public String getPwd() {
	      return this.pwd;
	   }

	   public Integer getCountryId() {
	      return this.countryId;
	   }

	   public Integer getStateId() {
	      return this.stateId;
	   }

	   public Integer getCityId() {
	      return this.cityId;
	   }

	   public void setName(final String name) {
	      this.name = name;
	   }

	   public void setEmail(final String email) {
	      this.email = email;
	   }

	   public void setPhno(final String phno) {
	      this.phno = phno;
	   }

	   public void setPwd(final String pwd) {
	      this.pwd = pwd;
	   }

	   public void setCountryId(final Integer countryId) {
	      this.countryId = countryId;
	   }

	   public void setStateId(final Integer stateId) {
	      this.stateId = stateId;
	   }

	   public void setCityId(final Integer cityId) {
	      this.cityId = cityId;
	   }
	}