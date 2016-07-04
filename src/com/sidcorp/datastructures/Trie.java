/**
 * 
 */
package com.sidcorp.datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Siddhant Verma
 *
 */
public class Trie {
	
	
	public static void main(String[] args) {
		String keys [] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
		
		TrieNode root = new TrieNode();
		
		for (String key : keys) {
			char[] keyArr = key.toCharArray();
			insert(root, keyArr);
		}
		printTrie(root);
		System.out.println("");
		System.out.println(search(root, "th"));
		System.out.println(search(root, "answers"));
		System.out.println(search(root, "their"));
	}
	
	private static void printTrie(TrieNode root) {
		Queue<TrieNode> q = new LinkedList<>();
		q.add(root);
		System.out.println("root");
		printTrieUtil(q);
		
	}

	private static void printTrieUtil(Queue<TrieNode> q) {
		while(!q.isEmpty()) {
			TrieNode crawlNode = q.remove();
			TrieNode[] children = crawlNode.getChildren();
			if (children != null) {
				for (TrieNode child : children) {
					if (child != null) {
						q.add(child);
						System.out.print(child.getC());
					}
				} 
			}
		}
	}

	private static boolean search(TrieNode root, String str) {
		TrieNode crawlNode = root;
		char[] keyArr = str.toCharArray();
		for (int i = 0; i < keyArr.length; i++) {
			int index = keyArr[i] - 'a';
			if (crawlNode.getChildren() == null) {
				return false;
			}
			if (crawlNode.getChildren() != null && crawlNode.getChildren()[index] != null) {
				crawlNode = crawlNode.getChildren()[index];
			} else {
				return false;
			}
		}
		if (crawlNode.isLeaf())
			return true ;
		else
			return false;
	}
	private static void insert(TrieNode root, char[] keyArr) {
		TrieNode crawlNode = root;
		
		for (int i = 0; i < keyArr.length; i++) {
			int index = keyArr[i] - 'a';
			if (crawlNode.getChildren() == null) {
				TrieNode[] children = new TrieNode[26];
				crawlNode.setChildren(children);
			}
			if (crawlNode.getChildren()[index] == null) {
				crawlNode.getChildren()[index] = new TrieNode();
			}
			crawlNode.getChildren()[index].setC(keyArr[i]);
			crawlNode = crawlNode.getChildren()[index];
		}
		crawlNode.setLeaf(true);
	}
}

class TrieNode {
	private TrieNode[] children;
	private boolean isLeaf;
	private char c;
	
	public TrieNode() {
		this.children = null;
		this.isLeaf = false;
	}

	public TrieNode[] getChildren() {
		return children;
	}

	public void setChildren(TrieNode[] children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "TrieNode [children=" + Arrays.toString(children) + ", isLeaf=" + isLeaf + ", c=" + c + "]";
	}

}


