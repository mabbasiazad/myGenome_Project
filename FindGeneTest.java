class FindGene {
    public String findGeneSimple(String s) {
        // start codon is "ATG"
        // stop codon is "TAA"
        int start_ptr = s.indexOf("ATG");
        if (start_ptr == -1) {
            return "";
        }
        
        int stop_ptr = s.indexOf("TAA", start_ptr + 3);

        while (stop_ptr != -1) {
            if ((stop_ptr - start_ptr) % 3 == 0) {
            return s.substring(start_ptr, stop_ptr + 3);
            } else{ 
                stop_ptr = s.indexOf("TAA", stop_ptr + 1);
            }
        }
            
        return ""; 
    }
}

/**
 * FineGene
 */
public class FindGeneTest {
    public static void main(String[] args) {
        // String dna_1 = "CGATGCGTATCCTGTAA"; 
        // String dna_2 = "ATGCGCGTAGT";
        String dna_3 = "ATGATCGCTAATGCTTAAGCTATG";

        FindGene findgene = new FindGene(); 
        // System.out.println(findgene.findGeneSimple(dna_1));
        // System.out.println(findgene.findGeneSimple(dna_2));
        System.out.println(findgene.findGeneSimple(dna_3));

    }

}
