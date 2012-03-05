/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author xuan
 */
public class StatementFactory {
    protected static Query q = null;
    protected static Modify m = null;
    
    public static Query getQuery() {
        if (q == null) {
            q = new Query();
        }
        return q;
    }

    public static Modify getModify() {
        if (m == null) {
            m = new Modify();
        }
        return m;
    }
}
