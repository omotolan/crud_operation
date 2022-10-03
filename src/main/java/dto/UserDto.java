package dto;

import data.model.Stack;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
public class UserDto {
    private String firstName;
    private String lastName;
    private List<Stack> stacks;
}
