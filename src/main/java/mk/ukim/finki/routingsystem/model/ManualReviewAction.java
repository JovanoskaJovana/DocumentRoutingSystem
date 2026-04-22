package mk.ukim.finki.routingsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity representing a manual review action in the system.
 */

@Entity
@Data
public class ManualReviewAction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Company company;

  @ManyToOne
  private Department manualChosenDepartment;

  @Column(columnDefinition = "TEXT")
  private String documentTitle;

  @Column(columnDefinition = "TEXT")
  private String documentText;

  private LocalDateTime timestamp;

  public ManualReviewAction() {
  }

}
