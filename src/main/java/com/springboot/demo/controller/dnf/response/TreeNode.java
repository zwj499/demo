package com.springboot.demo.controller.dnf.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public class TreeNode {

    private String label;
    private List<TreeNode> children;

    public TreeNode() {
    }

    public TreeNode(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
