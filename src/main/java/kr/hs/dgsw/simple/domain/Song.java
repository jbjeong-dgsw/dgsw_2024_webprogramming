package kr.hs.dgsw.simple.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {
    private int songIdx;

    private String title;

    private String singer;

    private int year;

}
/*

CREATE TABLE song (
    song_idx    int             NOT NULL    AUTO_INCREMENT,
    title       VARCHAR(100)    NOT NULL,
    singer      VARCHAR(100),
    year        smallint,
    PRIMARY KEY (song_idx)
);


 */

