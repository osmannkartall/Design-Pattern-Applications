//Population class
class Population {
    int populationSize;
    SiblingPair[] siblingPairs;
    double fittest;
    double leastFit;

    public Population(int populationSize) {
        this.populationSize = populationSize;
        siblingPairs = new SiblingPair[populationSize / 2];
        double fittest = 0.0;
    }

    //Initialize population
    public void initializePopulation() {
        for (int i = 0; i < siblingPairs.length; i++) {
            siblingPairs[i] = new SiblingPair();
        }
    }

    //Get the fittest individual
    public SiblingPair getFittest() {
        double maxFit = Double.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < siblingPairs.length; i++) {
            if (maxFit <= siblingPairs[i].fitness) {
                maxFit = siblingPairs[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = siblingPairs[maxFitIndex].fitness;
        return siblingPairs[maxFitIndex];
    }

    public SiblingPair getLeastFit() {
        double minFit = Double.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < siblingPairs.length; i++) {
            if (minFit > siblingPairs[i].fitness) {
                minFit = siblingPairs[i].fitness;
                minFitIndex = i;
            }
        }
        leastFit = siblingPairs[minFitIndex].fitness;
        return siblingPairs[minFitIndex];
    }

    //Calculate fitness of each individual
    public void calculateFitness() {
        for (int i = 0; i < siblingPairs.length; i++) {
            siblingPairs[i].calcFitness();
        }
        getFittest();
    }

}