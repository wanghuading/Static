package com.sz.learn.tree;

/**
 * @Author whd
 * @Date 2018/5/14 9:57
 * @Description 平衡二叉树
 **/
public class AVLTree<T extends Comparable> implements Tree<T> {
    public AVLNode<T> root;
    /**
     * 判空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private int size(AVLNode<T> subtree) {
        if (subtree == null) {
            return 0;
        } else {
            return size(subtree.left) + 1 +size(subtree.right);
        }
    }
    /**
     * 二叉树的结点个数
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int height(AVLNode<T> p) {
        return p == null ? -1 : p.height;
    }
    /**
     * 返回二叉树的高度或者深度,即结点的最大层次
     *
     * @return
     */
    @Override
    public int height() {
        return height(root);
    }

    private String preOrder(AVLNode<T> subtree) {
        StringBuilder sb = new StringBuilder();
        if (subtree != null) {
            sb.append(subtree.data).append(",");
            sb.append(preOrder(subtree.left));
            sb.append(preOrder(subtree.right));
        }
        return sb.toString();
    }

    /**
     * 先根次序遍历
     */
    @Override
    public String preOrder() {
        String sb = preOrder(root);
        if (sb.length() > 0) {
            sb = sb.substring(0, sb.length() - 1);
        }
        return sb;
    }
    /**
     * 中根遍历
     * @param subtree
     * @return
     */
    private String inOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null) {
            //访问左子树
            sb.append(inOrder(subtree.left));
            //访问根结点
            sb.append(subtree.data).append(",");
            //访问右子树
            sb.append(inOrder(subtree.right));
        }
        return sb.toString();
    }


    /**
     * 中根次序遍历
     */
    @Override
    public String inOrder() {
        String sb=inOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * 后根遍历
     * @param subtree
     * @return
     */
    private String postOrder(AVLNode<T> subtree){
        StringBuilder sb =new StringBuilder();
        if (subtree!=null){
            //访问左子树
            sb.append(postOrder(subtree.left));
            //访问右子树
            sb.append(postOrder(subtree.right));
            //访问根结点
            sb.append(subtree.data).append(",");
        }
        return sb.toString();
    }

    /**
     * 后根次序遍历
     */
    @Override
    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**
     * 层次遍历
     */
    @Override
    public String levelOrder() {
        return null;
    }

    private AVLNode<T> insert(T data, AVLNode<T> p) {
        // 说明没有孩子节点，可以创建新结点插入
        if (p == null) {
            p = new AVLNode<>(data);
        }

        int result = data.compareTo(p.data);
        // 向左子树寻找插入位置
        if (result < 0) {
            p.left = insert(data, p.left);
            // 插入后计算子树高度，等于2则需要重新恢复平衡，
            // 由于是左边插入，左子树的高度肯定大于或者等于右子树的高度
            if (height(p.left) - height(p.right) == 2) {
                // 判断data是插入点的左孩子还是右孩子
                if (data.compareTo(p.left.data) < 0) {
                    // 进行LL旋转
                    p = singleRotateLeft(p);
                } else {
                    // 进行左右旋转
                    p = doubleRotateWithLeft(p);
                }
            }
        }
        // 向右子树寻找插入位置
        else if (result > 0) {
            p.right = insert(data, p.right);

            if (height(p.right) - height(p.left) == 2) {
                if (data.compareTo(p.right.data) < 0) {
                    // 进行右左旋转
                    p = doubleRotateWithRight(p);
                } else {
                    p = singleRotateRight(p);
                }
            }
        }

        // 返回各个结点的高度
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }

    /**
     * 将data 插入
     *
     * @param data
     * @return
     */
    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data can't not be null");
        }
        this.root = insert(data, root);
    }


    private AVLNode<T> remove(T data, AVLNode<T> p) {
        if (p == null) {
            return null;
        }
        int result = data.compareTo(p.data);
        // 从左子树查找需要删除的元素
        if (result < 0) {
            p.left = remove(data, p.left);

            // 检测是否平衡
            if (height(p.right) - height(p.left) == 2) {
                AVLNode<T> currentNode = p.right;
                if (height(currentNode.left) > height(currentNode.right)) {
                    // RL
                    p = doubleRotateWithRight(p);
                } else {
                    // RR
                    p = singleRotateRight(p);
                }
            }
        }
        // 从右子树查找需要删除的元素
        else if (result > 0) {
            p.right = remove(data, p.right);
            // 检测是否平衡
            if (height(p.left) - height(p.right) == 2) {
                AVLNode<T> currentNode = p.left;
                // 判断需要哪种旋转
                if (height(currentNode.right) > height(currentNode.left)) {
                    // LR
                    p = doubleRotateWithLeft(p);
                } else {
                    // LL
                    p = singleRotateLeft(p);
                }
            }
        }
        // 已找到需要删除的元素，并且要删除的结点拥有两个子结点
        else if (p.right != null && p.left != null) {
            // 寻找替换结点
            p.data = findMin(p.right).data;
            // 移除用于替换的结点
            p.right = remove(p.data, p.right);
        } else {
            // 只有一个孩子或者子结点的情况
            p = (p.left != null) ? p.left : p.right;
        }

        if (p != null) {
            p.height = Math.max(height(p.left), height(p.right)) + 1;
        }
        return p;
    }

    /**
     * 删除
     *
     * @param data
     */
    @Override
    public void remove(T data) {
        if (data == null) {
            throw new RuntimeException("data can't be null");
        }
        this.root = remove(data, root);
    }

    private AVLNode<T> findMin(AVLNode<T> p) {
        // 结束条件
        if (p == null) {
            return null;
        }
        // 如果没有左节点，那么t就是最小的
        else if (p.left == null) {
            return p;
        }
        return findMin(p.left);
    }
    /**
     * 查找最小值
     *
     * @return
     */
    @Override
    public T findMin() {
        return findMin(root).data;
    }

    private AVLNode<T> findMax(AVLNode<T> p) {
        if (p == null) {
            return null;
        }
        else if (p.right == null) {
            return p;
        }
        return findMax(p.right);
    }
    /**
     * 查找最大值
     *
     * @return
     */
    @Override
    public T findMax() {
        return findMax(root).data;
    }

    /**
     * 根据值找到结点
     *
     * @param data
     * @return
     */
    @Override
    public Object findNode(T data) {
        return null;
    }

    private boolean contain(T data, AVLNode<T> subtree) {
        if (subtree == null) {
            return false;
        }

        int result = data.compareTo(subtree.data);

        if (result < 0) {
            return contain(data, subtree.left);
        } else if (result > 0) {
            return contain(data, subtree.right);
        } else {
            return true;
        }
    }

    /**
     * 是否包含某个值
     *
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) throws Exception {
        return data != null && contain(data, root);
    }

    /**
     * 清空
     */
    @Override
    public void clear() {
        this.root = null;
    }

    /**
      * @Author whd
      * @Date 2018/5/14 11:15
      * @Param [x]
      * @Return com.sz.learn.tree.AVLTree<T>.AVLNode<T>
      * @Description 左左单旋转，w变为x的根结点，x变为w的右子树
      **/
    private AVLNode<T> singleRotateLeft(AVLNode<T> x) {
        // 把w结点旋转为根结点
        AVLNode<T> w = x.left;
        // 同时w的右子树变为x的左子树
        x.left = w.right;
        // x变为w的右子树
        w.right = x;
        // 重新计算x、w的高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(height(w.left), height(w.right)) + 1;
        return w;
    }

    /**
      * @Author whd
      * @Date 2018/5/14 11:21
      * @Param [w]
      * @Return com.sz.learn.tree.AVLTree<T>.AVLNode<T>
      * @Description 右右单旋转（RR旋转）x变为w根结点，w变为x左子树
      **/
    private AVLNode<T> singleRotateRight(AVLNode<T> w) {
        AVLNode<T> x = w.right;
        w.right = x.left;
        x.left = w;
        // 重新计算x、w的高度
        x.height = Math.max(height(x.left), w.height) + 1;
        w.height = Math.max(height(w.left),height(w.right)) + 1;
        return x;
    }

    /**
      * @Author whd
      * @Date 2018/5/14 11:37
      * @Param [x]
      * @Return com.sz.learn.tree.AVLTree<T>.AVLNode<T>
      * @Description 左右旋转（LR旋转）
      **/
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> x) {
        x.left = singleRotateRight(x.left);
        return singleRotateLeft(x);
    }

    /**
      * @Author whd
      * @Date 2018/5/14 11:40
      * @Param [w]
      * @Return com.sz.learn.tree.AVLTree<T>.AVLNode<T>
      * @Description 右左旋转（RL旋转）
      **/
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> w) {
        // 先进性LL旋转
        w.right = singleRotateLeft(w.right);
        // 再进行RR旋转
        return singleRotateRight(w);
    }

    private class AVLNode<T extends Comparable> {
        // 左节点
        private AVLNode<T> left;
        // 右节点
        private AVLNode<T> right;
        private T data;
        // 当前节点的高度
        public int height;
        private AVLNode(T data) {
            this(null, null, data);
        }
        private AVLNode(AVLNode<T> left, AVLNode right, T data) {
            this(left, right, data, 0);
        }
        private AVLNode(AVLNode<T> left, AVLNode right, T data, int height) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.height = height;
        }
    }


}
