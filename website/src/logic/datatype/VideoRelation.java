/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

/**
 *
 * @author xiaoxiao
 */
public class VideoRelation {
    int hostVideoid;
    int relatedVideoid;
    double weight;

    public VideoRelation() {}

    public VideoRelation(int hostVideoid, int relatedVideoid) {
        this.hostVideoid = hostVideoid;
        this.relatedVideoid = relatedVideoid;
    }

    public int getHostVideoid() {
        return hostVideoid;
    }

    public void setHostVideoid(int hostVideoid) {
        this.hostVideoid = hostVideoid;
    }

    public int getRelatedVideoid() {
        return relatedVideoid;
    }

    public void setRelatedVideoid(int relatedVideoid) {
        this.relatedVideoid = relatedVideoid;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return "VideoRelation: " + "hostVideoid = " + hostVideoid +
                "; relatedVideoid = " + relatedVideoid + "; weight = " + weight;
    }
}
