class FindGene {
    public String findGeneSimple(String s) {
        // start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        int start_ptr = s.indexOf("ATG");
        if (start_ptr == -1) {
            return "no gene found - no start";
        }
        
        int stop_ptr = s.indexOf("TAA", start_ptr + 3);
        if (stop_ptr == -1) {
            return "no gene found - no stop";
        } 

        if ((stop_ptr - start_ptr) % 3 == 0) {
            result = s.substring(start_ptr, stop_ptr + 3);
        }
        else {
            result = "no gene found - invalid length";
        }



        return result; 
    }
}

/**
 * FineGene
 */
public class FindGeneTest {
    public static void main(String[] args) {
        String dna_1 = "CGATGCGTATCCTGTAA"; 
        String dna_2 = "ATGCGCGTAGT";
        String dna_3 = "ATGATCGCTAATGCTTAAGCTATG";

        FindGene findgene = new FindGene(); 
        System.out.println(findgene.findGeneSimple(dna_1));
        System.out.println(findgene.findGeneSimple(dna_2));

    }

}
