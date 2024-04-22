package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "user_entity"
)
public class UserEntity {
   @Id
   @GeneratedValue(
      strategy = GenerationType.IDENTITY
   )
   private Integer userId;
   private String name;
   private String email;
   private String pwd;
   private String pwdUpdated;
   private Long phno;
   @ManyToOne
   @JoinColumn(
      name = "country_id"
   )
   private CountryEntity country;
   @ManyToOne
   @JoinColumn(
      name = "state_id"
   )
   private StateEntity state;
   @ManyToOne
   @JoinColumn(
      name = "city_id"
   )
   private CityEntity city;
   @CreationTimestamp
   private LocalDate createdDate;
   @UpdateTimestamp
   private LocalDate updatedDate;

   public void setUserId(final Integer userId) {
      this.userId = userId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public void setPwd(final String pwd) {
      this.pwd = pwd;
   }

   public void setPwdUpdated(final String pwdUpdated) {
      this.pwdUpdated = pwdUpdated;
   }

   public void setPhno(final Long phno) {
      this.phno = phno;
   }

   public void setCountry(final CountryEntity country) {
      this.country = country;
   }

   public void setState(final StateEntity state) {
      this.state = state;
   }

   public void setCity(final CityEntity city) {
      this.city = city;
   }

   public void setCreatedDate(final LocalDate createdDate) {
      this.createdDate = createdDate;
   }

   public void setUpdatedDate(final LocalDate updatedDate) {
      this.updatedDate = updatedDate;
   }

   public Integer getUserId() {
      return this.userId;
   }

   public String getName() {
      return this.name;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPwd() {
      return this.pwd;
   }

   public String getPwdUpdated() {
      return this.pwdUpdated;
   }

   public Long getPhno() {
      return this.phno;
   }

   public CountryEntity getCountry() {
      return this.country;
   }

   public StateEntity getState() {
      return this.state;
   }

   public CityEntity getCity() {
      return this.city;
   }

   public LocalDate getCreatedDate() {
      return this.createdDate;
   }

   public LocalDate getUpdatedDate() {
      return this.updatedDate;
   }
}