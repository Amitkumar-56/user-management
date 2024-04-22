package in.ashokit.dto;
public class QuoteDto {
	   private String text;
	   private String author;

	   public String getText() {
	      return this.text;
	   }

	   public String getAuthor() {
	      return this.author;
	   }

	   public void setText(final String text) {
	      this.text = text;
	   }

	   public void setAuthor(final String author) {
	      this.author = author;
	   }
	}
	    