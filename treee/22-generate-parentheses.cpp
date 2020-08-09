class Solution {
public:
    struct Node {
        string s;
        int l;
        int r;
    };
    
    vector<string> generateParenthesis(int n) {
        Node node;
        node.s = string("");
        node.l = n;
        node.r = n;
        
        vector<string> ret;
        
        queue<Node> que;
        que.push(node);
        
        while (!que.empty()) {
            Node n = que.front();
            que.pop();
            
            if (n.l == 0 && n.r == 0) {
                ret.push_back(n.s);
            } else if (n.l == 0) {
                n.s = n.s + ")";
                n.r = n.r - 1;
                que.push(n);
            } else if (n.l == n.r) {
                n.s = n.s + "(";
                n.l = n.l - 1;
                que.push(n);
            } else {
                Node n1;
                n1.s = n.s;
                n1.l = n.l;
                n1.r = n.r;
                
                n1.s = n1.s + "(";
                n1.l = n1.l - 1;
                que.push(n1);
                
                n.s = n.s + ")";
                n.r = n.r - 1;
                que.push(n);
            }
        }
        
        return ret;
    }
};
