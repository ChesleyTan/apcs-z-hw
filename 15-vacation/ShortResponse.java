public class ShortResponse {
    private String recombine(String word1, String word2) {
        return word1.substring(0, word1.length / 2) + word2.substring(word2.length / 2);
    }

    private String[] mixedWords(String[] words) {
        String[] ret = new String[words.length];
        for (int i = 0;i < words.length - 1;i += 2) {
            ret[i] = recombine(words[i], words[i+1]);
            ret[i+1] = recombine(words[i+1], words[i]);
        }
        return ret;
    }

    public static int getPeakIndex(int[] array) {
        for (int i = 1;i < array.length - 1;i++) {
            if (array[i] > array[i-1] && array[i] < array[i+1]) {
                return i;
            }
        }
        return -1;
    }
      
    public static boolean isMountain(int[] array) {
        int peak = getPeakIndex(array);
        return isIncreasing(array, peak) && isDecreasing(array, peak);
    }

    public int getRandomDirection() {
        int[] locs = new int[] {Location.NORTH, Location.EAST, Location.SOUTH, Location.WEST, Location.NORTHEAST, Location.SOUTHEAST, Location.SOUTHWEST, Location.NORTHWEST};
        int rand = (int) (Math.random() * locs.length);
        return locs[rand];
    }

    public ArrayList<Location> getMoveLocations() {
        ArrayList<Location> ret = new ArrayList<Location>();
        Location myLoc = getLocation();
        Grid myGrid = getGrid();
        int dir = getRandomDirection();
        Location loc = myLoc.getAdjacentLocation(dir)
        while (myGrid.isValid(loc)) {
            if (Math.sqrt(loc.getRow() * loc.getRow() + loc.getCol() * loc.getCol()) <= maxDistance) {
                ret.add(loc);
                loc = myLoc.getAdjacentLocation(dir);
            }
        }
        return ret;
    }

    public Location selectMoveLocation(ArrayList<Location> loc) {
        if (loc.size() == 0) {
            return getLocation();
        }
        int rand = (int) (Math.random() * loc.size());
        Location targ = loc.get(rand);
        if (getGrid().get(targ) == null || getGrid().get(targ) instanceof Flower) {
            return targ;
        }
        else {
            return null;
        }
        
    }

    public boolean record(int score) {
        for (ScoreInfo s : scoreList) {
            if (s.getScore() == score) {
                s.increment();
                return false;
            }
        }
        scoreList.add(new ScoreInfo(score));
        return true;
    }

    public void recordScore(int[] stuScores) {
        for (int score : stuScores) {
            for (int i = 0;i < scoreList.size();i++) {
                if (scoreList.get(i).getScore() == score) {
                    record(score);
                    return;
                }
                else if (scoreList.get(i).getScore() < score) {
                    scoreList.add(i, new ScoreInfo(score));
                    return;
                }
            }
        }
    }
}
