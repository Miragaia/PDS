public class Filter implements FilterInterface {
    private FilterInterface filter;

    public Filter(FilterInterface filter) {
        this.filter = filter;
    }

    @Override
    public boolean hasNext() {
        return filter.hasNext();
    }

    @Override
    public String next() {
        return filter.next();
    }

}

    

