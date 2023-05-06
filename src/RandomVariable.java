import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RandomVariable {
    ArrayList<Integer> sampling; // вибірка
    public RandomVariable(ArrayList<Integer> sampling) {
        this.sampling = sampling;
    }

    public float getExpectedValue() { // Математичне сподівання
        float sum = 0;

        HashMap<Integer, Float> probabilities = new HashMap();

        for (int value : sampling) {
            if (probabilities.containsKey(value)) continue;

            probabilities.put(value, getProbability(value));
        }

        for(Map.Entry<Integer, Float> entry : probabilities.entrySet()) {
            Integer key = entry.getKey();
            Float value = entry.getValue();

            sum += key * value;
        }

        return sum;
    }

    public float getDispersion() {
        float expectedValue = getExpectedValue();
        float expectedValueSquared = expectedValue * expectedValue;

        ArrayList<Integer> copy = new ArrayList<>(sampling);
        for (int i = 0; i < copy.size(); i++) {
            var value = copy.get(i);
            copy.set(i, value * value);
        }

        RandomVariable randSquared = new RandomVariable(copy);
        float expectedValueOfRandSquared = randSquared.getExpectedValue();

        return expectedValueOfRandSquared - expectedValueSquared;
    }

    public double getStandartError() {
        var dispersion = getDispersion();
        return Math.sqrt(dispersion);
    }

    private float getProbability(int value) {
        float total = sampling.size();
        float count = countOccurrences(value);

        return count / total;
    }

    private int countOccurrences(int x) {
        int count = 0;
        for (int num : sampling) {
            if (num == x) {
                count++;
            }
        }
        return count;
    }
}
