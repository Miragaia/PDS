public class VowelFilter extends Filter {
    public VowelFilter(FilterInterface termReader){
        super(termReader);
    }

    @Override
    public String next(){
        String noVowels = "";
        while (super.hasNext()) {
            noVowels += super.next().replaceAll("[aeiouAEIOU]", "");
        }
        return noVowels;
    }
}
