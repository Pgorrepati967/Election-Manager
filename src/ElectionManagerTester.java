/////////////////////////////// FILE HEADER //////////////////////////////////
//
// Title: (tester Code to check Election Manager Methods are working properly)
// Course: CS 300 Fall 2024
//
// Author: (Praneeth Gorrepati)
// Email: (pgorrepati@wisc.edu)
// Lecturer: (Blerina Gkotse)
//
//////////////////////// ASSISTANCE/HELP CITATIONS ////////////////////////////
//
// Persons: none
// Online Sources: docs.oracle.com to check to find certain methods and understand what some methods
/////////////////////////////// did
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

/**
 * This class models an election in which data is being created and stored in a 2d array in which
 * then calls methods from the other class to see if those methods are working properly
 */
public class ElectionManagerTester {
  /**
   * example test method for verifying whether a candidate has already been added to the race when
   * the 2d array is empty
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testContainsEmpty() {
    // (1a) set up the test variables
    String[][] candidateList = {null, null, null, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 0;
    String targetName = "Charmander";
    String targetParty = "Fire";
    boolean expected = false;
    // (1b) call the method we are testing
    boolean actual =
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;
    // (3) since THIS method should not modify the array, check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying whether a candidate has already been added to the race when
   * the 2d array does not include candidate
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDoesNotContain() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    String targetName = "Charmander";
    String targetParty = "Fire";
    boolean expected = false;
    // (1b) call the method we are testing
    boolean actual =
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;
    // (3) since THIS method should not modify the array, check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a candidate has already been
   * added to the race.
   * 
   * NOTE: This method ONLY tests scenarios where the candidate IS PRESENT in the list; situations
   * where the candidate is not present or the list is empty should be tested in the other contains
   * tester methods.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDoesContain() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 3;
    String targetName = "Wooper";
    String targetParty = "Water";
    boolean expected = true;

    // (1b) call the method we are testing
    boolean actual =
        ElectionManager.containsCandidate(candidateList, size, targetName, targetParty);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) since THIS method should not modify the array, check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * example test method for verifying whether a new candidate has been added correctly to the race
   * of an empty 2d array.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testAddToEmpty() {
    // (1a) set up the test variables
    String[][] candidateList = {null, null, null, null, null, null};
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;
    String[][] expectedList = {{"Goldeen", "Water", "5"}, null, null, null, null, null};// alphabetically
                                                                                        // first,
                                                                                        // new
                                                                                        // candidate
                                                                                        // will be
                                                                                        // added
                                                                                        // here
                                                                                        // now only
                                                                                        // FIVE null
                                                                                        // values in
                                                                                        // this
                                                                                        // length-6
                                                                                        // array!
    int size = 0;
    int expected = 1;
    // (1b) call the method we are testing
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether a new candidate has been
   * added correctly to the race.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testAddToNonEmpty() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String newName = "Goldeen";
    String newParty = "Water";
    int newVotes = 5;

    String[][] expectedList = {{"Goldeen", "Water", "5"}, // alphabetically first, new candidate
                                                          // will be added here
        {"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}, null,
        null}; // now only TWO null values in this length-6 array!
    int size = 3;
    int expected = 4;

    // (1b) call the method we are testing
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying whether a new candidate has not been added correctly to the
   * race which already contain candidate.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testAddCandidateErrors() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Charmander", "Fire", "3"}, {"Gengar", "Ghost", "25"},
        {"Goldeen", "Water", "5"}, null, null, null};
    String newName = "Golduck";
    String newParty = "Water";
    int newVotes = -1;
    String[][] expectedList = {{"Charmander", "Fire", "3"}, {"Gengar", "Ghost", "25"}, // not change
                                                                                       // since this
                                                                                       // new
                                                                                       // Candidate
                                                                                       // added is
                                                                                       // already
                                                                                       // included
                                                                                       // in the
                                                                                       // test
                                                                                       // variable
                                                                                       // array
        {"Goldeen", "Water", "5"}, null, null, null};
    int size = 3;
    int expected = 3;
    // (1b) call the method we are testing
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying whether a new candidate has been incorrectly added to the
   * race of a full 2d array.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testAddToFull() {
    // (1a) set up the test variables
    String[][] candidateList =
        {{"Charmander", "Fire", "3"}, {"Gengar", "Ghost", "25"}, {"Goldeen", "Water", "5"},
            {"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}};
    String newName = "Golduck";
    String newParty = "Water";
    int newVotes = 1;
    String[][] expectedList =
        {{"Charmander", "Fire", "3"}, {"Gengar", "Ghost", "25"}, {"Goldeen", "Water", "5"},
            {"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"}, {"Wooper", "Water", "300"}}; // not
                                                                                                   // change
                                                                                                   // since
                                                                                                   // test
                                                                                                   // variable
                                                                                                   // array
                                                                                                   // is
                                                                                                   // full
    int size = 6;
    int expected = 6;
    // (1b) call the method we are testing
    int actual = ElectionManager.addCandidate(candidateList, size, newName, newParty, newVotes);
    if (expected != actual)
      return false;

    // (3) this method modifies the input array; verify that it was modified correctly
    if (!Arrays.deepEquals(candidateList, expectedList))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying whether possible to drop a candidate who is the only
   * candidate running in the race.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDropOnlyCandidate() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, null, null, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Slowpoke";
    String party = "Water";
    int size = 1;
    int expected = 0;
    // (1b) call the method we are testing
    int actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying whether possible to drop the first candidate who is running
   * in the race.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDropFirstCandidate() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Squirtle";
    String party = "Water";
    int size = 3;
    int expected = 2;
    // (1b) call the method we are testing
    int actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying whether trying to drop a candidate
   * who is not running in the race correctly has NO effect on the candidate list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testDropCandidateNotRunning() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "127"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String name = "Goldeen";
    String party = "Water";
    int size = 3;
    int expected = 3;

    // (1b) call the method we are testing
    int actual = ElectionManager.dropCandidate(candidateList, size, name, party);

    // (2) verify that the expected method return value and the actual return value match
    if (expected != actual)
      return false;

    // (2a) sometimes you may want to REPEAT the process with slightly different variables:
    name = "Slowpoke";
    party = "Fire"; // try with a name that's present but a different PARTY; should still not drop
    actual = ElectionManager.dropCandidate(candidateList, size, name, party);
    if (expected != actual)
      return false;

    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * example test method for verifying the results of an election where one candidate is in the
   * race/list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testUncontestedWinner() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, null, null, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Slowpoke";
    String expectedParty = "(Water)";
    double expectedVotePct = 3.0 / (3) * 100;
    int size = 1;
    // (1b) call the method we are testing
    String result = ElectionManager.findWinner(candidateList, size);

    // (2) verify that the expected method return value and the actual return value match
    // NOTE: for a String, this takes a little more processing to do sensitively.
    // We expect this result to be "Slowpoke (Water) - 100.0%" but there may be some weirdness
    // especially with that percentage. See how we do it here:

    String[] resultPieces = result.split(" "); // get the space-separated pieces of the string

    if (resultPieces.length != 4)
      return false; // incorrect formatting
    if (!resultPieces[3].endsWith("%"))
      return false; // no % at the end

    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party

    if (!resultPieces[2].equals("-"))
      return false; // forgot the "-" between party and %

    // do a range check on the calculated vote percentage, since it's not always going to come out
    // exactly the same:
    double actualVotePct =
        Double.valueOf(resultPieces[3].substring(0, resultPieces[3].length() - 1));
    if (Math.abs(actualVotePct - expectedVotePct) > 0.01)
      return false;

    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * PROVIDED TESTER METHOD: example test method for verifying the results of an election where one
   * candidate has received a clear majority of the votes cast.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testClearWinner() {

    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, {"Squirtle", "Water", "97"},
        {"Wooper", "Water", "300"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Wooper";
    String expectedParty = "(Water)";
    double expectedVotePct = 300.0 / (300 + 97 + 3) * 100;
    int size = 3;

    // (1b) call the method we are testing
    String result = ElectionManager.findWinner(candidateList, size);

    // (2) verify that the expected method return value and the actual return value match
    // NOTE: for a String, this takes a little more processing to do sensitively.
    // We expect this result to be "Wooper (Water) - 75.0%" but there may be some weirdness
    // especially with that percentage. See how we do it here:

    String[] resultPieces = result.split(" "); // get the space-separated pieces of the string

    if (resultPieces.length != 4)
      return false; // incorrect formatting
    if (!resultPieces[3].endsWith("%"))
      return false; // no % at the end

    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party

    if (!resultPieces[2].equals("-"))
      return false; // forgot the "-" between party and %

    // do a range check on the calculated vote percentage, since it's not always going to come out
    // exactly the same:
    double actualVotePct =
        Double.valueOf(resultPieces[3].substring(0, resultPieces[3].length() - 1));
    if (Math.abs(actualVotePct - expectedVotePct) > 0.01)
      return false;

    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * example test method for verifying the results of an election where there is not winner with
   * more than 50% votes in the race/list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testContingentElection() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "10"}, {"Squirtle", "Water", "10"},
        {"Wooper", "Water", "11"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "CONTINGENT";
    int size = 3;
    // (1b) call the method we are testing
    String result = ElectionManager.findWinner(candidateList, size);
    // (2) verify that the expected method return value and the actual return value match
    if (!result.equals(expectedName))
      return false;
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying the candidate with the lowest polling where only one
   * candidate is in the race/list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testUncontestedLowestPolling() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "3"}, null, null, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    int size = 1;
    String expectedName = "UNCONTESTED";
    // (1b) call the method we are testing
    String result = ElectionManager.findLowestPollingCandidate(candidateList, size);
    // (2) verify that the expected method return value and the actual return value match
    if (!result.equals(expectedName))
      return false;
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;
    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying the candidate with the lowest polling where multiple
   * candidates are in the race/list.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testLowestUniqueVoteCount() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "1"}, {"Squirtle", "Water", "10"},
        {"Wooper", "Water", "11"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Slowpoke";
    String expectedParty = "(Water)";
    int size = 3;
    // (1b) call the method we are testing
    String result = ElectionManager.findLowestPollingCandidate(candidateList, size);
    // (2) verify that the expected method return value and the actual return value match
    // NOTE: for a String, this takes a little more processing to do sensitively.
    // We expect this result to be "Slowpoke (Water) - 1" but there may be some weirdness
    // especially with that percentage. See how we do it here:

    String[] resultPieces = result.split(" ");// get the space-separated pieces of the string
    if (resultPieces.length != 4)
      return false; // incorrect formatting
    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party
    if (!resultPieces[2].equals("-"))
      return false; // forgot the "-" between party and numVote
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;
  }

  /**
   * example test method for verifying the candidate with the lowest polling where multiple
   * candidates are in the race/list and the multiple candidates have the same amount of votes.
   * 
   * @return false if any of the scenarios we test have results other than what we expect; true ONLY
   *         if all of our expectations are met by the method we are testing
   */
  public static boolean testLowestVoteCountTied() {
    // (1a) set up the test variables
    String[][] candidateList = {{"Slowpoke", "Water", "10"}, {"Squirtle", "Water", "10"},
        {"Wooper", "Water", "11"}, null, null, null};
    String[][] candidateCopy = Arrays.copyOf(candidateList, candidateList.length);
    String expectedName = "Slowpoke";
    String expectedParty = "(Water)";
    int size = 3;
    // (1b) call the method we are testing
    String result = ElectionManager.findLowestPollingCandidate(candidateList, size);
    // (2) verify that the expected method return value and the actual return value match
    // NOTE: for a String, this takes a little more processing to do sensitively.
    // We expect this result to be "Slowpoke (Water) - 10" but there may be some weirdness
    // especially with that percentage. See how we do it here:

    String[] resultPieces = result.split(" ");// get the space-separated pieces of the string
    if (resultPieces.length != 4)
      return false; // incorrect formatting
    if (!resultPieces[0].equals(expectedName) || !resultPieces[1].equals(expectedParty))
      return false; // wrong name or wrong party
    if (!resultPieces[2].equals("-"))
      return false; // forgot the "-" between party and numVote
    // (3) this scenario should NOT modify the input array; check it against a copy we made
    if (!Arrays.deepEquals(candidateList, candidateCopy))
      return false;

    // (4) if we have not yet returned false, we can now return true as all tests have passed!
    return true;

  }

