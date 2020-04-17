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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if (preorder.empty())
            return nullptr;
        int pivot = preorder[0];
        TreeNode* root = new TreeNode(pivot);
        
        auto it = find(inorder.begin(), inorder.end(), pivot);
        vector<int> li = vector<int>(inorder.begin(), it);
        vector<int> ri = vector<int>(it + 1, inorder.end());
        it = find_first_of(preorder.begin(), preorder.end(), ri.begin(), ri.end());
        vector<int> lp = vector<int>(preorder.begin() + 1, it);
        vector<int> rp = vector<int>(it, preorder.end());
        
        root->left = buildTree(lp, li);
        root->right = buildTree(rp, ri);
        
        return root;
    }
};