/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.datatype;

import database.StatementFactory;
import java.util.List;
import logic.IEvent;

/**
 *
 * @author xuan
 */
public abstract class BaseEvent implements IEvent {
    @Override
    public List<CommentEvent> getEventComments(int from, int topnum) {
        List<CommentEvent> comments = StatementFactory.getQuery().getEventComment("hostid", this.getEventID(), from + topnum);
        return comments.subList(from, Math.min(from + topnum, comments.size()));
    }

    @Override
    public int getEventCommentNum() {
        return StatementFactory.getQuery().getEventCommentCount("hostid", this.getEventID());
    }
}
