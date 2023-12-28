class Genome {
    public int findStopCodon(String dna, int startIndex, String codon){
        int currIndex = dna.indexOf(codon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            } else{
                currIndex = dna.indexOf(codon, currIndex + 1);
            }            
        }
        return -1;
    }

    public void testFindStop(){
        //            01234567890123456789012345  
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int index = findStopCodon(dna, 0, "TAA");
        if (index != 9) System.out.println("error on 9");

        index = findStopCodon(dna, 9, "TAA");
        if (index != 21) System.out.println("error on 21");

        index = findStopCodon(dna, 1, "TAA");
        if (index != -1) System.out.println("error on 26");

        index = findStopCodon(dna, 0, "TAG");
        if (index != -1) System.out.println("error on 26");

        System.out.println("Tests finished");
    }

    public String findGene(String dna){
        int start_index = dna.indexOf("ATG");
        if (start_index == -1) {
            return "";
        }
        int taa_index = findStopCodon(dna, start_index, "TAA");
        int tag_index = findStopCodon(dna, start_index, "TAG");
        int tga_index = findStopCodon(dna, start_index, "TGA"); 
        int min_index = 0;
        if (taa_index == -1 || 
            (tga_index != -1 && tga_index < taa_index)) {
            min_index = tga_index;
        } else {
            min_index = taa_index;
        }

        if (min_index == -1 ||(tag_index != -1 && tag_index < min_index)) {
            min_index = tag_index;
        }

        if (min_index == -1) {
            return "";
        }
        // int min_index = Math.min(taa_index, Math.min(tag_index, tga_index));
        
        return dna.substring(start_index, min_index + 3);
    }

    public void testFindGene() {
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna);
        System.out.println(gene);
        if (! gene.equals("ATGCCCGGGAAATAA")){
            System.out.println("error");
        }
        System.out.println("test of FindGene method finished");
    }

    public void printAllGenes(String dna){
        String dna_remainder = dna;
        int startPointer = 0;
        while (true) {
            String currentGene = findGene(dna_remainder);
            if (currentGene.isEmpty()) {
                System.out.println("The gene found is empty");
                break;
            }

            System.out.println(currentGene);
            startPointer = dna.indexOf(currentGene, startPointer) + 
                                    currentGene.length();
            dna_remainder = dna.substring(startPointer, dna.length() - 1);
        }
    }

    public void testPrintAllGenes(){
        String dna = "CGATGATCGCATGATTCATGCTTAAATAAAGCTCA";
        printAllGenes(dna);
    }
}

/**
 * GenomeApp
 */
public class GenomeApp {
    public static void main(String[] args) {
        Genome Genome = new Genome();
        // Genome.testFindStop();
        // Genome.testFindGene();
        Genome.testPrintAllGenes();
    }    
}
