package in.ashokit.dto;

public class UserDto {
   private Integer userId;
   private String name;
   private String email;
   private String phno;
   private String pwd;
   private String pwdUpdated;
   private String newPwd;
   private String confirmPwd;
   private Integer countryId;
   private Integer stateId;
   private Integer cityId;

   public Integer getUserId() {
      return this.userId;
   }

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

   public String getPwdUpdated() {
      return this.pwdUpdated;
   }

   public String getNewPwd() {
      return this.newPwd;
   }

   public String getConfirmPwd() {
      return this.confirmPwd;
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

   public void setUserId(final Integer userId) {
      this.userId = userId;
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

   public void setPwdUpdated(final String pwdUpdated) {
      this.pwdUpdated = pwdUpdated;
   }

   public void setNewPwd(final String newPwd) {
      this.newPwd = newPwd;
   }

   public void setConfirmPwd(final String confirmPwd) {
      this.confirmPwd = confirmPwd;
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