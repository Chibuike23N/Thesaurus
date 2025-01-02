/** ASSIGNMENT #4
 * @Username: (Chibuike Nnolim)
 * @Student#: (7644941)
 * @Version: 1.0(28 11 23)
 *
 * This class performs substitutions in the given text with synonyms from a given thesaurus.
 */



package lexicon;

import BasicIO.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main
{
    private ASCIIDataFile fileScript = new ASCIIDataFile();
    private ASCIIOutputFile output = new ASCIIOutputFile();
    Thesaurus thesaurus = new Thesaurus();
    private int distance = 0;
    public Main()
    {
        for(;;)//loops until the user decides to quit
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Provide an integer between 0 and 2.");
            System.out.println("");
            System.out.println("0: Exit");
            System.out.println("1: Substitute words with a provided distance");
            System.out.println("2: Substitute words at a random distance");
            try//avoid program from crashing because of an input mismatch
            {
                int input = scanner.nextInt();
                switch(input)
                {
                    case 0://exit
                    {
                        System.exit(0);
                    }
                    case 1://substitution with provided distance
                    {
                        for(;;)
                        {
                            try//avoid program from crashing from an input mismatch
                            {
                                System.out.print("Distance: ");
                                Scanner a = new Scanner(System.in);
                                distance = a.nextInt();
                                printSpecifiedDistance();
                                System.exit(0);
                            }
                            catch (InputMismatchException inputMismatchException)
                            {
                                System.out.println("Invalid entry, try again.");
                                System.out.println("");
                            }
                        }
                    }
                    case 2://prints reserved word list
                    {
                        for(;;)
                        {
                            try//avoid program from crashing from an input mismatch
                            {
                                printRandom();
                                System.exit(0);
                            }
                            catch (InputMismatchException inputMismatchException)
                            {
                                System.out.println("Invalid entry, try again.");
                                System.out.println("");
                            }
                        }
                    }
                    default:
                    {
                        System.out.println("Invalid entry.");
                    }
                }
            }
            catch(InputMismatchException inputMismatch)
            {
                System.out.println("Invalid entry.");
            }
        }
    }

    /**
     * Method substitutes words for their synonyms at a given distance.
     */
    public void printSpecifiedDistance()
    {
        for(;;)//loops to the end of the file
        {
            String script = fileScript.readLine();
            if(script == null)//checks if the reader is at the end
            {
                break;
            }
            StringTokenizer tokenizer = new StringTokenizer(script);
            while(tokenizer.hasMoreTokens())//loops through the tokens
            {
                String substitute = tokenizer.nextToken();
                if(substitute.contains(",") || substitute.contains(";") || substitute.contains(".") || substitute.contains(":"))//checks for punctuation
                {
                    String punc = substitute.substring(substitute.length() - 1);
                    System.out.print(thesaurus.getSynonym(substitute.replace(punc, ""), distance) + punc + " ");
                    output.writeString(thesaurus.getSynonym(substitute.replace(punc, ""), distance) + punc);
                }
                else
                {
                    System.out.print(thesaurus.getSynonym(substitute, distance) + " ");
                    output.writeString(thesaurus.getSynonym(substitute, distance));
                }
            }
        }
        fileScript.close();
        output.close();
    }

    /**
     * Method substitutes words for their synonyms at a random distance.
     */
    public void printRandom()
    {
        for(;;)//loops to the end of the file
        {
            String script = fileScript.readLine();
            if(script == null)//checks to see if the file reader is at the end
            {
                break;
            }
            StringTokenizer tokenizer = new StringTokenizer(script);
            while(tokenizer.hasMoreTokens())//loops through the tokens
            {
                String substitute = tokenizer.nextToken();
                if(substitute.contains(",") || substitute.contains(";") || substitute.contains(".") || substitute.contains(":"))//checks for punctuation
                {
                    String punc = substitute.substring(substitute.length() - 1);
                    System.out.print(thesaurus.getSynonym(substitute.replace(punc, "")) + punc + " ");
                    output.writeString(thesaurus.getSynonym(substitute.replace(punc, "")) + punc);
                }
                else
                {
                    System.out.print(thesaurus.getSynonym(substitute) + " ");
                    output.writeString(thesaurus.getSynonym(substitute));
                }
            }
        }
        fileScript.close();
        output.close();
    }

    public static void main(String[] args) {new Main();}
}


