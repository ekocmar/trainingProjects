/**
 * 
 */
package com.javacodegeeks.camel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emrullah Kocmar
 *
 */
public class MyList
{
    private List<String> repoList;
    /**
     * 
     */
    public MyList()
    {
        repoList = new ArrayList<String>();
    }
    public List<String> getRepoList()
    {
        return repoList;
    }
    public void setRepoList(List<String> repoList)
    {
        this.repoList = repoList;
    }

    public void addItem(String input)
    {
        if(repoList == null || repoList.isEmpty())
        {
            repoList = new ArrayList<String>();
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (String s : getRepoList())
        {
            sb.append(s);
            sb.append("\n");
        }

        return sb.toString();
    }
}
