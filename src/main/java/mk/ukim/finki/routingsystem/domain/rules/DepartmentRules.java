package mk.ukim.finki.routingsystem.domain.rules;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Domain representation of routing rules for a single department, containing the lists of weak, strong and negative words.
 */

@Getter
@Setter
public class DepartmentRules {

  private List<String> strong;

  private List<String> weak;

  private List<String> negative;

}
