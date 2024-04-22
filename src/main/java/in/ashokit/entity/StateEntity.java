package in.ashokit.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "state_master"
)
public class StateEntity {
   @Id

   private Integer stateId;
   private String stateName;
   @ManyToOne
   @JoinColumn(
      name = "country_id"
   )
   private CountryEntity country;

   public void setStateId(final Integer stateId) {
      this.stateId = stateId;
   }

   public void setStateName(final String stateName) {
      this.stateName = stateName;
   }

   public void setCountry(final CountryEntity country) {
      this.country = country;
   }

   public Integer getStateId() {
      return this.stateId;
   }

   public String getStateName() {
      return this.stateName;
   }

   public CountryEntity getCountry() {
      return this.country;
   }
}