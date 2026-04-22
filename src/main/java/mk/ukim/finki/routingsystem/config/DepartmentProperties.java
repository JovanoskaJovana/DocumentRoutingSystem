package mk.ukim.finki.routingsystem.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Configuration properties for a single department, containing the strong, weak and negative lists of words.
 */
@Getter
@Setter
public class DepartmentProperties {

  private List<String> strong;
  private List<String> weak;
  private List<String> negative;

}
