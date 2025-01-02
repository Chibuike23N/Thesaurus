/** ASSIGNMENT #4
 * @Username: (Chibuike Nnolim)
 * @Student#: (7644941)
 * @Version: 1.0(28 11 23)
 *
 * This class creates an adjacency matrix and is used by other classes to fill in the data.
 */

package graphs;

import java.util.Random;

public class Graph
{
    public boolean adj[][] = new boolean[1000][1000];

    /**
     * Method sets a vertex at the given indexes
     * @param i row i
     * @param j column j
     */
    public void createEdge(int i, int j)
    {
        adj[i][j] = true;
    }

    /**
     * Method gets a random neighbour of a given row
     * @param passed the given row
     */
    public int retrieveNeighbour(int passed)
    {
        Random box = new Random();
        for(;;)//loops until the random number lands on an existing vertex
        {
            int ranNum = box.nextInt(0, 1000);
            if (adj[passed][ranNum])
            {
                return ranNum;
            }
        }
    }

    /**
     * Method retrieves all the neighbours of a given row and sends it back as an array of indexes.
     * @param passed the given row
     */
    public int[] retrieveAllNeighbours(int passed)
    {
        int neighbours[] = new int[1000];
        int count = 0;
        for(int i = 0; i < adj[passed].length; i++)
        {
            if(adj[passed][i])
            {
                neighbours[count] = i;
                count++;
            }
        }
        return neighbours;
    }

}