  /**
   * PROVIDED MAIN METHOD to manage the tester methods above.
   * 
   * We're getting a little esoteric here to take advantage of loops to keep the code short; each
   * pass through the loop could also be written as follows:
   * 
   * boolean singleTest = testMethodCall(); allPass &= singleTest;
   * System.out.println("testMethodCall : " + singleTest);
   * 
   * @throws NoSuchMethodException                       if you spell a method name incorrectly
   * 
   *                                                     And a couple of other "checked" exceptions
   *                                                     that should never happen with our usage
   *                                                     here:
   * @throws IllegalAccessException
   * @throws java.lang.reflect.InvocationTargetException
   */
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
      java.lang.reflect.InvocationTargetException {
    boolean allPass = true, singlePass = true;
    String printFormat = "%-29s: %s\n";

    // NOTE TO STUDENTS: If you create any additional tests for any of the methods in
    // ElectionManager, add their names to the appropriate array below!
    String[] containsTests = {"testContainsEmpty", "testDoesNotContain", "testDoesContain"};
    String[] addTests =
        {"testAddToEmpty", "testAddToNonEmpty", "testAddCandidateErrors", "testAddToFull"};
    String[] dropTests =
        {"testDropOnlyCandidate", "testDropFirstCandidate", "testDropCandidateNotRunning"};
    String[] winTests = {"testUncontestedWinner", "testClearWinner", "testContingentElection"};
    String[] lowTests =
        {"testUncontestedLowestPolling", "testLowestUniqueVoteCount", "testLowestVoteCountTied"};

    String[][] testNames = {containsTests, addTests, dropTests, winTests, lowTests};

    // NOTE TO STUDENTS: this for-loop is moving through the method names we've added to the 2D
    // array testNames and attempting to call methods with those names from this tester
    // (specifically line 286 here). See Java's reflection framework for more details!
    for (String[] testSet : testNames) {
      for (String name : testSet) {
        singlePass = (boolean) ElectionManagerTester.class.getDeclaredMethod(name).invoke(null);
        allPass &= singlePass;
        System.out.printf(printFormat, name, singlePass);
      }
      System.out.println();
    }

    System.out.println("ALL TESTS: " + allPass);

  }

}

