/** ASSIGNMENT #4
 * @Username: (Chibuike Nnolim)
 * @Student#: (7644941)
 * @Version: 1.0(28 11 23)
 *
 * This class creates a bidirectional map that aids the completion of the adjacency matrix.
 */

package storage;

public class Map
{
    public String valMap[] = new String[1000];

    /**
     * Method sets a key value pair containing the given key and value
     * @param k the key for the value
     * @param v the value to be assigned to the key
     */
    public void setKeyValuePair(int k, String v)
    {
        valMap[k] = v;
    }

    /**
     * Method retrieves the key assigned to the given value.
     * @param value the value assigned to the desired key
     */
    public int getKey(String value)
    {
        for(int i = 0; i < valMap.length; i++)//loops until the end of the pairs to find the specified key
        {
            if(valMap[i] != null)
            {
                if(valMap[i].equals(value))//value found
                {
                    return i;
                }
            }
        }
        return (-1);//value not found in map
    }

    /**
     * Method retrieves the value assigned to the given key.
     * @param key the key assigned to the desired value
     */
    public String getValue(int key)
    {
        return valMap[key];
    }

    /**
     * Method gets the amount of key value pairs currently in the map.
     */
    public int getCount()
    {
        int count = 0;
        for(int i = 1; i < valMap.length; i++)//loops through the map until it reaches null values
        {
            if(valMap[i] != null)
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}
