// InvertBinaryTree.cpp
// Author: hyan23
// 2020.06.07
// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/

// Runtime: 0 ms
// Memory Usage : 8.3 MB

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//  Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Solution {
public:
	TreeNode* invertTree(TreeNode* root) {
		if (root == nullptr) {
			return;
		}
		TreeNode* tmp = root->left;
		root->left = root->right;
		root->right = tmp;
		invertTree(root->left);
		invertTree(root->right);
	}
};

int main(void)
{
	return 0;
}
