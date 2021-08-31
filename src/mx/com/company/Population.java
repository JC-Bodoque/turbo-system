/*
 * Replace this license header with the corresponding LICENSE.
 */
package mx.com.company;

import java.util.Arrays;

/**
 * <p>
 * This class represents a population. Lectus malesuada magna taciti odio diam
 * placerat congue. Purus nisi euismod facilisis! Sagittis nascetur pharetra leo
 * congue vehicula commodo lobortis cras tincidunt metus nullam curabitur. Class
 * cursus, viverra dis curae;. Sollicitudin morbi enim a faucibus. Dictumst
 * cubilia faucibus aliquet purus netus eros tempor lobortis. Nulla adipiscing
 * est gravida suspendisse mi ultrices porttitor.
 *
 * <p>
 * Commodo interdum fringilla ante? Hac blandit molestie risus ut hendrerit
 * curae; sociis dignissim litora lobortis potenti vivamus. Consectetur accumsan
 * tempor commodo penatibus nullam pellentesque sociosqu. Sociis odio, eros
 * tempor euismod. Vehicula nec porttitor gravida faucibus habitant in conubia
 * ultrices fames. {@link Chromosome}. Elit ac penatibus sed eros hac porta
 * ultrices. Semper est quis mi litora facilisis ridiculus pulvinar.
 *
 * @author Kyle B. Hemmer
 * @version 1.0
 */
public class Population {
    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    private Chromosome[] chromosomes;

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     * 
     * @param length the length of the population.
     */
    public Population(int length) {
        chromosomes = new Chromosome[length];
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public void sortChromosomesByFitness() {
        Arrays.sort(chromosomes, (chromosome1, chromosome2) -> {
            int flag = 0;
            if (chromosome1.getFitness() > chromosome2.getFitness()) {
                flag = -1;
            } else if (chromosome1.getFitness() < chromosome2.getFitness()) {
                flag = 1;
            }
            return flag;
        });
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public Population initializePopulation() {
        for (int i = 0; i < chromosomes.length; i++) {
            chromosomes[i] = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length).initializeChromosome();
        }
        sortChromosomesByFitness();
        return this;
    }

    /**
     * This method return the population chromosomes.
     */
    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    /**
     * This is the typical format of a simple documentation comment that spans two
     * lines.
     */
    public void setChromosomes(Chromosome[] chromosomes) {
        this.chromosomes = chromosomes;
    }
}