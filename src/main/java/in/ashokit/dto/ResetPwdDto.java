package in.ashokit.dto;

public class ResetPwdDto {
	   private Integer userId;
	   private String email;
	   private String oldPwd;
	   private String newPwd;
	   private String confirmPwd;

	   public Integer getUserId() {
	      return this.userId;
	   }

	   public String getEmail() {
	      return this.email;
	   }

	   public String getOldPwd() {
	      return this.oldPwd;
	   }

	   public String getNewPwd() {
	      return this.newPwd;
	   }

	   public String getConfirmPwd() {
	      return this.confirmPwd;
	   }

	   public void setUserId(final Integer userId) {
	      this.userId = userId;
	   }

	   public void setEmail(final String email) {
	      this.email = email;
	   }

	   public void setOldPwd(final String oldPwd) {
	      this.oldPwd = oldPwd;
	   }

	   public void setNewPwd(final String newPwd) {
	      this.newPwd = newPwd;
	   }

	   public void setConfirmPwd(final String confirmPwd) {
	      this.confirmPwd = confirmPwd;
	   }
	}