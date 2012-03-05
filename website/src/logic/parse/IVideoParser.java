/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic.parse;

import logic.IVideo;

/**
 *
 * @author xuan
 */
public interface IVideoParser {
    /**
     * Extract infomation in
     * filling in tiltel, siteSpecificId, snapshot
     *
     * refer can be:
     * video page url
     * @return
     * null: can't parse by this parser
     */
    public IVideo parse(String refer);
}
