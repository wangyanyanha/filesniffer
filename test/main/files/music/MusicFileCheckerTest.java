package main.files.music;//import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.util.regex.Matcher;

import static main.files.music.MusicFileChecker.OUTPUT_REGEX;

/**
 * Created by Dennis on 5-12-2016.
 */
public class MusicFileCheckerTest {
    MusicFileChecker m = new MusicFileChecker();

    @Test
    public void testRegex() throws Exception {
        Matcher matcher = OUTPUT_REGEX.matcher("- WARNING: No ID3V2.3.0 tag found, although this is the most popular tag for storing song information. [-1]");
        assert matcher.find();
        System.out.println("matcher.group(1) = " + matcher.group(1));
        System.out.println("matcher.group(2) = " + matcher.group(2));
        System.out.println("matcher.group(3) = " + matcher.group(3));
    }

    @Test
    public void checkMP3Valid() throws Exception {
        File mp3 = new File("D:\\Repos\\filesniffer\\files\\1-08 escape me.mp3");
        System.out.println("m.checkMP3("+mp3+") = " + m.checkMP3(mp3));
    }

    @Test
    public void checkMP3Corrupt() throws Exception {
        File mp3 = new File("D:\\Repos\\filesniffer\\files\\CORRUPT1-08 escape me - kopie.mp3");
        System.out.println("m.checkMP3("+mp3+") = " + m.checkMP3(mp3));
    }

    @Test
    public void checkMP3Missing() throws Exception {
        File mp3 = new File("D:\\Repos\\filesniffer\\files\\MISSING1-08 escape me - kopie.mp3");
        System.out.println("m.checkMP3("+mp3+") = " + m.checkMP3(mp3));
    }

}