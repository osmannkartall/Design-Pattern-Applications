import java.util.*;

/**
 * The abstract class SimpleGeneticAlgorithm
 *
 * @author Osman Kartal
 */
abstract class SimpleGeneticAlgorithm {
    Population population;
    private final int populationSize = 50;
    SiblingPair fittest;
    private final int maximumIteration = 200;
    private final double maximal = 125.0;

    SimpleGeneticAlgorithm() {
        population = new Population(populationSize);
    }

    /**
     * Template Method
     */
    final void createGenerations() {
        // Generate the initial population
        population.initializePopulation();
        System.out.println("Initial Random Population");
        System.out.println("    X1    |    X2");
        displayChromosomes();

        // Compute fitness
        population.calculateFitness();
        displayExtremeFitnessValues();
        System.out.println();

        // REPEAT
        int i;
        for (i = 1; i <= maximumIteration && population.fittest < maximal; i++) {
            System.out.println("Generation" + i);
            System.out.println("-----------------------------------------");
            System.out.println("-> Roulette Wheel Selection");
            System.out.println("--> Shuffle mating pool.");
            System.out.print("---> After Crossover & Mutation: ");
            // Selection
            selection();
            shuffleMatingPool();
            // Crossover
            crossover();
            // Mutation
            mutation();
            // Compute Fitness
            population.calculateFitness();
            displayExtremeFitnessValues();
            System.out.println();
        }

        if (i == maximumIteration) {
            System.out.println("You reached the maximum iteration number.");
        } else {
            System.out.println("You reached a number that greater than maximal.");
        }
    }

    /**
     * Display minimum and maximum fitness values in current population.
     */
    private void displayExtremeFitnessValues() {
        System.out.print("Fittest: " + population.fittest);
        System.out.println(" | LEAST: " + population.getLeastFit().fitness);
    }

    /**
     * Display real numbers that represented by chromosome pairs in current population.
     */
    private void displayRealValues() {
        for (int i = 0; i < population.siblingPairs.length; i++) {
            System.out.print(population.siblingPairs[i].x1);
            System.out.print(",");
            System.out.println(population.siblingPairs[i].x2);
        }
    }

    /**
     * Display the bit string representations of x1 and x2 real numbers.
     */
    private void displayChromosomes() {
        for (int i = 0; i < population.siblingPairs.length; i++) {
            System.out.println(population.siblingPairs[i].chromoX1 + ',' + population.siblingPairs[i].chromoX2);
        }
    }

    abstract void selection();

    abstract void crossover();

    /**
     * It shuffles the population that comes from selection. Thus, it provides
     * more randomness to crossover operation.
     */
    private void shuffleMatingPool() {
        List siblingPairsList = Arrays.asList(population.siblingPairs);
        Collections.shuffle(siblingPairsList);
        siblingPairsList.toArray(population.siblingPairs);
    }

    /**
     * @return total sum of fitness values of pairs.
     */
    double sumFitness() {
        double result = 0.0;
        for (int i = 0; i < population.siblingPairs.length; i++) {
            result += population.siblingPairs[i].fitness;
        }
        return result;
    }

    /**
     * 1-bit flip mutation
     */
    private void mutation() {
        // These are statistical boundaries for mutation probability
        // We don't want to do too many mutations thus probability value for a gene is very small.
        double lowerBound = 1.0 / populationSize;
        double upperBound = 1.0 / population.siblingPairs[0].chromosomeLength;

        Random rand = new Random();
        for (int i = 0; i < population.siblingPairs.length; i++) {
            String temp = population.siblingPairs[i].chromoX1;
            for (int j = 0; j < population.siblingPairs[0].chromosomeLength; j++) {
                double probability = rand.nextDouble();
                if (probability >= lowerBound && probability < upperBound) {
                    temp = bitFlip(temp, j);
                    SiblingPair mutation = new SiblingPair(temp, population.siblingPairs[i].chromoX2);
                    if (isFeasible(mutation)) {
                        population.siblingPairs[i] = mutation;
                    }
                }
            }
            // TODO: fix Duplicate Code
            temp = population.siblingPairs[i].chromoX2;
            for (int j = 0; j < population.siblingPairs[0].chromosomeLength; j++) {
                double probability = rand.nextDouble();
                if (probability >= lowerBound && probability < upperBound) {
                    temp = bitFlip(temp, j);
                    SiblingPair mutation = new SiblingPair(population.siblingPairs[i].chromoX1, temp);
                    if (isFeasible(mutation)) {
                        population.siblingPairs[i] = mutation;
                    }
                }
            }
        }
    }

    /**
     * Flips the bit 0-1 or vice versa.
     *
     * @param chromosome the string representation of a real number
     * @param index      gene index
     * @return flipped chromosome
     */
    private String bitFlip(String chromosome, int index) {
        char[] temp = chromosome.toCharArray();
        if (temp[index] == '1') {
            temp[index] = '0';
        } else {
            temp[index] = '1';
        }
        return String.valueOf(temp);
    }

    /**
     * It checks whether two real numbers in a pair violate boundary rules.
     *
     * @param pair a chromosome pair
     * @return true: not violated, false: violated
     */
    private boolean isFeasible(SiblingPair pair) {
        return pair.x1 <= pair.constraintUpperBound && pair.x2 <= pair.constraintUpperBound &&
                pair.x1 >= pair.constraintLowerBound && pair.x2 >= pair.constraintLowerBound &&
                pair.x1 + pair.x2 <= pair.constraintUpperBound;
    }

    /**
     * Applies 1-point crossover to the current population.
     */
    void onePointCrossover() {
        char[] firstOffspringX1, firstOffspringX2;
        char[] secondOffspringX1, secondOffspringX2;
        int iterBound;

        if (population.siblingPairs.length % 2 == 1) {
            iterBound = population.siblingPairs.length - 1;
        } else {
            iterBound = population.siblingPairs.length;
        }

        Random rand = new Random();
        for (int i = 0; i < iterBound; i += 2) {
            // Define the crossover point.
            int randIndex = rand.nextInt(population.siblingPairs[0].chromosomeLength - 1) + 1;

            // Match 2 adjacent pairs with each other.
            firstOffspringX1 = population.siblingPairs[i].chromoX1.toCharArray();
            firstOffspringX2 = population.siblingPairs[i].chromoX2.toCharArray();
            secondOffspringX1 = population.siblingPairs[i + 1].chromoX1.toCharArray();
            secondOffspringX2 = population.siblingPairs[i + 1].chromoX2.toCharArray();

            // Apply crossover.
            for (int j = 0; j < randIndex; j++) {
                firstOffspringX1[j] = population.siblingPairs[i + 1].chromoX1.charAt(j);
                firstOffspringX2[j] = population.siblingPairs[i + 1].chromoX2.charAt(j);
                secondOffspringX1[j] = population.siblingPairs[i].chromoX1.charAt(j);
                secondOffspringX2[j] = population.siblingPairs[i].chromoX2.charAt(j);
            }

            SiblingPair first = new SiblingPair(String.valueOf(firstOffspringX1), String.valueOf(firstOffspringX2));
            SiblingPair second = new SiblingPair(String.valueOf(secondOffspringX1), String.valueOf(secondOffspringX2));

            // Check whether child chromosomes are feasible.
            // If they are, change those with parents.
            if (isFeasible(first) && isFeasible(second)) {
                population.siblingPairs[i] = first;
                population.siblingPairs[i + 1] = second;
            }
        }
    }

    /**
     * Applies 2-point crossover to the current population.
     */
    void twoPointCrossover() {
    }
}