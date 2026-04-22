package mk.ukim.finki.routingsystem.model.dto.Routing;

import java.util.List;
import java.util.regex.Pattern;

/**
 * DTO containing compiled regex patterns for strong, weak and negative routing keywords.
 *
 * @param strong   the list of strong keyword patterns
 * @param weak     the list of weak keyword patterns
 * @param negative the list of negative keyword patterns
 */
public record CompiledRules(

        List<Pattern> strong,
        List<Pattern> weak,
        List<Pattern> negative
) {
}
