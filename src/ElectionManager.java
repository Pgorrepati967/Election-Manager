/////////////////////////////// FILE HEADER //////////////////////////////////
//
// Title: (methods created to help manage election information)
// Course: CS 300 Fall 2024
//
// Author: (Praneeth Gorrepati)
// Email: (pgorrepati@wisc.edu)
// Lecturer: (Blerina Gkotse)
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: none
// Online Sources: docs.oracle.com to check to find certain methods
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class has all the methods in which the stored data can be used for with adding, dropping,
 * checking, and ultimately will find the winner and loser of the election
 */
public class ElectionManager {
  /**
   * method to add the candidate in the 2D array
   * 
   * @praram candidates a 2d array, numCandidates an integer, name a String, party a string,
   *         numVotes an Integer
   * @return numCandidates if the method could not add candidate or returns numCandidates + 1 if it
   *         could
   */
  public static int addCandidate(String[][] candidates, int numCandidates, String name,
      String party, int numVotes) {
    if (numCandidates == 0) {
      String[] addArray = {name, party, String.valueOf(numVotes)}; // create an array with the
                                                                   // information of the new
                                                                   // candidate to add into the 2d
                                                                   // array
      candidates[0] = addArray;
      return numCandidates + 1;
    }
    if (!containsCandidate(candidates, numCandidates, name, party) && numVotes > 0) { // check if 2d
                                                                                      // array
                                                                                      // already has
                                                                                      // candidate
                                                                                      // with same
                                                                                      // name and
                                                                                      // party and
                                                                                      // see if the
                                                                                      // new
                                                                                      // candidates
                                                                                      // votes are
                                                                                      // more than 0
      if (numCandidates < candidates.length) { // makes sure the 2d array is not already full 
        for (int i = 0; i < numCandidates; i++) { // loop to alphabetically see which index
                                                  // candidate should be held
          if (name.compareToIgnoreCase(candidates[i][0]) < 0) {
            int index = i;
            String[] temp = candidates[index];
            while (i < numCandidates) { // loop to push all other candidates after index back one
                                        // position to create space for new candidate
              String[] temp2 = candidates[i + 1];
              candidates[i + 1] = temp;
              temp = temp2;
              i++;
            }
            String[] addArray = {name, party, String.valueOf(numVotes)}; // create an array with the
                                                                         // information of the new
                                                                         // candidate to add into
                                                                         // the 2d array
            candidates[index] = addArray;
            return numCandidates + 1;
          }
        }
        String[] addArray2 = {name, party, String.valueOf(numVotes)};// create an array with the
                                                                     // information of the new
                                                                     // candidate to add into the 2d
                                                                     // array
        candidates[numCandidates] = addArray2;
        return numCandidates + 1;
      }
    }
    return numCandidates;
  }

  /**
   * method that checks to see if a candidate is already contained in the 2D array
   * 
   * @praram candidates a 2d array, numCandidates an integer, name a String, party a string
   * @return true if the candidate name and party match another candidates name and party, false
   *         otherwise
   */
  public static boolean containsCandidate(String[][] candidates, int numCandidates, String name,
      String party) {
    for (int i = 0; i < numCandidates; i++) {
      if (name.equals(candidates[i][0]) && party.equals(candidates[i][1])) { // check to see if both
                                                                             // name and party match
                                                                             // that candidate in
                                                                             // that row of the 2d
                                                                             // array
        return true;
      }
    }
    return false;
  }

  /**
   * method to drop the candidate in the 2D array
   * 
   * @praram candidates a 2d array, numCandidates an integer, name a String, party a string
   * @return numCandidates if the method could not drop candidate or returns numCandidates - 1 if it
   *         could
   */
  public static int dropCandidate(String[][] candidates, int numCandidates, String name,
      String party) {
    for (int i = 0; i < numCandidates; i++) { // loop to see if or at what index a candidates and
                                              // their party match another candidate's
      if (name.equals(candidates[i][0]) && party.equals(candidates[i][1])) {
        while (i < (numCandidates - 1)) { // replaces all rows in 2d array with the one after it
                                          // starting from matching row to the information in the
                                          // parameter
          candidates[i] = candidates[i + 1];
          i++;
        }
        candidates[numCandidates - 1] = null;
        return numCandidates - 1;
      }
    }
    return numCandidates;
  }

  /**
   * method that finds which candidate has 50% of the votes in the 2D array
   * 
   * @praram candidates a 2d array, numCandidates an integer
   * @return String of candidates name, candidates party, and percentage of votes formatted like
   *         candidateName (party) - percentVote% if the candidate has more than 50% of votes. If
   *         not it returns CONTINGENT
   */
  public static String findWinner(String[][] candidates, int numCandidates) {
    double totalVotes = Double.parseDouble(candidates[0][2]);
    for (int i = 1; i < numCandidates; i++) { // add all votes up
      totalVotes += Double.parseDouble(candidates[i][2]);
    }
    for (int i = 0; i < numCandidates; i++) { // loop through all candidates to see if any have at
                                              // least 50% of the votes
      if (Double.parseDouble(candidates[i][2]) > totalVotes / 2) {
        return candidates[i][0] + " (" + candidates[i][1] + ") - "
            + (Double.parseDouble(candidates[i][2]) / totalVotes * 100) + "%";
      }
    }
    return "CONTINGENT";

  }

  /**
   * method that finds which candidate has least amount of the votes in the 2D array
   * 
   * @praram candidates a 2d array, numCandidates an integer
   * @return String of candidates name, candidates party, and number of votes formatted like
   *         candidateName (party) - numVotes if the candidate has the least votes. If more than one
   *         candidate have the same number it returns the candidate's information who has there
   *         name come first alphabetically. If only one candidate it returns UNCONTESTED
   */
  public static String findLowestPollingCandidate(String[][] candidates, int numCandidates) {
    if (numCandidates < 2) {
      return "UNCONTESTED";
    }
    int indexOfCandidate = 0;
    int numVote = Integer.parseInt(candidates[0][2]);
    for (int i = 1; i < numCandidates; i++) { // loops through comparing each candidates number of
                                              // votes and stores index row of the smallest number
      if (Integer.parseInt(candidates[i][2]) < numVote) {
        indexOfCandidate = i;
        numVote = Integer.parseInt(candidates[i][2]);
      }
    }
    return candidates[indexOfCandidate][0] + " (" + candidates[indexOfCandidate][1] + ") - "
        + numVote;
  }
}
