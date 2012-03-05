/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utility.alg;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author xuan
 */
public class RandomAlg {
    // choose number of distinct integer from the range [start, end)
    public static int[] RandomChooseInRange(int start, int end, int number) {
        int[] result = null;
        if (number > end - start) {
            result = new int[end - start];
            for (int i = 0; i != end - start; ++i) {
                result[i] = i + start;
            }
        } else if ( number > (end - start) /2 ) {
            TreeMap<Double, Integer> tree = new TreeMap<Double, Integer>();
            for (int i = 0; i != end - start; ++i) {
                tree.put(Math.random(), i);
            }
            result = new int[number];
            int index = 0;
            for (Map.Entry<Double, Integer> pair : tree.entrySet()) {
                result[index] = pair.getValue();
                index ++;
                if (index >= result.length) {
                    break;
                }
            }
        } else {
            Set<Integer> resultSet = new TreeSet<Integer>();
            while (resultSet.size() < number) {
                resultSet.add(start + (int)(Math.random() * (end - start)));
            }
            result = new int[number];
            int index = 0;
            for (Integer value : resultSet) {
                result[index] = value;
                index ++;
                if (index >= result.length) {
                    break;
                }
            }
        }
        return result;
    }
}
