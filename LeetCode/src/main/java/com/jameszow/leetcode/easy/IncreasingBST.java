/*
 * Copyright 2021 Apache All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.jameszow.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序搜索树
 * 给一颗二叉树，按中序遍历，重新排列为一棵递增顺序搜索树
 * 并且每个节点没有左子节点，只有一个右子节点
 */
public class IncreasingBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode () {};
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<TreeNode> nodeList = new ArrayList<>();

    public TreeNode increasingBST(TreeNode node) {
        dfs(node);
        TreeNode nodes = new TreeNode(-1);
        TreeNode cur = node;
        for (TreeNode item : nodeList){
            cur.right = item;
            nodes.left = null;
            cur = item;
        }
        return nodes.right;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        nodeList.add(root);
        dfs(root.right);
    }
}
