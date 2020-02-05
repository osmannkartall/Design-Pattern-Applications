import java.util.Random;

class SiblingPair implements Comparable<SiblingPair>{
    double fitness;

    public String chromoX1;
    public double x1;
    public double x2;
    public String chromoX2;
    final int chromosomeLength = 10; // precision of the real numbers between [0-5].
    final int maxBound = (int) Math.pow(2, chromosomeLength);
    final double constraintUpperBound = 5.0;
    final double constraintLowerBound = 0.0;
    public SiblingPair() {
        fitness = 0.0;
        Random random = new Random();

        int randomInteger = random.nextInt(maxBound);
        chromoX1 = String.format("%" + chromosomeLength + "s", Integer.toString(randomInteger, 2))
                .replace(' ', '0');
        x1 = (constraintUpperBound * randomInteger) / maxBound;

        chromoX2 = null;
        while (chromoX2 == null) {
            int randomInteger2 = random.nextInt(maxBound);
            if (randomInteger + randomInteger2 <= maxBound) {
                chromoX2 = String.format("%" + chromosomeLength + "s", Integer.toString(randomInteger2, 2))
                        .replace(' ', '0');
                x2 = (constraintUpperBound * randomInteger2) / maxBound;
            }
        }
        calcFitness();
    }

    public double getFitness() {
        return fitness;
    }

    public SiblingPair(String chromoX1, String chromoX2) {
        this.chromoX1 = chromoX1;
        this.chromoX2 = chromoX2;
        calcRealValues();
        calcFitness();
    }

    public void calcRealValues() {
        int intX1 = Integer.parseInt(chromoX1, 2);
        int intX2 = Integer.parseInt(chromoX2, 2);
        x1 = (constraintUpperBound * intX1) / maxBound;
        x2 = (constraintUpperBound * intX2) / maxBound;
    }

    //Calculate fitness
    public void calcFitness() {
        fitness = 20 * x1 * x2 + 16 * x2 - 2 * Math.pow(x1, 2) - Math.pow(x2, 2) - Math.pow(x1 + x2, 2);
    }

    public int compareTo(SiblingPair other) {
        if(this.getFitness() > other.getFitness())
            return 1;
        else if (this.getFitness() == other.getFitness())
            return 0 ;
        return -1 ;
    }
}