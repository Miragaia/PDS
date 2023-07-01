import java.text.Normalizer;

public class NormalizationFilter extends Filter {

    private String currentWord;

    public NormalizationFilter(FilterInterface termReader) {
        super(termReader);
    }

    @Override
    public boolean hasNext() {
        if (this.currentWord == null) {
            if (super.hasNext()) {
                this.currentWord = super.next();
            }
        }
        return (this.currentWord != null);
    }

    @Override
    public String next() {
        if (!hasNext()) {
            return null;
        }
        String normalizedWord = Normalizer.normalize(currentWord, Normalizer.Form.NFKD);
        normalizedWord = normalizedWord.replaceAll("[^\\p{ASCII}]", "");
        normalizedWord = normalizedWord.replaceAll("[.!?\\-,]", "");
        this.currentWord = null;
        return normalizedWord;
    }
}
