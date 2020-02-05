import java.util.*;
import java.io.*;


class Trie implements Serializable
{

  static class TrieNode implements Serializable
  {
    
    TrieNode [] pointers=new TrieNode[26];  
   
    TrieNode()
    {
     
      for(int i=0;i<26;i++)
        pointers[i]=null;
    }

  };
  
  static TrieNode root; 
  
  static void insert(String s)
  {
    
    /*inserting character as a node */
    
    int level;
    
    int length = s.length();
    
    int index;
    
    TrieNode curr = root;
    
    for(level=0;level<length;level++)
    {
    
     /* Ascii value correction */
      index=s.charAt(level)-'a';
      if(curr.pointers[index]==null)
      {
        curr.pointers[index]=new TrieNode();
      }
      curr=curr.pointers[index];
    }

  }
  static boolean isLeaf(TrieNode t)
  {
    
    //function to check whether we are at leaf node
    //if a node is leaf all reference pointers would be null
    
    for(int i=0;i<26;i++)
    {
    
      if(t.pointers[i]!=null)
      return false;
    
    }
    
    return true;
  }
  
  //display function to display the words in tree
  
  static void display(TrieNode root,char s[],int l)
  {
  
    //When we are at leaf means the word is complete
    if(isLeaf(root)==true)
    {
      s[l]='\0';
      s[0]=Character.toUpperCase(s[0]);
      //As the input contains the first letter capital changing to to capital
      System.out.println(s);
  
    }

    for(int i=0;i<26;i++)
    {
  
      if(root.pointers[i]!=null)
      {
    
        s[l]=(char)(i+'a');
        //Retreiveing the values from the node
        display(root.pointers[i],s,l+1);
    
      }
    }
  }
}