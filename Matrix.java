package pa1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import api.Graph;
import api.TaggedVertex;

public class Matrix implements Graph<String>
{
	ArrayList<TaggedVertex<String>> arrList = new ArrayList<TaggedVertex<String>>(); //stores the string with the key index integer
	private boolean[][] adj;
	private int edges;
	private int vertices;

	
	public Matrix(int v)
	{
		adj = new boolean[v][v];
		vertices = v;
		edges = 0;
		
	}
	
	public Matrix(int v, int e)
	{
		adj = new boolean[v][v];
		vertices = v;
		edges = e;
	}
	
	public void populateFalse() //fills adj with # of vertices
	{
		for(int i = 0; i < adj.length; i ++)
		{
			for(int j = 0; i < adj[i].length - 1; i++)
			{
				adj[i][j] = false;
			}
		}
	}
	
	public int getEdges()
	{
		return edges;
	}
	
	public int getVertices()
	{
		return vertices;
	}
	
	public boolean contains(int u, int v)
	{
		if(adj[u][v] == true)
		{
			return true;
		}
		return false;
	}
	
	public void addEdge(int u, int v) 
	{
		adj[u][v] = true;
		adj[v][u] = true;
	}
	
	public void removeEdge(int u, int v)
	{
		adj[u][v] = false;
		adj[v][u] = false;
	}
	
	public void addArrListElement(String val)
	{
		TaggedVertex<String> ver = new TaggedVertex<String>(val, 0);
		arrList.add(ver);
	}
	
	public void deleteArrListElement(TaggedVertex<String> v)
	{

		arrList.remove(v);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < vertices; i ++)
		{
			sb.append(i + ": ");
			
			for(boolean j : adj[i]) 
			{
				sb.append((j?1:0) + " ");
			}
			
			sb.append("\n");
		}
		return sb.toString();
	}
	


	@Override
	public ArrayList<String> vertexData() 
	{
		ArrayList<String> retList = new ArrayList<String>();
		
		for(int i = 0; i < arrList.size(); i++)
		{
			retList.add(i, arrList.get(i).getVertexData());
		}
		return retList;
	}

	@Override
	public ArrayList<TaggedVertex<String>> vertexDataWithIncomingCounts() 
	{
		ArrayList<TaggedVertex<String>> retList = new ArrayList<TaggedVertex<String>>();
		
		for(int i = 0; i < arrList.size(); i ++)
		{
			retList.add(arrList.get(i));
		}
		return retList;
	}

	@Override
	public List<Integer> getNeighbors(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getIncoming(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
