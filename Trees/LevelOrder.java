class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(l);
        }
        return ans;
    }
    
}

Time Complexity = O(n)
Space Complexity = O(n)
