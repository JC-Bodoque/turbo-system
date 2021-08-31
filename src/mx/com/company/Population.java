/*
 * To change this license header, choose License Headers in Project Properties.
 */
package mx.com.company;

import java.util.Arrays;

/*
 * 
 */
public class Population {
    private Chromosome[] chromosomes;

    public Population(int length) {
        chromosomes = new Chromosome[length];
    }

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

    public Population initializePopulation() {
        for (int i = 0; i < chromosomes.length; i++) {
            chromosomes[i] = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length).initializeChromosome();
        }
        sortChromosomesByFitness();
        return this;
    }

    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(Chromosome[] chromosomes) {
        this.chromosomes = chromosomes;
    }
}
