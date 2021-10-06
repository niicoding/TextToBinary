/**
 * @author  Zachary Perales
 * Course #: CSC240-80
 * DUE: 13 OCTOBER 2019
 * Description: Second to last lab in the class. This lab reads in data from .txt file, makes and writes to a .bin file, and then reads the .bin file.
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadText_WriteBinary {

    Scanner                 itemScanner;
    Scanner                 lineScanner;
    ArrayList<String>       stringList;

    ArrayList<String>       lastNameList;
    ArrayList<Integer>      experienceList;
    ArrayList<Character>    positionList;
    ArrayList<Integer>      heightList;
    ArrayList<Integer>      weightList;
    ArrayList<Double>       yardSpeedList;
    ArrayList<String>       teamList;
    ArrayList<Boolean>      playerActiveList;

    ArrayList<ArrayList>    arrayListArrayList;
    ArrayList<ArrayList>    cleanArrayListArrayList;

    ArrayList<Boolean>      destroyerArray;


    // Getters and Setters
    public ArrayList<Boolean> getDestroyerArray() {
        return destroyerArray;
    }

    public void setDestroyerArray(ArrayList<Boolean> destroyerArray) {
        this.destroyerArray = destroyerArray;
    }

    public ArrayList<ArrayList> getCleanArrayListArrayList() {
        return cleanArrayListArrayList;
    }

    public void setCleanArrayListArrayList(ArrayList<ArrayList> cleanArrayListArrayList) {
        this.cleanArrayListArrayList = cleanArrayListArrayList;
    }

    public ArrayList<ArrayList> getArrayListArrayList() {
        return arrayListArrayList;
    }

    public void setArrayListArrayList(ArrayList<ArrayList> arrayListArrayList) {
        this.arrayListArrayList = arrayListArrayList;
    }

    public ArrayList<String> getLastNameList() {
        return lastNameList;
    }

    public void setLastNameList(ArrayList<String> lastNameList) {
        this.lastNameList = lastNameList;
    }

    public ArrayList<Integer> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Integer> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<Character> getPositionList() {
        return positionList;
    }

    public void setPositionList(ArrayList<Character> positionList) {
        this.positionList = positionList;
    }

    public ArrayList<Integer> getHeightList() {
        return heightList;
    }

    public void setHeightList(ArrayList<Integer> heightList) {
        this.heightList = heightList;
    }

    public ArrayList<Integer> getWeightList() {
        return weightList;
    }

    public void setWeightList(ArrayList<Integer> weightList) {
        this.weightList = weightList;
    }

    public ArrayList<Double> getYardSpeedList() {
        return yardSpeedList;
    }

    public void setYardSpeedList(ArrayList<Double> yardSpeedList) {
        this.yardSpeedList = yardSpeedList;
    }

    public ArrayList<String> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<String> teamList) {
        this.teamList = teamList;
    }

    public ArrayList<Boolean> getPlayerActiveList() {
        return playerActiveList;
    }

    public void setPlayerActiveList(ArrayList<Boolean> playerActiveList) {
        this.playerActiveList = playerActiveList;
    }

    public Scanner getItemScanner() {
        return itemScanner;
    }

    public void setItemScanner(Scanner itemScanner) {
        this.itemScanner = itemScanner;
    }

    public Scanner getLineScanner() {
        return lineScanner;
    }

    public void setLineScanner(Scanner lineScanner) {
        this.lineScanner = lineScanner;
    }

    public ArrayList<String> getStringList() {
        return stringList;
    }

    public void setStringList(ArrayList<String> stringList) {
        this.stringList = stringList;
    }

    public void exMessage(Exception e) {
        System.out.println(e.toString() + " The record will not be written.");
    }

    // initialize the field arrays
    public void initializeArrayLists () {
        setLastNameList(    new ArrayList<>());
        setExperienceList(  new ArrayList<>());
        setPositionList(    new ArrayList<>());
        setHeightList(      new ArrayList<>());
        setWeightList(      new ArrayList<>());
        setYardSpeedList(   new ArrayList<>());
        setTeamList(        new ArrayList<>());
        setPlayerActiveList(new ArrayList<>());
    }

    // initialize an array of field arrays
    public ArrayList<ArrayList> initializeArrayListArrayLists (ArrayList<ArrayList> arrayList) {
        arrayList.add(  getLastNameList());
        arrayList.add(  getExperienceList());
        arrayList.add(  getPositionList());
        arrayList.add(  getHeightList());
        arrayList.add(  getWeightList());
        arrayList.add(  getYardSpeedList());
        arrayList.add(  getTeamList());
        arrayList.add(  getPlayerActiveList());

        return arrayList;
    }

    public Scanner askUserForFile() {
        boolean isFile      = false;
        Scanner scan        = new Scanner(System.in);
        Scanner userInput   = null;
        Scanner itemScan    = null;

        do {
            try {
                System.out.print("Enter the file name: ");
                File file   = new File(scan.next());
                itemScan    = new Scanner(file);
                isFile      = true;
            } catch (Exception e) {
                System.out.println(e.toString() + " That file doesn't exist in this directory. Enter another name.");
            }

        } while (isFile == false);

        return itemScan;
    }

    public ArrayList<String> scanInFileReturnArrayList() {
        setStringList(new ArrayList<>());

        try {
            setItemScanner(askUserForFile());
        } catch (Exception e) {
            System.out.println("Error");
        }

        while (getItemScanner().hasNextLine()) {
            String line = getItemScanner().nextLine();

            setLineScanner(new Scanner(line).useDelimiter("\\s*,\\s*")); // Splice at comma

            while (getLineScanner().hasNext()) {
                getStringList().add(getLineScanner().next());
            }
        }

        return getStringList();
    }

    public ArrayList<Boolean> destroyerLister (ArrayList<ArrayList> arrayList) {
        setDestroyerArray(new ArrayList<>());

        int destroyerArraySize = arrayList.get(0).size();

        for (int i = 0; i < destroyerArraySize; i++) {
            getDestroyerArray().add(false);
        }

        ArrayList<Boolean> destroyList = getDestroyerArray(); // fix with get

        for (ArrayList<Object> statList : arrayList) {
            int z = 0; // null indexer
            int r = 0; // null indexer for characters
            for (Object obby : statList) {
                if (obby == null) { // if object is null
                    destroyList.set(z, true);
                    z++; // increase null index
                } else if ((obby.getClass() == Character.class)) {

                    char c = (char) obby;
                    int i = c;

                    if (i == 0) { // if character is null
                        destroyList.set((r/2), true); // mark correct index for deletion
                    }

                    r++;
                } else {
                    z++; // increase null index
                }
            }
        }

        return getDestroyerArray();
    }

    public ArrayList<ArrayList> makeCleanArrayList(ArrayList<Boolean> destroyerArray, ArrayList<ArrayList> dirtyArray) {
        ArrayList<ArrayList> myCleanArray = new ArrayList<>();

        initializeArrayLists();
        myCleanArray = initializeArrayListArrayLists(myCleanArray);


        for (ArrayList arrayList : dirtyArray) {
            int i = 0;
            for (Boolean bool : destroyerArray) {
                if (!bool) {
                    if (dirtyArray.indexOf(arrayList) == 2) { // fix this
                        myCleanArray.get(dirtyArray.indexOf(arrayList)).add(arrayList.get(i*2));
                        myCleanArray.get(dirtyArray.indexOf(arrayList)).add(arrayList.get((i*2) + 1));
                    } else {
                        myCleanArray.get(dirtyArray.indexOf(arrayList)).add(arrayList.get(i));
                    }
                }
                i++;
            }
        }

        return myCleanArray;
    }

    public ArrayList<ArrayList> fillAndCombineArrayLists (ArrayList<String> stringList) {
        initializeArrayLists();

        setArrayListArrayList(new ArrayList<>());

        int i = 0;

        for (String string : stringList) {

            if (i == 8) {
                i = 0;
            }

            if (i == 0) {
                try {
                    if (string.matches("^[A-Z]'?[- a-zA-Z]+$")) { // Name format includes ' and hyphen
                        getLastNameList().add(string);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    exMessage(e);
                    getLastNameList().add(null);
                }
            } else if (i == 1) {
                try {
                    getExperienceList().add(Integer.parseInt(string));
                } catch (Exception e) {
                    exMessage(e);
                    getExperienceList().add(null);
                }
            } else if (i == 2) {
                try {
                    if (string.matches("[a-zA-Z]+") && (string.length() == 2)) {
                        getPositionList().add(string.charAt(0));
                        getPositionList().add(string.charAt(1));
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    exMessage(e);
                    getPositionList().add('\0'); // null literal
                    getPositionList().add('\0'); // null literal
                }
            } else if (i == 3) {
                try {
                    getHeightList().add(Integer.parseInt(string));
                } catch (Exception e) {
                    exMessage(e);
                    getHeightList().add(null);
                }
            } else if (i == 4) {
                try {
                    getWeightList().add(Integer.parseInt(string));
                } catch (Exception e) {
                    exMessage(e);
                    getWeightList().add(null);
                }
            } else if (i == 5) {
                try {
                    getYardSpeedList().add(Double.parseDouble(string));
                } catch (Exception e) {
                    exMessage(e);
                    getYardSpeedList().add(null);
                }
            } else if (i == 6) { // Add string mandate, exclude 49ers 49rs 49'ers
                try {
                    if (string.matches("^[A-Z]'?[- a-zA-Z]+$") || string.equals("49ers") || string.equals("49'ers")) {
                        getTeamList().add(string);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    exMessage(e);
                    getTeamList().add(null);
                }
            } else if (i == 7) {
                try {
                    if (string.toUpperCase().equals("TRUE") || string.toUpperCase().equals("FALSE")) {
                        getPlayerActiveList().add(Boolean.parseBoolean(string));
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    exMessage(e);
                    getPlayerActiveList().add(null);
                }
            }

            i++;
        }

        initializeArrayListArrayLists(getArrayListArrayList());

        return getArrayListArrayList();
    }

    public static void main(String[] args) {
        ReadText_WriteBinary obj        = new ReadText_WriteBinary();

        //PARSE RECORDS AND REMOVE RECORDS THAT CONTAIN ERRORS AND STORE CLEAN RECORDS
        ArrayList<String> stringList1   = obj.scanInFileReturnArrayList();
        ArrayList<ArrayList> megaList   = obj.fillAndCombineArrayLists(stringList1);
        ArrayList<Boolean> dirtyList    = obj.destroyerLister(megaList);
        ArrayList<ArrayList> cleanList  = obj.makeCleanArrayList(dirtyList, megaList);

        File binaryFile                 = new File("theBinaryFile.bin"); // CREATE A BINARY FILE

        System.out.println("\nWe are creating a new binary file named 'theBinaryFile.bin' in this directory...");

        // WRITE CLEAN RECORDS TO BINARY FILE
        try (DataOutputStream outPutStream = new DataOutputStream(new FileOutputStream(binaryFile))) {

            int i = 0;
            for (Object name : cleanList.get(0)) {
                outPutStream.writeUTF(      name.toString());
                outPutStream.writeInt(      Integer.parseInt(cleanList.get(1).get(i).toString()));
                outPutStream.writeChar(     cleanList.get(2).get(i * 2).toString().charAt(0));
                outPutStream.writeChar(     cleanList.get(2).get((i * 2) + 1).toString().charAt(0));
                outPutStream.writeInt(      Integer.parseInt(cleanList.get(3).get(i).toString()));
                outPutStream.writeInt(      Integer.parseInt(cleanList.get(4).get(i).toString()));
                outPutStream.writeDouble(   Double.parseDouble(cleanList.get(5).get(i).toString()));
                outPutStream.writeUTF(      cleanList.get(6).get(i).toString());
                outPutStream.writeBoolean(  Boolean.parseBoolean(cleanList.get(7).get(i).toString()));

                i++;
            }

            System.out.println("\nWE HAVE SUCCESSFULLY WRITTEN TO THIS BINARY FILE");




        } catch (Exception e) {
            e.toString();
        }


        // READ IN BINARY BACK TO TEXT RECORDS AND PRINT TO CONSOLE
        try (DataInputStream inPutStream = new DataInputStream(new FileInputStream("theBinaryFile.bin"))) {

            System.out.println("\nWe are reading back in the binary file to console... \n");

            for (Object i : cleanList.get(0)) {
                System.out.println(     "\nRECORD \n");
                System.out.println(     inPutStream.readUTF());
                System.out.println(     inPutStream.readInt());
                System.out.print(       inPutStream.readChar());
                System.out.println(     inPutStream.readChar());
                System.out.println(     inPutStream.readInt());
                System.out.println(     inPutStream.readInt());
                System.out.println(     inPutStream.readDouble());
                System.out.println(     inPutStream.readUTF());
                System.out.println(     inPutStream.readBoolean());
            }

        } catch (Exception e) {
            e.toString();
        } finally {
            System.out.println("\nALL RECORDS READ IN.");
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to delete binary file? Y/N");

        String input = scan.next();

        if (input.toUpperCase().equals("Y")) {
            binaryFile.delete();
            System.out.println("\nFILE WAS DELETED");
        } else {
            System.out.println("\nFILE NOT DELETED. YOU MUST MANUALLY DELETE FILE IF YOU RUN THIS AGAIN OR THERE WILL BE UNINTENDED FUNCTION.");
        }
    }
}