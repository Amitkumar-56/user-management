package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
   name = "city_master"
)
public class CityEntity {
   @Id
  
   private Integer cityId;
   private String cityName;
   @ManyToOne
   @JoinColumn(
      name = "state_id"
   )
   private StateEntity state;

   public void setCityId(final Integer cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setState(final StateEntity state) {
      this.state = state;
   }

   public Integer getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public StateEntity getState() {
      return this.state;
   }
}