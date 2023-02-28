package inicial.spring.boot.springboote.requests;
//DTO

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimePostRequestBody {
  @NotEmpty(message = "The anime name cannot be empty/null")
  private String name;
}
