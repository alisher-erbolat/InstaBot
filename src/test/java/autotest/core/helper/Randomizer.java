package autotest.core.helper;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Randomizer {
    private static final Logger logger = Logger.getLogger("logging");

    private static Random rand;

    public static int randInt(int min, int max) {
        try{
            rand = SecureRandom.getInstanceStrong();
        }catch (NoSuchAlgorithmException e){
            logger.log(Level.INFO, "getInstanceStrong method not found", e);
        }
        return rand.nextInt((max - min) + 1) + min;
    }
}
