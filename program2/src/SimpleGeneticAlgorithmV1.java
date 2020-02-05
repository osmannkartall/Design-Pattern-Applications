import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * V1 | selection: “roulette wheel selection", crossover: 1-point
 *
 * @author Osman Kartal
 */
class SimpleGeneticAlgorithmV1 extends SimpleGeneticAlgorithm {
    /**
     * Roulette Wheel Selection Method
     */
    void selection() {
        double[] probabilities = new double[population.siblingPairs.length];
        double sumFitness = sumFitness();
        //Select the most fittest individual so that we can stop searching.
        fittest = population.getFittest();

        // Calculate probabilities and distribute them as magnitude.
        for (int i = 0; i < population.siblingPairs.length; i++) {
            if (population.siblingPairs[i].fitness < 0.0) {
                population.siblingPairs[i].fitness = 0.0;
            }
            probabilities[i] = population.siblingPairs[i].fitness / sumFitness;
        }

        // Match lower probability magnitudes with smaller numbers(and vice versa).
        Arrays.sort(probabilities);
        Arrays.sort(population.siblingPairs, Comparator.comparing(SiblingPair::getFitness));

        // Generate a random number as magnitude.
        // Find its matching fitness value and assign the pair that have this value to the next slot.
        Random rand = new Random();
        double randProbMagnitude = 0.0;
        for (int i = 0; i < population.siblingPairs.length; i++) {
            randProbMagnitude = rand.nextDouble();
            if (randProbMagnitude < probabilities[0]) {
                population.siblingPairs[i] = population.siblingPairs[0];
            }
            else {
                for(int j = 1; j < probabilities.length; j++) {
                    if (randProbMagnitude >= probabilities[j-1] && randProbMagnitude < probabilities[j]) {
                        population.siblingPairs[i] = population.siblingPairs[j];
                        break;
                    }
                }
            }
        }
    }

    /**
     * 1-point Crossover Method
     */
    void crossover() {
        double crossProbMagnitude = 0.7;
        Random rand = new Random();
        double probability = rand.nextDouble();
        if (probability <= crossProbMagnitude) {
            onePointCrossover();
        }
    }
}
