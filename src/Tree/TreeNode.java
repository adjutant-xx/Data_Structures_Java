// Data_Structures_Java
//
// Author: Matt Paauw
// GitHub: https://github.com/adjutant-xx
//
// No license, free use

package Tree;

import java.util.HashSet;

public class TreeNode<T> {

    public TreeNode(){}

    public TreeNode(T v){
        data = v;
        children = new HashSet<TreeNode<T>>();
    }

    public T data;
    public HashSet<TreeNode<T>> children;
}
