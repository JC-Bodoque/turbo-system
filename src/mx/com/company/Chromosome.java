package mx.com.company;

import java.util.Arrays;

/*
 *<p>
Lectus malesuada magna taciti odio diam placerat congue. Purus nisi euismod facilisis! Sagittis nascetur pharetra leo congue vehicula commodo lobortis cras tincidunt metus nullam curabitur. Class cursus, viverra dis curae;. Sollicitudin morbi enim a faucibus. Dictumst cubilia faucibus aliquet purus netus eros tempor lobortis. Nulla adipiscing est gravida suspendisse mi ultrices porttitor. Ultrices in magna imperdiet eleifend neque tempus senectus? Habitant urna praesent suspendisse. Sed?
</p>
<p>
Commodo interdum fringilla ante? Hac blandit molestie risus ut hendrerit curae; sociis dignissim litora lobortis potenti vivamus. Consectetur accumsan tempor commodo penatibus nullam pellentesque sociosqu? Sociis odio, eros tempor euismod. Vehicula nec porttitor gravida faucibus habitant in conubia ultrices fames. Sagittis duis senectus tristique cum ante rhoncus? Elit ac penatibus sed eros hac porta ultrices? Semper est quis mi litora facilisis ridiculus pulvinar.
</p>
<p>
Pharetra dapibus, magna rutrum nullam. Id penatibus lectus facilisis arcu dapibus massa commodo vitae praesent phasellus taciti accumsan. Proin nullam himenaeos at gravida sem viverra vulputate? A consectetur fringilla dignissim dignissim euismod conubia natoque gravida pretium? Faucibus, ultrices urna velit laoreet. Vel consequat nam turpis consequat fermentum adipiscing, potenti elementum phasellus litora. Facilisis aliquet blandit curae; dui turpis metus. Laoreet pulvinar ridiculus pellentesque per faucibus mattis purus sodales dictum? Magna, cum lacinia mattis velit placerat.
</p>
<p>
Lobortis non habitant maecenas ultrices. Sed vitae cubilia, platea justo ultricies sodales. At, conubia et id vestibulum vestibulum magna a fermentum sagittis hac vitae. Venenatis interdum interdum interdum maecenas montes. Mollis maecenas iaculis tempus posuere laoreet ridiculus sociis hac facilisis. Sollicitudin, quam fringilla purus porta taciti nullam mollis primis et aenean litora dis. Suscipit maecenas tincidunt sodales pharetra velit facilisi elementum pharetra ac viverra. Penatibus semper lacus, leo vestibulum ipsum nibh torquent etiam fames phasellus. Dis aenean egestas praesent lorem pharetra facilisis elementum netus in natoque ultrices. Viverra feugiat vehicula molestie platea sagittis.
</p>
<p>
Mollis per dolor molestie ipsum orci tellus suscipit varius ullamcorper facilisi torquent in. Netus, aliquet duis fermentum bibendum in. Pulvinar torquent aenean nulla nisl rutrum potenti faucibus in congue, mollis fames lacinia. Condimentum penatibus enim cum vehicula aenean eros tempus imperdiet vestibulum. Penatibus cum mollis quam lacus magna accumsan pellentesque tincidunt at! Mollis etiam montes felis. Vestibulum ad dictum senectus. Ornare dapibus habitant ullamcorper at ultricies. Blandit at turpis magnis quisque at cras quisque natoque himenaeos felis montes eleifend. Leo congue dictum phasellus dolor, nam tortor. Felis dis est neque gravida.
</p>
 */
public class Chromosome {
    private boolean isFitnessChanged = true;
    private int fitness = 0;
    private int[] genes;

    public Chromosome(int length) {
        genes = new int[length];
    }

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

    public int getFitness() {
        if (isFitnessChanged) {
            fitness = recalculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public int recalculateFitness() {
        int chromosomeFitness = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == GeneticAlgorithm.TARGET_CHROMOSOME[i]) {
                chromosomeFitness++;
            }
        }
        return chromosomeFitness;
    }

    public String toString() {
        return Arrays.toString(this.genes);
    }
}
