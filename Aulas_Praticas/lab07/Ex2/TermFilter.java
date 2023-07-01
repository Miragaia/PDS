public class TermFilter extends Filter {
    private int term;
    private String[] terms = null;

    public TermFilter(FilterInterface termReader) {
        super(termReader);
        this.term = 0;
        this.terms = new String[0];
    }

    public boolean hasNext() {
        if (super.hasNext()) {
            return true;
        } else if (this.terms != null && this.term < this.terms.length) {
            return true;
        } else {
            return false;
        }
    }

    public String next() {
        if (!this.hasNext()) {
            return null;
        }
        if (this.term != 0 && this.term < this.terms.length) {
            this.term++;
            return this.terms[this.term - 1];
        } else if (super.hasNext()) {
            this.terms = super.next().split(" ");
            this.term = 1;
            return this.next();
        } else {
            return null;
        }
    }
}
