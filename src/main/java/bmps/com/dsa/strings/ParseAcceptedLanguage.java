package bmps.com.dsa.strings;

import java.util.HashSet;
import java.util.Set;

public class ParseAcceptedLanguage {

    //"fr-CA, fr-FR", ["en-US", "fr-FR"]
    public Set<String> parseAcceptLanguage(String preferredLanguages, Set<String> supportedLanguages) {
        Set<String> result = new HashSet<>();
        for (var language : preferredLanguages.split(", ")) {
            if (supportedLanguages.contains(language)) {
                result.add(language);
            }
        }
        return result;
    }
}
