package mx.com.company;

import java.util.Arrays;

/**
 * <p>
 * Lectus malesuada magna taciti odio diam placerat congue. Purus nisi euismod
 * facilisis! Sagittis nascetur pharetra leo congue vehicula commodo lobortis
 * cras tincidunt metus nullam curabitur. Class cursus, viverra dis curae;.
 * Sollicitudin morbi enim a faucibus. {@link Population}. Dictumst cubilia
 * faucibus aliquet purus netus eros tempor lobortis. Nulla adipiscing est
 * gravida suspendisse mi ultrices porttitor.
 *
 * <p>
 * Commodo interdum fringilla ante? Hac blandit molestie risus ut hendrerit
 * curae; sociis dignissim litora lobortis potenti vivamus. Consectetur accumsan
 * tempor commodo penatibus nullam pellentesque sociosqu. Sociis odio, eros
 * tempor euismod. Vehicula nec porttitor gravida faucibus habitant in conubia
 * ultrices fames. Elit ac penatibus sed eros hac porta ultrices. Semper est
 * quis mi litora facilisis ridiculus pulvinar.
 *
 * @author Kyle B. Hemmer
 * @version 1.0
 */
public class Chromosome {
    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    private boolean isFitnessChanged = true;
    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    private int fitness = 0;
    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    private int[] genes;

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     *
     * @param length length of the chromosome.
     */
    public Chromosome(int length) {
        genes = new int[length];
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public Chromosome initializeChromosome() {
        for (int i = 0; i < genes.length; i++) {
            if (Math.random() >= 0.5) {
                genes[i] = 1;
            } else {
                genes[i] = 0;
            }
        }
        return this;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     *
     * @return the chromosome fitness
     */
    public int getFitness() {
        if (isFitnessChanged) {
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     *
     * @param fitness the new fitness
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public int[] getGenes() {
        return genes;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     *
     * @param genes the new genes
     */
    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public int recalculateFitness() {
        int chromosomeFitness = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == GeneticAlgorithm.TARGET_CHROMOSOME[i]) {
                chromosomeFitness++;
            }
        }
        return chromosomeFitness;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public String toString() {
        return Arrays.toString(this.genes);
    }
}