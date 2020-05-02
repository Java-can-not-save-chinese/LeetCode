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
    TreeNode* bstFromPreorder(vector<int>& preorder, int l, int r) {
        if (l > r)
            return nullptr;
        int head = preorder[l];
        TreeNode* root = new TreeNode(head);
        int t = l;
        while (t <= r) {
            if (preorder[t] > head)
                break;
            ++t;
        }
        root->left = bstFromPreorder(preorder, l + 1, t - 1);
        root->right = bstFromPreorder(preorder, t, r);
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return bstFromPreorder(preorder, 0, preorder.size() - 1);
    }
};