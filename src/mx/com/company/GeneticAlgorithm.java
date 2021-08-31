package mx.com.company;

/**
 * This class represents a single GeneticAlgorithm.
 * 
 * @author Kyle B. Hemmer
 * @version 1.0
 */
public class GeneticAlgorithm {
    public static final int POPULATION_SIZE = 10;
    public static final double MUTATION_RATE = 0.25;
    public static final int[] TARGET_CHROMOSOME = { 1, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
    public static final int NUMBER_OF_ELITE_CHROMOSOMES = 1;
    public static final int TOURNAMENT_SELECTION_SIZE = 5;

    /**
     * This method is used to cross a population with itself.
     * 
     * @param population the population to cross.
     * @return a crossed population
     */
    private Population crossover(Population population) {
        Population crossoverredPopulation = new Population(population.getChromosomes().length);
        for (int i = 0; i < NUMBER_OF_ELITE_CHROMOSOMES; i++) {
            crossoverredPopulation.getChromosomes()[i] = population.getChromosomes()[i];
        }
        for (int i = NUMBER_OF_ELITE_CHROMOSOMES; i < population.getChromosomes().length; i++) {
            Chromosome chromosome1 = selectTournamentPopulation(population).getChromosomes()[0];
            Chromosome chromosome2 = selectTournamentPopulation(population).getChromosomes()[0];
            crossoverredPopulation.getChromosomes()[i] = crossover(chromosome1, chromosome2);
        }
        return crossoverredPopulation;
    }

    /**
     * This method is used to mutate a population.
     * 
     * @param population population to mutate.
     * @return the mutated population
     */
    private Population mutate(Population population) {
        Population mutatedPopulation = new Population(population.getChromosomes().length);
        for (int i = 0; i < NUMBER_OF_ELITE_CHROMOSOMES; i++) {
            mutatedPopulation.getChromosomes()[i] = population.getChromosomes()[i];
        }
        for (int i = NUMBER_OF_ELITE_CHROMOSOMES; i < population.getChromosomes().length; i++) {
            mutatedPopulation.getChromosomes()[i] = mutate(population.getChromosomes()[i]);
        }
        return mutatedPopulation;
    }

    /**
     * This method is used to evolve the population.
     * 
     * @param population population to evolve
     * @return evolved population
     */
    public Population evolve(Population population) {
        return mutate(crossover(population));
    }

    /**
     * This method is used to cross two chromosomes.
     * 
     * @param chromosome1 the first chromosome
     * @param chromosome2 the second chromosome
     * @return crossoverred chromosome
     */
    public Chromosome crossover(Chromosome chromosome1, Chromosome chromosome2) {
        Chromosome crossoverredChromosome = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length);
        for (int i = 0; i < chromosome1.getGenes().length; i++) {
            if (Math.random() < 0.5) {
                crossoverredChromosome.getGenes()[i] = chromosome1.getGenes()[i];
            } else {
                crossoverredChromosome.getGenes()[i] = chromosome2.getGenes()[i];
            }
        }
        return crossoverredChromosome;
    }

    /**
     * This method is used to mutate a chromosome based on a mutaion rate.
     * 
     * @param chromosome the first chromosome
     * @return mutated chromosome
     */
    public Chromosome mutate(Chromosome chromosome) {
        Chromosome mutatedChromosome = new Chromosome(GeneticAlgorithm.TARGET_CHROMOSOME.length);
        for (int i = 0; i < chromosome.getGenes().length; i++) {
            if (Math.random() < MUTATION_RATE) {
                if (Math.random() < 0.5) {
                    mutatedChromosome.getGenes()[i] = 1;
                } else {
                    mutatedChromosome.getGenes()[i] = 0;
                }
            } else {
                mutatedChromosome.getGenes()[i] = chromosome.getGenes()[i];
            }
        }
        return mutatedChromosome;
    }

    /**
     * This method is used to select the best individuals to the tournament.
     * 
     * @param population
     * @return
     */
    public Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
        for (int i = 0; i < TOURNAMENT_SELECTION_SIZE; i++) {
            tournamentPopulation.getChromosomes()[i] = population
                    .getChromosomes()[(int) (Math.random() * population.getChromosomes().length)];
        }
        tournamentPopulation.sortChromosomesByFitness();
        return tournamentPopulation;
    }
}