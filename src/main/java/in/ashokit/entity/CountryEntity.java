package in.ashokit.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(
   name = "country_master"
)
public class CountryEntity {
   @Id
   
   private Integer countryId;
   private String countryName;

   public void setCountryId(final Integer countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public Integer getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }
}
    