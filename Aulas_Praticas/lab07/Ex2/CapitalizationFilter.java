public class CapitalizationFilter extends Filter {

    private String currentString;

    public CapitalizationFilter(FilterInterface filter) {
        super(filter);
    }

    @Override
    public boolean hasNext() {
        if (this.currentString == null || this.currentString.isEmpty()) {
            if (super.hasNext()) {
                currentString = super.next();
            }
        }
        return !(this.currentString == null || this.currentString.isEmpty());
    }

    @Override
    public String next() {
        if (!hasNext()) {
            return null;
        }

        String firstChar = currentString.substring(0, 1).toUpperCase();
        String lastChar = currentString.substring(currentString.length() - 1).toUpperCase();
        String middleChars = "";

        if (currentString.length() > 2) {
            middleChars = currentString.substring(1, currentString.length() - 1).toLowerCase();
        } else if (currentString.length() == 2) {
            return firstChar + lastChar;
        }

        currentString = "";
        return firstChar + middleChars + lastChar;
    }
}
