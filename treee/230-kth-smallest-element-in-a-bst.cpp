/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> vec;
        inorder(root, vec, k);
        return *vec.rbegin();
    }
    
    void inorder(TreeNode* root, vector<int>& vec, int k) {
        if (root == nullptr)
            return;
        if (vec.size() == k)
            return;
        
        inorder(root->left, vec, k);
        if (vec.size() < k)
            vec.push_back(root->val);
        inorder(root->right, vec, k);
    }
};
