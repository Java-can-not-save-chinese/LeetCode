/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int d = 0;
    int diameterOfBinaryTree(TreeNode* root) {
        treeHeight(root);
        return d;
    }
    
    int treeHeight(TreeNode* root) {
        if (root == nullptr)
            return 0;
        int l = treeHeight(root->left);
        int r = treeHeight(root->right);
        if (l + r > d)
            d = l + r;
        return max(l, r) + 1;
    }
};