/** ASSIGNMENT #4
 * @Username: (Chibuike Nnolim)
 * @Student#: (7644941)
 * @Version: 1.0(28 11 23)
 *
 * This class creates a thesaurus using the imported graph and map classes.
 */


package lexicon;

import BasicIO.*;
import graphs.Graph;
import storage.Map;


public class Thesaurus
{
    private ASCIIDataFile file = new ASCIIDataFile();
    private int keyCount = 1;
    Graph synGraph = new Graph();
    Map biDirectional = new Map();
    public Thesaurus()
    {
        createConnections();
    }

    /**
     * Method creates the map system and completes the adjacency matrix as the map is created.
     */
    public void createConnections()
    {
        for(;;)//loops until the end of the file
        {
            String temp = file.readLine();
            if(temp == null)//checks to see if the reader is at the end
            {
                break;
            }
            temp = temp.replace(",","");
            temp = temp.replace("\t"," ");
            String connect[] = temp.split(" ");

            for(int i = 1; i < connect.length; i++)//loops the length of the current set of words
            {
                if (biDirectional.getKey(connect[0]) == -1)//checks to see if the word is present in the map
                {
                    biDirectional.setKeyValuePair(keyCount, connect[0]);
                    keyCount++;
                }

                if (biDirectional.getKey(connect[i]) == -1)//checks to see if the current synonym is present in the map
                {
                    biDirectional.setKeyValuePair(keyCount, connect[i]);
                    keyCount++;
                }

                synGraph.createEdge(biDirectional.getKey(connect[0]), biDirectional.getKey(connect[i]));
            }
        }
        file.close();
    }

    /**
     * Method gets the synonym of the given word at a random distance.
     * @param word the word to be substituted.
     */
    public String getSynonym(String word)
    {
        int key = biDirectional.getKey(word);
        if(key == -1)//checks to see if word is in the map
        {
            return word;
        }
        return biDirectional.getValue(synGraph.retrieveNeighbour(key));
    }

    /**
     * Method gets the synonym of the given word at the specified distance.
     * @param word the word to be substituted.
     * @param distance the given distance of the substitution.
     * @return the resulting synonym
     */
    public String getSynonym(String word, int distance)
    {
        int curDist = 0;
        int recentSyn = 0;
        int key = biDirectional.getKey(word);
        if(key == -1)//checks to see if the word is in the map
        {
            return word;
        }

        for(int i = 0; i < synGraph.adj[key].length; i++)//loops the length of the row of where the word's key is in the matrix
        {
            if(synGraph.adj[key][i])//checks to see if there is a vertex at the given indexes
            {
                recentSyn = i;
                curDist++;
                if(curDist == distance)//checks to see if it has reached the given distance
                {
                    return biDirectional.getValue(recentSyn);
                }
            }
        }
        return biDirectional.getValue(recentSyn);
    }


}
