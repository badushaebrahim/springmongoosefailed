package training.Immobilier.experience.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    Optional<Object> Data;
    Optional<String> Error;
    String Status;

}

