package in.ashokit.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(
   prefix = "app"
)
public class AppProperties {
   private Map<String, String> message = new HashMap();

   public Map<String, String> getMessage() {
      return this.message;
   }

   public void setMessage(final Map<String, String> message) {
      this.message = message;
   }


}