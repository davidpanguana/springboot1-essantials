package spring.academy.springboot1.requestDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime name can not be empty")
    @NotNull(message = "The anime name can not be null")
    private String name;
}
