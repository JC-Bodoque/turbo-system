package mx.com.company;

/**
 * <h3>Genetic algorithm</h3>
 *
 * <p>A genetic algorithm is a class of adaptive stochastic optimization algorithms
 * involving search and optimization. Genetic algorithms were first used by
 * Holland (1975).
 *
 * <p>The basic idea is to try to mimic a simple picture of natural selection to
 * find a good algorithm. The first step is to mutate, or randomly vary, a given
 * collection of sample programs. The second step is a selection step, which is
 * often done by measuring against a fitness function. The process is repeated
 * until a suitable solution is found.
 *
 * <p>There are a large number of different types of genetic algorithms. The step
 * involving mutation depends on how the sample programs are represented, as
 * well as whether the programmer includes various crossover techniques. The
 * fitness test is also up to the programmer.
 *
 * <p>Like a gradient flow optimization, the process can get stuck in a local
 * maximum of the fitness function. One advantage of a genetic algorithm is that
 * it does not require the fitness function to be very smooth, since a random
 * search is done instead of following the path of the least resistance. But to
 * be successful, there needs to be some nice relationship between the
 * modifiable parameters to the fitness. In general, one runs into computational
 * irreducibility.
 *
 * <p>Holland created an electronic organism as a binary string (“chromosome”) and
 * then used genetic and evolutionary principles of fitness-proportionate
 * selection for reproduction (including random crossover and mutation) to
 * search enormous solution spaces efficiently. So-called genetic programming
 * languages apply the same principles, using an expression tree instead of a
 * bit string as the "chromosome."
 */
public class GeneticAlgorithm {
    public static final int POPULATION_SIZE = 10;
    public static final double MUTATION_RATE = 0.25;
    public static final int[] TARGET_CHROMOSOME = {1, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    public static final int NUMBER_OF_ELITE_CHROMOSOMES = 1;
    public static final int TOURNAMENT_SELECTION_SIZE = 5;

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

    public Population evolve(Population population) {
        return mutate(crossover(population));
    }

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

    public Population selectTournamentPopulation(Population population) {
        Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE);
        for (int i = 0; i < TOURNAMENT_SELECTION_SIZE; i++) {
            tournamentPopulation.getChromosomes()[i] = population.getChromosomes()[(int) (Math.random() * population.getChromosomes().length)];
        }
        tournamentPopulation.sortChromosomesByFitness();
        return tournamentPopulation;
    }
}
