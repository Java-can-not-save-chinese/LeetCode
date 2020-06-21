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
class BSTIterator {
public:
    BSTIterator(TreeNode* root) {
        cur = 0;
        build(root);
    }
    
    /** @return the next smallest number */
    int next() {
        return vec[cur++];
    }
    
    /** @return whether we have a next smallest number */
    bool hasNext() {
        return cur != vec.size();
    }

private:
    void build(TreeNode* root) {
        if (root == nullptr)
            return;
        if (root->left == nullptr && root->right == nullptr) {
            vec.push_back(root->val);
            return;
        }
        build(root->left);
        vec.push_back(root->val);
        build(root->right);
    }
    
    vector<int> vec;
    int cur;
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */