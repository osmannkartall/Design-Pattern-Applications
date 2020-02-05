import java.util.Random;

/**
 * V3 | selection: “tournament selection", crossover: 1-point
 *
 * @author Osman Kartal
 */
class SimpleGeneticAlgorithmV3 extends SimpleGeneticAlgorithm {
    /**
     * Tournament Selection Method
     */
    void selection() {
        System.out.println("Tournament Selection");
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
